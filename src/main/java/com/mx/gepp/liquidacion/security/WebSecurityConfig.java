package com.mx.gepp.liquidacion.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
   
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
        .csrf().disable()
        .authorizeHttpRequests((requests) -> requests
        .antMatchers("/**").permitAll()
        .anyRequest().authenticated())
        .httpBasic();

        return http.build();
    }
}
