package it.uniroma3.siw.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.uniroma3.siw.spring.controller.validator.BuffetValidator;
import it.uniroma3.siw.spring.model.Buffet;
import it.uniroma3.siw.spring.service.BuffetService;

@Controller
public class BuffetController {
	
	@Autowired
	private BuffetService buffetService;
	
    @Autowired
    private BuffetValidator buffetValidator;
    
    @GetMapping("/buffet")
    public String getBuffets(Model model) {
    	List<Buffet> buffets = buffetService.findAll();
		model.addAttribute("buffets", buffets);
		return "buffets.html";
    }
    
}