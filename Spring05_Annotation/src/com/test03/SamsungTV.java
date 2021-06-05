package com.test03;

import org.springframework.stereotype.Component;

//SamsungTV samsung = new SamsungTV(); -> @Component("samsung") ->samsung이라는 이름으로 만들게 된다. 
@Component("samsung")
public class SamsungTV implements TV {
	
	public SamsungTV() {
		System.out.println("Samsung tv 생성");
	}

	@Override
	public void powerOn() {
		System.out.println("samsung tv power on");

	}

	@Override
	public void powerOff() {
		System.out.println("samsung tv power off");

	}

	@Override
	public void volumeUp() {
		System.out.println("samsung tv volume up");

	}

	@Override
	public void volumeDown() {
		System.out.println("samsung tv volume off");

	}

}
