package com.mmall.concurrency.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	@ResponseBody
	public String hello() {
		String sentense="Hello World";
		System.out.println(sentense);
		return sentense;
	}
}
