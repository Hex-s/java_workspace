
/**
 * 变量数据类型的使用
 * @author Administrator
 *
 */
public class Exam2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//int类型
		int width = 1234567891;
		//int的长度范围，通过包装类获取
		int maxValue = Integer.MAX_VALUE;
		int minValue = Integer.MIN_VALUE;
		//此时的加号表示为连接符，用来将常值和变量进行拼接
		System.out.println("int的最大值是"+maxValue+",最小值是"+minValue);
		
		//short类型
		//默认情况下直接写的所有整数都将识别为int型
		short age = 22; 
		short shortMax = Short.MAX_VALUE;
		short shortMin = Short.MIN_VALUE;
		System.out.println("short的最大值是"+shortMax+",最小值是"+shortMin);
		
		//long类型  需要在值的后面加上l表示该值为long型
		long length = 1234l;
		long longMax = Long.MAX_VALUE;
		long longMin = Long.MIN_VALUE;
		System.out.println("long的最大值是"+longMax+",最小值是"+longMin);
		
		//float 单精度浮点小数,默认情况下带有小数的数值都将识别为double型
		//使用f表示float类型的值
		float price = 10.5f;
		float floatMax = Float.MAX_VALUE;
		float floatMin = Float.MIN_VALUE;
		System.out.println("float的最大值是"+floatMax+",最小值是"+floatMin);
		
		//double 双精度浮点小数
		double toSunLength = 11111111.1212312323;
		double doubleMax = Double.MAX_VALUE;
		double doubleMin = Double.MIN_VALUE;
		System.out.println("double的最大值是"+doubleMax+",最小值是"+doubleMin);
	}

}
