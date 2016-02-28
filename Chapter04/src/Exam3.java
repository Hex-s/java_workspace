
public class Exam3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//操场一圈是400米，如果需要跑11800米，共需多少跑多少圈
		//当前跑步的距离
		int length = 0;
		//跑步的圈数
		int count = 0;
		//如果没有跑满11800米，则应该继续跑步
		while(length < 11800){
			//圈数累加
			count++;
			//跑过一圈400米
			length += 400;
		}
		System.out.println("一共跑了"+count+"圈");
	}

}
