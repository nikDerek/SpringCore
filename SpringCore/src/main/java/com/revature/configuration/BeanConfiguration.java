package com.revature.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.revature.repository.UserRepository;

/*
 * We also have another option for declaring beans.  @Configuration annotation - allows for declaring
 * of beans using the @Bean annotation above methods.
 */

@Configuration
public class BeanConfiguration {
	
	@Bean(name = "userRepository")
	@Scope("singleton") //defines how the bean is created (prototype - new instance every time the bean is 
						//requested)
	public UserRepository userRepository() {
		return new UserRepository();
	}

}
