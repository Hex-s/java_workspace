/**
 * 2. ����������ѡȡ�˿��ƵĲ�ͬ��ɫ�����ң����ң����飬÷���������������ֵ��ƻ���
 *
 */
import java.util.Scanner;

public class HomeWork2 {
	
	public static void main(String[] args){
		//�Ӽ��̽��ܱ���
		Scanner sc = new Scanner(System.in);
		
		//����ѡȡ�˿��ƻ�ɫ
		System.out.print("����ѡȡ�˿��ƻ�ɫ��");
		String left=sc.next();
		
		//����ѡȡ�˿��ƻ�ɫ
		System.out.print("����ѡȡ�˿��ƻ�ɫ��");
		String right = sc.next();
		
		//���������ѡȡ�Ļ�ɫ
		System.out.println("�����˿��ƵĻ�ɫΪ��"+left+"�������˿��ƵĻ�ɫΪ��"+right);
		
		//�����ֵ��ƻ���
		String temp=left;
		left=right;
		right=temp;
		//��������������ֵ��˿��ƻ�ɫ
		System.out.println("�����˿��ƵĻ�ɫΪ��"+left+"�������˿��ƵĻ�ɫΪ��"+right);
	}

}
