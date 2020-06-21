//package com.initializer.services.implementation;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.initializer.controllers.AuthenticationRequest;
//import com.initializer.entities.User;
//
//@Service
//public class AuthenticationManagerServiceImplementation // implements AuthenticationManagerService {
//{
//	static final List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>();
//
//	@Autowired
//	private LoginServiceImplementation usuarioService;
//
////	@Override
////	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
////		AuthenticationRequest authReq = (AuthenticationRequest) authentication.getPrincipal();
////		User user = this.usuarioService.loadUserByUsername(authReq.getUsername());
////		if (this.verifyCredentials(authReq, user))
////			return new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials(),
////					user.getAuthorities());
////		else
////			throw new BadCredentialsException("Bad Credentials");
////	}
////
////	private boolean verifyCredentials(AuthenticationRequest authReq, User user) {
////		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
////		if (encoder.matches(authReq.getPassword(), user.getPassword()))
////			return true;
////		else
////			return false;
////
////	}
//
//
//}
