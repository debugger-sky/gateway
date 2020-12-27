package com.msa.gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SkyNewConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http.httpBasic()
                .and().csrf().disable().cors()
                .and()
                .authorizeRequests()
                .antMatchers("/login/**", "/other/**").permitAll()
                .antMatchers("/hello/**").denyAll()
                .and().formLogin().permitAll()
                .and().authorizeRequests().anyRequest().authenticated()
                .and().build();
    }

    @Bean
    public ServerCodecConfigurer serverCodecConfigurer() {
        return ServerCodecConfigurer.create();
    }
}
