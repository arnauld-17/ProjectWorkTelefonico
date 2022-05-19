package fonia.model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
@Table(name="chiamata")
public class Chiamata {

	
	@Id
	@NotNull(message="id chiamata obbligatorio")
	@Column(name="id_chiamata")
	private Integer idChiamata;
	
	
	
	@ManyToOne
	@JoinColumn(name="id_linea",referencedColumnName= "num_telefono")
	private Linea linea;
	
	@Transient
	private Integer idLinea;
	
	
	@NotNull(message="data inizio obbligatorio")
	@Column(name="data_inizio")
	private LocalDateTime dataInizio;
	
	@NotNull(message="data fine obbligatorio")
	@Column(name="data_fine")
	private LocalDateTime dataFine;
	
	@Transient
	private int durata=0;
	
	

	public int getDurata() {
		setDurata();
		return this.durata;
	}

	public void setDurata() {
		if(this.durata==0) {
			Duration duration= Duration.between(dataInizio, dataFine);
			this.durata = (int)duration.toMinutes();
		}		
	}

	public Integer getIdChiamata() {
		return idChiamata;
	}

	public void setIdChiamata(Integer idChiamata) {
		this.idChiamata = idChiamata;
	}

	public Integer getIdLinea() {
		return idLinea;
	}

	public void setIdLinea(Integer idLinea) {
		this.idLinea = idLinea;
	}

	public LocalDateTime getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDateTime dataInizio) {
		this.dataInizio = dataInizio;
	}

	public LocalDateTime getDataFine() {
		return dataFine;
	}

	public void setDataFine(LocalDateTime dataFine) {
		this.dataFine = dataFine;
	}
	
	

	public Linea getLinea() {
		return linea;
	}

	public void setLinea(Linea linea) {
		this.linea = linea;
	}

	public Chiamata( int idChiamata, Integer idLinea, LocalDateTime dataInizio,LocalDateTime dataFine) {
		this.idChiamata = idChiamata;
		this.idLinea = idLinea;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
	}

	public Chiamata() {
		super();
	}
	
	
	
	
}
