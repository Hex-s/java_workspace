/**
 * 
 * @author Administrator
 *
 */
public class RunGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//创建一个玩家
		Player player = new Player();
		//玩家姓名
		player.name = "tom";
		//创建一个电脑
		Computer computer = new Computer();
		//进行游戏
		player.doGame(computer);
		
		

	}

}
