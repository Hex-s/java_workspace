/**
 * 5. �������Ŷ�Ʊ���Żݻ���޶�10���Ŷӣ����뱨�����������Żݻ�������������Ŷӱ����Żݻ��Ч����
 * ����Ŷ��������˱���ռ��70%�Ŷ�Ʊ���Դ�5�ۣ���ͯ�����ﵽ50%��3�ۣ�������������ۣ�
 * ������11-2�·ݴ�3�ۣ�����5��6��7��10�´�5�ۣ����ྰ�㲻���ۡ�
 *  ͨ������¼�������Ϣ����#�˳�¼�룬��������Ŷӵ�����Ʊ���Ƕ���
 *  ����>=60 ������
 *  ����<=12�� Ϊ��ͯ
 *  ��ʼƱ��500
 * @author Administrator
 *
 */
import java.util.Scanner;

public class HomeWork5 {

	public static void main(String[] args) {
		// ��������
		int oldNum = 0;
		// С������
		int childNum = 0;
		// ������
		int totalNum = 0;
		// Ʊ��
		double ticketPrice = 500;
		//��Ʊ��
		double totalPrice;
		//���εص�
		String travelPlace;
		//�����·�
		int travelMonth;
		// ��Ա����
		Scanner sc = new Scanner(System.in);
		String ageStr;
		int age;
		//��ȡ���εص�
		System.out.print("���������εص㣺");
		travelPlace = sc.next();
		//��ȡ���εص�
		System.out.print("�������·ݣ�");
		travelMonth = sc.nextInt();
		while (true) {
			System.out.print("�������ο����䣺");
			// ��������
			ageStr = sc.next();
			//����#ʱ���������
			if (!ageStr.equals("#")) {
				// ������1
				totalNum++;
				// ������ת��������
				age = Integer.parseInt(ageStr);
				// ��������
				if (age >= 70) {
					oldNum++;
				}
				// ��ͯ����
				else if (age <= 12) {
					childNum++;
				}
			}
			else{
				break;
			}
		}
		System.out.println("���εص�Ϊ��"+travelPlace+"���·�Ϊ��"+travelMonth+"���Ŷ�������Ϊ��"+totalNum + "����������Ϊ��" + oldNum + "����ͯ����Ϊ��" + childNum);
		//�ж����εص��Ƿ�Ϊ����
		if(travelPlace.equals("����")){
			switch(travelMonth){
			case 11 :
			case 12 :
			case 1:
			case 2:
				ticketPrice *= 0.3;
			}
		}
		//�ж����εص��Ƿ�Ϊ����
		else if(travelPlace.equals("����")){
			switch(travelMonth){
			case 5 :
			case 6 :
			case 7:
			case 10:
				ticketPrice *= 0.5;
			}
		}
		//�ж������Ƿ���10��
		//������10��
		if(totalNum >= 10){
			//������������
			double rate =(double) oldNum / totalNum;
			if(rate >= 0.7){
				ticketPrice *= 0.5; 
			}
			//��ͯ��������
			rate = (double) childNum / totalNum;
			if(rate >= 0.5){
				ticketPrice *= 0.3; 
			}
		}
		//��Ʊ��
		totalPrice = totalNum * ticketPrice; 
		System.out.println("��Ʊ��Ϊ��"+totalPrice+"Ԫ");
	}

}
