package fonia.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="linea")
public class Linea {
	
	@Id
	@NotNull(message="id linea obbligatorio")
	@Column(name="num_telefono")
	private int idLinea;
	
	@NotNull(message="tipo linea obbligatorio")
	@Column(name="tipo_linea")
	private String tipoLinea;
	
	
	@Column(name="stato_linea")
	private String  statoLinea;

	@ManyToOne
	@JoinColumn(name="id_cliente",referencedColumnName= "id_cliente")
	private Cliente cliente;

	@Transient
	private int idCliente;

	public int getIdLinea() {
		return idLinea;
	}


	public void setIdLinea(Integer idLinea) {
		this.idLinea = idLinea;
	}


	public String getTipoLinea() {
		return tipoLinea;
	}


	public void setTipoLinea(String tipoLinea) {
		this.tipoLinea = tipoLinea;
	}


	public String getStatoLinea() {
		return statoLinea;
	}


	public void setStatoLinea(String statoLinea) {
		this.statoLinea = statoLinea;
	}


	

	
	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Linea() {
		
	}
	public Linea( int idLinea, String tipoLinea, int idCliente) {
		this.idLinea = idLinea;
		this.tipoLinea = tipoLinea;
		this.idCliente=idCliente;
		
	}

	

	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	@Override
	public String toString() {
		return "Linea [idLinea=" + idLinea + ", tipoLinea=" + tipoLinea + ", statoLinea=" + statoLinea + ", cliente="
				+ cliente + "]";
	}


	

	/*public Linea( int idLinea, String tipoLinea, String statoLinea) {
		this.idLinea = idLinea;
		this.tipoLinea = tipoLinea;
		this.statoLinea = statoLinea;
		/*this.listCliente = listCliente;
	}*/


	
	    

	
	

}
