/**
 * 
 * @author Administrator
 *
 */
public class RunGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//����һ�����
		Player player = new Player();
		//�������
		player.name = "tom";
		//����һ������
		Computer computer = new Computer();
		//������Ϸ
		player.doGame(computer);
		
		

	}

}
