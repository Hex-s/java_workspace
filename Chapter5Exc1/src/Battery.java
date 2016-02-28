/**
 * 电池类
 * @author Administrator
 *
 */
public class Battery {
	//电池的电量 100表示满电量 0表示没有电
	int capacity = 100;
	
	/**
	 * 充电的方法
	 */
	public void charging(){
		System.out.println("电池开始充电");
		System.out.println("电池正在充电........");
		System.out.println("充电结束");
		capacity = 100;
	}

}
