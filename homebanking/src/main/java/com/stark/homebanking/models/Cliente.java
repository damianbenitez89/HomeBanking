package com.stark.homebanking.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity //con esto digo que esta clase es una entidad y tiene que tener clave primaria
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")// para no pensar como generar secuencialmente  uso estas aotaciones
    @GenericGenerator(name= "native,",strategy = "native") //generar id de los regstros para que sean unicos
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @OneToMany(mappedBy="cliente", fetch=FetchType.EAGER)
    private Set<Account> accounts = new HashSet<>();

    @OneToMany(mappedBy="cliente", fetch=FetchType.EAGER)
    private Set<ClientLoan> clientLoans = new HashSet<>();

    @OneToMany(mappedBy = "cliente",fetch = FetchType.EAGER)
    private Set<Card> cards =new HashSet<>();


    public Cliente() { }

    public Cliente( String firstName, String lastName, String email,String password) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public List<Loan> getLoans() {
        return clientLoans.stream().map(clientLoan -> clientLoan.getLoan()).collect(Collectors.toList());
    }

    public Long getId() {return id;}
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

    public Set<Account> getAccounts() {
        return accounts;
    }
    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Account account){
        account.setCliente(this);
        this.accounts.add(account);
    }

    public Set<ClientLoan> getClientLoans() {return clientLoans;}
    public void setClientLoans(Set<ClientLoan> clientLoans) {this.clientLoans = clientLoans;}

    public void addClientLoan(ClientLoan clientLoan) {
        clientLoan.setCliente(this);
        this.clientLoans.add(clientLoan);
    }
    public Set<Card> getCards() {return cards;}
    public void setCards(Set<Card> cards) {this.cards = cards;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
}
