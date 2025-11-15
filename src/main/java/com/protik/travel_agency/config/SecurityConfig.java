package com.protik.travel_agency.config;

import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain configuration(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(request-> {
                    request.requestMatchers("/user/register").permitAll()
                            .requestMatchers("/").authenticated()
                            .anyRequest().permitAll();
                })
                .httpBasic(Customizer.withDefaults())
                .cors(Customizer.withDefaults())
                .csrf(Customizer.withDefaults());
        return http.build();

    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    @SneakyThrows
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) {
        return authenticationConfiguration.getAuthenticationManager();


    }
}
