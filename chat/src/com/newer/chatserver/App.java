package com.newer.chatserver;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ��������� �û������б�
 * @author LIUTAN
 *
 */
public class App {
	//������׽���
	ServerSocket serverSocket;
	//�û��б�
	public static HashMap<String, String> users=new HashMap<>();
	//�̳߳�
	ExecutorService pool;
	
	
	public void start(){
		
		pool=Executors.newCachedThreadPool();
		
		try {
			serverSocket=new ServerSocket(9999);
			System.out.println("�����������");
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
