package com.revature.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.User;
import com.revature.repository.UserRepository;



@Transactional

@Service("userService")
public class UserService {

private UserRepository userRepository;
	/*
	 * Lets say that I want to log some information about what is occuring in my service layer.
	 * If I wish to do so, I already ahve the dependencies needed to easily log.
	 */

	//private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> findAllUsers(){
		//LOGGER.info("The FindAll() method within my UserService class was called.");
		List<User> allUsers = this.userRepository.findAll();
		
		return allUsers;
	}
	
	public List<User> findAll(){
		
		return this.userRepository.findAll();
	}
	
	public void save(User user) {
		this.userRepository.save(user);
	}
	
//	public User findById(String pathParam) {
//		
//		return this.userRepository.findUserById(pathParam);
//	}
	
	public User findByUserName(String userName) {
		
		return this.userRepository.findByUserName(userName);
	}
	
//	public User LogIn(String userName) {
//		System.out.println("4");
//		return this.userRepository.logIn(userName);
//	}
}
