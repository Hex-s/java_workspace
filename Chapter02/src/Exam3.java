
public class Exam3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//String字符串类型
		String name = "Jerry";
		System.out.println(name);
		
		//char单字符类型
		char sex = '男';
		char ch = '5';
		//char可以在赋值的时候值写成整数，此时的值代表字符的ASCII值
		char ch1 = 5;
		char ch2 = 65;
		int n = 5;
		System.out.println(sex);
		System.out.println(ch);
		System.out.println(ch1);
		System.out.println(ch2);
		System.out.println(n);
		
		//boolean类型 用来描述事物的两面性的状态
		//boolean isOpen = true;
		//boolean isClose = true;
		//true表示开   false表示关
		boolean flag = true;
		
		//变量名命名要求首字母只能是_$和字母构成，其余部分可以出现数字，并且变量名使用驼峰命名法
		String myNameIsTom;
	}

}
