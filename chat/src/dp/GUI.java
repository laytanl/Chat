package dp;

import java.util.Observable;
import java.util.Observer;
/**
 * 视图界面
 * @author LIUTAN
 *
 */
public class GUI implements Observer{

	Data data;
	public GUI(Data data) {
		this.data=data;
	
	}

	//更新
	@Override
	public void update(Observable o, Object arg) {
		
		System.out.println("view updata:"+arg);
		
	}
}
