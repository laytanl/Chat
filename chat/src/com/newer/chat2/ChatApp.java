package com.newer.chat2;

import java.net.DatagramSocket;
import java.net.SocketException;


public class ChatApp {
	
	DatagramSocket socket;
	OnlineThread onlineThread;
	
	SendThread sendThread;
	ReceiveThread receiveThread;
	
	public void start(){
		try {
			socket=new DatagramSocket();
			System.out.println("≥Ã–Ú∆Ù∂Ø");
			onlineThread=new OnlineThread();
			onlineThread.start();
			while(!onlineThread.isonline){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}			
			sendThread=new SendThread(socket);
			receiveThread=new ReceiveThread(socket);		
			sendThread.start();
			receiveThread.start();	
			
		} catch (SocketException e) {
			e.printStackTrace();
		}	
	}
	
	public static void main(String[] args) {
		ChatApp app=new ChatApp();
		app.start();	
	}

}
