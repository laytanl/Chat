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

	
		// 获得客户端的昵称和IP并追加到在线用户列表中
		try(InputStream in=socket.getInputStream();
				OutputStream out=socket.getOutputStream())  {
			byte[] buf = new byte[1024*4];
			int size = in.read(buf);
			String s = new String(buf, 0, size,"utf-8");
			users.put(s,socket.getInetAddress().toString());
			
			//[{},{},{}]
			while(true){
				StringBuilder builder=new StringBuilder("[");
				for (String ip:users.keySet()) {//遍历所有的键
					String n=users.get(ip);//得到相应键的值
					String u=String.format("{name:%s,ip:%s}",n,ip);
					builder.append(u);
					builder.append(",");
				}
				builder.replace(builder.length()-1, builder.length()-1, "]");//替换最后一个','字符
				
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
		

		// [特定的频率]发送列表给当前用户

		// 从列表中删除用户

	}

}
