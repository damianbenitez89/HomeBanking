package com.stark.homebanking.dtos;

import com.stark.homebanking.models.Account;
import com.stark.homebanking.models.Cliente;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ClientDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Set<AccountDTO>  account = new HashSet<>();
    private Set<ClientLoanDTO> loans= new HashSet<>();

    public ClientDTO() {}

    public ClientDTO(Cliente cliente) {

        this.id = cliente.getId();
        this.firstName = cliente.getFirstName();
        this.lastName = cliente.getLastName();
        this.email = cliente.getEmail();
        this.account = cliente.getAccounts().stream().map(account -> new AccountDTO(account)).collect(Collectors.toSet());
        this.loans = cliente.getClientLoans().stream().map(clientLoan -> new ClientLoanDTO(clientLoan)).collect(Collectors.toSet());
    }

    public Set<AccountDTO> getAccount() {
        return account;
    }
    public void setAccount(Set<AccountDTO> account) {
        this.account = account;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Set<ClientLoanDTO> getLoans() {return loans;}

    public void setLoans(Set<ClientLoanDTO> loans) {this.loans = loans;}
}
