/**
 * 1.����һ���Լ����յ�����������е�ÿһ����ֵ
 * @author Administrator
 *
 */
import java.util.Scanner;

public class HomeWork1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("����������������ݣ�");
		int year = sc.nextInt();
		// ��ȡ��λ��
		int n1 = year % 10;
		// ��ȡʮλ��
		int n2 = year / 10 % 10;
		// ��ȡ��λ��
		int n3 = year / 100 % 10;
		// ��ȡǧλ��
		int n4 = year / 1000;
		// ������
		System.out.print("��������ݵ�ǧλ���ǣ�" + n4 + "����λ���ǣ�" + n3 + "��ʮλ���ǣ�" + n2
				+ "����λ���ǣ�" + n1);

	}

}
