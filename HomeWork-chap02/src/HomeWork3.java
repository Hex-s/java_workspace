/**
 * 3. 显示菜单如下：
	1 商品浏览
	2 商品购买
	3 货物结算
	请选择：

          要求：通过键盘接受选择的菜单项并显示选择的数字，不管选择的是哪个项，都接着显示商品的信息，商品信息如下:

	品名   数量   单价  
 	衬衫   10   230
	球鞋   7    345.5
	图书   28   87
 */

import java.util.Scanner;

public class HomeWork3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// 变量声明
		String shirt = "衬衫";
		String shoes = "球鞋";
		String book = "图书";
		int shirtNumber = 10;
		int shoesNumber = 7;
		int bookNumber = 28;
		double shirtPrice = 230;
		double shoesPrice = 345.5;
		double bookPrice = 87;

		// 输出菜单项
		System.out.print("显示菜单如下：\n\t1 商品浏览\n\t2 商品购买\n\t3 货物结算\n\t请选择：");

		// 从键盘选择菜单项
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();

		// 输出菜单项内容
		System.out.println("品名\t数量\t单价");
		System.out.println(shirt + "\t" + shirtNumber + "\t" + shirtPrice);
		System.out.println(shoes + "\t" + shoesNumber + "\t" + shoesPrice);
		System.out.print(book + "\t" + bookNumber + "\t" + bookPrice);
	}

}
