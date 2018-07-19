package dp;

public class App {
	
	public static void main(String[] args) {
		Data data=new Data();
		
		GUI view=new GUI(data);
		
		data.addObserver(view);
		
		data.setInfo("hello");
		
		
	}

}
