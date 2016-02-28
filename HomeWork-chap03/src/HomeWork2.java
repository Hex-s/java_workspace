/**
 * 2.购买了一台彩电，价格是3856元，求：支付的纸币各多少张？（纸币有100,50,20,10,5,1）
 * 
 * @author Administrator
 * 
 */
public class HomeWork2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int price = 3856;
		// 纸币张数
		int hundred = 0, fifty = 0, twenty = 0, ten = 0, five = 0, one = 0;
		// 100的纸币张数
		if (price >= 100) {
			hundred = price / 100;
			price = price % 100;
		}
		// 50的纸币张数
		if (price >= 50) {
			fifty = price / 50;
			price = price % 50;
		}
		// 20的纸币张数
		if (price >= 20) {
			twenty = price / 20;
			price = price % 20;
		}
		// 10的纸币张数
		if (price >= 10) {
			ten = price / 10;
			price = price % 10;
		}
		// 5的纸币张数
		if (price >= 5) {
			five = price / 5;
			price = price % 5;
		}
		// 1的纸币张数
		if (price > 0) {
			one = price;
		}
		// 输出结果
		System.out.print("支付的100元纸币张数为：" + hundred + "，50元纸币张数为：" + fifty
				+ "，20元纸币张数为：" + twenty + "，10元纸币张数为：" + ten + "，5元纸币张数为："
				+ five + "，1元纸币张数为：" + one);
	}

}
