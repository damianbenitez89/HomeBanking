package com.stark.homebanking.controller;

import com.stark.homebanking.dtos.AccountDTO;
import com.stark.homebanking.dtos.ClientDTO;
import com.stark.homebanking.models.Account;
import com.stark.homebanking.models.Cliente;
import com.stark.homebanking.repositories.AccountRepository;
import com.stark.homebanking.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/accounts")
    public List<AccountDTO> getAllAccount(){

        return accountRepository.findAll().stream().map(account -> new AccountDTO(account)).collect(Collectors.toList());

    }


    @RequestMapping("/accounts/{id}")

    public AccountDTO getAccount(@PathVariable Long id){

        return accountRepository.findById(id).map(account -> new AccountDTO(account)).orElse(null);

    }

    @PostMapping("/clients/current/accounts")

    public ResponseEntity<Object> createAccount(Authentication authentication) {
       Cliente cliente = this.clientRepository.findByEmail(authentication.getName());

       if(cliente.getAccounts().size()>=3){
           return new ResponseEntity<>("Client´s of accounts limit reached", HttpStatus.FORBIDDEN);
       }

        String accountNumber = "VIN"+(int)((Math.random()*(10000000-1))+1);
       accountRepository.save(new Account(accountNumber, LocalDateTime.now(),0,cliente));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/clients/current/accounts")
    public List<AccountDTO>getAccounts(Authentication authentication){
        Cliente cliente = this.clientRepository.findByEmail(authentication.getName());
        return cliente.getAccounts().stream().map(account -> new AccountDTO(account)).collect(Collectors.toList());
    }
}
