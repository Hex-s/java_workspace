import java.util.Scanner;

/**
 * 猜拳游戏类，封装了游戏的逻辑过程
 * @author Administrator
 *
 */
public class Game {
	//玩家
	Player player;
	//电脑
	Computer cpu;
	//游戏的总次数
	int count;
	/**
	 * 初始化游戏的方法
	 */
	public void init(){
		player = new Player();
		cpu = new Computer();
	}
	/**
	 * 开启游戏的方法
	 */
	public void start(){
		System.out.println("------------------猜拳游戏------------------");
		System.out.println("游戏开始:");
		//调用游戏的过程方法
		gameLogic();
		System.out.println("-----------------游戏结束-----------------");
		//呈现游戏的结果
		showResult();
	}
	/**
	 * 游戏逻辑过程的方法
	 */
	public void gameLogic(){
		//累加游戏的总次数
		count++;
		//玩家出拳
		System.out.println("请玩家出拳");
		int playerGuess = player.gestrue();
		//呈现玩家出拳的结果
		System.out.println("玩家出的拳是"+change(playerGuess));
		System.out.println("电脑开始出拳");
		//电脑出拳
		int cpuGuess = cpu.gestrue();
		//呈现电脑出拳的结果
		System.out.println("电脑出的拳是"+change(cpuGuess));
		//比较出拳的结果
		//玩家获胜的情况
		if(playerGuess == 1 && cpuGuess == 2 || playerGuess == 2 && cpuGuess == 3 || playerGuess == 3 && cpuGuess == 1){
			//玩家获胜，记录次数
			player.winCount++;
			System.out.println("玩家获胜！");
		}
		//平局的情况
		else if(playerGuess == cpuGuess){
			System.out.println("平局！");
		}
		//玩家输的情况
		else{
			//累加电脑获胜的次数
			cpu.winCount++;
			System.out.println("电脑获胜！");
		}
		System.out.println("是否要再进行一轮猜拳？(y/n)");
		Scanner sc = new Scanner(System.in);
		String answer = sc.next();
		//判断选择
		if(answer.equals("y")){
			//递归当前游戏过程
			gameLogic();
		}
	}
	/**
	 * 呈现游戏结果的方法
	 */
	public void showResult(){
		System.out.println("游戏次数："+count+"次");
		System.out.println("胜利次数："+player.winCount+"次");
		System.out.println("平局次数："+(count-player.winCount-cpu.winCount)+"次");
		System.out.println("失败次数："+cpu.winCount+"次");
		//根据玩家和电脑的总胜利次数进行比较给出游戏评价
		if(player.winCount > cpu.winCount){
			System.out.println("恭喜你华丽地击败了电脑，称为了最终的获胜者！");
		}
		else if(player.winCount == cpu.winCount){
			System.out.println("平分秋色，握手言和");
		}
		else{
			System.out.println("很遗憾，你连电脑都打不过");
		}
	}
	/**
	 * 将玩家和电脑出拳的结果转换成字符串的方法
	 * @param guess
	 * @return
	 */
	public String change(int guess){
		String str = "";
		switch(guess){
		case 1:
			str = "石头";
			break;
		case 2:
			str = "剪刀";
			break;
		case 3:
			str = "布";
			break;
		}
		return str;
	}
}
