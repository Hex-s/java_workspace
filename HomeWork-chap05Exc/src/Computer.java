/**
 * 电脑类
 * @author Administrator
 *
 */
public class Computer {
	
	//产生随机数 1表示拳头 2表示步 3表示剪刀  1<2 2<3 3<2
	public int computerRandom(){
		//产生一个随机数，1-3
		int choice = (int)(Math.random()*3)+1;
		//返回结果
		return choice;
	}
}
