import java.util.Scanner;

public class Calendar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// �������
		System.out.print("��������ݣ�>=1900����");
		int year = sc.nextInt();
		// �����·�
		System.out.print("�������·ݣ�");
		int month = sc.nextInt();
		// ������
		int totalDays = 0;
		// 1990-year���ۻ�����
		for (int i = 1900; i < year; i++) {
			// �жϸ����Ƿ�Ϊ����
			if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
				totalDays += 366;
			} else {
				totalDays += 365;
			}
		}
		// 1�µ������µ�����
		// ÿ�µ�����
		int day = 0;
		for (int i = 1; i <= month; i++) {
			switch (i) {
			// �жϵ����Ƿ�Ϊ����
			case 2:
				if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
					day = 29;
				} else {
					day = 28;
				}
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				day = 30;
				break;
			default:
				day = 31;
				break;
			}
			//�ۼ�1�µ������µ�����
			if(i < month ){
			totalDays += day;}
		}
		//�ж�ÿ�µĵ�һ�������ڼ�
		int week = (totalDays + 1) % 7;
		//���������
		System.out.println("������\t����һ\t���ڶ�\t������\t������\t������\t������");
		//���1��ǰ�Ŀո�
		for(int i = 1; i <= week; i++){
			System.out.print("\t");
		}
		//��ӡ��ǰ�·ݵ�ÿһ��
		for(int i = 1;i <= day; i++){
			System.out.print(i+"\t");
			if((totalDays+i) % 7 == 6){
				System.out.println();
			}
		}
		
	}

}
