/**
 * �����
 * @author Administrator
 *
 */
import java.util.Scanner;

public class Player {
	// �������
	String name;
	// �Ƿ������Ϸ��y/n��ѡ��
	String answer;
	// ��ҳ�ȭ��ѡ��
	int playerChoice;
	// ���Գ�ȭ��ѡ��
	int computerChoice;
	// ������Ϸ�Ĵ���
	int count = 0;
	// ���ʤ���Ĵ���
	int playerWin = 0;
	// ����ʤ���Ĵ���
	int computerWin = 0;
	// ƽ�ֵĴ���
	int deuce = 0;
	// ���ֱ����ı������
	String winP = "Ӯ�ˣ�";
	String winC = "����Ӯ�ˣ�";
	String winD = "ƽ�֣�";

	Computer computer;

	// �Ӽ��̽�������
	Scanner sc = new Scanner(System.in);

	/**
	 * ������Ϸ��ѡ���Ƿ����������Ϸ
	 */
	public void doGame(Computer computer) {
		this.computer = computer;
		System.out.print("�Ƿ������Ϸ?��y/n��:");
		answer = sc.next();
		// ����������Ϸ
		if (answer.equals("y")) {
			// ��Ϸ����+1
			count++;
			// ������Ϸ
			continueGame(computer);
			// �ٴ�ѡ���Ƿ������Ϸ
			doGame(computer);
		}
		// ������Ϸ ͳ��ս�� ��ʾ���ջ�ʤ������һ��ǵ���
		else if (answer.equals("n")) {
			evalaute();
		} else {
			System.out.println("��Ч���룬������ѡ��");
			doGame(computer);
		}
	}

	/**
	 * ѡ�������Ϸ y ����ҳ�ȭ
	 * @param computer
	 */
	public void continueGame(Computer computer) {
		System.out.print("���ȭ��1ʯͷ 2�� 3��������");
		// ��ҵĳ�ȭ���
		playerChoice = sc.nextInt();
		// �����ȡ���Եĳ�ȭ���
		computerChoice = computer.computerRandom();
		// �Գ�ȭ������бȽ�
		compare(playerChoice, computerChoice);

	}

	/**
	 * �Ե��Ժ���ҵĳ�ȭ������бȽ�
	 * @param playerChoice ��ҵĳ�ȭ���
	 * @param computerChoice ���Եĳ�ȭ���
	 */
	public void compare(int playerChoice, int computerChoice) {
		// ����ҵĳ�ȭ���ת����ʯͷ����������
		String play = "";
		// �����Եĳ�ȭ���ת����ʯͷ����������
		String comp = "";
		// �������Գ�ȭ�����ͬ�����
		if (playerChoice == computerChoice) {
			if (playerChoice == 1) {
				play = "ʯͷ";
			} else if (playerChoice == 2) {
				play = "��";
			} else {
				play = "����";
			}
			resultOutput(name, play, play, winD);
			deuce++;
		}
		//�������Գ�ȭ�������ͬ����������������ж���Ӯ
		else {
			String result = "";
			switch (playerChoice) {
			// ��ҳ�����ʯͷ
			case 1:
				play = "ʯͷ";
				switch (computerChoice) {
				case 2:
					comp = "��";
					result = winC;
					computerWin++;
					break;
				case 3:
					comp = "����";
					result = name+winP;
					playerWin++;
					break;
				}
				resultOutput(name, play, comp, result);
				break;
			// ��ҳ����ǲ�
			case 2:
				play = "��";
				switch (computerChoice) {
				//���Գ�����ʯͷ�����Ӯ
				case 1:
					comp = "ʯͷ";
					result =name+ winP;
					playerWin++;
					break;
				//���Գ����Ǽ���������Ӯ
				case 3:
					comp = "����";
					result = winC;
					computerWin++;
					break;
				}
				resultOutput(name, play, comp, result);
				break;
			// ��ҳ����Ǽ���	
			case 3:
				play = "����";
				switch (computerChoice) {
				case 1:
					comp = "ʯͷ";
					result = winC;
					computerWin++;
					break;
				case 2:
					comp = "��";
					result =name+ winP;
					playerWin++;
					break;
				}
				resultOutput(name, play, comp, result);
				break;
			//�������Ƿ�����	
			default:
				//��Ϸ��������1��
				count--;
				System.out.println("��Ч�����룬�����³�ȭ��");
				doGame(computer);
				break;
			}
		}
	}

	/**
	 * ���ÿ�β�ȭ�Ľ��
	 * @param name �������
	 * @param play ��ҳ�ȭ���
	 * @param comp ���Գ�ȭ���
	 * @param result ���α����Ľ��
	 */
	public void resultOutput(String name, String play, String comp,
			String result) {
		System.out.println(name + "������" + play + ",���Գ�����" + comp + "\n"
				+ result);

	}
	
	/**
	 * ͳ��ս�� ͨ��ս����ʾ���ջ�ʤ������һ��ǵ���
	 */
	public void evalaute() {
		System.out.println(name + "�͵���һ��������" + count + "�α�����" + name + "Ӯ��"
				+ playerWin + "�Σ�����Ӯ��" + computerWin + "�Σ�ƽ��" + deuce + "��");
		//�жϵ�������ҵ�ʤ��
		if (playerWin > computerWin) {
			System.out.println("�ⳡ��ȭ���������ջ�ʤ����" + name + "��");
		} else if (playerWin == computerWin) {
			System.out.println("�ⳡ��ȭ������ƽ�֣�");
		} else {
			System.out.println("�ⳡ��ȭ���������ջ�ʤ���ǵ��ԣ�");
		}
	}

}
