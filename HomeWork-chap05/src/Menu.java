/**
 * 菜单类
 * @author Administrator
 *
 */
import java.util.Scanner;

public class Menu {

	// 从键盘接收数据
	Scanner sc;
	// 系统数据
	Data data;
	// 验证码
	Code code;
	// 选择项
	int choice;
	// 产生的验证码
	String codeStr;
	// 从键盘接收姓名
	String name;
	// 从键盘接收密码
	String pwd;
	// 从键盘接收确认密码
	String pwdAffirm;

	/**
	 * 系统初始化
	 */
	public void init() {
		sc = new Scanner(System.in);
		data = new Data();
		code = new Code();
	}

	/**
	 * 开始方法呈现开始菜单 登陆 注册 退出
	 */
	public void start() {
		System.out.println("---------------购物系统---------------");
		System.out.println("1. 登陆");
		System.out.println("2. 注册");
		System.out.println("3. 退出");
		System.out.print("请选择：");
		choice = sc.nextInt();
		switch (choice) {
		case 1:
			// 登录
			login();
			break;
		case 2:
			// 注册
			register();
			break;
		case 3:
			// 退出
			System.out.println("您已经退出系统，欢迎再次使用！");
			break;
		default:
			// 输入错误
			System.out.println("无效的输入，请重新选择！");
			back(1,1);
			break;
		}

	}

	/**
	 * 登录
	 */
	public void login() {
		// 选择登陆后输入用户名密码，确认密码和验证码
		System.out.print("请输入用户名：");
		name = sc.next();
		System.out.print("请输入密码：");
		pwd = sc.next();
		System.out.print("请再次输入密码：");
		pwdAffirm = sc.next();
		// 产生验证码
		codeStr = code.testCode();
		System.out.print("请输入验证码" + codeStr + "：");
		String code = sc.next();

		// 验证用户名,密码和验证码的正确性
		if (validate(pwd,pwdAffirm,code)&&validateLogin(name, pwd)) {
			System.out.println("登陆成功！");
			mainMenu();
		} else {
			back(1, 2);
		}

	}

	
	/**
	 * 验证两次输入的密码是否一致，验证码是否正确
	 * @param pwd 输入的密码
	 * @param pwdAffirm  确认的密码
	 * @param code 输入的验证码
	 * @return
	 */
	public boolean validate(String pwd, String pwdAffirm,
			String code) {
		// 验证验证码的正确性
		if (!code.equals(codeStr)) {
			System.out.println("验证码错误！");
			return false;
		}
		if (!pwdAffirm.equals(pwd)) {
			System.out.println("两次密码输入不一致！");
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @param name 输入的用户名
	 * @param pwd 输入的密码
	 * @return 校验的结果
	 */ 
	public boolean validateLogin(String name, String pwd) {

		// 验证用户名的正确性
		if (!name.equals(data.name)) {
			System.out.println("用户名错误！");
			return false;
		}
		// 验证密码的正确性
		if (!pwd.equals(data.pwd)) {
			System.out.println("密码错误！");
			return false;
		}

		return true;
	}

	/**
	 * 返回菜单和选择的方法
	 * 
	 * @param menuId
	 *            上级菜单的编号 1表示主菜单 2表示主菜单界面
	 * @param optId
	 *            当前操作的编号 1表示主菜单的选择 2表示登录 3表示注册 4表示主菜单界面
	 */
	public void back(int menuId, int optId) {
		System.out.println("输入0返回上级菜单，输入1继续执行");
		choice = sc.nextInt();
		switch (choice) {
		case 0:
			if (menuId == 1) {
				start();
				break;
			}
			else if(menuId == 2){
				mainMenu();
				break;
			}
			break;
		default:
			// 判断当前操作的编号
			switch (optId) {
			case 1:
				start();
				break;
			case 2:
				login();
				break;
			case 3:
				register();
				break;
			case 4:
				mainMenu();
				break;
			case 5:
				sweepstake();
				break;

			}

		}
	}

	/**
	 * 注册
	 */
	public void register() {
		System.out.print("请输入您要注册的用户名：");
		name = sc.next();
		System.out.print("请输入您要注册的密码：");
		pwd = sc.next();
		System.out.print("请再次输入您要注册的密码：");
		pwdAffirm = sc.next();
		// 产生验证码
		codeStr = code.testCode();
		System.out.print("请输入验证码" + codeStr + "：");
		String code = sc.next();

		// 验证用户名，密码，确认密码和验证码
		if (validateRegistr(name)&&validate(pwd,pwdAffirm,code)) {
			
			// 将新的用户名和密码赋值给Data
			data.name = name;
			data.pwd = pwd;
			System.out.println("注册成功！");
			// 注册成功退回开始菜单
			start();		
		}	
		// 注册失败
		else {
			back(1, 3);
		}

	}

	/**
	 * 验证注册时的用户名是否与已经存在的用户名重复
	 * 
	 * @param name 输入的用户名
	 */
	public boolean validateRegistr(String name) {

		// 验证用户名是否重复
		if (name.equals(data.name)) {
			System.out.println("用户名已存在！");
			return false;
		}
		return true;
	}

	/**
	 * 主菜单界面
	 */
	public void mainMenu() {
		System.out.println("-------------主菜单界面-----------------");
		System.out.println("1. 幸运抽奖");
		System.out.println("2. 购物结算");
		System.out.println("3. 商品陈列");
		System.out.println("4. 真情回馈");
		System.out.print("请选择：");
		choice = sc.nextInt();
		switch(choice){
		case 1:
			//幸运抽奖
			sweepstake();
			back(2,5);
			break;
		case 2:
			//2. 购物结算
			break;
		case 3:
			//3. 商品陈列
			break;
		case 4:
			//4. 真情回馈
			break;
		default:
			// 输入错误
			System.out.println("无效的输入，请重新选择！");
			back(1,4);	
			break;
		}
	}
	
	//幸运抽奖
	public void sweepstake(){
		// 幸运数字
		int luckyNum = (int) (Math.random() * 10);
		// 输入数字
		System.out.print("请输入您的幸运数字：");
		int num = sc.nextInt();
		// 比较数字与幸运数字
		if (luckyNum == num) {
			System.out.println("恭喜您！中奖了，获得MP3一个！");
		} else {
			System.out.println("很遗憾，您没有中奖！");
		}
		back(2,5);
	}
	
}
