package com.stark.homebanking.dtos;

import com.stark.homebanking.models.ClientLoan;

public class ClientLoanDTO {

    private Long id;
    private Long loanId;
    private String name;
    private double amount;
    private int payments;

    public ClientLoanDTO(ClientLoan clienteLoan) {
        this.id= clienteLoan.getId();
        this.loanId= clienteLoan.getLoan().getId();
        this.name=clienteLoan.getLoan().getName();
        this.amount=clienteLoan.getAmount();
        this.payments=clienteLoan.getPayment();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getPayments() {
        return payments;
    }

    public void setPayments(int payments) {
        this.payments = payments;
    }
}
