package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.service.UserService;

public class Driver {
	
	public static void main(String[] args) {
		
		/*
		 * As proof of concept, we will attempt to grab a bean from our IOC container. There is
		 * an ApplicationContext interface which allows us to access beans in our IOC container.
		 * Please note that there are several implementations of the ApplicationContext:
		 * 
		 * ClassPathXmlApplicationContext
		 * FileSystemXmlApplicationContext
		 * AnnotationConfigApplicationContext
		 */
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserService userService = context.getBean("userService", UserService.class);
		
		System.out.println(userService.findAll());
		
		
		
	}

}
