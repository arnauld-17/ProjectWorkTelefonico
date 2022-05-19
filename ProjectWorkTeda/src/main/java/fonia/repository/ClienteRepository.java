package fonia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fonia.model.Cliente;



@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
