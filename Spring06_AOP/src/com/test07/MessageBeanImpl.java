package com.test07;

public class MessageBeanImpl implements MessageBean {
	
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void sayHello() {
		try {
			Thread.sleep(2000); //2000ms 2초 동안 쓰레드를 잠깐 멈춤
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Hello, " + name);
	}

}
