import java.util.Scanner;


/**
 * 计算器类
 * @author Administrator
 *
 */
public class Calculator {
	//当类中的某个数据需要在多个方法都能访问
	//则该数据应成为类的属性
//	double num1;
//	double num2;
	
	/**
	 * 计算的方法
	 * @return
	 */
	public double calculate(){
		//计算结果
		double result = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入第一个数：");
		double num1 = sc.nextDouble();
		System.out.println("请输入第二个数：");
		double num2 = sc.nextDouble();
		System.out.println("请输入运算符：1.+ 2.- 3.* 4./");
		int opt = sc.nextInt();
		
		//判断运算符
		switch(opt){
		case 1:
			result = addition(num1,num2);
			break;
		case 2:
			result = substraction(num1,num2);
			break;
		case 3:
			result = multiplication(num1,num2);
			break;
		case 4:
			result = divition(num1,num2);
			break;
		default:
			System.out.println("无效的运算符！");
			break;
		}
		return result;
	}
	/**
	 * 加法运算
	 * @return
	 */
	public double addition(double num1, double num2){
		
		double result = num1+num2;
		return result;
	}
	/**
	 * 减法
	 * @return
	 */
	public double substraction(double num1, double num2){
		double result = num1-num2;
		return result;
	}
	/**
	 * 乘法
	 * @return
	 */
	public double multiplication(double num1, double num2){
		double result = num1*num2;
		return result;
	}
	/**
	 * 除法
	 * @return
	 */
	public double divition(double num1, double num2){
		double result = num1/num2;
		return result;
	}
}
