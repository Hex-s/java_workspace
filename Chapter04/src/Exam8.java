
public class Exam8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//计算1-100所有奇数的和
		int sum = 0;
		//for(int i = 1,j = 1; i <= 100 && j <= 50; i++, j++){
		for(int i = 1; i <= 100; i++){
			//System.out.println(i);
			if(i % 2 != 0){
				sum += i;
			}
		}
		System.out.println(sum);
		//System.out.println(i);
	}

}
