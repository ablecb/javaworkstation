package com.mmall.concurrency.ioc.entity;

import org.springframework.stereotype.Component;

@Component
public class Dog implements Pet{

	public void move() {
		System.out.println("running-----------");
		
	}

}
