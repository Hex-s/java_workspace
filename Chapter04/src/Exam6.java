import java.util.Scanner;


public class Exam6 {

	/**
	 * ѭ����½
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String userName;
		String password;
		//��¼�Ƿ���֤ͨ���ı�ʾ
//		boolean isValidate;
//		do{
//			//ÿһ����������ʱĬ��Ϊ��ȷ�����
//			isValidate = true;
//			System.out.println("�������û�����");
//			userName = sc.next();
//			System.out.println("���������룺");
//			password = sc.next();
//			//�ж��û���
//			if(!userName.equals("admin")){
//				System.out.println("�û�������ȷ");
//				//�޸ı�ʾ
//				isValidate = false;
//			}
//			else if(!password.equals("0000")){
//				System.out.println("���벻��ȷ");
//				isValidate = false;
//			}
//		}while(!isValidate);
		
		
		//��֤��״̬��ʾ  1��ʾͨ����֤��0��ʾδͨ����֤
		int isValidate;
		do{
			isValidate = 1;
			//ÿһ����������ʱĬ��Ϊ��ȷ�����
			System.out.println("�������û�����");
			userName = sc.next();
			System.out.println("���������룺");
			password = sc.next();
			//�ж��û���
			if(!userName.equals("admin")){
				System.out.println("�û�������ȷ");
				//�޸ı�ʾ
				isValidate = 0;
			}
			else if(!password.equals("0000")){
				System.out.println("���벻��ȷ");
				isValidate = 0;

			}
		}while(isValidate == 0);
		
		
		
		
	}

}
