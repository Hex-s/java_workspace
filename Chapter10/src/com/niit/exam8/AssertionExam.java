package com.niit.exam8;

public class AssertionExam {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String userName = "admin1";
		String password = "123";
		
//		if(userName.equals("admin")){
//			if(password.equals("123")){
//				System.out.println("��½�ɹ�");
//			}
//		}
		
		//���Ա�ʾһ�ּ���Ŀ϶�
		assert userName.equals("admin"):"�û�������";
		//��������Ҳ����ȷ��
		assert password.equals("123"):"�������";
		System.out.println("��½�ɹ�");

	}

}
