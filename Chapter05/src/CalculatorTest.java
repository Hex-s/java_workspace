
public class CalculatorTest {
	public static void main(String[] args) {
		//实例化计算器
		Calculator cal = new Calculator();
		//调用的加法计算
//		double result = cal.addition();
//		System.out.println(result);
		
		double result = cal.calculate();
		System.out.println("运算的结果是："+result);
		
	}
}
