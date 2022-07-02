package it.uniroma3.siw.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.uniroma3.siw.spring.model.User;
import it.uniroma3.siw.spring.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
//	/* Per inserire i dati di un User all'interno del sistema */
//	@PostMapping("/user")
//	public String addUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
//		if(!bindingResult.hasErrors()) {
//			userService.save(user);
//			model.addAttribute("user", user);
//			return "user.html";
//		}
//		else {
//			return "registrazione.html";
//		}
//	}
	
	/* I metodi che dialogano con le viste hanno sempre come parametro Model*/
	@GetMapping("/user/{id}")
	public String getUser(@PathVariable("id") Long id, Model model) {
		User user = userService.getUser(id);
		model.addAttribute("user", user);
		return "user.html";
	}
	
	@GetMapping("/users")
	public String getUsers(Model model) {
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "users.html";
	}

}