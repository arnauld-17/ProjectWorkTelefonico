package fonia.repository;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fonia.model.Cliente;
import fonia.model.Linea;
import fonia.repository.ClienteRepository;
import fonia.repository.LineaRepository;



@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	

	public Cliente createCliente(Cliente client) {
		
		return client= clienteRepository.save(client);

	}
	
	public Optional<Cliente>  getCliente(int idCliente) {
		
		
		return clienteRepository.findById(idCliente);
	}
	
	@Transactional
	public void UpdateCliente( Integer idCliente,String nome, String cognome, String email, String cf) {
		
		Cliente cliente= clienteRepository.findById(idCliente).orElse(null);
		
		if(nome!=null)
			cliente.setNome(nome);
		if(cognome!=null)
			cliente.setCognome(cognome);
		if(email!=null)
			cliente.setEmail(email);
		if(cf!=null)
			cliente.setCf(cf);
		
	}


	
	
	
	public void DeleteCliente( Integer idCliente) {
		
		clienteRepository.deleteById(idCliente);
		
		
		
	}
	
}
