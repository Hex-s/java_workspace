import java.util.Scanner;


public class Exam6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//���̽��ճɼ����жϳɼ��Ƿ�������
		Scanner sc = new Scanner(System.in);
		System.out.println("������ɼ���");
		int score = sc.nextInt();
		//�ж��Ƿ�����
		
		//if����������ʹ��
		if(score == 100){
			//��������ִ�еĴ���
			System.out.println("�ɼ�������");
		}
		//else��ʾ����û����������
		//elseֻ�ܽ��if���ʹ��
//		else{
//			System.out.println("û������");
//		}
		if(score >= 90){
			System.out.println("�ɼ����ڵ���90��");
		}
		else{
			System.out.println("û����������");
		}
		System.out.println("����ִ�н���");
	}

}
