package com.niit.exam10;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//����һ��ѧУ
		School school = new School();
		//��ȡ��ɫ��ӡ��
		ColorPrinter colorPrinter = new ColorPrinter();
		//��ȡ�ڰ״�ӡ��
		BlackPrinter blackPrinter = new BlackPrinter();
		//ΪѧУ�䱸һ̨�ڰ״�ӡ��
		//school.setPrinter(blackPrinter);
		//ѧУ�䱸��ɫ��ӡ��
		school.setPrinter(colorPrinter);
		//����һ����ʦ
		Teacher teacher = new Teacher();
		//����һ���Ծ�
		Paper paper = new Paper();
		//��ʦʹ��ѧУ�䱸�Ĵ�ӡ����ӡ�Ծ���Ϣ
		//teacher.usePrinter(school.getPrinter(), paper);
		//����һ��ѧ��
		Student stu = new Student();
		//ѧ����ӡ�Լ��ĸ�����Ϣ
		stu.usePrinter(school.getPrinter(), stu);
	}

}
