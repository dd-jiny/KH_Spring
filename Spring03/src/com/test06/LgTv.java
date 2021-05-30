package com.test06;

public class LgTv implements TV {

	@Override
	public void powerOn() {
		System.out.println("Lg Tv on");
	}

	@Override
	public void powerOff() {
		System.out.println("Lg Tv off");
	}

	@Override
	public void volumeUp() {
		System.out.println("Lg Tv volume Up");
	}

	@Override
	public void volumeDown() {
		System.out.println("Lg Tv volume Down");
	}

}
