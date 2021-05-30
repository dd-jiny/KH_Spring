package com.test07;

public class LgTv implements TV {

	public LgTv() {
		System.out.println("lg tv 생성!");
	}

	@Override
	public void powerOn() {
		System.out.println("lg Tv on");
	}

	@Override
	public void powerOff() {
		System.out.println("lg Tv off");
	}

	@Override
	public void volumeUp() {
		System.out.println("lg Tv volume Up");
	}

	@Override
	public void volumeDown() {
		System.out.println("lg Tv volume Down");
	}

}
