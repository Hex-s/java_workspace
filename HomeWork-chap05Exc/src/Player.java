/**
 * 玩家类
 * @author Administrator
 *
 */
import java.util.Scanner;

public class Player {
	// 玩家姓名
	String name;
	// 是否继续游戏的y/n的选择
	String answer;
	// 玩家出拳的选择
	int playerChoice;
	// 电脑出拳的选择
	int computerChoice;
	// 进行游戏的次数
	int count = 0;
	// 玩家胜利的次数
	int playerWin = 0;
	// 电脑胜利的次数
	int computerWin = 0;
	// 平局的次数
	int deuce = 0;
	// 单局比赛的比赛结果
	String winP = "赢了！";
	String winC = "电脑赢了！";
	String winD = "平局！";

	Computer computer;

	// 从键盘接收数据
	Scanner sc = new Scanner(System.in);

	/**
	 * 进入游戏，选择是否继续进行游戏
	 */
	public void doGame(Computer computer) {
		this.computer = computer;
		System.out.print("是否继续游戏?（y/n）:");
		answer = sc.next();
		// 继续进行游戏
		if (answer.equals("y")) {
			// 游戏次数+1
			count++;
			// 继续游戏
			continueGame(computer);
			// 再次选择是否继续游戏
			doGame(computer);
		}
		// 结束游戏 统计战绩 提示最终获胜者是玩家还是电脑
		else if (answer.equals("n")) {
			evalaute();
		} else {
			System.out.println("无效输入，请重新选择！");
			doGame(computer);
		}
	}

	/**
	 * 选择继续游戏 y 后玩家出拳
	 * @param computer
	 */
	public void continueGame(Computer computer) {
		System.out.print("请出拳（1石头 2布 3剪刀）：");
		// 玩家的出拳结果
		playerChoice = sc.nextInt();
		// 随机获取电脑的出拳结果
		computerChoice = computer.computerRandom();
		// 对出拳结果进行比较
		compare(playerChoice, computerChoice);

	}

	/**
	 * 对电脑和玩家的出拳结果进行比较
	 * @param playerChoice 玩家的出拳结果
	 * @param computerChoice 电脑的出拳结果
	 */
	public void compare(int playerChoice, int computerChoice) {
		// 将玩家的出拳结果转换成石头、剪刀、布
		String play = "";
		// 将电脑的出拳结果转换成石头、剪刀、布
		String comp = "";
		// 玩家与电脑出拳结果相同的情况
		if (playerChoice == computerChoice) {
			if (playerChoice == 1) {
				play = "石头";
			} else if (playerChoice == 2) {
				play = "布";
			} else {
				play = "剪刀";
			}
			resultOutput(name, play, play, winD);
			deuce++;
		}
		//玩家与电脑出拳结果不相同的情况，继续进行判断输赢
		else {
			String result = "";
			switch (playerChoice) {
			// 玩家出的是石头
			case 1:
				play = "石头";
				switch (computerChoice) {
				case 2:
					comp = "布";
					result = winC;
					computerWin++;
					break;
				case 3:
					comp = "剪刀";
					result = name+winP;
					playerWin++;
					break;
				}
				resultOutput(name, play, comp, result);
				break;
			// 玩家出的是布
			case 2:
				play = "布";
				switch (computerChoice) {
				//电脑出的是石头，玩家赢
				case 1:
					comp = "石头";
					result =name+ winP;
					playerWin++;
					break;
				//电脑出的是剪刀，电脑赢
				case 3:
					comp = "剪刀";
					result = winC;
					computerWin++;
					break;
				}
				resultOutput(name, play, comp, result);
				break;
			// 玩家出的是剪刀	
			case 3:
				play = "剪刀";
				switch (computerChoice) {
				case 1:
					comp = "石头";
					result = winC;
					computerWin++;
					break;
				case 2:
					comp = "布";
					result =name+ winP;
					playerWin++;
					break;
				}
				resultOutput(name, play, comp, result);
				break;
			//玩家输入非法数据	
			default:
				//游戏次数减少1次
				count--;
				System.out.println("无效的输入，请重新出拳！");
				doGame(computer);
				break;
			}
		}
	}

	/**
	 * 输出每次猜拳的结果
	 * @param name 玩家名字
	 * @param play 玩家出拳结果
	 * @param comp 电脑出拳结果
	 * @param result 单次比赛的结果
	 */
	public void resultOutput(String name, String play, String comp,
			String result) {
		System.out.println(name + "出的是" + play + ",电脑出的是" + comp + "\n"
				+ result);

	}
	
	/**
	 * 统计战绩 通过战绩提示最终获胜者是玩家还是电脑
	 */
	public void evalaute() {
		System.out.println(name + "和电脑一个进行了" + count + "次比赛，" + name + "赢了"
				+ playerWin + "次，电脑赢了" + computerWin + "次，平局" + deuce + "次");
		//判断电脑与玩家的胜负
		if (playerWin > computerWin) {
			System.out.println("这场猜拳大赛的最终获胜者是" + name + "！");
		} else if (playerWin == computerWin) {
			System.out.println("这场猜拳大赛是平局！");
		} else {
			System.out.println("这场猜拳大赛的最终获胜者是电脑！");
		}
	}

}
