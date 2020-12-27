package com.msa.gateway;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@EnableWebSecurity
//@Configuration
public class SkyConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and().csrf().disable().cors()
                .and()
                    .authorizeRequests()
                    .antMatchers("/login/**", "/hello/**").permitAll()
                    .antMatchers("/other/**").denyAll()
                .and().formLogin().permitAll()
                .and().authorizeRequests().anyRequest().authenticated();
    }
}
