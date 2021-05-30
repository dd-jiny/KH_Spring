package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory= new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		//ApplicationContext는 bean을 담을 컨테이너,그릇이다.
		//객체화 되는 시점은 xml을 읽어 들일 때 
		Emp lee = (Emp)factory.getBean("lee");
		Emp hong = (Emp)factory.getBean("hong");
		
		System.out.println(lee);
		System.out.println(hong);

	}

}
