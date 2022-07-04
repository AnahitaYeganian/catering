package it.uniroma3.siw.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Piatto;
import it.uniroma3.siw.spring.repository.PiattoRepository;

@Service
public class PiattoService {
	
	@Autowired
	private PiattoRepository piattoRepository;
	
	public List<Piatto> findPiattiByBuffet_Id(Long id) {
		List<Piatto> piatti = new ArrayList<Piatto>();
		for(Piatto p: this.piattoRepository.findPiattiByBuffet_Id(id)) {
			piatti.add(p);
		}
		return piatti;
	}

}
