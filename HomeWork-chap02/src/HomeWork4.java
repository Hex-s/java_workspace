/**
 * 4. ���̽���һ�������ȸ������ͣ����������ͽ���װ�䣬ת�����ַ�������
 * 5. �������е��ַ�������ת����˫���ȸ����װ���ͣ����в������ת��������
 *
 */

import java.util.Scanner;
public class HomeWork4 {
	
	public static void main(String[] args){
		//�Ӽ��̽���һ�������ȸ�������
		Scanner sc=new Scanner(System.in);
		System.out.print("������һ�������ȸ�����������");
		float n1=sc.nextFloat();
		//��float����װ��
		Float n2=new Float(n1);
		//ת�����ַ�������
		String str =n2.toString();
		//���ת���Ľ��
		System.out.println("������������ת�����ַ������ͣ�"+str);
		
		//���ַ�������ת����˫���ȸ�����
		double n3=Double.parseDouble(str);
		System.out.println("���ַ�������ת����˫���ȸ�������"+n3);
		//��double���а�װ
		Double n4=new Double(n3);
		//��double���в���
		double n5=n4.doubleValue();
		//��doubleת��������
		int n6=(int)n5;
		System.out.print("��˫���ȸ�������ת�������ͣ�"+n6);
	}

}
