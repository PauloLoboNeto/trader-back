package com.initializer.services.implementation;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.initializer.controllers.AuthenticationRequest;
import com.initializer.entities.User;
import com.initializer.repositories.UserRepository;
import com.initializer.services.interfaces.LoginService;

@Service
public class LoginServiceImplementation implements LoginService {
	
	private UserRepository users;
	
	public LoginServiceImplementation(UserRepository users) {
        this.users = users;
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.users.findByUsername(username).orElseThrow(() -> 
        new UsernameNotFoundException("Username: " + username + "not found"));
    }
    
	public void verifyCredentials(AuthenticationRequest authReq) {
		User users = this.loadUserByUsername(authReq.getUsername());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if (!encoder.matches(authReq.getPassword(), users.getPassword()))
			throw new BadCredentialsException("Bad Credentials");
	}
}
