import java.util.Scanner;

/**
 * ����
 * @author Administrator
 *
 */
public class Human {
	String name;
	Scanner sc = new Scanner(System.in);
	/**
	 * �˾߱�ʹ�ò������ķ���
	 * @param player
	 */
	public void doPlay(MediaPlayer player, Disk disk){
		System.out.println("�Ƿ�Ҫ���¿���?(y/n)");
		String answer = sc.next();
		if(answer.equals("y")){
			//�����������Ŀ���
			player.OpenClose();
			//�жϸղŵ�ִ���ǿ����ǹ�
			if(player.isOpen){
				//����������������أ���ʾ������
				showMediaPlayerInfo(player, disk);
			}
		}
	}
	
	public void showMediaPlayerInfo(MediaPlayer player, Disk disk){
		System.out.println("1. ���Ÿ���");
		System.out.println("2. ��ͣ����");
		System.out.println("3. ������һ��");
		System.out.println("4. ������һ��");
		System.out.println("5. ѭ������");
		System.out.println("6. �رղ�����");
		System.out.println("����ѡ��ص���������������");
		int chooice = sc.nextInt();
		switch(chooice){
		case 1:
			//���play��������ֵΪfalse��ʾû�е���
			if(!player.play(disk)){
				System.out.println("�Ƿ���Ҫ���?(y/n)");
				String answer = sc.next();
				if(answer.equals("y")){
					//�Բ�������װ�ĵ�ؽ��г��
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
	 * �˾߱�ʹ�ó���ؽ��г��ķ���
	 * @param battery
	 */
	public void doCharging(Battery battery){
		System.out.println(name+"׼���Ե�ؽ��г��");
		battery.charging();
	}
	/**
	 * Ϊ��������װ��صķ���
	 * @param battery
	 */
	public void setBatteryForPlayer(MediaPlayer player, Battery battery){
		player.setBattery(battery);
	}
}
