
public class Exam10 {

	/**
	 * 40个小伙伴围成一圈，从第一个人开始报数，每次报到3的小伙伴需要表演一个节目，下一次报数的时候还是从1开始，
	 * 表演过节目的小伙伴将退出圆圈，问还剩下最后一个人的时候一共报了多少次数
	 * @param args
	 */
	public static void main(String[] args) {
		//总的人数
		int num = 40;
		//报数的次数
		int count = 0;
		//当前报的数
		int now = 1;
		//如果没有到最后一个人则继续循环报数
		while(num != 1){
			//记录报数的总次数
			count++;
			//判断当前的报数
			//如果当前的报数是3，该伙伴表演节目
			if(now == 3){
				System.out.println("小伙伴表演了节目");
				//表演完节目后该伙伴退出游戏，意味着总人数少了一个人
				num--;
				//下一次报数从头开始
				now = 1;
			}
			//如果当前报数不是3，继续报数
			else{
				now++;
			}
		}
		System.out.println("一共报数了"+count+"次");
	}

}
