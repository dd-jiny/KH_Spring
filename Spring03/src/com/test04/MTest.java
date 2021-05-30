package com.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test04/beans.xml");
		
		Developer lee = factory.getBean("lee-ss", Developer.class);
		//Developer.class -> "lee-ss"를 가져오면 obj로 가져오게 되어 형변환을 해줘야한다. 뒤에 Devleoper.class(developer클래스타입) 를 써주면 자동으로 형 변환해준다. 
		Engineer hong = (Engineer) factory.getBean("hong-gd");
		
		System.out.println(lee);
		System.out.println(hong);

	}

}
