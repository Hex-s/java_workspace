import java.util.Scanner;

/**
 * ���
 * @author Administrator
 *
 */
public class Player {
	//��¼���ʤ���Ĵ���
	int winCount;
	/**
	 * ��ҳ�ȭ�ķ���
	 * @return
	 */
	public int gestrue(){
		Scanner sc = new Scanner(System.in);
		System.out.println("����ҳ�ȭ��1.ʯͷ  2.����  3.��");
		int chooice = sc.nextInt();
		return chooice;
	}
}
