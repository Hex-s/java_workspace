/**
 * 1. 登陆模拟，用户名或密码输入错误后给出相关错误提示，并告知还有多少次错误机会 
 *	   如果3次验证失败后将冻结账户
 */
import java.util.Scanner;

public class HomeWork1 {

	public static void main(String[] args) {
		//输入次数
		int inputCount = 0;
		//允许验证的最大的次数
		int allowCount = 3;
		//正确用户名
		String realName = "tom";
		//正确密码
		String realPassword = "123456";
		//输入的用户名
		String name;
		//输入的密码
		String password;
		Scanner sc = new Scanner(System.in);
		do{
			//输入一次，inputCount加1
			inputCount++;
			//输入用户名
			System.out.print("请输入用户名：");
			name = sc.next();
			//输入密码
			System.out.print("请输入密码：");
			password = sc.next();
			//判断密码是否正确
			if(! name.equals(realName) ){
				System.out.println("用户名错误，请重新输入！");
				System.out.println("您一共有3次验证机会，还剩"+(allowCount - inputCount)+"次机会！");
			}
			//判断密码是否正确
			else if(!password.equals(realPassword)){
				System.out.println("密码错误，请重新输入！");
				System.out.println("您一共有3次验证机会，还剩"+(allowCount - inputCount)+"次机会！");
			}
			//用户名和密码都正确
			else{
				System.out.println("登陆成功！");
				break;
			}
			if(inputCount == 3){
				System.out.println("账户已被冻结！");
			}
		}while( inputCount < 3);
		
	}

}
