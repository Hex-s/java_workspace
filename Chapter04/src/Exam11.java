
public class Exam11 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		for(int i = 1; i <= 10; i++){
			//如果 循环到第5次退出循环
			if(i == 5){
				//break表示退出当前循环体
				break;
			}
			//System.out.println(i);
		}
		
		//计算1-100的和，当和的值等于或超过2500的时候，当前被加的数是多少
		int sum = 0;
		for(int i = 1; i <= 100; i++){
			sum += i;
			//对和进行判断
			if(sum >= 2500){
				System.out.println("当和的值等于或超过2500的时候，当前被加的数是"+i);
				//退出循环
				break;
			}
		}
		
//		int i = 1;
//		while(true){
//			if(i == 10){
//				break;
//			}
//			i++;
//		}
	}

}
