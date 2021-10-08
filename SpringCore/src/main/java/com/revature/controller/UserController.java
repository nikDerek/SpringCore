package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exception.BusinessException;
import com.revature.model.User;
import com.revature.service.UserService;


/*
 * @Controller is a specialized stereotype for web layer of our application.
 */
@RestController("userController")
/*
 * This controller is mapped to "/user", which means that if HTTP should contain it as a part of the URL 
 * request then the framework will delegate this controller.
 */
@RequestMapping("/user")
public class UserController {

	//as usual we will need a userService
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
//	@GetMapping(path="/home")
//	@ResponseBody
//	public String goHome(){
//		return "home";		
//	}
	
	@GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> findAll(){
		return this.userService.findAll();
	}
	
	@GetMapping(path = "/all1", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> findAll1(){		
		/*
		 * ResponseEntity allows us to specify the status code that we intend to send to the 
		 * client
		 */
		//ResponseEntity<List<User>> responseEntity = new ResponseEntity<>();
		return new ResponseEntity<List<User>>(this.userService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/userName/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public User findByUserName(@PathVariable String userName) {
		return this.userService.findByUserName(userName);
	}
	
	//@RequestMapping(method = RequestMethod.GET)
	@GetMapping(path = "/userNameV2", produces = MediaType.APPLICATION_JSON_VALUE)
	public User findByUserNameV2(@RequestParam String userName) {
		return this.userService.findByUserName(userName);
	}
	
	/*
	 * consumes attribute specifies which data formats the client may send in the request
	 */
	@PostMapping(path = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveUser(@RequestBody User user) {
		this.userService.save(user);
	}
	/*
	 * proof of concept for Exception handler
	 */
	@GetMapping(path = "/exception")
	public void throwException() {
			throw new RuntimeException();	
	}
	/*
	 * proof for @ResponseStatus
	 */
	
	@GetMapping(path = "/exception-handling")
	public void throwBusinessException() throws BusinessException {
		throw new BusinessException();
	}
	
	/*
	 * Spring web has several built in mechanisms for exception handling. For instance we 
	 * often need to think about what sort of response a client will get in a case f an 
	 * exception.
	 * You can handle any kind of exception but its best practice to be specific about the 
	 * type of exception your handler handles
	 */
//	@ExceptionHandler(Exception.class)
//	public String handleException() {
//		return "Something went wrong!";
//	}
}
