package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.uniroma3.siw.spring.controller.validator.ChefValidator;
import it.uniroma3.siw.spring.model.Chef;
import it.uniroma3.siw.spring.service.ChefService;

@Controller
public class ChefController {
	
	@Autowired
	private ChefService chefService;
	
    @Autowired
    private ChefValidator chefValidator;
    
    @GetMapping("buffet/chef/{id}")
    public String getChef(@PathVariable("id") Long id, Model model) {
    	Chef chef = this.chefService.findById(id);
    	model.addAttribute("chef", chef);
    	return "chef.html";
    }

}
