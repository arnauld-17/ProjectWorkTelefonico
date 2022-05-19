package fonia.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fonia.model.Chiamata;
import fonia.model.Linea;

public interface ChiamataRepository extends JpaRepository<Chiamata,Integer> {

		List<Chiamata> findByLinea(Linea linea);
}
