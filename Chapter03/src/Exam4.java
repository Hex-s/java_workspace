import java.util.Scanner;


public class Exam4 {

	/**
	 * ��ϵ�����
	 * @param args
	 */
	public static void main(String[] args) {
		
		int num1 = 20;
		int num2 = 10;
		//��ϵ������Ƕ�ĳ�������һ�����裬���й�ϵ���������������Ϊboolean����
		//System.out.println(num1<=num2);
		
		String str1 = "hello";
		Scanner sc = new Scanner(System.in);
		String str2 = sc.next();
		String str3 = "hello";
		//�����ַ����ĵ�ֵ�Ƚ�ʹ��equals
		//System.out.println(str1 == str2);
		System.out.println(str1.equals(str2));
	}

}
