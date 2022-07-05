package it.uniroma3.siw.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    
    @GetMapping("/adminBuffet")
    public String getAdminBuffets(Model model) {
    	List<Buffet> buffets = buffetService.findAll();
		model.addAttribute("buffets", buffets);
		return "admin/buffets.html";
    }
    
    @GetMapping("/updateBuffet/{id}")
	public String updateUser(@PathVariable("id") Long id, Model model, HttpSession session) {
    	Buffet buffet = this.buffetService.getBuffet(id);
    	
		model.addAttribute("buffet", buffet);
		session.setAttribute("currentBuffet", buffet);
		return "admin/buffetDetailsForm.html";
	}
	
	@PostMapping("/updateBuffet")
    public String updateBuffet(@Valid @ModelAttribute("buffet") Buffet buffet, BindingResult buffetBindingResult, Model model, HttpSession session) {
		
		this.buffetValidator.validate(buffet, buffetBindingResult);
        
		if(!buffetBindingResult.hasErrors()) {
        	Buffet currentBuffet = (Buffet)session.getAttribute("currentBuffet");
			
        	currentBuffet.setNome(buffet.getNome());
        	currentBuffet.setDescrizione(buffet.getDescrizione());
        	
        	this.buffetService.saveBuffet(currentBuffet);
            //model.addAttribute("modificaAvvenuta", new String("L'utente inserito è stato registrato"));
        	model.addAttribute("buffets", this.buffetService.findAll());
            return "admin/buffets.html";
        }
        
        return "admin/buffetDetailsForm.html";
    }
    
}