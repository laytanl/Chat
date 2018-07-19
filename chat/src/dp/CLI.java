package dp;

import java.util.Observable;
import java.util.Observer;

public class CLI implements Observer,UI{

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("View update"+arg);		
	}
	@Override
	public void display() {
	
		
	}
	
	

}
