//����Scanner���ڵ�java��
//ֻ����Scanner����
import java.util.Scanner;
//��java.util���е������������Ͷ�����
//import java.util.*;

public class Exam4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//�������̽��ն���
		Scanner sc = new Scanner(System.in);
		//���ռ��̵�������ַ���
		System.out.println("������������");
		String str = sc.next();
		System.out.println("����������");
		int age = sc.nextInt();
		System.out.println("��������ߣ���λ:�ף�");
		double d = sc.nextDouble();
		System.out.println("�������Ա�(true��ʾ�� false��ʾŮ)");
		boolean flag = sc.nextBoolean();
		//��ӡ��ʾ���������
		System.out.println("��������������ǣ�"+str);
	}

}
