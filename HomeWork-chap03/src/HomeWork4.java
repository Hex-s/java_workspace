/**
 * 输入儿童的年龄和性别，判断儿童是否能搬动桌子，3岁及以下男孩女孩都搬不动，4-5岁的男孩可以搬动，5岁以上男孩女孩都能搬动
 * @author Administrator
 *
 */
import java.util.Scanner;

public class HomeWork4 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// 输入儿童的年龄
		System.out.print("年龄：");
		int age = sc.nextInt();
		// 输入儿童的性别
		System.out.print("性别：");
		String sex = sc.next();
		// 3岁及以下男孩女孩都搬不动
		if (age <= 3) {
			System.out.print("3岁及以下男孩女孩都搬不动桌子");
		} else if (age >= 4 && age <= 5) {
			if (sex.equals("男")) {
				System.out.print("4-5岁的男孩可以搬动桌子");
			} else {
				System.out.print("4-5岁的女孩不能搬动桌子");
			}

		} else {
			System.out.print("5岁以上男孩女孩都能搬动桌子");
		}

	}
}
