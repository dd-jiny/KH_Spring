package com.hello.mvc.dao;

import org.springframework.stereotype.Repository;

@Repository
public class HelloDao {
	
	
	//TODO : 07.Dao에서 return (db랑 연결하는 코드가 들어감) 해당 코드에서는 db랑 연결했다 치고 들어감 
	public String getHello() {
		return "Spring";
	}

}
