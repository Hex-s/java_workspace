import java.util.Scanner;


public class Exam4 {

	/**
	 * 关系运算符
	 * @param args
	 */
	public static void main(String[] args) {
		
		int num1 = 20;
		int num2 = 10;
		//关系运算符是对某种情况的一个假设，所有关系运算符的运算结果都为boolean类型
		//System.out.println(num1<=num2);
		
		String str1 = "hello";
		Scanner sc = new Scanner(System.in);
		String str2 = sc.next();
		String str3 = "hello";
		//所有字符串的等值比较使用equals
		//System.out.println(str1 == str2);
		System.out.println(str1.equals(str2));
	}

}
