import java.util.Random;
import java.util.Scanner;


public class Exam5 {

	/**
	 * ������Բ��������貹����ֱ������Ϊֹ
	 * @param args
	 */
	public static void main(String[] args) {
		//�������������
		Random random = new Random();
		int score;
		int count = 1;
		do{
			System.out.println("�μ���"+count+"�ο���");
			//�ۼƿ��ԵĴ���
			count++;
			score = random.nextInt(101);
			System.out.println("��ǰ���Գɼ��ǣ�"+score);
		}while(score < 60);
		
		System.out.println("ͨ���˿��ԣ�");
	}

}
