package fonia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fonia.model.Linea;




@Repository 
public interface LineaRepository extends JpaRepository<Linea, Integer>{

}
