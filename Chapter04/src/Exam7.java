import java.util.Scanner;


public class Exam7 {

	/**
	 * ģ������������СQ�ĶԻ���
		����˵����á���ʱ��СQ�ش����ѽ��
		����˵�����������治����ʱ��СQ�ش���ѽ���ҳԹ����ˡ�
		����˵������ʱ��СQ�ش�������������˵ʲô,��˵һ���ء�
		����˵���ټ������ߡ�88�����ߡ�byebye��ʱ��СQ�ش��������������ټ�����
	 * @param args
	 */
	public static void main(String[] args) {
		//��˵�Ļ�
		String say;
		//СQ�Ļش�
		String answer;
		//�˳��ı�ʾ
		boolean isExit = false;
		Scanner sc = new Scanner(System.in);
		do{
			say = sc.next();
			//�ж�˵�Ļ�����СQ�ĶԻ�����
			if(say.equals("���")){
				answer = "���ѽ";
			}
			else if(say.equals("���������治��")){
				answer = "��ѽ���ҳԹ�����";
			}
			else if(say.equals("�ټ�") || say.equals("88") || say.equals("byebye")){
				answer = "�������������ټ���";
				//�޸ı�ʾ
				isExit = true;
			}
			else{
				answer = "������������˵ʲô,��˵һ����";
			}
			//��ʾСQ�Ļش�
			System.out.println("СQ˵��"+answer);
			
		}while(!isExit);
		
	}

}
