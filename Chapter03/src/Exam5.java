import java.util.Scanner;


public class Exam5 {

	/**
	 * �߼������
	 * @param args
	 */
	public static void main(String[] args) {
		//&&��ʾ���ҵĹ�ϵ��Ҫ������������ͬʱ����
		//true&&true��ʾ���ҹ�ϵ���� 
		//true&&false false&&true false&&false��ʾ���ҹ�ϵ������
		//�߼����������Ľ������Ҳ��boolean����
		//||��ʾ���߹�ϵ��ֻҪ����һ�������������������߶�����
		//true||false  false||true  true||true��ʾ���߹�ϵ����
		//false||false ��ʾ���߹�ϵ������
		int n1 = 10;
		int n2 = 4;
		int n3 = 6;
		int n4 = 3;
		//System.out.println(n1 - n4 <= n2 || n1 == n2 + n3 && n4 * n3 > n1);
		//System.out.println(n1 != n4 || (n2 +  n3) * n4 >= n1 && n1 == n2 + n3 || n2 != n3 + n4 );
		
		//&& ||�ֳ�Ϊ��·�����
//		System.out.println(++n3 <= n1 & n4++ == n2);
//		System.out.println(n4);
//		System.out.println(n3);
		
		//!��ʾ��boolean����ȡ�� 
//		boolean flag = true;
//		System.out.println(!flag);
		
		int num = 10;
		//�ж��Ƿ��Ǹ�λ��
		System.out.println(!(num >= 0 && num <= 9));
	}

}
