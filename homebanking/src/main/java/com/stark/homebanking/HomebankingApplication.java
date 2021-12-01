package com.stark.homebanking;

import com.stark.homebanking.models.*;
import com.stark.homebanking.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {

		SpringApplication.run(HomebankingApplication.class, args);
	}
	LocalDateTime hoy = LocalDateTime.now();

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository,
									  AccountRepository accountRepository,
									  TransactionRepository transactionRepository,
									  LoanRepository loanRepository,
									  ClientLoanRepository clientLoanRepository)  {
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

			Transaction transaction =new Transaction(TransactionType.DEBITO,-5000 ,"mucama" ,hoy,account);
			Transaction transaction2=new Transaction(TransactionType.CREDITO,4000 ,"sueldo" ,hoy,account);
			Transaction transaction3=new Transaction(TransactionType.DEBITO,-3400 ,"insumos",hoy,account);
            Transaction transaction4=new Transaction(TransactionType.DEBITO,-7000 ,"mucama" ,hoy,account);
            Transaction transaction5=new Transaction(TransactionType.CREDITO,9000 ,"sueldo" ,hoy,account);
            Transaction transaction6=new Transaction(TransactionType.DEBITO,-3600 ,"insumos",hoy,account2);
			Transaction transaction7=new Transaction(TransactionType.DEBITO,-1000 ,"mucama" ,hoy,account2);
			Transaction transaction8=new Transaction(TransactionType.CREDITO,6000 ,"sueldo" ,hoy,account2);
			Transaction transaction9=new Transaction(TransactionType.DEBITO,-10000,"insumos",hoy,account2);

			transactionRepository.save(transaction);
			transactionRepository.save(transaction2);
			transactionRepository.save(transaction3);
			transactionRepository.save(transaction4);
			transactionRepository.save(transaction5);
			transactionRepository.save(transaction6);
			transactionRepository.save(transaction7);
			transactionRepository.save(transaction8);
			transactionRepository.save(transaction9);


			Loan loan = new Loan("Hipotecario",500000, List.of(12,24,36,48,60));
			Loan loan2 = new Loan("Personal",100000, List.of(6,12,24));
			Loan loan3 = new Loan("Automotriz",300000, List.of(6,12,24,36));

			loanRepository.save(loan);
			loanRepository.save(loan2);
			loanRepository.save(loan3);

			ClientLoan clientLoan  = new ClientLoan(400000,60,cliente,loan);
			ClientLoan clientLoan2 = new ClientLoan(50000 ,12,cliente,loan2);
			ClientLoan clientLoan3 = new ClientLoan(100000,24,cliente2,loan);
			ClientLoan clientLoan4 = new ClientLoan(200000,36,cliente2,loan3);

			clientLoanRepository.save(clientLoan);
			clientLoanRepository.save(clientLoan2);
			clientLoanRepository.save(clientLoan3);
			clientLoanRepository.save(clientLoan4);

		};
	}




}
