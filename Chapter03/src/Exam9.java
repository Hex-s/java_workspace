import java.util.Scanner;


public class Exam9 {

	/**
	 * ʵ�ֵ�½�Ĳ���
	 * @param args
	 */
	public static void main(String[] args) {
		
		//��ȷ���û���
		String realName = "admin";
		//��ȷ������
		String realPassword = "0000";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�������û�����");
		String name = sc.next();
		System.out.println("���������룺");
		String password = sc.next();
		
		//�ж��û����������Ƿ���ȷ
		if(name.equals(realName)){
			//�û�����ȷ
			//�����ж�����
			if(password.equals(realPassword)){
				//�û��������붼��ȷ
				System.out.println("��½�ɹ�");
			}
			else{
				System.out.println("�������");
			}
		}
		else{
			System.out.println("�û��������ڣ�");
		}
	}

}
