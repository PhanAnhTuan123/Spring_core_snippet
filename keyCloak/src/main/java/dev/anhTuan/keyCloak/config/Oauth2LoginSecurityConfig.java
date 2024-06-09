package dev.anhTuan.keyCloak.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;
import org.springframework.security.oauth2.client.oidc.web.server.logout.OidcClientInitiatedServerLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestCustomizers;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class Oauth2LoginSecurityConfig {

    private final ClientRegistrationRepository clientRegistrationRepository;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(request->{
            request.requestMatchers("/bugtracker/ui").authenticated();
            request.requestMatchers("/bugtracker/ui/admin/**").hasAnyRole("bugtracker.admin");
            request.requestMatchers("/bugtracker/ui/**").hasAnyRole("bugtracker.admin","bugtracker.user");
            request.anyRequest().authenticated();
        });
        http.oauth2Login(registry -> registry
                .userInfoEndpoint(epConfig -> epConfig.oidcUserService(this.userService()))
                .authorizationEndpoint(cfg -> cfg.authorizationRequestResolver(pkceResolver(clientRegistrationRepository))));
        http.logout(logout ->logout.logoutSuccessHandler(oidLogoutSuccessHandler()));
        return http.build();
    }

    private OAuth2UserService<OidcUserRequest, OidcUser> userService() {
        final OidcUserService delegate = new OidcUserService();
        return (userRequest) ->{

            // Delegate to the default implementation for loading a user
            OidcUser oidcUser = delegate.loadUser(userRequest);

            // Not used in this logic
            OAuth2AccessToken accessToken = userRequest.getAccessToken();

            // Get the roles from the ID token
            List<String>roles = oidcUser.getIdToken().getClaim("roles");
            if (roles == null){
                roles = List.of();
            }

            // map the roles to authorities
            Set<GrantedAuthority> mappedAuthorities = new HashSet<>();
            List<SimpleGrantedAuthority> lisAuthorities = roles.stream().map(SimpleGrantedAuthority::new).toList();
            mappedAuthorities.addAll(lisAuthorities);

            // Create new DefaultOidcUser with authorities
            return new DefaultOidcUser(mappedAuthorities, oidcUser.getIdToken(),oidcUser.getUserInfo());
        };
    }


    private LogoutSuccessHandler oidLogoutSuccessHandler(){
        OidcClientInitiatedLogoutSuccessHandler oidcClientInitiatedServerLogoutSuccessHandler =
                new OidcClientInitiatedLogoutSuccessHandler(this.clientRegistrationRepository);

        // set the location that the End-User's User Agent will be redirected to
        // after the logout has been performed at the Provider
        oidcClientInitiatedServerLogoutSuccessHandler.setPostLogoutRedirectUri("{baseUrl}/bugtracker/ui");
        return oidcClientInitiatedServerLogoutSuccessHandler;
    }

    public OAuth2AuthorizationRequestResolver pkceResolver(ClientRegistrationRepository repo){
        var resolver = new DefaultOAuth2AuthorizationRequestResolver(repo,"/oauth2/authorization");
        resolver.setAuthorizationRequestCustomizer(OAuth2AuthorizationRequestCustomizers.withPkce());
        return resolver;
    }



}
