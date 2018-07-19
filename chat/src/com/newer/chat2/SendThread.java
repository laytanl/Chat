package com.newer.chat2;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * ������Ϣ
 * 
 * @author LIUTAN
 *
 */
public class SendThread extends Thread {

	DatagramSocket socket;

	public SendThread(DatagramSocket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		super.run();

		Scanner sc = new Scanner(System.in);
		while (true) {

			System.out.println("�Է���IP��");
			String ip = sc.nextLine();
			System.out.println("��Ϣ��");
			String msg = sc.nextLine();
			// ����һ�����ݰ�
			byte[] data;
			try {
				data = msg.getBytes("utf-8");
				DatagramPacket packet = new DatagramPacket(data, data.length,
						InetAddress.getByName(ip), 7000);
				socket.send(packet);
				if (msg.equalsIgnoreCase("bye"))
					break;

			} catch (UnsupportedEncodingException | UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
