
public class Exam6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**************隐式转换又称为自动类型转换****************/
		//当我们将范围小的数据赋值给范围更大的目标数据类型时将由JVM自动发生转换
//		long num1;
//		int num2 = 10;
//		num1 = num2;
//		double num3;
//		float num4=10.0f;
//		num4 = num1; 
//		num3 = num4;
		
		/***********强制类型转换是将范围大的数据赋值给范围小的目标数据采取的转换手段*********/
		
//		long num2 = 10000000000000000l;
//		int num3;
//		//使用强制类型转换将long转换成int型
//		num3 = (int)num2;
//		System.out.println(num3);
		
		
//		float n1 = (float)15.56;
//		//将浮点数转换成整数，会造成小数精度的丢失
//		int n2 = (int)n1;
//		System.out.println(n2);
//		int n3 = 10;
//		n1 = n3;
//		System.out.println(n1);
		
		
		
		/***********toString用来将任意Java类型转换成String类型***********/
		int n1 = 100;
		double n2 = 100.999;
		boolean flag = true;
		String str;
		//任意数据类型通过加号连接""都将获取一个新的String的值
		str = n1+"";
		str = n2+"";
		str = flag+"";
		//将int型转换成包装类,该过程成为装箱
		Integer num1 = new Integer(n1);
		//将包装类中对应的数据转换成基本的数据时，这个过程称为拆箱
		int n3 = num1.intValue();
		//对double进行装箱拆箱
		Double num2 = new Double(n2);
		n2 = num2.doubleValue();
		//char进行装箱和拆箱
		Character ch = new Character('a');
		char word = ch.charValue();
		//System.out.println(word);
		
		//将int型使用toString转换成String类型
		//首先要先将int进行装箱，然后再通过包装类的toString实现转换
		str = num1.toString();
		System.out.println(str);
		
		
		/***************parse用来将String转换成其他数据类型*******************/
//		String str = "100.1";
//		//转换成int型
//		//int num1 = Integer.parseInt(str);
//		//转换成float型
//		float num2 = Float.parseFloat(str);
//		//字符串成不能通过parse方法转换成char类型
		
	}

}
