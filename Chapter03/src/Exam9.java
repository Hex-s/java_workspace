import java.util.Scanner;


public class Exam9 {

	/**
	 * 实现登陆的操作
	 * @param args
	 */
	public static void main(String[] args) {
		
		//正确的用户名
		String realName = "admin";
		//正确的密码
		String realPassword = "0000";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String name = sc.next();
		System.out.println("请输入密码：");
		String password = sc.next();
		
		//判断用户名和密码是否正确
		if(name.equals(realName)){
			//用户名正确
			//继续判断密码
			if(password.equals(realPassword)){
				//用户名和密码都正确
				System.out.println("登陆成功");
			}
			else{
				System.out.println("密码错误！");
			}
		}
		else{
			System.out.println("用户名不存在！");
		}
	}

}
