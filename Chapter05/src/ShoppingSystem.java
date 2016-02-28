import java.util.Scanner;

/**
 * 购物系统类
 * @author Administrator
 *
 */
public class ShoppingSystem {
	//由于键盘输入对象需要在多个方法中重复创建，因此抽离成属性
	Scanner sc;
	//系统所需的数据
	Data data;
	
	/**
	 * 初始化系统
	 */
	public void init(){
		sc = new Scanner(System.in);
		data = new Data();
	}
	/**
	 * 开启系统的方法
	 */
	public void start(){
		System.out.println("----------------购物系统-------------");
		System.out.println("1. 登陆");
		System.out.println("2. 注册");
		System.out.println("3. 退出");
		System.out.println("请选择：");
		int chooice = sc.nextInt();
		switch(chooice){
		case 1:
			//登陆
			login();
			break;
		case 2:
			//注册
			regist();
			break;
		case 3:
			//退出
			System.out.println("您已退出，欢迎下次使用系统");
			break;
		default:
			System.out.println("无效的输入，请重新选择");
			//递归
			//start();
			back(1, 1);
			break;
		}
	}
	/**
	 * 登陆功能
	 */
	public void login(){
		System.out.println("请输入用户名：");
		String name = sc.next();
		System.out.println("请输入密码：");
		String pwd = sc.next();
		//调用验证的方法
		if(validate(name, pwd)){
			System.out.println("登录成功");
		}
		else{
			System.out.println("用户名或密码错误！请重新输入");
			//递归调用login方法
			//login();
			back(1, 2);
		}
	}
	
	/**
	 * 校验的方法
	 * @param name 输入的用户名
	 * @param pwd 输入的密码
	 * @return 校验的结果
	 */
	public boolean validate(String name, String pwd){
		if(!name.equals(data.name)){
			return false;
		}
		if(!pwd.equals(data.pwd)){
			return false;
		}
		return true;
	}
	/**
	 * 注册功能
	 */
	public void regist(){
		
	}
	/**
	 * 返回菜单和选择的方法
	 * @param menuId 上级菜单的编号 1表示主菜单
	 * @param optId 当前操作的编号 1表示主菜单的选择  2表示登录  3表示注册
	 */
	public void back(int menuId, int optId){
		System.out.println("输入0返回上级菜单，任意数字继续执行");
		int chooice = sc.nextInt();
		switch(chooice){
		case 0:
			if(menuId == 1){
				start();
			}
			break;
		default:
			//判断当前操作的编号
			switch(optId){
			case 1:
				start();
				break;
			case 2:
				login();
				break;
			case 3:
				regist();
				break;
			}
			
		}
	}
}
