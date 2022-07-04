package it.uniroma3.siw.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.spring.model.Piatto;

public interface PiattoRepository extends CrudRepository<Piatto, Long> {
	
//	@Query("select p from Piatto p join Buffet b on p.buffet_id=b.id where b.id=:id")
//	public List<Piatto> findByBuffet(Long id);
//	//@Query("select p from Piatto p where p.buffet_id = :buffet_id")
	
	@Query("SELECT p FROM Buffet b JOIN b.piatti p WHERE b.id=:id")
	public List<Piatto> findPiattiByBuffet_Id(Long id);

}
