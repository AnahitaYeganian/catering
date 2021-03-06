package it.uniroma3.siw.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Piatto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(unique=true)
	@NotBlank
	private String nome;
	
	private String descrizione;
	
	@ManyToOne
	private Buffet buffet;
	
	@OneToMany
	@JoinColumn(name = "piatto_id")
	private List<Ingrediente> ingredienti;
	
	public Piatto() {
		this.ingredienti = new ArrayList<Ingrediente>();
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

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public List<Ingrediente> getIngredienti() {
		return this.ingredienti;
	}

	public void setIngredienti(List<Ingrediente> ingredienti) {
		this.ingredienti = ingredienti;
	}
	
	public Buffet getBuffet() {
		return this.buffet;
	}

	public void setBuffet(Buffet buffet) {
		this.buffet = buffet;
	}

	@Override
	public int hashCode() {
		return this.getNome().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Piatto altroPiatto = (Piatto)obj;
		return this.getNome().equals(altroPiatto.getNome());
	}

}
