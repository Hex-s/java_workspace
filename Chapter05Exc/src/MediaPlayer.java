/**
 * 播放器类
 * @author Administrator
 *
 */
public class MediaPlayer {
	//播放器的开关状态 默认是关
	boolean isOpen = false;
	//暂停的状态
	boolean push = false;
	//电池
	Battery battery;
	
	/**
	 * 播放器播放光盘的方法
	 * @param disk 音乐光盘
	 */
	public boolean play(Disk disk){
		//判断开关开启，电量是否足够
		if(validate()){
			System.out.println("正在播放<<"+disk.musicName+">>专辑...........");
			//电量减少
			battery.capacity--;
		}
		//判断电量是否足够
		else if(battery.capacity == 0){
			return false;
		}
		return true;
		
	}
	/**
	 * 暂停播放
	 */
	public void stop(Disk disk){
		System.out.println("暂停播放<<"+disk.musicName+">>专辑...........");
		//暂停标识
		push = true;
	}
	/**
	 * 下一首
	 */
	public void next(Disk disk){
		if(validate()){
			System.out.println("播放下一首歌曲："+disk.secondMusic);
			//减少电量
			battery.capacity--;
		}
		
	}
	/**
	 * 前一首
	 */
	public void back(Disk disk){
		if(validate()){
			System.out.println("播放前一首歌曲："+disk.firstMusic);
			//减少电量
			battery.capacity--;
		}
	}
	/**
	 * 循环播放
	 */
	public void loopPlay(Disk disk){
		if(validate()){
			while(battery.capacity != 0){
				System.out.println("当前播放歌曲："+disk.firstMusic);
				battery.capacity--;
				if(battery.capacity == 0){
					break;
				}
				System.out.println("当前播放歌曲："+disk.secondMusic);
				battery.capacity--;
			}
			System.out.println("电量不够");
		}
		
	}
	/**
	 * 开关
	 */
	public void OpenClose(){
		if(!isOpen){
			//如果没有装电池
			if(battery == null){
				System.out.println("没有安装电池");
			}
			else if(battery.capacity == 0){
				System.out.println("电池没有电量");
			}
			else{
				System.out.println("打开了播放器的开关");
				isOpen = true;
			}
			
		}
		else{
			System.out.println("关闭了播放器的开关");
			isOpen = false;
			//关闭播放器对应程序的关闭
			System.exit(0);
		}
	}
	/**
	 * 装载电池的方法
	 * @param battery
	 */
	public void setBattery(Battery battery){
		this.battery = battery;
	}
	/**
	 * 检查开关和电量的方法
	 * @return
	 */
	public boolean validate(){
		boolean flag = false;
		if(!isOpen){
			System.out.println("没有打开播放器");
		}
		else if(battery.capacity == 0){
			System.out.println("电量不够！");
		}
		else{
			flag = true;
		}
		return flag;
	}
	
}
