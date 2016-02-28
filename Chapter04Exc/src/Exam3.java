import java.util.Scanner;

public class Exam3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// for (int i = 1; i <= 9; i++) {
		// for (int j = 1; j <= i; j++) {
		// System.out.print(i+"*"+j+"="+(i*j)+"\t");
		// }
		// System.out.println();
		// }

		// for(int i = 1;i <= 5; i++ ){
		// for(int j = 1; j < i; j++){
		// System.out.print(" ");
		// }
		// for(int k = 1; k <= 5; k++){
		// System.out.print("*");
		// }
		// System.out.println();
		// }

		// for (int i = 1; i <= 5; i++) {
		// for(int j = 5; j >= i; j--){
		// System.out.print("*");
		// }
		// System.out.println();
		// }

		/**
		 * *
		 *** 
		 ***** 
		 ******* 
		 ********* 
		 */
		// for(int i = 1; i <=5; i++){
		// for(int j = 1; j <= 5-i ; j++){
		// System.out.print(" ");
		// }
		// for(int k = 1; k <= 2*i-1; k++){
		// System.out.print("*");
		// }
		// System.out.println();
		// }
		// for(int i = 1; i <= 4; i++){
		// for(int j = 1;j <= i;j++){
		// System.out.print(" ");
		// }
		// for(int k = 1; k <= 2*(5-i)-1; k++){
		// System.out.print("*");
		// }
		// System.out.println();
		// }

		Scanner sc = new Scanner(System.in);
		System.out.print("请输入菱形的行数：");
		int n = sc.nextInt();
		int halfN = (n + 1) / 2;
		if (n % 2 == 0 || n < 3) {
			System.out.println("您输入的行数不能组成一个菱形！");
		} else {
			// 菱形的上半部分
			for (int i = 1; i <= halfN; i++) {
				// 打印空格
				for (int j = 1; j <= halfN - i; j++) {
					System.out.print(" ");
				}
				// 打印*
				for (int k = 1; k <= 2 * i - 1; k++) {
					// 首尾打*，其余用空格补位
					if (k == 1 || k == 2 * i - 1) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
			// 菱形的下半部分
			for (int i = 1; i <= n / 2; i++) {
				for (int j = 1; j <= i; j++) {
					System.out.print(" ");
				}
				for (int k = 1; k <= n - 2 * i; k++) {
					// 首尾打*，其余用空格补位
					if (k == 1 || k == n - 2 * i) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
				System.out.println();
			}

		}

	}

}
