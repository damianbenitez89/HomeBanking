package com.stark.homebanking;

import com.stark.homebanking.models.Account;
import com.stark.homebanking.models.Cliente;
import com.stark.homebanking.repositories.AccountRepository;
import com.stark.homebanking.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {

		SpringApplication.run(HomebankingApplication.class, args);
	}
	LocalDateTime hoy = LocalDateTime.now();

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository,AccountRepository accountRepository)  {
		return (args) -> {
			Cliente cliente = new Cliente();

			cliente.setEmail("melba@mindhub.com");
			cliente.setFirstName("Melba!");
			cliente.setLastName("Morel");

			clientRepository.save(cliente);

			Account account=new Account();

			account.setNumber("VIN001");
			account.setCreationDate(hoy);
			account.setBalance(5000);
			account.setCliente(cliente);

			accountRepository.save(account);

			Account account2=new Account();

			account2.setNumber("VIN002");
			account2.setCreationDate(hoy.plusDays(1));
			account2.setBalance(7500);
			account2.setCliente(cliente);

			accountRepository.save(account2);




		};
	}




}
