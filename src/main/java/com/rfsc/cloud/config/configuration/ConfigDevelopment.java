package com.rfsc.cloud.config.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Profile({"local", "dev", "qa"})
@Slf4j
public class ConfigDevelopment extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.info("Configuracion de seguridad para DESARROLLO");
        http.csrf()
            .disable()
            .authorizeRequests()
            .antMatchers("/**")
            .permitAll();
    }
}
