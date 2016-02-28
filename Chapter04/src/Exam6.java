import java.util.Scanner;


public class Exam6 {

	/**
	 * 循环登陆
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String userName;
		String password;
		//记录是否验证通过的标示
//		boolean isValidate;
//		do{
//			//每一次重新输入时默认为正确的情况
//			isValidate = true;
//			System.out.println("请输入用户名：");
//			userName = sc.next();
//			System.out.println("请输入密码：");
//			password = sc.next();
//			//判断用户名
//			if(!userName.equals("admin")){
//				System.out.println("用户名不正确");
//				//修改标示
//				isValidate = false;
//			}
//			else if(!password.equals("0000")){
//				System.out.println("密码不正确");
//				isValidate = false;
//			}
//		}while(!isValidate);
		
		
		//验证的状态标示  1标示通过验证，0标示未通过验证
		int isValidate;
		do{
			isValidate = 1;
			//每一次重新输入时默认为正确的情况
			System.out.println("请输入用户名：");
			userName = sc.next();
			System.out.println("请输入密码：");
			password = sc.next();
			//判断用户名
			if(!userName.equals("admin")){
				System.out.println("用户名不正确");
				//修改标示
				isValidate = 0;
			}
			else if(!password.equals("0000")){
				System.out.println("密码不正确");
				isValidate = 0;

			}
		}while(isValidate == 0);
		
		
		
		
	}

}
