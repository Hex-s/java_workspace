
/**
 * ����������д��ڷ���������Human��Ľ��
 * @author Administrator
 *
 */
public class HumanTest {

	public static void main(String[] args) {
		
		//���ǳ���ģ�ʹ�������Ҫ�����ɶ������Ӧ�ã������Ҫ�������ʵ����
		Human man1 = new Human();
		//ͨ��������.���������ʶ��������
		//System.out.println(man1.name+","+man1.sex+","+man1.age);
		man1.name = "�°���";
		man1.sex = '��';
		man1.age = 53;
		//ʵ����
		Human man2 = new Human();
		man2.name = "������";
		man2.sex = 'Ů';
		man2.age = 32;
		//ʵ����
		Human man3 = new Human();
		//ʵ����
		Human man4 = new Human();
		
//		System.out.println(man1.name+","+man1.sex+","+man1.age);
//		System.out.println(man2.name+","+man2.sex+","+man2.age);
//		System.out.println(man3.name+","+man3.sex+","+man3.age);
//		System.out.println(man4.name+","+man4.sex+","+man4.age);
		
		//ͨ��������.���������ʷ���
//		man1.details();
//		man2.details();
//		man1.interView();
		
		//ִ�д��л�ֵ�ķ���
		String ware = man1.shopping();
		System.out.println(man1.name+"ͨ�����﷽��������"+ware);
	}
}
