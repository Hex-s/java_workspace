/**
 * 3. ������ݺ��·ݣ��ж������·�һ���ж�����
 * @author Administrator
 *
 */
import java.util.Scanner;

public class HomeWork3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// �������
		System.out.print("��������ݣ�");
		int year = sc.nextInt();
		// �����·�
		System.out.print("�������·�:");
		int month = sc.nextInt();
		// ����Ķ�������
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			if (month == 2) {
				System.out.print(year + "���" + month + "����29��");
			}
		}
		//������Ķ�������
		else {
			if (month == 2) {
				System.out.print(year + "���" + month + "����28��");
			}
		}

		// �����·�
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.print(year + "���" + month + "����31��");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.print(year + "���" + month + "����30��");
			break;
		}
	}

}
