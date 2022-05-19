package fonia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="cliente")
public class Cliente {
	
	@Id
	@NotNull(message="id cliente obbligatorio")
	@Column(name="id_cliente")
	private Integer idCliente;
	
	
	@NotNull(message="nome cliente obbligatorio")
	@Column(name="nome")
	private String nome;
	
	
	@NotNull(message="cognome cliente obbligatorio")
	@Column(name="cognome")
	private String cognome;
	
	
	@NotNull(message="email cliente obbligatorio")
	@Column(name="email")
	private String email;
	

	@NotNull(message="cf cliente obbligatorio")
	@Column(name="cf")
	private String cf;
	

	
	



	public Integer getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCf() {
		return cf;
	}


	public void setCf(String cf) {
		this.cf = cf;
	}


	

	public Cliente() {
		
	}

	public Cliente( Integer idCliente,String nome, String cognome, String email, String cf) {
		
		this.idCliente=idCliente;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.cf = cf;
	}
	


	
	

	

}
