package com.rfsc.cloud.config.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Profile("prod")
@Slf4j
public class ConfigProduction extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.info("Configuracion de seguridad para PRODUCCION");
        http.csrf()
            .disable()
            .authorizeRequests()
            .antMatchers("/health", "/info")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic();
    }
}
