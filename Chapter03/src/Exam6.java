import java.util.Scanner;


public class Exam6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//键盘接收成绩，判断成绩是否是满分
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入成绩：");
		int score = sc.nextInt();
		//判断是否满分
		
		//if条件允许单独使用
		if(score == 100){
			//条件满足执行的代码
			System.out.println("成绩是满分");
		}
		//else表示条件没有满足的情况
		//else只能结合if语句使用
//		else{
//			System.out.println("没有满分");
//		}
		if(score >= 90){
			System.out.println("成绩大于等于90分");
		}
		else{
			System.out.println("没有满足条件");
		}
		System.out.println("程序执行结束");
	}

}
