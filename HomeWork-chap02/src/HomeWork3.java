/**
 * 3. ��ʾ�˵����£�
	1 ��Ʒ���
	2 ��Ʒ����
	3 �������
	��ѡ��

          Ҫ��ͨ�����̽���ѡ��Ĳ˵����ʾѡ������֣�����ѡ������ĸ����������ʾ��Ʒ����Ϣ����Ʒ��Ϣ����:

	Ʒ��   ����   ����  
 	����   10   230
	��Ь   7    345.5
	ͼ��   28   87
 */

import java.util.Scanner;

public class HomeWork3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// ��������
		String shirt = "����";
		String shoes = "��Ь";
		String book = "ͼ��";
		int shirtNumber = 10;
		int shoesNumber = 7;
		int bookNumber = 28;
		double shirtPrice = 230;
		double shoesPrice = 345.5;
		double bookPrice = 87;

		// ����˵���
		System.out.print("��ʾ�˵����£�\n\t1 ��Ʒ���\n\t2 ��Ʒ����\n\t3 �������\n\t��ѡ��");

		// �Ӽ���ѡ��˵���
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();

		// ����˵�������
		System.out.println("Ʒ��\t����\t����");
		System.out.println(shirt + "\t" + shirtNumber + "\t" + shirtPrice);
		System.out.println(shoes + "\t" + shoesNumber + "\t" + shoesPrice);
		System.out.print(book + "\t" + bookNumber + "\t" + bookPrice);
	}

}
