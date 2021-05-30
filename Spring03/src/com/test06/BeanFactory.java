package com.test06;

public class BeanFactory {
//ApplicationContext.xml 로 만들 xml 파일이 내부적으로는 이런식으로 설계가 되어있다. 
		public Object getBean(String beanName) {
			if (beanName.equals("samsung")) {
				return new SamsungTv();
			} else if (beanName.equals("lg")) {
				return new LgTv();
			}
			
			return null;
		}
}
