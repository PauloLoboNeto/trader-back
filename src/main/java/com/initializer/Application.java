package com.initializer;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.initializer.entities.User;
import com.initializer.repositories.UserRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	UserRepository users;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setUserName("user");
		user.setPassword(this.passwordEncoder().encode("user"));
		user.setRoles(Arrays.asList("ROLE_USER"));

		User user2 = new User();
		user2.setUserName("admin");
		user2.setPassword(this.passwordEncoder().encode("admin"));
		user2.setRoles(Arrays.asList("ROLE_USER", "ROLE_ADMIN"));

		this.users.save(user);
		this.users.save(user2);

		this.users.findAll().forEach(v -> System.out.println(" User :" + v.toString()));

	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
