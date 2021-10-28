package com.stark.homebanking.repositories;

import com.stark.homebanking.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Cliente, Long> {// extend clase y tipo de datos de la clase primaria


}
