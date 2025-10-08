package com.example.todolist.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.todolist.entities.Tasks;
import com.example.todolist.entities.User;
import com.example.todolist.entities.enums.TaskStatus;
import com.example.todolist.repositories.TasksRepository;
import com.example.todolist.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Autowired
	TasksRepository tasksRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Maria Silva", "maria@gmail.com");
		User u2 = new User(null, "João Santos", "joao@gmail.com");
		User u3 = new User(null, "Ana Costa", "ana.costa@gmail.com");

		userRepository.saveAll(Arrays.asList(u1, u2, u3));

		Tasks t1 = new Tasks(null, "Estudar Java", "Revisar conceitos de JPA e Spring Boot", TaskStatus.IN_PROGRESS,
				LocalDate.of(2025, 10, 9), u1);

		Tasks t2 = new Tasks(null, "Ir à academia", "Treino de pernas e braços", TaskStatus.PENDING,
				LocalDate.of(2025, 10, 8), u1);

		Tasks t3 = new Tasks(null, "Ler livro", "Capítulo 5 do livro de programação", TaskStatus.DONE,
				LocalDate.of(2025, 10, 7), u2);

		tasksRepository.saveAll(Arrays.asList(t1, t2, t3));
		

	}

}
