package fonia.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fonia.model.Cliente;
import fonia.model.Linea;
import fonia.repository.LineaRepository;

@Service
public class LineaService {
	
	
	@Autowired
	private LineaRepository lineaRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	
public Linea createLinea(Linea linea) {
	
		Cliente cliente= clienteRepository.findById(linea.getIdCliente()).orElse(null);
		linea.setCliente(cliente);
		return linea= lineaRepository.save(linea);

	}
		
  public Optional<Linea>  getLinea(int idLinea) {
	
	
	return lineaRepository.findById(idLinea);
} 
	
  @Transactional
  public void UpdateLinea( int idLinea, String statoLinea) {
		
		Linea linea = lineaRepository.findById(idLinea).orElse(null);
		

		if(statoLinea.equalsIgnoreCase("attivata") || statoLinea.equalsIgnoreCase("sospesa") 
			||statoLinea.equalsIgnoreCase("cessata") )
			linea.setStatoLinea(statoLinea);
		
		}
	
  public void DeleteLinea( Integer idLinea) {
		
		lineaRepository.deleteById(idLinea);
		
}
  }
