import java.util.Scanner;


public class Exam2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//����ȡ��
//		int num1 = 10;
//		int num2 = 3;
//		int result = num1 % num2;
//		System.out.println(result);
		
		
		//��������Сʱ������ʾ������ʣ�����Сʱ
//		Scanner sc = new Scanner(System.in);
//		System.out.println("������Сʱ��");
//		int hour = sc.nextInt();
//		int day = hour / 24;
//		int lastHour = hour % 24;
//		System.out.println("һ������"+day+"�죬ʣ��"+lastHour+"��Сʱ");
		
		
		//���̽���һ��ǧλ�����ֱ�ͨ��4�������ֱ�����ǧλ������λ����ʮλ���Լ���λ��
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ��ǧλ����");
		int num = sc.nextInt();
		int n1 = num % 10;
		int n2 = num / 10 % 10;
		int n3 = num / 100 % 10;
		int n4 = num / 1000;
	}

}
