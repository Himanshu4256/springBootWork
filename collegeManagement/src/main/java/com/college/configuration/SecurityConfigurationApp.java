package com.college.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfigurationApp{
	
	//For Password Encoder
	@Bean
	public PasswordEncoder passwordEncoder() {
		//return new BCryptPasswordEncoder();
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	//For User Details
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails normalUserDetails = User.withUsername("himanshu")
				.password(passwordEncoder()
				.encode("omnie@2161"))
				.roles("NORMAL")
				.build();
		
		UserDetails adminUserDetails = User.withUsername("dushyant")
				.password(passwordEncoder()
				.encode("omnie@2161"))
				.roles("ADMIN")
				.build();
		
		//Here we [want to/have to] return UserDetails. But the method return type is UserDetailsService.
		//So for this here we have 'InMemoryUserDetailsManager' class. Now we can return anything which is in this method.
		
		//return new InMemoryUserDetailsManager(normalUserDetails,adminUserDetails);
		InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager(normalUserDetails,adminUserDetails);
		return inMemoryUserDetailsManager;
	}
	
	// To provide the authorization Like - [give access or not]. And this method active the security. so it's a first method for security use.
	//SecurityFilterChain provide the security filter to your application
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.csrf(csrf -> csrf.disable())    // csrf() - (Cross-Site Request Forgery) it is a attack to user for provide the authenticated data AND Disable unauthorized request.
				httpSecurity.csrf().disable()
                .authorizeHttpRequests()    
                .requestMatchers("api/students/{id}")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
	
	return httpSecurity.build();
	}
}
