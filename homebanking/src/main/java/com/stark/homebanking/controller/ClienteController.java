package com.stark.homebanking.controller;

import com.stark.homebanking.dtos.ClientDTO;
import com.stark.homebanking.models.Account;
import com.stark.homebanking.models.Cliente;
import com.stark.homebanking.repositories.AccountRepository;
import com.stark.homebanking.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/clients")
    public List<ClientDTO>getAllClient(){

        return clientRepository.findAll().stream().map(client -> new ClientDTO(client)).collect(Collectors.toList());
    }

    @GetMapping("/clients/{id}")

    public ClientDTO getClient(@PathVariable Long id){
        return clientRepository.findById(id).map(cliente -> new ClientDTO(cliente)).orElse(null);

    }
    @GetMapping("/clients/current")
    public ClientDTO getClient(Authentication authentication){
        Cliente cliente = this.clientRepository.findByEmail(authentication.getName());
        return new ClientDTO(cliente);
    }



    @PostMapping("/clients")

    public ResponseEntity<Object> createClient(
            @RequestParam String firstName, @RequestParam String lastName,
            @RequestParam String email, @RequestParam String password) {
        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
        }

        if (clientRepository.findByEmail(email) !=  null) {
            return new ResponseEntity<>("Name already in use", HttpStatus.FORBIDDEN);
        }


        Cliente cliente = clientRepository.save(new Cliente(firstName, lastName, email, passwordEncoder.encode(password)));
        String accountNumber = "VIN"+(int)((Math.random()*(10000000-1))+1);
        accountRepository.save(new Account(accountNumber, LocalDateTime.now(),0,cliente));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }




}
