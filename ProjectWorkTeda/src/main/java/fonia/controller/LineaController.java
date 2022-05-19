package fonia.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fonia.model.Cliente;
import fonia.model.Linea;
import fonia.repository.LineaRepository;
import fonia.repository.LineaService;


@RestController
@RequestMapping("/linea")
public class LineaController {
	@Autowired
	LineaService lineaService;
	

	@PostMapping("/create")
    public Linea createLine(@RequestBody Linea linea){
		 System.out.println(linea.getIdCliente());
		 return lineaService.createLinea(linea);
    }
	
	@GetMapping("/")
	public Optional<Linea> getLinea(@RequestParam int idLinea) {
		System.out.println(idLinea);
		
		return lineaService.getLinea(idLinea);
	}
	
	
	@PutMapping(path= "{idLinea}")
	public void UpdateLinea(@PathVariable("idLinea") int idLinea,
                            @RequestParam(required= false) String statoLinea) {
        System.out.println(idLinea+" "+statoLinea);                                                   
		lineaService.UpdateLinea(idLinea, statoLinea);
		
	}
	
	@DeleteMapping(path= "{idLinea}")
	public void DeleteLinea(@PathVariable int idLinea) {
		
		lineaService.DeleteLinea(idLinea);
	}
	
}
