/**
 * 2. 输入一个数字，将该数反过来输出（如：输入12345  输出54321）
 * @author Administrator
 *
 */
import java.util.Scanner;

public class HomeWork2 {

	public static void main(String[] args) {
		//输入的数字
		int inputNum;
		//用来接收的数字
		int receiveNum;
		Scanner sc = new Scanner(System.in);
		//从键盘输入数字
		System.out.print("请输入一个大于0的正整数：");
		inputNum = sc.nextInt();
		System.out.print("将该数反过来输出：");
		do{
			//接收个位数
			receiveNum = inputNum % 10;
			//输出个位数
			System.out.print(receiveNum);
			//输入数字10倍递减
			inputNum /= 10;
		}while(inputNum > 0);
	}

}
