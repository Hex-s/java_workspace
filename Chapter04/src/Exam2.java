
public class Exam2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		int a = 1;
//		a = a + 2;
//		//等同于上述代码
//		a+=2;
		
		//计算1-100所有数的和
		//int i = 1;
		//变量作用域，变量的访问范围取决于声明变量所在的大括号的范围中
//		int sum = 0;
//		while(i <= 100){
//			//sum = sum + i;
//			sum += i;
//			i++;
//		}
//		System.out.println("1-100所有数的和："+sum);
		
		
		//要求计50-200间所有偶数的和
		int i = 50;
		int sum = 0;
		while(i <= 200){
			//判断每一个数是否是偶数
//			if(i % 2 == 0){
//				sum += i;
//			}
//			i++;
			sum += i;
			i += 2;
		}
		System.out.println(sum);
		
	}

}
