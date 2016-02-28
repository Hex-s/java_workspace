import java.util.Scanner;


public class Exam9 {

	/**
	 * 录入10个同学的成绩，大于等于80分的成绩属于优秀成绩，根据录入学生的优秀成绩的比例，显示对应的班级情况
	 * 如果班里有60%的同学达到了优秀成绩，则该班整体情况优良
	 * 如果班里优秀成绩比例达到30%,则该班整体情况一般
	 * 如果班里优秀成绩比例低于20%，则该班情况较差
	 * @param args
	 */
	public static void main(String[] args) {
		//学生的数量
		int stuNum;
		//成绩
		int score;
		//优秀成绩的人数
		int count = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("输入学生的数量：");
		stuNum = sc.nextInt();
		//循环录入成绩
		for(int i = 1; i <= stuNum; i++){
			System.out.println("请输入第"+i+"个学生的成绩：");
			score = sc.nextInt();
			//判断成绩是否是优秀成绩
			if(score >= 80){
				//累计人数
				count++;
			}
		}
		//计算优秀人数的比例
		double pre = (double)count / stuNum;
		System.out.println(pre);
		//判断优秀人数的比例属于的情况
		if(pre >= 0.6){
			System.out.println("班级情况优良");
		}
		else if(pre >= 0.3){
			System.out.println("班级情况一般");
		}
		else if(pre < 0.2){
			System.out.println("班级情况较差");
		}
	}

}
