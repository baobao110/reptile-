package com.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanUtils {
	
	private static final ApplicationContext context;
	
	static {
		context = new ClassPathXmlApplicationContext("spring/spring-config.xml");//加载spring
	}
	
	public static <T> T getBean(Class<T> clazz) {
		return context.getBean(clazz);//泛型根据类获取相应的对象
	}
	
}
