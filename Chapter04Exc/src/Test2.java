
public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//打印5行5列*构成的图案
		
		//控制循环打印的行数
//		for(int j = 1; j <= 5; j++){
//			//重复打每一个列，构成一行
//			for(int i = 1; i <= 5; i++){
//				System.out.print("*");
//			}
//			//换行
//			System.out.println();
//		}
		
		//*
		//**
		//***
		//****
		//*****
		//外层循环控制行数
//		for(int i = 1; i <= 5; i++){
//			//里层循环列数
//			for(int j = 1; j <= i; j++){
//				System.out.print("*");
//			}
//			//换行
//			System.out.println();
//		}
		
		//1*1=1
		//2*1=2 2*2=4
		//3*1=3 3*2=6 3*3=9
		//....................
//		for(int i = 1; i <= 9; i++){
//			for(int j = 1; j <= i; j++){
//				System.out.print(i+"*"+j+"="+i*j+"\t");
//			}
//			System.out.println();
//		}
		
		//*****
		//#*****
		//##*****
		//###*****
		//####*****
		//控制行数
//		for(int i = 1; i <= 5; i++){
//			//每一行
//			//控制打印的空格
//			for(int j = 1; j < i; j++){
//				System.out.print(" ");
//			}
//			//控制打印的*
//			for(int k = 1; k <= 5; k++){
//				System.out.print("*");
//			}
//			//换行
//			System.out.println();
//		}
		
		//*****
		//****
		//***
		//**
		//*
//		for(int i = 1; i <= 5; i++){
//			for(int j = 5; j >= i; j--){
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		for(int i = 5; i >=1; i--){
//			for(int j = 1; j <= i; j++){
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		for(int i = 1; i <= 5; i++){
//			for(int j = 0; j <= 5-i; j++){
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		//    *
		//   ***
		//  *****
		// *******
		//*********
//		for(int i = 1; i <= 5; i++){
//			//控制打印的空格
//			for(int j = 1; j <= 5-i; j++){
//				System.out.print(" ");
//			}
//			//控制打印的*
//			for(int k = 1; k <= 2*i-1; k++){
//				System.out.print("*");
//			}
//			//换行
//			System.out.println();
//		}
		
		//	  *
		//   ***
		//  *****
		// *******
		//*********
		// *******
		//  *****
		//   ***
		//    *
		//打印上半部分
//		for(int i = 1; i <= 5; i++){
//			//控制打印的空格
//			for(int j = 1; j <= 5-i; j++){
//				System.out.print(" ");
//			}
//			//控制打印的*
//			for(int k = 1; k <= 2*i-1; k++){
//				System.out.print("*");
//			}
//			//换行
//			System.out.println();
//		}
//		//打印下半部分
//		for(int i = 1; i <= 4; i++){
//			for(int j = 1; j <= i; j++){
//				System.out.print(" ");
//			}
//			for(int k = 1; k <= 9-2*i; k++){
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		//键盘接受菱形的行数（判断奇数条件，如果输入错误，重新输入），打印一个空心的菱形
//		for(int i = 1; i <= 5; i++){
//			//判断首尾的条件
//			if(i == 1 || i == 5){
//				System.out.print("*");
//			}
//			else{
//				System.out.print(" ");
//			}
//		}
//		for(int i = 1; i <= 5; i++){
//			//控制打印的空格
//			for(int j = 1; j <= 5-i; j++){
//				System.out.print(" ");
//			}
//			//控制打印的*
//			for(int k = 1; k <= 2*i-1; k++){
//				//判断*的首尾位置
//				if(k == 1 || k == 2*i-1){
//					System.out.print("*");
//				}
//				else{
//					System.out.print(" ");
//				}
//			}
//			//换行
//			System.out.println();
//		}
//		//打印下半部分
//		for(int i = 1; i <= 4; i++){
//			for(int j = 1; j <= i; j++){
//				System.out.print(" ");
//			}
//			for(int k = 1; k <= 9-2*i; k++){
//				if(k == 1 || k == 9-2*i){
//					System.out.print("*");
//				}
//				else{
//					System.out.print(" ");
//				}
//			}
//			System.out.println();
//		}
		
		//打印显示1-100内的所有质数
		//思路：
		//3 3%2!=0 
		//5 5%2 5%3 5%4
		//6 6%2
		//7 7%2 7%3 7%4 7%5 7%6
		//标示是否是质数 默认是质数
//		boolean flag = true;
//		for(int i = 2; i <= 100; i++){
//			flag = true;
//			for(int j = 2; j < i; j++){
//				//mod操作，判断是否除尽
//				if(i%j == 0){
//					//修改标示
//					flag = false;
//					break;
//				}
//			}
//			//如果标示为true，则是质数
//			if(flag){
//				System.out.println(i);
//			}
//		}
		
		
	}

}
