package com.test07;

public class SamsungTv implements TV {

	public SamsungTv() {
		System.out.println("samsungTv 생성!");
	}

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
