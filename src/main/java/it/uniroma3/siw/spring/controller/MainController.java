package it.uniroma3.siw.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.uniroma3.siw.spring.model.User;

@Controller
public class MainController {
	
	//@GetMapping({"/", "index"})
	@GetMapping("/")
	public String mostraFormLogin() {
		return "index.html";
	}
	
}