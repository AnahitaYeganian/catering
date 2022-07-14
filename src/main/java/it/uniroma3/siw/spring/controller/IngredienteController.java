package it.uniroma3.siw.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.uniroma3.siw.spring.model.Ingrediente;
import it.uniroma3.siw.spring.service.IngredienteService;

@Controller
public class IngredienteController {
	
	@Autowired
	private IngredienteService ingredienteService;
    
    @GetMapping("buffet/piatto/ingrediente/{id}")
    public String getIngredientiPerPiatto(@PathVariable("id") Long id, Model model) {
    	List<Ingrediente> ingredienti = this.ingredienteService.findIngredientiByPiatto_Id(id);
    	model.addAttribute("ingredienti", ingredienti);
    	return "ingredienti.html";
    }

}
