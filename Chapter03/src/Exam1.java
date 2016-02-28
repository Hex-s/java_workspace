
public class Exam1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 4;
		double num3 = 10.5;
		
		//加法计算,任何运算都需要通过变量保存计算的结果
		//num1 = num1 + num2;
		int result = num1 + num2;
		//当算术运算中存在不同类型时，结果类型取决于范围更大的数据类型
		//result = (int)(num1 + num3);
		//result = num1 + (int)num3;
		
		//System.out.println(result);
		//任何数据类型通过加号连接字符串最终结果类型都为String
		//小括号在Java有着最高的运算优先级
		//System.out.println("num1+num2="+((num1+num2)+(num1+num2)));
		//System.out.println(num1+num2+"的运算结果是"+num1+num2);
		//System.out.println(num1+"+"+num2+"="+(num1+num2));
		
		//乘法
		result = num1 * num2;
		System.out.println(result);
		
		//减法
		result = num1 - num2;
		System.out.println(result);
		
		//除法 如果相除两数是整数，则将丢失所有小数精度
		//分母不能为0
		double res = (double)num1 / num2;
		System.out.println(res);
	}

}
