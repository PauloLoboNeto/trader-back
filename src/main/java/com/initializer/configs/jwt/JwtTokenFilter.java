package com.initializer.configs.jwt;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class JwtTokenFilter implements Filter {

	private JwtTokenProvider jwtTokenProvider;

	public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
		this.jwtTokenProvider = jwtTokenProvider;
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
			throws IOException, ServletException {
		String token = jwtTokenProvider.resolveToken((HttpServletRequest) req);
		try {
			if (token != null && jwtTokenProvider.validateToken(token)) {
				Authentication auth = token != null ? jwtTokenProvider.getAuthentication(token) : null;
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		filterChain.doFilter(req, res);
	}
}