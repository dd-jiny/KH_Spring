package com.test04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {
	
		@Before("execution(public * *(..))")
		public void before(JoinPoint join) {
			System.out.println("출석한다. ");
			
		}
		
		@After("execution(public * *(..))")
		public void after(JoinPoint join) {
			System.out.println("집에 간다.");
		}
		//  //returnValue 는 해당 메서드의 리턴객체를 그대로 가져올 수 있다
		@AfterReturning(pointcut = "execution(public * *(..))", returning = "returnVal")
		public void returning(JoinPoint join, Object returnVal) {
			System.out.println(returnVal+"열심히 하는 날이었다.....아마두");
			
		}
		
		@AfterThrowing("execution(public * *(..))")
		public void throwing(JoinPoint join) {
			System.out.println("쉬는날이었따....");
			//exception 으로 해당 메서드에서 발생한 예외를 가져올 수 있다.
		}
//		
//		//Before : 메소드 실행 전 Advice 실행
//		After : 메소드 실행 후 Advice 실행
//		After-returning : 메서드가 성공 후(예외 없이) Advice 실행
//		After-throwing : 메서드가 예외발생 후 Advice 실행
}
