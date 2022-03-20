package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.example.demo.security.JWTAuthenticationFilter;
import com.example.demo.security.JWTAuthorizationFilter;
import com.example.demo.security.JWTUtil;
import com.example.demo.services.UsuarioService;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UsuarioService service;
	
	@Autowired
	private JWTUtil jwtUtil;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder passwordEnconder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication()
		.withUser("squad")
		.password(passwordEnconder.encode("senha"))
		.roles("ADMIN", "USER");
		
		auth.userDetailsService(service).passwordEncoder(passwordEnconder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors()
		.and()
		.csrf()
		.disable()
		.authorizeRequests()
		.antMatchers("/locais").hasRole("ADMIN")
		.antMatchers("/contat").hasRole("ADMIN")
		.antMatchers("/cadastro").hasRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.and()
		.httpBasic();
		
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtil));
		http.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtUtil, service));
	}
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}
}
