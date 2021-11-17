package com.stark.homebanking.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity //con esto digo que esta clase es una entidad y tiene que tener clave primaria
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")// para no pensar como generar secuencialmente  uso estas aotaciones
    @GenericGenerator(name= "native,",strategy = "native") //generar id de los regstros para que sean unicos
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    @OneToMany(mappedBy="cliente", fetch=FetchType.EAGER)
    private Set<Account> accounts = new HashSet<>();


    public Cliente() { }

    public Cliente( String firstName, String lastName, String email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

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

}
