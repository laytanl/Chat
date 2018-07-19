package com.newer.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Reciver {
	public static void main(String[] args) {
		DatagramSocket socket;
		DatagramPacket packet;

		try {
			socket = new DatagramSocket(9000);
			byte[] buf = new byte[1024];
			packet = new DatagramPacket(buf, buf.length);
			try {
				while (true) {
					System.out.println("��ʼ����");
					socket.receive(packet);
					byte[] data = packet.getData();
					int size = packet.getLength();
					String msg = new String(data, 0, size,"utf-8");
					System.out.println(packet.getAddress()+msg);
					if(msg.equals("�ټ�")) break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (SocketException e) {
			e.printStackTrace();
		}

	}

}
