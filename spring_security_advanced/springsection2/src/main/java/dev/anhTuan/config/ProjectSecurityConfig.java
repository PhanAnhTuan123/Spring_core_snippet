package dev.anhTuan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(request -> {
            request.requestMatchers("/myAccount/**","/myBalance/**","/myCards/**","/myLoan/**").authenticated();
            request.requestMatchers("/myNotices/**","/contact").permitAll();
        });
//        http.authorizeHttpRequests(request -> request.anyRequest().denyAll());
//        http.authorizeHttpRequests(request -> request.anyRequest().permitAll());
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());

        return http.build();
    }

}
