/**
 * 3.������Ϸ��ϵͳ����һ��1-100���������
 * ����´����Ը��ݴ�С��ʾ�´��˻��ǲ�С�ˣ�
 * ����´�10������Ϸ����������Ҫ��Գɼ���������(���ݴ�������)
 * @author Administrator
 *
 */
import java.util.Scanner;

public class HomeWork3 {

	public static void main(String[] args) {
		//�µĴ���
		int guessCount = 0;
		//ϵͳ����һ��1-100�������
		int luckyNum = (int)(Math.random() * 100 + 1);
		//�µ�����
		int guessNum;
		Scanner sc = new Scanner(System.in);
		do{
			//�����Ĵ����ۼ�
			guessCount++;
			//����Ҫ�µ�����
			System.out.print("���������µ����֣�1-100����"+luckyNum);
			guessNum = sc.nextInt();
			//���бȽ�
			if(guessNum < luckyNum){
				System.out.println("��С�ˣ�������"+(10-guessCount)+"�λ��ᣡ");
			}
			else if(guessNum > luckyNum){
				System.out.println("�´��ˣ�������"+(10-guessCount)+"�λ��ᣡ");
			}
			else{
				System.out.println("�¶��ˣ�");
				break;
			}		
		}while(guessCount < 10);
		//�Գɼ���������(���ݴ�������)
		if(guessCount <= 3){
			System.out.println("��������ȥ���Ʊ�ɣ�");
		}
		else if(guessCount <= 6){
			System.out.println("�ٽ�������");
		}
		else{
			System.out.println("�������ã������»�����Ʒ�ɣ�");
		}
	}

}
