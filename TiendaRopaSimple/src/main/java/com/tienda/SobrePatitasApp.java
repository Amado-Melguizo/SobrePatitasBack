package com.tienda;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tienda.entidades.Products;
import com.tienda.entidades.Users;
import com.tienda.interfaces.RepProducts;
import com.tienda.interfaces.RepUsers;

@SpringBootApplication
public class SobrePatitasApp {

	public static void main(String[] args) {
		SpringApplication.run(SobrePatitasApp.class, args);
	}

	@Bean
	CommandLineRunner initUsers(RepUsers userRepository) {
		return args -> {
			Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
				Stream.of("Wick", "Andrew", "Laurence", "Hell", "Crop").forEach(pass -> {

						Users user = new Users(null, name, name.toLowerCase() + "@domain.com", pass,
								name.toLowerCase() + ".jpg");

						userRepository.save(user);
					});
					userRepository.findAll().forEach(System.out::println);
				});
			};
		};

	@Bean
	CommandLineRunner initProducts(RepProducts prodRepository) {
		return args -> {
			Stream.of("Camisetas", "Bolsos").forEach(name -> {
				Stream.of("Camisetas de animalitos", "Bolsos de animalitos").forEach(description -> {
					Stream.of(15, 7).forEach(price -> {
						Stream.of(100, 150).forEach(stock -> {
							Stream.of("camiseta", "bolso").forEach(img -> {

								Products prod = new Products(null, name, description, price, stock, name + ".jpg");
								prodRepository.save(prod);
							});
							prodRepository.findAll().forEach(System.out::println);

						});
					});
				});
			});

		};
	}
}
