package com.mmall.concurrency.ioc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mmall.concurrency.ioc.entity.Person;

//@Configuration
public class ApplicationConfig {
	//@Bean(name="person")
	public Person initPerson() {
		Person user=new Person();
		user.setId(1L);
		user.setName("Jack");
		return user;
	}
}
