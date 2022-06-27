package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import it.uniroma3.siw.spring.controller.validator.ChefValidator;
import it.uniroma3.siw.spring.service.ChefService;

@Controller
public class ChefController {
	
	@Autowired
	private ChefService chefService;
	
    @Autowired
    private ChefValidator chefValidator;

}
