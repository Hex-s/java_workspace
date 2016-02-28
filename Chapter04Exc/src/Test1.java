import java.util.Scanner;


public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*******1 2,2 3,3 5,5 8,8 13.......第12组数据分别是多少******/
//		int a = 1;
//		int b = 2;
//		int c;
//		int d;
//		for(int i = 1; i < 12; i++){
//			//临时保存a的值
////			c = a;
////			a = b;
////			b = c+b;
//			
//			//临时保存b的值
//			c = b;
//			b = a+c;
//			a = c; 
//		}
		//System.out.println(a+":"+b);
		
		
		/**通过键盘输入2个数，比如第一个数为2，第二个数是4
		最终计算2+22+222+2222=?
		如果第一个数是3,第二个数是5
		最终计算3+33+333+3333+33333=?*/
		
		//0*10+2
		//2*10+2
		//22*10+2
		//222*10+2
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个个位数表示起始值");
		int a = sc.nextInt();
		System.out.println("请输入另一个个位数表示累加的次数");
		int n = sc.nextInt();
		//临时变量，用来保存上一个计算的结果
		int temp = 0;
		//计算的和
		int sum = 0;
		//反复累加
//		for(int i = 1; i <= n; i++){
//			temp+=a;
//			//计算和
//			sum+=temp;
//			//每次扩大10倍
//			temp = temp*10;
//		}
		
		
		//另一种思路
		//0+2
		//2*10+2
		//2*100+22
		//2*1000+222
		for(int i = 1; i <= n; i++){
			temp+=a;
			//累加和
			sum+=temp;
			//a扩大10倍
			a = a*10;
		}
		System.out.println(sum);
	}

}
