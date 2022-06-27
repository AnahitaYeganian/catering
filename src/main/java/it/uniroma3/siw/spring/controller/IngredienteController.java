package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import it.uniroma3.siw.spring.controller.validator.IngredienteValidator;
import it.uniroma3.siw.spring.service.IngredienteService;

@Controller
public class IngredienteController {
	
	@Autowired
	private IngredienteService ingredienteService;
	
    @Autowired
    private IngredienteValidator ingredienteValidator;

}
