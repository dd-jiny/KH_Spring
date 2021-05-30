package com.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test04/applicationContext.xml");
		
		Address lee = (Address)factory.getBean("lee");	
		//factory.getBean("lee"); -> object타입 
		//bean객체에 담겨져있는 값이 어떤 값인지 몰라 가장큰 object로 가져옴 
		//object타입을 Address타입으로 형변환  
		Address hong = (Address)factory.getBean("hong");
		
		System.out.println(lee);
		System.out.println(hong);

	}

}
