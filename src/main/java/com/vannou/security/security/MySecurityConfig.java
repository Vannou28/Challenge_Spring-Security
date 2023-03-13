package com.vannou.security.security;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MySecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authz) -> {
            try {
                authz
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/avengers/assemble").hasRole("CHAMPION")
                        .requestMatchers("/secret-bases").hasRole("DIRECTOR")
                        .anyRequest().authenticated()
                        .and().formLogin()
                        .and().httpBasic();
            } catch (Exception e) {

                e.printStackTrace();
            }
        });
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        UserDetails user = User
                .withUsername("user")
                .password(encoder.encode("user"))
                .roles("CHAMPION")
                .build();

        UserDetails admin = User
                .withUsername("admin")
                .password(encoder.encode("admin"))
                .roles("DIRECTOR")
                .build();

        UserDetails steve = User
                .withUsername("Steve")
                .password(encoder.encode("password"))
                .roles("CHAMPION")
                .build();

        UserDetails nick = User
                .withUsername("Nick")
                .password(encoder.encode("flerken"))
                .roles("DIRECTOR")
                .build();

        return new InMemoryUserDetailsManager(List.of(user, admin, steve, nick));
    }
}
