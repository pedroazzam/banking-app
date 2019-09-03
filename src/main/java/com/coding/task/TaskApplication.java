package com.coding.task;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.coding.task.models.SecretKey;
import com.coding.task.repository.SecretKeyRepository;

@SpringBootApplication
public class TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demoKey(SecretKeyRepository repo) {
		SecretKey newSecretKey = new SecretKey();
		newSecretKey.setKey("3861");
		List<SecretKey> listKey = repo.findAll();
		if (listKey.size()==0) {
			return args -> {
				repo.save(newSecretKey);
			};
		}
		return null;
	}

}
