package com.example.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	            .authorizeHttpRequests((authz) -> authz
	                .anyRequest().authenticated()
	            )
	            .httpBasic();
	    }

   @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Creamos una cuenta de usuario por default
       auth.inMemoryAuthentication()
               .withUser("izan")
               .password("{noop}123")
               .roles("ADMIN");
       
       auth.inMemoryAuthentication()
			   .withUser("peter")
			   .password("{noop}root")
			   .roles("USER");
    }
}