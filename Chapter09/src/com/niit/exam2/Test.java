package com.niit.exam2;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//�����ڶ�̬�����ø�����������ʵ��
		Base base1 = new Child();
		Base base2 = new Base();
		Child child = new Child();
		
		//���಻�ܽ��ܸ����ʵ��
		//child = (Child)base2;
		//child.method1();
		
		//���´��������ȷ���У���Ϊbase1��ʵ���������ʵ��
		child = (Child)base1;
		child.method1();
		
		//װ��  ����������н���ȷ����������ת����ĳһ�������ӿ�ʱ�Ĺ��̾���װ��
		Object obj = new Child();
		//����  �������ӿ��е�����ת������ȷ�����͵Ĺ��̳�Ϊ����
		//��ȷ����������ڶ�̬�Ե�ת��
		Base base = (Base)obj;
		base.method1();
		//��������
//		AnotherChild another = (AnotherChild)obj;
//		another.method1();
		//��ȷ�������obj�ı������childʵ��
		Child child1 = (Child)obj;
		child1.method1();
		
		//����ʱӦ�ȶԸ�������ͽ����ж� �𰸣�base:����ĵ�һ������
		if(obj instanceof Base){
			Base base3 = (Base)obj;
			System.out.print("base:");
			base3.method1();
		}
		else if(obj instanceof Child){
			Child child2 = (Child)obj;
			System.out.print("child:");
			child2.method1();
		}
		
		//�𰸣�child:����ĵ�һ������
//		if(obj instanceof Child){
//			Child child2 = (Child)obj;
//			System.out.print("child:");
//			child2.method1();
//		}
//		else if(obj instanceof Base){
//			Base base3 = (Base)obj;
//			System.out.print("base:");
//			base3.method1();
//		}

			
		//������õķ���ȡ����ʵ��������
		//ʹ�ö�̬�Ե�ʱ�����ڸ���ֻ�ܷ��ʵ�����ʵ����ͬ���ķ���������ڱ�д����ʱ����Ҫ�Ը����ĳЩ����������д
		//base1.method1();
		//���������޷������������������Լ�����
		//base1.otherMethod();�����д
		
		
		//ͨ�������ʶ��ǰ���е���������
		//������ instanceof ������������
//		if(base2 instanceof Child){
//			System.out.println("���������ʵ��");
//		}
//		else if(base2 instanceof Base){
//			System.out.println("���Ǹ����ʵ��");
//		}
		
	}

}
