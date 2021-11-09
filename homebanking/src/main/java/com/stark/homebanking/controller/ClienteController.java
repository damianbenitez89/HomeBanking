package com.stark.homebanking.controller;

import com.stark.homebanking.models.Account;
import com.stark.homebanking.models.Cliente;
import com.stark.homebanking.repositories.AccountRepository;
import com.stark.homebanking.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/account")
    public List<Account> getAllAccount(){

        return accountRepository.findAll();
    }

    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/clients")
    public List<Cliente> getAllClient(){

        return clientRepository.findAll();
    }

}
