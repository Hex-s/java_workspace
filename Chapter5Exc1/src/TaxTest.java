import java.util.Scanner;


public class TaxTest {

	public static void main(String[] args){
		//˰ǰ����
		double salary;
		//���չ���
		double money;
		//���ϱ��ս�Ľ��ɱ���
		double old;
		//�Ƿ���ɹ����� true��ʾ���� false��ʾ������
		boolean fundChoose = false;;
		int fundInt;
		//��������ɱ���
		double fund = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�������������ʣ�");
		double startSalary = sc.nextDouble();
		System.out.print("������ڶ����������ʣ�");
		double startSalary2 = sc.nextDouble();
		System.out.print("������������������ʣ�");
		double startSalary3 = sc.nextDouble();
		System.out.print("���������˰ǰ���ʣ�");
		salary = sc.nextDouble();
		System.out.print("��������Ҫ���ɵ����Ͻ������0.08-0.11����");
		old = sc.nextDouble();
		System.out.print("��ѡ�����Ƿ�Ҫ���ɹ�����1��ʾ���� 0��ʾ�����ɣ���");
		fundInt = sc.nextInt();
		if(fundInt == 1){
			fundChoose = true;
			System.out.print("��������Ҫ���ɵĹ����������0-0.11����");
			fund = sc.nextDouble();
		}
		
		Tax tax = new Tax();
		money = tax.getSalary(salary,old,fundInt,fund,startSalary);
		System.out.println("�������չ���Ϊ��"+money);
	}
}
