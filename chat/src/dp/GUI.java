package dp;

import java.util.Observable;
import java.util.Observer;
/**
 * ��ͼ����
 * @author LIUTAN
 *
 */
public class GUI implements Observer{

	Data data;
	public GUI(Data data) {
		this.data=data;
	
	}

	//����
	@Override
	public void update(Observable o, Object arg) {
		
		System.out.println("view updata:"+arg);
		
	}
}
