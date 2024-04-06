package com.ravi.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

import static javax.management.Query.and;

@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfiguration {

    @Autowired
    DataSource dataSource;

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication()
                .dataSource(dataSource);
    }


    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .requestMatchers("/admin").hasRole("ADMIN")
                .requestMatchers("/user").hasAnyRole("ADMIN", "USER")
                .requestMatchers("/").permitAll()
                .and();
    }

}
