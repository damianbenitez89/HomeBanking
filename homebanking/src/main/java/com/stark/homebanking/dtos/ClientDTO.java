package com.stark.homebanking.dtos;


import com.stark.homebanking.models.Cliente;

public class ClientDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    public ClientDTO(Cliente cliente) {

        this.id = cliente.getId();

        this.firstName = cliente.getFirstName();

        this.lastName = cliente.getLastName();

        this.email = cliente.getEmail();

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
}
