package com.mmall.concurrency.ioc.entity;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Bird implements Pet{

	public void move() {
		System.out.println("fly");
		
	}

}
