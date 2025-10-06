package com.example.todolist.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.todolist.entities.User;
import com.example.todolist.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Silva", "maria@gmail.com");
		User u2 = new User(null, "João Santos", "joao@gmail.com");
		User u3 = new User(null, "Ana Costa", "ana.costa@gmail.com");
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3));

	}

}
