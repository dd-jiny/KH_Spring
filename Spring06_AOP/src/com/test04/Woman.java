package com.test04;

import com.test04.Student;

public class Woman implements Student {

	@Override
	public String classWork() {
		System.out.println("컴퓨터를 켜서 주식본다.");
		return "스프링 연습";
	}

}
