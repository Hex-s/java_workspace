import java.util.Random;
import java.util.Scanner;


public class Exam5 {

	/**
	 * 如果考试不及格，则需补考，直到及格为止
	 * @param args
	 */
	public static void main(String[] args) {
		//创建随机数对象
		Random random = new Random();
		int score;
		int count = 1;
		do{
			System.out.println("参加了"+count+"次考试");
			//累计考试的次数
			count++;
			score = random.nextInt(101);
			System.out.println("当前考试成绩是："+score);
		}while(score < 60);
		
		System.out.println("通过了考试！");
	}

}
