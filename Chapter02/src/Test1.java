
import java.util.Scanner;
public class Test1 {

	/**
	 * ʹ�ü��̽��ս�������������������¶ȣ����������������գ������·�����ɫ���Լ������ص�λg
     * ʹ�ñ�����������Ľ�����������б������ݴ�ӡ����
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���������ڼ���");
		String week = sc.next();
		
		System.out.println("������¶ȣ�");
		int tempeture = sc.nextInt();
		
		System.out.println("���������������գ�");
		String date = sc.next();
		
		System.out.println("�·�����ɫ��");
		String clothColor = sc.next();
		
		System.out.println("���أ���λΪg��");
		int weight=sc.nextInt();
		
		System.out.println("������"+week+"���¶���"+tempeture+"��,������"+date+",�·�����ɫ��"+clothColor+",����Ϊ"+weight+"g");

	
	}

}
