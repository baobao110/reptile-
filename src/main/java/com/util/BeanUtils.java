package com.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanUtils {
	
	private static final ApplicationContext context;
	
	static {
		context = new ClassPathXmlApplicationContext("spring/spring-config.xml");//����spring
	}
	
	public static <T> T getBean(Class<T> clazz) {
		return context.getBean(clazz);//���͸������ȡ��Ӧ�Ķ���
	}
	
}
