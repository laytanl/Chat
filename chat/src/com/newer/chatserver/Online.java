package com.newer.chatserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.HashMap;
/**
 * 
 * @author LIUTAN
 *
 */
public class Online  implements Runnable {
	HashMap<String, String> users;
	Socket socket;

	public Online(HashMap<String, String> users, Socket socket) {
		this.users=users;
		this.socket = socket;
	}

	@Override
	public void run() {

	
		// ��ÿͻ��˵��ǳƺ�IP��׷�ӵ������û��б���
		try(InputStream in=socket.getInputStream();
				OutputStream out=socket.getOutputStream())  {
			byte[] buf = new byte[1024*4];
			int size = in.read(buf);
			String s = new String(buf, 0, size,"utf-8");
			users.put(s,socket.getInetAddress().toString());
			
			//[{},{},{}]
			while(true){
				StringBuilder builder=new StringBuilder("[");
				for (String ip:users.keySet()) {//�������еļ�
					String n=users.get(ip);//�õ���Ӧ����ֵ
					String u=String.format("{name:%s,ip:%s}",n,ip);
					builder.append(u);
					builder.append(",");
				}
				builder.replace(builder.length()-1, builder.length()-1, "]");//�滻���һ��','�ַ�
				
				out.write(builder.toString().getBytes("utf-8"));
				System.out.println(builder.toString());
				out.flush();
				
				Thread.sleep(2000);
			}
		}	

		catch (IOException e) {

			e.printStackTrace();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		

		// [�ض���Ƶ��]�����б����ǰ�û�

		// ���б���ɾ���û�

	}

}
