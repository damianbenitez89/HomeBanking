package com.stark.homebanking.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class ClientLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")// para no pensar como generar secuencialmente  uso estas aotaciones
    @GenericGenerator(name= "native,",strategy = "native") //generar id de los regstros para que sean unicos
    private Long id;
    private double amount;
    private int payment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="loan_id")
    private Loan loan;

    public ClientLoan() {
    }

    public ClientLoan(double amount, int payment, Cliente cliente, Loan loan) {
        this.amount = amount;
        this.payment = payment;
        this.cliente = cliente;
        this.loan = loan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }
}
