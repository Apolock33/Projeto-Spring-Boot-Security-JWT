package com.example.demo.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.entities.Usuario;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;
	
	private JWTUtil jwtUtil;
	
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, 
			HttpServletResponse response)
			throws AuthenticationException {
		try {
			Usuario usuario = new ObjectMapper()
					.readValue(request.getInputStream(), Usuario.class);
			
			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(usuario.getUsername(), usuario.getPassword(), new ArrayList<>());
			
			Authentication auth = authenticationManager.authenticate(authToken);
			return auth;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	protected void successfulAuthentication(HttpServletRequest req, 
			HttpServletRequest res, 
			FilterChain chain, 
			Authentication auth) throws IOException, ServletException {
		String username = ((Usuario) auth.getPrincipal()).getUsername();
		System.out.println("usuario " + username);
		String token = jwtUtil.generateToken(username);
		System.out.println("token " + token);
		((HttpServletResponse) res).addHeader("Authorization", "Bearer " + token);
		((HttpServletResponse) res).addHeader("acess-control-expose=headers", "Authorization");
	}
}
