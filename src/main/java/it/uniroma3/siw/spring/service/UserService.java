package it.uniroma3.siw.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.User;
import it.uniroma3.siw.spring.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional // Operazione di aggiornamento dei dati nel DB
	public void save(User user) {
		this.userRepository.save(user);
	}
	
	public User findById(Long id) {
		return userRepository.findById(id).get();
	}
	
	public List<User> findAllUsers() {
		List<User> users = new ArrayList<User>();
		
		for(User u: userRepository.findAll())
			users.add(u);
		
		return users;
	}

}
