
public class RunApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//����һ����
		Human man = new Human();
		//��������
		man.name = "jerry";
		//����һ��������
		MediaPlayer player = new MediaPlayer();
		//����һ�����
		Battery battery = new Battery();
		//�˸�������װ���
		man.setBatteryForPlayer(player, battery);
		//����һ������
		Disk disk = new Disk();
		disk.musicName = "���ɽ���";
		disk.firstMusic = "�̹�";
		disk.secondMusic = "��ں�";
		
		//��ʹ�ò��������Ź���
		man.doPlay(player, disk);
	}

}
