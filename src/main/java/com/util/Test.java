package com.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static ApplicationContext context;
	
	public static void main(String[] args) {
		init();
		getCatalog();
	
	}
	
	public static void init() {
		context=new ClassPathXmlApplicationContext("spring/spring-config.xml");
	}
	
	public static void getCatalog() {
		
	}

}
