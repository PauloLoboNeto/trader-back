package com.initializer.controllers;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.ok;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.initializer.configs.jwt.JwtTokenProvider;
import com.initializer.entities.User;
import com.initializer.services.implementation.AuthenticationManagerServiceImplementation;
import com.initializer.services.implementation.LoginServiceImplementation;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/v1/auth")
@Api(tags = { "loginApi" })
public class LoginController {

	private AuthenticationManagerServiceImplementation authenticationManager;
	private JwtTokenProvider jwtTokenProvider;
	private LoginServiceImplementation loginService;

	@Autowired
	public LoginController(AuthenticationManagerServiceImplementation authenticationManager,
			JwtTokenProvider jwtTokenProvider, LoginServiceImplementation loginService) {
		this.authenticationManager = authenticationManager;
		this.jwtTokenProvider = jwtTokenProvider;
		this.loginService = loginService;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/signin")
	public ResponseEntity<Map<Object, Object>> signin(@RequestBody AuthenticationRequest data) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(data, data.getPassword()));
			User user = this.loginService.loadUserByUsername(data.getUsername());
			String token = jwtTokenProvider.createToken(user.getUsername(), user.getRoles());
			Map<Object, Object> model = new HashMap<>();
			model.put("username", user.getUsername());
			model.put("token", token);
			return ok(model);
		} catch (AuthenticationException e) {
			throw new BadCredentialsException("Invalid username/password supplied");
		}
	}

	@GetMapping("/me")
	public ResponseEntity<Map<Object, Object>> currentUser(@AuthenticationPrincipal User userDetails) {
		Map<Object, Object> model = new HashMap<>();
		model.put("username", userDetails.getUsername());
		model.put("roles", userDetails.getAuthorities().stream().map(a -> ((GrantedAuthority) a).getAuthority())
				.collect(toList()));
		return ok(model);
	}
}
