package it.uniroma3.siw.spring.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.spring.model.Buffet;

public interface BuffetRepository extends CrudRepository<Buffet, Long> {
	
	//private List<Piatto> findByBuffet_Piatto_Id();

}
