package com.niit.exam5;

public class ThrowExam1 {
	
	private int age;
	
	/**
	 * throws�������Ѿ��ܳ��쳣�ķ��������쳣����������ʾ�÷����ĵ����߻�����쳣����Ҫ���д���
	 * @param age
	 * @throws Exception
	 */
	public void setAage(int age) throws Exception{
		if(age >= 1 && age <= 150){
			this.age = age;
		}
		else{
			//System.out.println("�����Ƿ�");
			//throw����ǿ���ڳ��������쳣��ʵ�����֣����Ҳ��Ը��쳣���д����ɸ÷����ĵ����߽��д���
			//�κ�Java�г��ֵ��쳣����ͨ��throw������
			throw new Exception("���������Ƿ���");
		}
	}
	
	public static void main(String[] args){
		ThrowExam1 ex = new ThrowExam1();
		try {
			ex.setAage(-100);
		} catch (Exception e) {		
			System.out.println(e.getMessage());
		}
		System.out.println("�������н���");
	}
}
