import java.util.Scanner;

public class Exam5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�������һ������");
		int num1 = sc.nextInt();
		System.out.println("������ڶ�������");
		int num2 = sc.nextInt();
		System.out.println("��������ǰ��num1="+num1+",num2="+num2);
		//����������ֵ�Ľ�����Ҫ�����ڵ���������
		//������ʱ����
		int temp;
		//��num1��ֵ����temp
		temp = num1;
		//��num2��ֵ����num1
		num1 = num2;
		//���洢��num1��ֵ����ʱ�����ٸ�ֵ��num2
		num2 = temp;
		System.out.println("����������num1="+num1+",num2="+num2);
		
	}

}
