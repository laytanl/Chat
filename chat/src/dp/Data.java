package dp;

import java.util.ArrayList;
import java.util.Observable;

import com.newer.chatserver.User;

/**
 * ���ݻ���ģ��(�ɹ۲�Ķ���)������
 * @author LIUTAN
 *
 */
public class Data extends Observable{
	
	String info;
	
	ArrayList<User> users=new ArrayList<>();
	
	public void online(User u){
		users.add(u);	
	}
	
	
	//�޸��ֶε�ֵ
	public void setInfo(String info){
		this.info=info;
		
		//֪ͨ�۲���
		setChanged();
		notifyObservers(info);
		
	}
	public String getInfo(){
		return info;
	}
	

}
