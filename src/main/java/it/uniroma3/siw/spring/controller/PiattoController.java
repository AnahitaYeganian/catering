package it.uniroma3.siw.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.spring.controller.validator.PiattoValidator;
import it.uniroma3.siw.spring.model.Piatto;
import it.uniroma3.siw.spring.service.BuffetService;
import it.uniroma3.siw.spring.service.PiattoService;

@Controller
public class PiattoController {
	
	@Autowired
	private PiattoService piattoService;
	
    @Autowired
    private PiattoValidator piattoValidator;
    
    @Autowired
    private BuffetService buffetService;
    
    @GetMapping("buffet/piatto/{id}")
    public String getPiattiPerBuffet(@PathVariable("id") Long id, Model model) {
    	List<Piatto> piatti = this.piattoService.findPiattiByBuffet_Id(id);
    	model.addAttribute("piatti", piatti);
    	return "piatti.html";
    }
    
    @GetMapping("buffet/newPiatto/{id}")
    public String newPiattoPerBuffet(@PathVariable("id") Long buffetId, Model model) {
    	Piatto nuovoPiatto = new Piatto();
    	//nuovoPiatto.setBuffet(this.buffetService.getBuffet(buffetId));
    	model.addAttribute("nuovoPiatto", nuovoPiatto);
    	model.addAttribute("buffetId", buffetId);
    	return "admin/piattoDetailsForm.html";
    }
    
    @PostMapping("buffet/newPiatto")
    public String salvaPiatto(@Valid @ModelAttribute("nuovoPiatto") Piatto nuovoPiatto, BindingResult piattoBindingResult, Model model) {
    	this.piattoValidator.validate(nuovoPiatto, piattoBindingResult);

        if(!piattoBindingResult.hasErrors()) {
        	this.piattoService.savePiatto(nuovoPiatto);
            //model.addAttribute("modificaAvvenuta", new String("L'utente inserito è stato registrato"));
        	model.addAttribute("piatti", this.piattoService.findPiattiByBuffet_Id(nuovoPiatto.getBuffet().getId()));
            return "piatti.html";
        }
        
        return "admin/buffets.html";
    }
    
}
