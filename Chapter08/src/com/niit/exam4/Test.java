package com.niit.exam4;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//ʵ��������
		Child child = new Child();
//		System.out.println("���ӵ�ͷ����ɫ�ǣ�"+child.getHairColor());
//		System.out.println("���ӵ��۾���ɫ�ǣ�"+child.getEyeColor());
		//ϰ��
//		child.habit();
		//ϲ������
//		child.smoking();
//		child.play();
		child.setName("tom");
		System.out.println("���ӵ������ǣ�"+child.getName());
		child.hobby();
		
		//ʵ��������
		Father father = new Father();
		//�����ǲ��߱�������ӵķ������������Ե�
	}

}
