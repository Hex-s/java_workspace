import java.util.Random;
import java.util.Scanner;

/**
 * ���࣬���������������߱���ͨ�����Ժͷ���
 * @author Administrator
 *
 */
public class Human {
	
	/***************������ֻ��д���Ժͷ���******************/
	//��д����,�����ֳ�Ϊȫ�ֱ�����Ҳ���Գ�Ϊ��Ա����
	//������Դ���Ĭ��ֵ
	//String��Ĭ��ֵ��null
	//int��Ĭ��ֵ��0
	//double��Ĭ��ֵ��0.0
	//boolean��Ĭ��ֵ��false
	//����
	String name = "tom";
	//�Ա�
	char sex = '��';
	//����
	int age = 20;
	
	//�����ɷ������η�������ֵ���ͣ��������������б��Լ������幹��
	/**
	 * ��ӡ��ʾ������Ϣ�ķ���
	 */
	public void details(){
		//����ֲ�����
		String name = "jack";
		//this�ؼ��ִ���ǰ���ʵ������
		System.out.println("�ҵ������ǣ�"+this.name+",�Ա�"+sex+",����"+age);
//		if(true){}
//		while(true){}
	}
	
	/**
	 * ���Եķ���
	 */
	public void interView(){
		//�����ڲ��ı����ֳ�Ϊ�ֲ�����
//		String str = "�����ڵı���";
//		System.out.println(str);
		
		//����ClassA��ķ���������ClassA����һ���࣬�����Ҫ����ʵ����
		ClassA a = new ClassA();
		a.testMethod();
		//�����ҽ���
		//�����������þ��Ǹ��ô��룬������ڲ�����ֱ�ӷ����Լ��ķ���������Ҫʵ��������
		details();
		//�������Ե���������
		System.out.println("���Ե���������");
	}
	
	/**
	 * һ������ֻ����һ������ֵ
	 * @return
	 */
	public String shopping(){
		System.out.println(name+"�����˹���");
		Scanner sc = new Scanner(System.in);
		System.out.println("���������빺�����Ʒ���ƣ�");
		String str = sc.next();
		//�������ʱҪ�󷵻�String���͵Ľ���������ͨ��return�ؼ��ַ�Χ��Ӧ�������͵�ֵ
		return str;
	}
	
	/**
	 * �Ӵ����̴�������Ʒ
	 * @return �����˹������Ʒ����
	 */
	public Ware shopping(Proxyer proxyer){
		System.out.println(name+"���ڴ�"+proxyer.band+"����������Ʒ");
		return proxyer.ware;
	}
	

}
