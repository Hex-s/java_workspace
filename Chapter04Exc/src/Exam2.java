
import java.util.Scanner;

public class Exam2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	
		System.out.print("请输入初始值：");
		int a = sc.nextInt();
		System.out.print("请输入累加的循环次数：");
		int n = sc.nextInt();
		int sumSp = 0;
		int sumTotal = 0;		
//		for(int i = 1; i <= n ;i++){
//			sumSp = sumSp * 10 + a;
//			System.out.print(sumSp+"\t");
//			sumTotal += sumSp;
//		}
//		System.out.println(sumTotal);
		
		int ten = 1;
		System.out.print(sumSp+"\t");
		for(int i = 1; i <= n ;i++){
			sumSp += a*ten;
			System.out.print(sumSp+"\t");
			sumTotal += sumSp;
			ten *= 10;
		}
		System.out.println(sumTotal);
		
		
	}

}
