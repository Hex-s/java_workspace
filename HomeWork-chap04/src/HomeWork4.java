/**
 * 4. �¶ȼ�ͬʱ�������϶Ⱥͻ��϶ȣ�
 * 	���϶ȴ�0�ȿ�ʼ����߿ɲ⵽180�ȣ�
 *  ���϶ȵļ���ÿ20��Ϊһ����ʾ��λ��
 *  ��ӡ��ʾ�������¶ȼ�ÿ������϶ȼ���Ӧ�Ļ��϶ȣ����϶�=���϶�*1.8+32��
 * @author Administrator
 *
 */
public class HomeWork4 {

	public static void main(String[] args) {
		//�����¶�
		int centigage = 0;
		//���϶�
		double fahrenheit;
		//����
		int count = 0;
		//���ÿ��Ĳ���
		while(centigage < 180){
			//ÿ������϶�
			centigage =count *  20;
			//ÿ��Ļ��϶�
			fahrenheit = centigage * 1.8 + 32;
			//��������
			count++;
			//������
			System.out.println("��"+count+"������Ӧ�����϶�Ϊ"+centigage+"�棬����Ӧ�Ļ��϶�Ϊ"+fahrenheit+"�H");
		}
	}

}
