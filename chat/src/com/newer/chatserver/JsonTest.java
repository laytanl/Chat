package com.newer.chatserver;

import java.util.HashMap;

import com.google.gson.Gson;

public class JsonTest {
	public static void main(String[] args) {
		
		
		Gson gson=new Gson();
		User u1=new User("bob","1",2000);
		
		String m=gson.toJson(u1);
		System.out.println(m);
		
		User u2=gson.fromJson(m, User.class);
		System.out.println(u2);
		
		
//		HashMap<String, Object> data=new HashMap<>();
//		data.put("name", "bob");
//		data.put("age", 21);
//		data.put("isSingle",false);
//		//–Ú¡–ªØ
//		String n=gson.toJson(data);
//		System.out.println(n);
//		
//		HashMap<String, Object> h=gson.fromJson(n, HashMap.class);
//		System.out.println(h);
		
	}

}
