import java.util.Scanner;


public class Exam9 {

	/**
	 * ¼��10��ͬѧ�ĳɼ������ڵ���80�ֵĳɼ���������ɼ�������¼��ѧ��������ɼ��ı�������ʾ��Ӧ�İ༶���
	 * ���������60%��ͬѧ�ﵽ������ɼ�����ð������������
	 * �����������ɼ������ﵽ30%,��ð��������һ��
	 * �����������ɼ���������20%����ð�����ϲ�
	 * @param args
	 */
	public static void main(String[] args) {
		//ѧ��������
		int stuNum;
		//�ɼ�
		int score;
		//����ɼ�������
		int count = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("����ѧ����������");
		stuNum = sc.nextInt();
		//ѭ��¼��ɼ�
		for(int i = 1; i <= stuNum; i++){
			System.out.println("�������"+i+"��ѧ���ĳɼ���");
			score = sc.nextInt();
			//�жϳɼ��Ƿ�������ɼ�
			if(score >= 80){
				//�ۼ�����
				count++;
			}
		}
		//�������������ı���
		double pre = (double)count / stuNum;
		System.out.println(pre);
		//�ж����������ı������ڵ����
		if(pre >= 0.6){
			System.out.println("�༶�������");
		}
		else if(pre >= 0.3){
			System.out.println("�༶���һ��");
		}
		else if(pre < 0.2){
			System.out.println("�༶����ϲ�");
		}
	}

}
