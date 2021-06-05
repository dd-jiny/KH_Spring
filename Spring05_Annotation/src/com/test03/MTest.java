package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");
		
		TV samsung = factory.getBean("samsung", TV.class);
		samsung.powerOn();
		samsung.volumeUp();
		samsung.volumeDown();
		samsung.powerOff();
		
		TV lg = (TV) factory.getBean("lgTV");
		lg.powerOn();
		lg.volumeUp();
		lg.volumeDown();
		lg.powerOff();
	}

}
