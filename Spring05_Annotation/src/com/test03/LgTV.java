package com.test03;

import org.springframework.stereotype.Component;

//LgTV lgTV = new LgTV  ->첫번째 글자만 소문자로하여 자동으로 저장되어진다. 
@Component
public class LgTV implements TV {
	
	public LgTV() {
		System.out.println("Lg tv 생성");
	}

	@Override
	public void powerOn() {	
		System.out.println("Lg tv power on");

	}

	@Override
	public void powerOff() {
		System.out.println("Lg tv power off");

	}

	@Override
	public void volumeUp() {
		System.out.println("Lg tv volume up");

	}

	@Override
	public void volumeDown() {
		System.out.println("Lg tv volume down");

	}

}
