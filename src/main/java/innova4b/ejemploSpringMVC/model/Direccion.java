package innova4b.ejemploSpringMVC.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="direccion")
public class Direccion {
	@Id
	@GeneratedValue
	private long id;
	private String calle;
	private Integer portal;
	private Integer piso;
	private String letra;
	private String otros;
	@Column(name="codigo_postal")
	private Integer codigoPostal;
	private String municipio;
	
	@ManyToOne
	@JoinColumn(name = "persona_id", referencedColumnName = "id")
	private Persona persona;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public Integer getPortal() {
		return portal;
	}
	public void setPortal(Integer portal) {
		this.portal = portal;
	}
	public Integer getPiso() {
		return piso;
	}
	public void setPiso(Integer piso) {
		this.piso = piso;
	}
	public String getLetra() {
		return letra;
	}
	public void setLetra(String letra) {
		this.letra = letra;
	}
	public String getOtros() {
		return otros;
	}
	public void setOtros(String otros) {
		this.otros = otros;
	}
	public Integer getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	public String getDireccionSimple(){
		return this.calle+" "+this.portal+", "+this.municipio;
	}
	
	
}
