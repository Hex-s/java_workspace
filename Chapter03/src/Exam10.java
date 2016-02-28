
public class Exam10 {

	/**
	 * 输入一个成绩，判断成绩的状态
	 * 90分以上优秀  80分以上良好 60分以上一般  60分以下非常差
	 * @param args
	 */
	public static void main(String[] args) {
		
		int score = 85;
		
//		if(score >= 90){
//			System.out.println("成绩优秀");
//		}
//		else{
//			if(score >= 80){
//				System.out.println("成绩良好");
//			}
//			else{
//				if(score >= 60){
//					System.out.println("成绩一般");
//				}
//				else{
//					System.out.println("成绩非常差");
//				}
//			}
//		}
		
		//使用多重条件结构简化上述代码
		if(score >= 90){
			System.out.println("成绩优秀");
		}
		else if(score >= 80){
			System.out.println("成绩良好");
		}
		else if(score >= 60){
			System.out.println("成绩一般");
		}
		else{
			System.out.println("成绩非常差");
		}
	}

}
