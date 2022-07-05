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

import it.uniroma3.siw.spring.controller.validator.CredentialsValidator;
import it.uniroma3.siw.spring.controller.validator.UserValidator;
import it.uniroma3.siw.spring.model.Credentials;
import it.uniroma3.siw.spring.model.User;
import it.uniroma3.siw.spring.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private CredentialsValidator credentialsValidator;
	
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
	
	@GetMapping("/updateUser/{userId}")
	public String updateUser(@PathVariable("userId") Long userId, Model model) {
		model.addAttribute("user", this.userService.getUser(userId));
		model.addAttribute("credentials", this.userService.getCredentialsService().findCredentialsByUser_Id(userId));
		return "userDetailsForm.html";
	}
	
	@PostMapping("/updateUser")
    public String updateUser(@Valid @ModelAttribute("user") User user, BindingResult userBindingResult,
                 @Valid @ModelAttribute("credentials") Credentials credentials, BindingResult credentialsBindingResult, Model model, HttpSession session) {
		
        this.userValidator.validate(user, userBindingResult);
        this.credentialsValidator.validate(credentials, credentialsBindingResult);

        if(!userBindingResult.hasErrors() && ! credentialsBindingResult.hasErrors()) {
        	
        	User currentUser = (User)session.getAttribute("currentUser");
        	Credentials currentCredentials = (Credentials)session.getAttribute("currentCredentials");
        	
        	currentUser.setNome(user.getNome());
        	currentUser.setCognome(user.getCognome());
        	currentCredentials.setUsername(credentials.getUsername());
        	currentCredentials.setPassword(credentials.getPassword());
        	
        	//currentCredentials.setUser(currentUser); non serve
            this.userService.getCredentialsService().saveCredentials(currentCredentials);
            model.addAttribute("modificaAvvenuta", new String("L'utente inserito è stato registrato"));
            return "home.html";
        }
        
        return "userDetailsForm.html";
    }

}