package it.uniroma3.siw.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Chef;
import it.uniroma3.siw.spring.repository.ChefRepository;

@Service
public class ChefService {
	
	@Autowired
	private ChefRepository chefRepository;
	
	public Chef findById(Long id) {
		return chefRepository.findById(id).get(); // Mettiamo .get() perché altrimenti ritorna un Optional
	}

}
