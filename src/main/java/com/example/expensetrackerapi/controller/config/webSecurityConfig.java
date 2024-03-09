//package com.example.expensetrackerapi.controller.config;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//import com.example.expensetrackerapi.security.CustomUserDetailsService;
//
//@Configuration
//@EnableWebSecurity
//public class webSecurityConfig {
//
//	@Autowired
//	private CustomUserDetailsService userDetailsService;
//	
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.csrf((csrf) -> csrf.disable()).authorizeHttpRequests(
//				(authz) -> authz.requestMatchers("/login", "/register").permitAll().anyRequest().authenticated())
//				.httpBasic(withDefaults());
//		return http.build();
//	}
//
////	@Bean
////	public CustomUserDetailsService userDetailsService() {
//////		UserBuilder users = User.withDefaultPasswordEncoder();
//////		UserDetails user = users
//////				.username("kanchan")
//////				.password("kanchan78")
//////				.roles("USER")
//////				.build();
//////			UserDetails admin = users
//////				.username("kanan")
//////				.password("kanan")
//////				.roles("USER", "ADMIN")
//////				.build();
//////			return new InMemoryUserDetailsManager(user, admin);
////		return new CustomUserDetailsService();
////	}
//	
//	@Bean
//	public AuthenticationProvider authProvider() {
//		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//		provider.setUserDetailsService(userDetailsService);
//		provider.setPasswordEncoder(passwordEncoder());
//		return provider;
//	}
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//	@Bean
//	public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
//	    return http.getSharedObject(AuthenticationManagerBuilder.class)
//	            .build();
//	}
//	
//}
