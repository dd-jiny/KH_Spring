package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	//@Autowired가 있고 없고의 차이...
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		School mySchool = (School) factory.getBean("mySchool");
		System.out.println(mySchool);
		
	}

}
