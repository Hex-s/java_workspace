/**
 * ��Ʊ�����Ϊ���òպ�����գ�
 * ÿ���1��2��5��10��12��Ϊ�����������·�Ϊ������
 * ������ʱ��2,5,10�²����ۣ�����ʱ��Ϊ8�ۣ�
 * ������ʱ���Ʊͳһ��4�ۡ�
 * ���òյļ۸�Ϊԭ�۵�80%�������Ϊԭ�۵�200%��
 * Ҫ����������Ʊԭ�ۣ�����Ĳ�λ�����·�ʱ�䣬���Ʊ�����ռ۸�
 * @author Administrator
 *
 */
import java.util.Scanner;

public class HomeWork5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ��������
		String space1 = "���ò�";
		String space2 = "�����";
		double finalPrice = 0;

		Scanner sc = new Scanner(System.in);
		// �����Ʊԭ��
		System.out.print("�������Ʊԭ�ۣ�");
		double originalPrice = sc.nextDouble();
		// ���빺��Ĳ�λ����
		System.out.print("�����빺��Ĳ�λ����Ϊ�����òջ�����գ���");
		String space = sc.next();
		// ���빺����·�
		System.out.print("�����빺����·ݣ�");
		int month = sc.nextInt();

		// ���òյļ۸�Ϊԭ�۵�80%�������Ϊԭ�۵�200%��
		if (space.equals(space1)) {
			finalPrice = originalPrice * 0.8;
		} else {
			finalPrice = originalPrice * 2;
		}

		switch (month) {
		case 1:
		case 12:
			finalPrice*=0.8;
			break;
		case 3:
		case 4:
		case 6:
		case 7:
		case 8:
		case 9:
		case 11:
			finalPrice*=0.4;
			break;
		}
		
		//������
		System.out.print("�������"+month+"�µ�"+space+"�ļ۸�Ϊ"+finalPrice+"Ԫ");

	}

}
