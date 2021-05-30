package com.test06;

public class SamsungTv implements TV {

	@Override
	public void powerOn() {
		System.out.println("samsung tv on");
	}

	@Override
	public void powerOff() {
		System.out.println("samsung tv off");
	}

	@Override
	public void volumeUp() {
		System.out.println("samsung tv volume Up");
	}

	@Override
	public void volumeDown() {
		System.out.println("samsung tv volume sDown");
	}

}
