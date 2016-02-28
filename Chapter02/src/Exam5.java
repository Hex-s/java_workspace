import java.util.Scanner;

public class Exam5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入第一个数：");
		int num1 = sc.nextInt();
		System.out.println("请输入第二个数：");
		int num2 = sc.nextInt();
		System.out.println("两数交换前，num1="+num1+",num2="+num2);
		//对两数进行值的交换需要借助于第三个变量
		//创建临时变量
		int temp;
		//将num1的值赋给temp
		temp = num1;
		//将num2的值赋给num1
		num1 = num2;
		//将存储了num1的值的临时变量再赋值给num2
		num2 = temp;
		System.out.println("两数交换后，num1="+num1+",num2="+num2);
		
	}

}
