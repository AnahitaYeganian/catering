package it.uniroma3.siw.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String login(Model model) {
			return "login.html";
	}
	
	@GetMapping("registrazione")
	public String registrazione(Model model) {
			return "registrazione.html";
	}
	
	@GetMapping("login")
	public String tornaAllaPaginaDiLogin(Model model) {
			return "login.html";
	}
	
	@GetMapping("confermaLogin")
	public String confermaLogin(Model model) {
			return "";
	}
	
	@GetMapping("confermaRegistrazione")
	public String confermaRegistrazione(Model model) {
			return "";
	}
}