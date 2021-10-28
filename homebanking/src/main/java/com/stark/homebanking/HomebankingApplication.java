package com.stark.homebanking;

import com.stark.homebanking.models.Cliente;
import com.stark.homebanking.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {

		SpringApplication.run(HomebankingApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository) {
		return (args) -> {
			Cliente cliente = new Cliente();

			cliente.setEmail("asdads@sasda.com");
			cliente.setFirstName("Dami!");
			cliente.setLastName("No Sound");

			clientRepository.save(cliente);
		};
	}

}
