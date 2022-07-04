package it.uniroma3.siw.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.spring.model.Ingrediente;

public interface IngredienteRepository extends CrudRepository<Ingrediente, Long> {
	
	@Query("SELECT i FROM Piatto p JOIN p.ingredienti i WHERE p.id=:id")
	public List<Ingrediente> findIngredientiByPiatto_Id(Long id);

}
