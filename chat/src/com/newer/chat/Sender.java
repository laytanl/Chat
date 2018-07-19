package com.newer.chat;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * ����UDP ���ݰ�
 * 
 * @author LIUTAN
 *
 */
public class Sender {
	public static void main(String[] args) {

		DatagramSocket socket = null;
		DatagramPacket packet = null;
		try {
			socket = new DatagramSocket();
		} catch (SocketException e1) {
			e1.printStackTrace();
		}// ���ͷ��Ķ˿ںſ��Բ�д�����շ��Ķ˿ںű���д
		while (true) {
			// ����һ���׽���
			Scanner sc = new Scanner(System.in);
			String msg = sc.next();
			byte[] data = null;
			try {
				data = msg.getBytes("utf-8");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			// Ŀ������������˿�
			InetAddress address = null;
			try {
				address = InetAddress.getByName("172.22.72.94");
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			// ���� UDP ���ݰ�
			int port = 9000;
			packet = new DatagramPacket(data, data.length, address, port);
			// ����
			try {
				socket.send(packet);
				System.out.println("��ɷ���");
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (msg.equals("�ټ�"))
				break;
		}
	}

}
