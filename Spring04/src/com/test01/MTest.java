package com.test01;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		//만드는 놈 : 이 만드는 놈이 xml파일을 읽어 들어옴 
		//1.xml 파일을 읽어온다 
		//2.xml에 있는 bean객체를 읽는다.
		//3.bean태그 안에 있는 id를 개체로 만든다. 
		//4.스프링은 그 객체를 가지고 있는다.  그것이 applicationContext
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/applicationContext.xml");
		//ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/applicationContext.xml");->스프링IOC컨테이너
		System.out.println("-----------------------------------");
		
		//xml에서 만들어진 애들을 가져와서 사용 
		Date today = (Date) factory.getBean("today");
		System.out.println(today.toLocaleString());
		
		MyClass myclass = (MyClass) factory.getBean("myclass");
		myclass.prn();
		
		/*
		 MyClass Constructor!!!
		 2021. 5. 21. 오전 1:57:13
	     MyClass.prn(); !!!!!
	     이렇게 되는 이유 : 
	     1.ApplicationContext 를 사용하며 applicationContext.xml 의 bean태그의 객체를 만들며
	     생성자를 호출 -> MyClass Constructor!!! 출력!
	     
	     2. applicationContext에서 객체를 만들어 놓음 Date객체를 가지고 와서 출력 
	     System.out.println(today.toLocaleString()); 호출하여 2021. 5. 21. 오전 1:57:13 출력
	     
	     3. applicationContext.xml 에서 만들어진 객체를 가지고와서 사용  
	    MyClass myclass = (MyClass) factory.getBean("myclass");
		myclass.prn();
		myclass안에 prn메소드를 호출하여 MyClass.prn(); !!!!! 출력 
		
		생성과 사용 분리~
	    
		 */

	}

}
