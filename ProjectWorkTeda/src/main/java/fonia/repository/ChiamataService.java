package fonia.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fonia.model.Chiamata;
import fonia.model.Cliente;
import fonia.model.Linea;

@Service
public class ChiamataService {
	
	@Autowired
	private  ChiamataRepository chiamataRepository;
	
	@Autowired
	private LineaRepository lineaRepository;
	
	
public Chiamata createChiamata(Chiamata chiamata) {
	
		Linea linea = lineaRepository.findById(
				chiamata.getIdLinea()).orElse(null);
		
		chiamata.setLinea(linea);
		return chiamata = chiamataRepository.save(chiamata);

	}
	
	public Optional<Chiamata>  getChiamata(int idChiamata) {
		
		
		return chiamataRepository.findById(idChiamata);
	
	}
	
	@Transactional
	public void UpdateChiamata( int idChiamata, int idLinea, LocalDateTime dataInizio,LocalDateTime dataFine) {
		
		Chiamata chiamata= chiamataRepository.findById(idChiamata).orElse(null);
		
		if(dataInizio!=null)
			chiamata.setDataInizio(dataInizio);
		if(dataFine!=null)
			chiamata.setDataFine(dataFine);
		
	}
	
     public void DeleteChiamata( Integer idChiamata) {
		
	chiamataRepository.deleteById(idChiamata);
		
	
    }


     public int getReport(int idLinea){
    	 
    	 Linea linea = lineaRepository.findById(idLinea).orElse(null);
    	 List <Chiamata> chiamate= chiamataRepository.findByLinea(linea);
    	 int minuti=0;
    	 
    	 for(Chiamata c: chiamate) {
    		 minuti+=c.getDurata();
    	 }
    	 
    	 return minuti;
    	 
    	 
     }
}
