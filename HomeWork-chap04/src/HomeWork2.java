/**
 * 2. ����һ�����֣�������������������磺����12345  ���54321��
 * @author Administrator
 *
 */
import java.util.Scanner;

public class HomeWork2 {

	public static void main(String[] args) {
		//���������
		int inputNum;
		//�������յ�����
		int receiveNum;
		Scanner sc = new Scanner(System.in);
		//�Ӽ�����������
		System.out.print("������һ������0����������");
		inputNum = sc.nextInt();
		System.out.print("�����������������");
		do{
			//���ո�λ��
			receiveNum = inputNum % 10;
			//�����λ��
			System.out.print(receiveNum);
			//��������10���ݼ�
			inputNum /= 10;
		}while(inputNum > 0);
	}

}
