package it.uniroma3.siw.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Ingrediente;
import it.uniroma3.siw.spring.repository.IngredienteRepository;

@Service
public class IngredienteService {
	
	@Autowired
	private IngredienteRepository ingredienteRepository;
	
	public List<Ingrediente> findIngredientiByPiatto_Id(Long id) {
		List<Ingrediente> ingredienti = new ArrayList<Ingrediente>();
		for(Ingrediente i: this.ingredienteRepository.findIngredientiByPiatto_Id(id)) {
			ingredienti.add(i);
		}
		return ingredienti;
	}

}
