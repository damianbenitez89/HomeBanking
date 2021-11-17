package com.stark.homebanking.controller;

import com.stark.homebanking.dtos.AccountDTO;
import com.stark.homebanking.dtos.ClientDTO;
import com.stark.homebanking.models.Account;
import com.stark.homebanking.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/accounts")
    public List<AccountDTO> getAllAccount(){

        return accountRepository.findAll().stream().map(account -> new AccountDTO(account)).collect(Collectors.toList());

    }
    @GetMapping("/accountss")
    public List<Account> getAllAccountss(){

        return accountRepository.findAll();

    }


    @RequestMapping("/accounts/{id}")

    public AccountDTO getAccount(@PathVariable Long id){

        return accountRepository.findById(id).map(account -> new AccountDTO(account)).orElse(null);

    }
}
