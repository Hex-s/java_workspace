import java.util.Scanner;

/**
 * 玩家
 * @author Administrator
 *
 */
public class Player {
	//记录玩家胜利的次数
	int winCount;
	/**
	 * 玩家出拳的方法
	 * @return
	 */
	public int gestrue(){
		Scanner sc = new Scanner(System.in);
		System.out.println("请玩家出拳：1.石头  2.剪刀  3.布");
		int chooice = sc.nextInt();
		return chooice;
	}
}
