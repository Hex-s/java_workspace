/**
 * 4. 温度计同时标有摄氏度和华氏度，
 * 	摄氏度从0度开始，最高可测到180度，
 *  摄氏度的计量每20度为一格显示单位，
 *  打印显示该摄氏温度计每格的摄氏度及对应的华氏度（华氏度=摄氏度*1.8+32）
 * @author Administrator
 *
 */
public class HomeWork4 {

	public static void main(String[] args) {
		//摄氏温度
		int centigage = 0;
		//华氏度
		double fahrenheit;
		//格数
		int count = 0;
		//输出每格的参数
		while(centigage < 180){
			//每格的摄氏度
			centigage =count *  20;
			//每格的华氏度
			fahrenheit = centigage * 1.8 + 32;
			//格数递增
			count++;
			//输出结果
			System.out.println("第"+count+"格所对应的摄氏度为"+centigage+"℃，所对应的华氏度为"+fahrenheit+"℉");
		}
	}

}
