package dev.anhTuan.keyCloak.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;
import org.springframework.security.oauth2.client.oidc.web.server.logout.OidcClientInitiatedServerLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestCustomizers;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestResolver;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class Oauth2LoginSecurityConfig {

    private final ClientRegistrationRepository clientRegistrationRepository;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(request->{
            request.requestMatchers("/bugtracker/ui").authenticated();
            request.requestMatchers("/bugtracker/ui/admin/**").hasAnyAuthority("SCOPE_bugtracker.admin");
            request.requestMatchers("/bugtracker/ui/**").hasAnyAuthority("SCOPE_bugtracker.admin","SCOPE_bugtracker.user","SCOPE_email");
            request.anyRequest().authenticated();
        });
        http.oauth2Login(registry -> registry.authorizationEndpoint(cfg -> cfg.authorizationRequestResolver(pkceResolver(clientRegistrationRepository))));
        http.logout(logout ->logout.logoutSuccessHandler(oidLogoutSuccessHandler()));
        return http.build();
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
