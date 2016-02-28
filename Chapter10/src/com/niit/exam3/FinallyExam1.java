package com.niit.exam3;

public class FinallyExam1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] array = new int[10];
		try {
			array[10] = 10;
			System.out.println(array[10]);
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("数组越界");
		}
		//finally表示不管异常是否发生，始终都会执行的代码段
		finally{
			System.out.println("程序执行结束");
		}
		
		
	}

}
