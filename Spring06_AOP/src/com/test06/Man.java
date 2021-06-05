package com.test06;

import org.springframework.stereotype.Component;

@Component("man")
public class Man implements Student {

	@Override
	public void classWork() {
		System.out.println("컴퓨터 켜서 뉴스본다");
		
	}

}
