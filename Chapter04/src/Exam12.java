
public class Exam12 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		for(int i = 1; i <= 10; i++){
			if(i == 5){
				continue;
			}
			System.out.println(i);
		}
		
		//计算1-100所有偶数的和
		int sum = 0;
		for(int i = 1; i <= 100; i++){
			//判断是否是奇数，如果是奇数则跳过
			if(i % 2 != 0){
				continue;
			}
			sum += i;
		}
		System.out.println(sum);
	}

}
