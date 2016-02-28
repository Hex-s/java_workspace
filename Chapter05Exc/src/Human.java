import java.util.Scanner;

/**
 * 人类
 * @author Administrator
 *
 */
public class Human {
	String name;
	Scanner sc = new Scanner(System.in);
	/**
	 * 人具备使用播放器的方法
	 * @param player
	 */
	public void doPlay(MediaPlayer player, Disk disk){
		System.out.println("是否要按下开关?(y/n)");
		String answer = sc.next();
		if(answer.equals("y")){
			//开启播放器的开关
			player.OpenClose();
			//判断刚才的执行是开还是关
			if(player.isOpen){
				//如果开启播放器开关，显示主界面
				showMediaPlayerInfo(player, disk);
			}
		}
	}
	
	public void showMediaPlayerInfo(MediaPlayer player, Disk disk){
		System.out.println("1. 播放歌曲");
		System.out.println("2. 暂停播放");
		System.out.println("3. 播放下一首");
		System.out.println("4. 播放上一首");
		System.out.println("5. 循环播放");
		System.out.println("6. 关闭播放器");
		System.out.println("其余选择回到播放器的主界面");
		int chooice = sc.nextInt();
		switch(chooice){
		case 1:
			//如果play方法返回值为false表示没有电量
			if(!player.play(disk)){
				System.out.println("是否需要充电?(y/n)");
				String answer = sc.next();
				if(answer.equals("y")){
					//对播放器中装的电池进行充电
					doCharging(player.battery);
				}
			}
			break;
		case 2:
			player.stop(disk);
			break;
		case 3:
			player.next(disk);
			break;
		case 4:
			player.back(disk);
			break;
		case 5:
			player.loopPlay(disk);
			break;
		case 6:
			player.OpenClose();
			break;
		}
		showMediaPlayerInfo(player, disk);
	}
	
	/**
	 * 人具备使用充电电池进行充电的方法
	 * @param battery
	 */
	public void doCharging(Battery battery){
		System.out.println(name+"准备对电池进行充电");
		battery.charging();
	}
	/**
	 * 为播放器安装电池的方法
	 * @param battery
	 */
	public void setBatteryForPlayer(MediaPlayer player, Battery battery){
		player.setBattery(battery);
	}
}
