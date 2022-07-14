package it.uniroma3.siw.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

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

//	public void newPiattoPerBuffet(Long buffetId) {
//		Piatto piatto = new Piatto();
//		this.piattoRepository.save(null);
//	}
	
	@Transactional
	public void savePiatto(Piatto piatto) {
		this.piattoRepository.save(piatto);
	}
	
	public List<Piatto> findAll() {
		List<Piatto> piatti = new ArrayList<Piatto>();
		for(Piatto p: this.piattoRepository.findAll()) {
			piatti.add(p);
		}
		return piatti;
	}

}
