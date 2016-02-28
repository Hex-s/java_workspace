import java.util.Scanner;


public class Exam11 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("-------------系统菜单-------------");
		System.out.println("1. 登陆");
		System.out.println("2. 注册");
		System.out.println("3. 退出");
		System.out.println("请选择：");
		Scanner sc = new Scanner(System.in);
		int chooice = sc.nextInt();
		//判断选择
//		if(chooice == 1){
//			System.out.println("选择了登陆");
//		}
//		else if(chooice == 2){
//			System.out.println("选择了注册");
//		}
//		else{
//			System.out.println("选择了退出");
//		}

		int n = 1;
		//使用switch语句改写
		switch(chooice){
		//case后只能写常值
		case 1:
			//满足条件执行的代码
			System.out.println("登陆");
			//跳出当前的switch结构
			break;
		//每一个case的值不能重复
		case 2:
			System.out.println("注册");
			break;
		case 3:
			System.out.println("退出");
			break;
		//default表示没有满足所有的case条件，相当于if条件中的else
		default:
			System.out.println("输入无效！");
			break;
		}
	}

}
