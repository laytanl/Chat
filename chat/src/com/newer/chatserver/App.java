package com.newer.chatserver;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 聊天服务器 用户在线列表
 * @author LIUTAN
 *
 */
public class App {
	//服务端套接字
	ServerSocket serverSocket;
	//用户列表
	public static HashMap<String, String> users=new HashMap<>();
	//线程池
	ExecutorService pool;
	
	
	public void start(){
		
		pool=Executors.newCachedThreadPool();
		
		try {
			serverSocket=new ServerSocket(9999);
			System.out.println("服务端启动：");
			while(true){
				Socket socket=serverSocket.accept();
				
				Online online=new Online(users,socket);
				pool.execute(online);
				
			}	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		App app=new App();
		app.start();
	}
	

}
