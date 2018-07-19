package com.newer.chat2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.newer.chatserver.App;

/**
 * �ӷ�������������û��б�
 * 
 * @author LIUTAN
 *
 */

public class OnlineThread extends Thread {
	// TCP
	Socket socket;
	boolean isonline = false;

	@Override
	public void run() {
		super.run();
		// Scanner sc = new Scanner(System.in);
		// System.out.println("����������ʹ�õ��ǳ�");
		// String s = sc.nextLine();
		// while (true) {
		// try {
		// Thread.sleep(2000);
		// socket = new Socket("172.22.184.200", 9999);
		// out = socket.getOutputStream();
		// out.write(s.getBytes());
		// in = socket.getInputStream();
		// ByteArrayOutputStream bis = new ByteArrayOutputStream();
		// byte[] buf = new byte[1024 * 4];
		// int size;
		// while (-1 != (size = in.read(buf))) {
		// bis.write(buf, 0, size);
		// }
		// byte[] b = bis.toByteArray();
		// String s1 = new String(b, 0, b.length);
		// System.out.println(s1);
		// } catch (UnknownHostException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// }

		try {
			socket = new Socket("172.22.184.200", 9999);
			// �����ǳ�
			try (InputStream in = socket.getInputStream();
					OutputStream out = socket.getOutputStream()) {

				Scanner sc = new Scanner(System.in);
				System.out.println("����������ʹ�õ��ǳ�");
				String name = sc.nextLine();

				out.write(name.getBytes("utf-8"));
				out.flush();
				isonline = true;
				// �����û��б�
				byte[] buf = new byte[1024 * 4];
				while (true) {
					int size = in.read(buf);
					String online = new String(buf, 0, size);
					// ��ʾ�û��б�
					System.out.println("online: " + online);
				}

			} catch (Exception e) {
			}
		} catch (UnknownHostException e1) {

			e1.printStackTrace();
		} catch (IOException e1) {

			e1.printStackTrace();
		}

	}

}
