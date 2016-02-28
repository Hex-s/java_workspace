import java.util.Scanner;

public class HomeWork6 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// 输出菜单项
		System.out.println("/*************抽奖系统****************/");
		System.out.println();
		System.out.println("\t1. 登陆");
		System.out.println("\t2. 注册");
		System.out.println("\t3. 退出");
		System.out.print("\t请选择：");

		// 输入选择项
		Scanner sc = new Scanner(System.in);
		int choice1 = sc.nextInt();

		if (choice1 == 1) {
			// 模拟登陆过程
			// 输入用户名
			System.out.print("请输入用户名：");
			String name = sc.next();
			// 输入密码
			System.out.print("请输入密码：");
			String password = sc.next();
			// 确认密码
			System.out.print("请再次输入密码：");
			String confirmPassword = sc.next();
			// 输入验证码 1000-9999
			int securityCode = (int) (Math.random() * 9000) + 1000;
			System.out.print("请输入验证码（" + securityCode + "）：");
			int securityCodeInput = sc.nextInt();

			// 确认两次输入密码的一致性
			if (password.equals(confirmPassword)) {
				// 密码一致，验证码输入正确，注册成功
				if (securityCodeInput == securityCode) {
					System.out.println("注册成功！");
					// 主菜单
					System.out.println();
					System.out.println(">>主菜单");
					System.out.println("\t1. 幸运抽奖");
					System.out.println("\t2. 购物结算");
					System.out.println("\t3. 退出系统");
					System.out.print("\t请选择：");
					// 输入主菜单选择项
					int choice2 = sc.nextInt();
					if (choice2 == 1) {

						// 幸运数字
						int luckyNum = (int) (Math.random() * 10);
						// 输入账号
						System.out.print("请输入您的账号：");
						int account = sc.nextInt();
						// 获取账号的百位数
						int accountHun = account / 100 % 10;
						// 比较账号百位数字与幸运数字
						if (luckyNum == accountHun) {
							System.out.println("恭喜您！中奖了，获得MP3一个！");
						} else {
							System.out.println("很遗憾，您没有中奖！");
						}
					} else {
						System.out.println("您已经退出系统");
					}
				} else {
					System.out.println("验证码输入错误！");
				}
			} else {
				System.out.println("密码不一致，请重新注册！");
			}
		} else {
			System.out.println("您已经退出系统");
		}
	}

}
