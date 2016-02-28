/**
 * ��������
 * @author Administrator
 *
 */
public class MediaPlayer {
	//�������Ŀ���״̬ Ĭ���ǹ�
	boolean isOpen = false;
	//��ͣ��״̬
	boolean push = false;
	//���
	Battery battery;
	
	/**
	 * ���������Ź��̵ķ���
	 * @param disk ���ֹ���
	 */
	public boolean play(Disk disk){
		//�жϿ��ؿ����������Ƿ��㹻
		if(validate()){
			System.out.println("���ڲ���<<"+disk.musicName+">>ר��...........");
			//��������
			battery.capacity--;
		}
		//�жϵ����Ƿ��㹻
		else if(battery.capacity == 0){
			return false;
		}
		return true;
		
	}
	/**
	 * ��ͣ����
	 */
	public void stop(Disk disk){
		System.out.println("��ͣ����<<"+disk.musicName+">>ר��...........");
		//��ͣ��ʶ
		push = true;
	}
	/**
	 * ��һ��
	 */
	public void next(Disk disk){
		if(validate()){
			System.out.println("������һ�׸�����"+disk.secondMusic);
			//���ٵ���
			battery.capacity--;
		}
		
	}
	/**
	 * ǰһ��
	 */
	public void back(Disk disk){
		if(validate()){
			System.out.println("����ǰһ�׸�����"+disk.firstMusic);
			//���ٵ���
			battery.capacity--;
		}
	}
	/**
	 * ѭ������
	 */
	public void loopPlay(Disk disk){
		if(validate()){
			while(battery.capacity != 0){
				System.out.println("��ǰ���Ÿ�����"+disk.firstMusic);
				battery.capacity--;
				if(battery.capacity == 0){
					break;
				}
				System.out.println("��ǰ���Ÿ�����"+disk.secondMusic);
				battery.capacity--;
			}
			System.out.println("��������");
		}
		
	}
	/**
	 * ����
	 */
	public void OpenClose(){
		if(!isOpen){
			//���û��װ���
			if(battery == null){
				System.out.println("û�а�װ���");
			}
			else if(battery.capacity == 0){
				System.out.println("���û�е���");
			}
			else{
				System.out.println("���˲������Ŀ���");
				isOpen = true;
			}
			
		}
		else{
			System.out.println("�ر��˲������Ŀ���");
			isOpen = false;
			//�رղ�������Ӧ����Ĺر�
			System.exit(0);
		}
	}
	/**
	 * װ�ص�صķ���
	 * @param battery
	 */
	public void setBattery(Battery battery){
		this.battery = battery;
	}
	/**
	 * ��鿪�غ͵����ķ���
	 * @return
	 */
	public boolean validate(){
		boolean flag = false;
		if(!isOpen){
			System.out.println("û�д򿪲�����");
		}
		else if(battery.capacity == 0){
			System.out.println("����������");
		}
		else{
			flag = true;
		}
		return flag;
	}
	
}
