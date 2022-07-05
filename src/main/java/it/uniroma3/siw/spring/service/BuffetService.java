package it.uniroma3.siw.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Buffet;
import it.uniroma3.siw.spring.repository.BuffetRepository;

@Service
public class BuffetService {
	
	@Autowired
	private BuffetRepository buffetRepository;

	public List<Buffet> findAll() {
		List<Buffet> buffets = new ArrayList<Buffet>();
		for(Buffet b: this.buffetRepository.findAll()) {
			buffets.add(b);
		}
		return buffets;
	}
	
	public Buffet getBuffet(Long id) {
		return this.buffetRepository.findById(id).get();
	}
	
	@Transactional
	public void saveBuffet(Buffet buffet) {
		this.buffetRepository.save(buffet);
	}

}
