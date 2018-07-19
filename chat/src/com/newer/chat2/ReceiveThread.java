package com.newer.chat2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 接收消息
 * @author LIUTAN
 *
 */
public class ReceiveThread extends Thread{

	DatagramSocket socket;
	
	public ReceiveThread(DatagramSocket socket) {
		this.socket=socket;
	}

	@Override
	public void run() {
		
		byte[] buf=new byte[1024];
		while(true){
			DatagramPacket packet=new DatagramPacket(buf, buf.length);		
			
			try {
				socket.receive(packet);
				byte[] data=packet.getData();
				String msg=new String(data, 0,packet.getLength(),"utf-8");
				System.out.printf("收到(%s):%s\n",packet.getAddress(),msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}

	}
}
