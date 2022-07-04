package it.uniroma3.siw.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.uniroma3.siw.spring.controller.validator.PiattoValidator;
import it.uniroma3.siw.spring.model.Piatto;
import it.uniroma3.siw.spring.service.PiattoService;

@Controller
public class PiattoController {
	
	@Autowired
	private PiattoService piattoService;
	
    @Autowired
    private PiattoValidator piattoValidator;
    
    @GetMapping("buffet/piatto/{id}")
    public String getPiattiPerBuffet(@PathVariable("id") Long id, Model model) {
    	List<Piatto> piatti = this.piattoService.findPiattiByBuffet_Id(id);
    	model.addAttribute("piatti", piatti);
    	return "piatti.html";
    }
    
}
