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
	
	// Basic config method
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
	   
        // We create admin and user
       auth.inMemoryAuthentication()
               .withUser("izan")
               .password("{noop}root")
               .roles("ADMIN");
       auth.inMemoryAuthentication()
			   .withUser("oscar")
			   .password("{noop}1234")
			   .roles("USER");
    }
}
