
public class Practise {
	public static void main(String[] args){
		int n1=10;
		//装箱
		Integer n2=new Integer(n1);
		String str=n2.toString();
		System.out.println(n1);
		System.out.println(str);
		
		//拆箱
		int n3=n2.intValue();
		System.out.println(n3);
		
		//parse转换
		String str1="100.0";
		//int num=Integer.parseInt(str1);
		float num=Float.parseFloat(str1);
		double num1=Double.parseDouble(str1);
		System.out.println(num);
		System.out.println(num1);
		
		//parse转换，将String转换成其他(没有char)
		String s="a";
		
	}
}
