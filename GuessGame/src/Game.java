import java.util.Scanner;

/**
 * ��ȭ��Ϸ�࣬��װ����Ϸ���߼�����
 * @author Administrator
 *
 */
public class Game {
	//���
	Player player;
	//����
	Computer cpu;
	//��Ϸ���ܴ���
	int count;
	/**
	 * ��ʼ����Ϸ�ķ���
	 */
	public void init(){
		player = new Player();
		cpu = new Computer();
	}
	/**
	 * ������Ϸ�ķ���
	 */
	public void start(){
		System.out.println("------------------��ȭ��Ϸ------------------");
		System.out.println("��Ϸ��ʼ:");
		//������Ϸ�Ĺ��̷���
		gameLogic();
		System.out.println("-----------------��Ϸ����-----------------");
		//������Ϸ�Ľ��
		showResult();
	}
	/**
	 * ��Ϸ�߼����̵ķ���
	 */
	public void gameLogic(){
		//�ۼ���Ϸ���ܴ���
		count++;
		//��ҳ�ȭ
		System.out.println("����ҳ�ȭ");
		int playerGuess = player.gestrue();
		//������ҳ�ȭ�Ľ��
		System.out.println("��ҳ���ȭ��"+change(playerGuess));
		System.out.println("���Կ�ʼ��ȭ");
		//���Գ�ȭ
		int cpuGuess = cpu.gestrue();
		//���ֵ��Գ�ȭ�Ľ��
		System.out.println("���Գ���ȭ��"+change(cpuGuess));
		//�Ƚϳ�ȭ�Ľ��
		//��һ�ʤ�����
		if(playerGuess == 1 && cpuGuess == 2 || playerGuess == 2 && cpuGuess == 3 || playerGuess == 3 && cpuGuess == 1){
			//��һ�ʤ����¼����
			player.winCount++;
			System.out.println("��һ�ʤ��");
		}
		//ƽ�ֵ����
		else if(playerGuess == cpuGuess){
			System.out.println("ƽ�֣�");
		}
		//���������
		else{
			//�ۼӵ��Ի�ʤ�Ĵ���
			cpu.winCount++;
			System.out.println("���Ի�ʤ��");
		}
		System.out.println("�Ƿ�Ҫ�ٽ���һ�ֲ�ȭ��(y/n)");
		Scanner sc = new Scanner(System.in);
		String answer = sc.next();
		//�ж�ѡ��
		if(answer.equals("y")){
			//�ݹ鵱ǰ��Ϸ����
			gameLogic();
		}
	}
	/**
	 * ������Ϸ����ķ���
	 */
	public void showResult(){
		System.out.println("��Ϸ������"+count+"��");
		System.out.println("ʤ��������"+player.winCount+"��");
		System.out.println("ƽ�ִ�����"+(count-player.winCount-cpu.winCount)+"��");
		System.out.println("ʧ�ܴ�����"+cpu.winCount+"��");
		//������Һ͵��Ե���ʤ���������бȽϸ�����Ϸ����
		if(player.winCount > cpu.winCount){
			System.out.println("��ϲ�㻪���ػ����˵��ԣ���Ϊ�����յĻ�ʤ�ߣ�");
		}
		else if(player.winCount == cpu.winCount){
			System.out.println("ƽ����ɫ�������Ժ�");
		}
		else{
			System.out.println("���ź����������Զ��򲻹�");
		}
	}
	/**
	 * ����Һ͵��Գ�ȭ�Ľ��ת�����ַ����ķ���
	 * @param guess
	 * @return
	 */
	public String change(int guess){
		String str = "";
		switch(guess){
		case 1:
			str = "ʯͷ";
			break;
		case 2:
			str = "����";
			break;
		case 3:
			str = "��";
			break;
		}
		return str;
	}
}
