package com.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {
	
	
	public static void main(String[] args) {
	
		getCatalog();
		
	}
	
	public static void getCatalog() {
		Productor a=new Productor();
		Customer b=new Customer();
		Customer1 c=new Customer1();
		Customer2 d=new Customer2();
		new Thread(a).start();
		new Thread(b,"1").start();
		new Thread(c,"2").start();
		new Thread(d,"3").start();
	}
}
