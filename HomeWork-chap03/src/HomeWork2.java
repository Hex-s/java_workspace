/**
 * 2.������һ̨�ʵ磬�۸���3856Ԫ����֧����ֽ�Ҹ������ţ���ֽ����100,50,20,10,5,1��
 * 
 * @author Administrator
 * 
 */
public class HomeWork2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int price = 3856;
		// ֽ������
		int hundred = 0, fifty = 0, twenty = 0, ten = 0, five = 0, one = 0;
		// 100��ֽ������
		if (price >= 100) {
			hundred = price / 100;
			price = price % 100;
		}
		// 50��ֽ������
		if (price >= 50) {
			fifty = price / 50;
			price = price % 50;
		}
		// 20��ֽ������
		if (price >= 20) {
			twenty = price / 20;
			price = price % 20;
		}
		// 10��ֽ������
		if (price >= 10) {
			ten = price / 10;
			price = price % 10;
		}
		// 5��ֽ������
		if (price >= 5) {
			five = price / 5;
			price = price % 5;
		}
		// 1��ֽ������
		if (price > 0) {
			one = price;
		}
		// ������
		System.out.print("֧����100Ԫֽ������Ϊ��" + hundred + "��50Ԫֽ������Ϊ��" + fifty
				+ "��20Ԫֽ������Ϊ��" + twenty + "��10Ԫֽ������Ϊ��" + ten + "��5Ԫֽ������Ϊ��"
				+ five + "��1Ԫֽ������Ϊ��" + one);
	}

}
