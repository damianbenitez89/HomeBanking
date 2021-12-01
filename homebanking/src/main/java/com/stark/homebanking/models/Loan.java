package com.stark.homebanking.models;

import ch.qos.logback.core.net.server.Client;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")// para no pensar como generar secuencialmente  uso estas aotaciones
    @GenericGenerator(name= "native,",strategy = "native") //generar id de los regstros para que sean unicos
    private Long id;
    private String name;
    private double maxAmount;

    @ElementCollection
    private List<Integer> payments;

    @OneToMany(mappedBy="loan", fetch=FetchType.EAGER)
    private Set<ClientLoan> clientLoans = new HashSet<>();

    public Loan() {
    }

    public Loan( String name, double maxAmount, List<Integer> payments) {
        this.name = name;
        this.maxAmount = maxAmount;
        this.payments = payments;
    }
    @JsonIgnore
    public List<Cliente> getClients() {
        return clientLoans.stream().map(clientLoan -> clientLoan.getCliente()).collect(Collectors.toList());
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public double getMaxAmount() {return maxAmount;}
    public void setMaxAmount(double maxAmount) {this.maxAmount = maxAmount;}

    public List<Integer> getPayments() {return payments;}
    public void setPayments(List<Integer> payments) {this.payments = payments;}

    public Set<ClientLoan> getClientLoans() {return clientLoans;}
    public void setClientLoans(Set<ClientLoan> clientLoans) {this.clientLoans = clientLoans;}

    public void addClientLoan(ClientLoan clientLoan) {
        clientLoan.setLoan(this);
        this.clientLoans.add(clientLoan);
    }
}
