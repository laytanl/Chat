package dp;

import java.util.ArrayList;
import java.util.Observable;

import com.newer.chatserver.User;

/**
 * 数据或者模型(可观测的对象)发布者
 * @author LIUTAN
 *
 */
public class Data extends Observable{
	
	String info;
	
	ArrayList<User> users=new ArrayList<>();
	
	public void online(User u){
		users.add(u);	
	}
	
	
	//修改字段的值
	public void setInfo(String info){
		this.info=info;
		
		//通知观察者
		setChanged();
		notifyObservers(info);
		
	}
	public String getInfo(){
		return info;
	}
	

}
