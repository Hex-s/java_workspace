package com.niit.exam3;

public class FinallyExam2 {

	public static int method(){
		try{
			System.out.println("������try");
			return 1;
		}
		catch(Exception e){
			System.out.println("������catch");
			return 2;
		}
		finally{
			System.out.println("������finally");
			try{
			int a = Integer.parseInt("a");
			return 4;
		}
		catch(Exception e){
			System.out.println("������Ƕ�׵�catch");
			return 5;
		}
		finally{
			System.out.println("������Ƕ�׵�finally");
			return 6;
		}
//			return 3;
		}
	}
	public static void main(String[] args) {
		
		System.out.println(FinallyExam2.method());
	}
}



