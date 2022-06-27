package it.uniroma3.siw.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Chef {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private String cognome;
	
	private String nazionalita;
	
	@OneToMany(mappedBy = "chef")
	private List<Buffet> buffets;
	
	public Chef() {
		this.buffets = new ArrayList<Buffet>();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNazionalita() {
		return this.nazionalita;
	}

	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}

	public List<Buffet> getBuffets() {
		return this.buffets;
	}

	public void setBuffets(List<Buffet> buffets) {
		this.buffets = buffets;
	}
	
	@Override
	public int hashCode() {
		return this.getNome().hashCode() + this.getCognome().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Chef altroChef = (Chef)obj;
		return this.getNome().equals(altroChef.getNome()) && this.getCognome().equals(altroChef.getCognome());
	}
	
}
