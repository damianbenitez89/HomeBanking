package com.stark.homebanking.controller;

import com.stark.homebanking.dtos.ClientDTO;
import com.stark.homebanking.models.Account;
import com.stark.homebanking.models.Cliente;
import com.stark.homebanking.repositories.AccountRepository;
import com.stark.homebanking.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<ClientDTO>getAllClient(){

        return clientRepository.findAll().stream().map(client -> new ClientDTO(client)).collect(Collectors.toList());
    }

    @RequestMapping("/clients/{id}")

    public ClientDTO getClient(@PathVariable Long id){

        return clientRepository.findById(id).map(cliente -> new ClientDTO(cliente)).orElse(null);

    }



}
