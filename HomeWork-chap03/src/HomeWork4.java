/**
 * �����ͯ��������Ա��ж϶�ͯ�Ƿ��ܰᶯ���ӣ�3�꼰�����к�Ů�����᲻����4-5����к����԰ᶯ��5�������к�Ů�����ܰᶯ
 * @author Administrator
 *
 */
import java.util.Scanner;

public class HomeWork4 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// �����ͯ������
		System.out.print("���䣺");
		int age = sc.nextInt();
		// �����ͯ���Ա�
		System.out.print("�Ա�");
		String sex = sc.next();
		// 3�꼰�����к�Ů�����᲻��
		if (age <= 3) {
			System.out.print("3�꼰�����к�Ů�����᲻������");
		} else if (age >= 4 && age <= 5) {
			if (sex.equals("��")) {
				System.out.print("4-5����к����԰ᶯ����");
			} else {
				System.out.print("4-5���Ů�����ܰᶯ����");
			}

		} else {
			System.out.print("5�������к�Ů�����ܰᶯ����");
		}

	}
}
