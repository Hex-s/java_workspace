/**
 * ������
 * @author Administrator
 *
 */
public class Computer {
	
	//��������� 1��ʾȭͷ 2��ʾ�� 3��ʾ����  1<2 2<3 3<2
	public int computerRandom(){
		//����һ���������1-3
		int choice = (int)(Math.random()*3)+1;
		//���ؽ��
		return choice;
	}
}
