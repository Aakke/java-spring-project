package com.github.aakke.javaspringproject.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Security configurations for spring project.
 * @author Aleksi Tani
 * @version 8.12.2020
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
    public InMemoryUserDetailsManager userDetailsService() {
          UserDetails user = User.withUsername("admin")
                  .password(passwordEncoder().encode("admin123"))
                  .roles("ADMIN")
                  .build();
          return new InMemoryUserDetailsManager(user);
    }
	
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http.
			csrf(Customizer.withDefaults())
			.authorizeHttpRequests(requests -> requests
			.anyRequest().authenticated())
			.httpBasic(Customizer.withDefaults());
		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
