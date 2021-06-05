package com.test06;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	
	@Pointcut("execution(public * *(..))")  //어떤 JoinPoint에 연결될건지 지정해주는 애가 Pointcut
	public void myClass() {
		
	}
	
	@Before("myClass()") //pointcut이랑 연결 되는 before & after 가 advice
	public void before() {
		System.out.println("출석한다.");
	}
	
	@After("myClass()")
	public void after() {
		System.out.println("집에 간다.");
	}
	
	/* pointcut + advice = advisor(=aspect) */ 

}
