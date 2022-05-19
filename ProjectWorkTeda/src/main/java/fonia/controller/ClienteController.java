package fonia.controller;

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

import fonia.model.Cliente;
import fonia.repository.ClienteService;


@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteService   clienteService;

	@PostMapping("/create")
    public Cliente createLoan(@RequestBody Cliente cliente){
		
    	 return clienteService.createCliente(cliente);
    }
	
	@GetMapping("/")
	public Optional<Cliente> getCliente(@RequestParam int idCliente) {
		System.out.println(idCliente);
		return clienteService.getCliente(idCliente);
	}
	
	@PutMapping(path= "{idCliente}")
	public void UpdateCliente(@PathVariable("idCliente") int idCliente,
							  @RequestParam(required= false) String nome,
                              @RequestParam(required= false) String cognome,
                              @RequestParam(required= false) String email,
                              @RequestParam(required= false) String cf){
		
		System.out.println(idCliente+" "+nome);	                             
		clienteService.UpdateCliente(idCliente, nome, cognome, email, cf);
		
	}
	
	
	
	@DeleteMapping(path= "{idCliente}")
	public void DeleteCliente(@PathVariable int idCliente) {
		
		clienteService.DeleteCliente(idCliente);
	}
	
	}
