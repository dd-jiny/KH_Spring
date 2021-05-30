package com.test07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	//사용
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test07/applicationContext.xml");
		//lazy init을 했을때 객체는 컨테이너가 만들어질때 applicationContext.xml 빈객체에 넣어주며 생성 
		System.out.println("spring ioc container 준비 완료!");
		
		TV tv = (TV) factory.getBean("samsung");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();

	}

}
