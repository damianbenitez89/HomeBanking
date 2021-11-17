package com.stark.homebanking;

import com.stark.homebanking.models.Account;
import com.stark.homebanking.models.Cliente;
import com.stark.homebanking.models.Transaction;
import com.stark.homebanking.models.TransactionType;
import com.stark.homebanking.repositories.AccountRepository;
import com.stark.homebanking.repositories.ClientRepository;
import com.stark.homebanking.repositories.TransactionRepository;
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
	public CommandLineRunner initData(ClientRepository clientRepository, AccountRepository accountRepository, TransactionRepository transactionRepository)  {
		return (args) -> {
			Cliente cliente = new Cliente("Melba","Flores","melba@mindhub.com");
			Cliente cliente2 = new Cliente("carlos","Benitez","Damianbenitez8928@gmail.com");

			clientRepository.save(cliente);
			clientRepository.save(cliente2);

			Account account=new Account("VIN001",hoy,5000,cliente);
			Account account2=new Account("VIN002",hoy.plusDays(1),7500,cliente);
			Account account3=new Account("VIN003",hoy.plusDays(1),9500,cliente2);
			Account account4=new Account("VIN004",hoy,8500,cliente2);



			accountRepository.save(account);
			accountRepository.save(account2);
			accountRepository.save(account3);
			accountRepository.save(account4);

			Transaction transaction=new Transaction(TransactionType.DEBITO,-5000,"mucama",hoy,account);
			Transaction transaction2=new Transaction(TransactionType.CREDITO,4000,"sueldo",hoy,account);
			Transaction transaction3=new Transaction(TransactionType.DEBITO,-3000,"insumos",hoy,account);

			transactionRepository.save(transaction);
			transactionRepository.save(transaction2);
			transactionRepository.save(transaction3);






		};
	}




}
