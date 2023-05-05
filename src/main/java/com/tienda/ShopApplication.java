package com.tienda;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tienda.entities.Users;
import com.tienda.interfaces.UsersRepo;

@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}
	@Bean
	CommandLineRunner initUsers(UsersRepo userRepository) {
		return args -> {
			Stream.of("Sujeto1").forEach(name -> {
				Stream.of("sujeto1").forEach(pass -> {

						Users user = new Users(null, name, name.toLowerCase() + "@domain.com", pass,
								name.toLowerCase() + ".jpg", null, null);

						userRepository.save(user);
					});
					userRepository.findAll().forEach(System.out::println);
				});
			};
		};

}
