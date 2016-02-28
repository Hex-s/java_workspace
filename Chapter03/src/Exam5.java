import java.util.Scanner;


public class Exam5 {

	/**
	 * 逻辑运算符
	 * @param args
	 */
	public static void main(String[] args) {
		//&&表示并且的关系，要求两个条件都同时满足
		//true&&true表示并且关系成立 
		//true&&false false&&true false&&false表示并且关系不成立
		//逻辑运算符运算的结果类型也是boolean类型
		//||表示或者关系，只要任意一个条件满足则整个或者都成立
		//true||false  false||true  true||true表示或者关系成立
		//false||false 表示或者关系不成立
		int n1 = 10;
		int n2 = 4;
		int n3 = 6;
		int n4 = 3;
		//System.out.println(n1 - n4 <= n2 || n1 == n2 + n3 && n4 * n3 > n1);
		//System.out.println(n1 != n4 || (n2 +  n3) * n4 >= n1 && n1 == n2 + n3 || n2 != n3 + n4 );
		
		//&& ||又称为短路运算符
//		System.out.println(++n3 <= n1 & n4++ == n2);
//		System.out.println(n4);
//		System.out.println(n3);
		
		//!表示对boolean类型取反 
//		boolean flag = true;
//		System.out.println(!flag);
		
		int num = 10;
		//判断是否是个位数
		System.out.println(!(num >= 0 && num <= 9));
	}

}
