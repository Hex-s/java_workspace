
public class Exam4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//自身的经验值
		double nowExp = 0;
		//每一个怪物的经验值
		int monsterExp = 15;
		//升级所需的经验
		double lvupExp = 100;
		//杀掉的怪物数量
		int count = 0;
		//满级的等级
		int maxLevel = 20;
		//当前的等级
		int nowLevel = 1;
		//每个等级经验的涨幅
		double rate = 1.2;
		
		//如果还没满级
		while(nowLevel < maxLevel){
			//如果经验条没有达到升级所需的经验，则继续杀怪
			while(nowExp < lvupExp){
				//累计杀掉怪物的数量
				count++;
				System.out.println("消灭了第"+count+"个怪物");
				//增长经验值
				nowExp+=monsterExp;
			}
			nowLevel++;
			System.out.println("Level Up!当前等级升至"+nowLevel+"!");
			//清空经验条
			nowExp -= lvupExp;
			//下一级所需经验递增
			lvupExp = (long)(lvupExp * rate);
		}
		
	}

}
