import java.util.Random;

/**
 * ����
 * @author Administrator
 *
 */
public class Computer {
	//��¼����Ӯ�Ĵ���
	int winCount;
	
	/**
	 * ���Գ�ȭ�ķ���
	 * ���Գ�ȭͨ�����������
	 * @return
	 */
	public int gestrue(){
		Random random = new Random();
		int guess = random.nextInt(3)+1;
		return guess;
	}
}
