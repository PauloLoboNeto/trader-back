package com.initializer.services.interfaces;

import org.springframework.stereotype.Service;

import com.initializer.entities.User;

@Service
public interface LoginService {
	public User loadUserByUsername(String username);
}
