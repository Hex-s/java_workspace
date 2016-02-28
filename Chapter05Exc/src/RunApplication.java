
public class RunApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//创建一个人
		Human man = new Human();
		//给他起名
		man.name = "jerry";
		//创建一个播放器
		MediaPlayer player = new MediaPlayer();
		//创建一个电池
		Battery battery = new Battery();
		//人给播放器装电池
		man.setBatteryForPlayer(player, battery);
		//创建一个光盘
		Disk disk = new Disk();
		disk.musicName = "怀旧金曲";
		disk.firstMusic = "绿光";
		disk.secondMusic = "天黑黑";
		
		//人使用播放器播放光盘
		man.doPlay(player, disk);
	}

}
