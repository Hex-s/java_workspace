
public class Practise {
	public static void main(String[] args){
		int n1=10;
		//װ��
		Integer n2=new Integer(n1);
		String str=n2.toString();
		System.out.println(n1);
		System.out.println(str);
		
		//����
		int n3=n2.intValue();
		System.out.println(n3);
		
		//parseת��
		String str1="100.0";
		//int num=Integer.parseInt(str1);
		float num=Float.parseFloat(str1);
		double num1=Double.parseDouble(str1);
		System.out.println(num);
		System.out.println(num1);
		
		//parseת������Stringת��������(û��char)
		String s="a";
		
	}
}
