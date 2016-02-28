/**
 * 2. 输入左右手选取扑克牌的不同花色（黑桃，红桃，方块，梅花），并将左右手的牌互换
 *
 */
import java.util.Scanner;

public class HomeWork2 {
	
	public static void main(String[] args){
		//从键盘接受变量
		Scanner sc = new Scanner(System.in);
		
		//左手选取扑克牌花色
		System.out.print("左手选取扑克牌花色：");
		String left=sc.next();
		
		//右手选取扑克牌花色
		System.out.print("右手选取扑克牌花色：");
		String right = sc.next();
		
		//输出左右手选取的花色
		System.out.println("左手扑克牌的花色为："+left+"，右手扑克牌的花色为："+right);
		
		//左右手的牌互换
		String temp=left;
		left=right;
		right=temp;
		//输出交换后左右手的扑克牌花色
		System.out.println("左手扑克牌的花色为："+left+"，右手扑克牌的花色为："+right);
	}

}
