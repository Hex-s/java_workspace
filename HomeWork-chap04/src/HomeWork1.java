/**
 * 1. ��½ģ�⣬�û����������������������ش�����ʾ������֪���ж��ٴδ������ 
 *	   ���3����֤ʧ�ܺ󽫶����˻�
 */
import java.util.Scanner;

public class HomeWork1 {

	public static void main(String[] args) {
		//�������
		int inputCount = 0;
		//������֤�����Ĵ���
		int allowCount = 3;
		//��ȷ�û���
		String realName = "tom";
		//��ȷ����
		String realPassword = "123456";
		//������û���
		String name;
		//���������
		String password;
		Scanner sc = new Scanner(System.in);
		do{
			//����һ�Σ�inputCount��1
			inputCount++;
			//�����û���
			System.out.print("�������û�����");
			name = sc.next();
			//��������
			System.out.print("���������룺");
			password = sc.next();
			//�ж������Ƿ���ȷ
			if(! name.equals(realName) ){
				System.out.println("�û����������������룡");
				System.out.println("��һ����3����֤���ᣬ��ʣ"+(allowCount - inputCount)+"�λ��ᣡ");
			}
			//�ж������Ƿ���ȷ
			else if(!password.equals(realPassword)){
				System.out.println("����������������룡");
				System.out.println("��һ����3����֤���ᣬ��ʣ"+(allowCount - inputCount)+"�λ��ᣡ");
			}
			//�û��������붼��ȷ
			else{
				System.out.println("��½�ɹ���");
				break;
			}
			if(inputCount == 3){
				System.out.println("�˻��ѱ����ᣡ");
			}
		}while( inputCount < 3);
		
	}

}
