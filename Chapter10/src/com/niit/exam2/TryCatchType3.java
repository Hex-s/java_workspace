package com.niit.exam2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatchType3 {

	/**
	 * 异常的第三种情况，捕获的异常和发生的异常不匹配，将导致异常无法正确进行处理
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
		 * Java中如果出现异常，会产生一个相应的异常类的实例对象
		 * chatch表示将参数要捕获的异常类型和JVM中产生的异常实例类型进行匹配，如果匹配成功则能对该异常进行正确的处理
		 * 反之，则捕获不到异常
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入用户的数量：");
		//监视可能出现的异常代码段
		try{
			int num = sc.nextInt();
			User[] users = new User[num];
			for(int i = 0; i < users.length; i++){
				System.out.println("请输入用户的姓名");
				users[i].setName(sc.next());
				System.out.println("请输入用户的年龄");
				users[i].setAge(sc.nextInt());
			}
		}
		//捕获对应的异常并处理
		//对于多个异常可以使用多重catch来解决
		//如果程序中存在多种异常，并且多种异常都需要使用不同的方式处理，则应使用多重catch
		catch(InputMismatchException e){
			System.out.println("捕获非法输入异常！");
		}
		catch(NullPointerException e){
			System.out.println("捕获到空指针异常！");
			//e.printStackTrace();
		}
		//即使使用多重catch，也应在最后加上Exception的捕获
		catch(Exception e){
			//打印异常对象中的消息
			//System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("代码执行结束");
		
	}

}
