package com.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    new CustomAuthenticationSuccessHandler()
    @Bean
    public RememberMeServices rememberMeServices() {
        return new PersistentTokenBasedRememberMeServices("myAppKey", userDetailsService(), persistentTokenRepository());
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


        /*
                .loginProcessingUrl()
         */

        // 01. 인증 처리
        LogoutConfigurer<HttpSecurity> authenticationBuild = http
                .formLogin(form -> form
                        .loginPage("/login.os")
//                        .successHandler()
//                        .failureHandler()
                )
                .rememberMe(me -> me.
//                        .rememberMeServices(rember)

                )
                .logout();


        return http.build();
    }

}
