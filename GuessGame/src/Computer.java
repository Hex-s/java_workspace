import java.util.Random;

/**
 * 电脑
 * @author Administrator
 *
 */
public class Computer {
	//记录电脑赢的次数
	int winCount;
	
	/**
	 * 电脑出拳的方法
	 * 电脑出拳通过随机数产生
	 * @return
	 */
	public int gestrue(){
		Random random = new Random();
		int guess = random.nextInt(3)+1;
		return guess;
	}
}
