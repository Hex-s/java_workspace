/**
 * 3.猜数游戏，系统产生一个1-100的随机数，
 * 如果猜错，可以根据大小提示猜大了还是猜小了，
 * 如果猜错10次则游戏结束，并且要求对成绩给予评价(根据次数决定)
 * @author Administrator
 *
 */
import java.util.Scanner;

public class HomeWork3 {

	public static void main(String[] args) {
		//猜的次数
		int guessCount = 0;
		//系统产生一个1-100的随机数
		int luckyNum = (int)(Math.random() * 100 + 1);
		//猜的数字
		int guessNum;
		Scanner sc = new Scanner(System.in);
		do{
			//猜数的次数累加
			guessCount++;
			//输入要猜的数字
			System.out.print("请输入您猜的数字（1-100）："+luckyNum);
			guessNum = sc.nextInt();
			//进行比较
			if(guessNum < luckyNum){
				System.out.println("猜小了！您还有"+(10-guessCount)+"次机会！");
			}
			else if(guessNum > luckyNum){
				System.out.println("猜大了！您还有"+(10-guessCount)+"次机会！");
			}
			else{
				System.out.println("猜对了！");
				break;
			}		
		}while(guessCount < 10);
		//对成绩给予评价(根据次数决定)
		if(guessCount <= 3){
			System.out.println("真厉害！去买彩票吧！");
		}
		else if(guessCount <= 6){
			System.out.println("再接再厉！");
		}
		else{
			System.out.println("运气不好！做好事积攒人品吧！");
		}
	}

}
