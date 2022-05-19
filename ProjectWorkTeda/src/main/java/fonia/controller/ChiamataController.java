package fonia.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fonia.model.Chiamata;
import fonia.model.Cliente;
import fonia.repository.ChiamataService;
import fonia.repository.ClienteService;

@RestController
@RequestMapping("/chiamata")
public class ChiamataController {
	
	@Autowired
	
	ChiamataService   chiamataService;
	
	@PostMapping("/create")
    public Chiamata createchiama(@RequestBody Chiamata chiamata){
		
    	 return chiamataService.createChiamata(chiamata);
    }
	
	@GetMapping("/")
	public Optional<Chiamata> getChiamata(@RequestParam int idChiamata) {
		System.out.println(idChiamata);
		return chiamataService.getChiamata(idChiamata);
	}
	
	
	@PutMapping(path= "{idChiamata}")
	public void UpdateChiamata(@PathVariable("idChiamata") int idChiamata,
                            @RequestParam(required= false) LocalDateTime dataInizio,
	                       @RequestParam(required= false) LocalDateTime dataFine){
                                                        
          
        chiamataService.UpdateChiamata(idChiamata, idChiamata, dataInizio,dataFine);
		
	}
	
	@DeleteMapping(path= "{idChiamata}")
	public void DeleteChiamata(@PathVariable int idChiamata) {
		
		 chiamataService.DeleteChiamata(idChiamata);
	}

	
	@GetMapping("/report")
	public String getReport(@RequestParam int idLinea) {
		
		
		return "NUMERO: "+idLinea+"\nNUMERO TOTALE MINUTI: "+chiamataService.getReport(idLinea);
		
	}
	
	
}
