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
 * 发送UDP 数据包
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
		}// 发送方的端口号可以不写，接收方的端口号必须写
		while (true) {
			// 创建一个套接字
			Scanner sc = new Scanner(System.in);
			String msg = sc.next();
			byte[] data = null;
			try {
				data = msg.getBytes("utf-8");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			// 目标的主机名，端口
			InetAddress address = null;
			try {
				address = InetAddress.getByName("172.22.72.94");
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			// 创建 UDP 数据包
			int port = 9000;
			packet = new DatagramPacket(data, data.length, address, port);
			// 发送
			try {
				socket.send(packet);
				System.out.println("完成发送");
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (msg.equals("再见"))
				break;
		}
	}

}
