package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		//기존 방식 
		//1.
		//Resource res = new fileSystemResource("src/com/test03/beans.xml");
		
		//2.
		//Resource res = new ClassPathResource("com/test03/beans.xml");
		//BeanFactory factory = new XmlBeanFactory(res);
		
		
		//3. 
		//IoC (Inversion of Control : 생성은 스프링이 사용은 여기서MTest 해줌
		//객체 생성은 beans에서 스프링이 해준다 
		//만드는곳과 사용하는 곳이 달라졌다. -> 결합도가 낮아진다. 
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/beans.xml");
		
		MessageBean korean = (MessageBean) factory.getBean("korean");
		MessageBean english = (MessageBean) factory.getBean("english");
		
		korean.sayHello("스프링");
		english.sayHello("Spring");

	}

}

/*
ApplicationContext / ClassPathXmlApplicationContext

BeanFactory <- ApplicationContext <- ClassPathXmlApplicationContext

스프링의 ApplicationContext 객체는 스프링 컨테이너의 인스턴스이다.
스프링은 ApplicationContext의 몇가지 기본 구현을 제공한다. 
그 중 ClassPathXmlApplicationContext는 xml형식의 독립형 어플리케이션에 적합하다. 
(지정된 classpath에서 xml파일을 읽어서 스프링 컨테이너 객체 생성)

----
content : 기능 
context : 기능을 구현하기 위한 정보 
container : 담는 그릇 

*/


















