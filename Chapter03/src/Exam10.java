
public class Exam10 {

	/**
	 * ����һ���ɼ����жϳɼ���״̬
	 * 90����������  80���������� 60������һ��  60�����·ǳ���
	 * @param args
	 */
	public static void main(String[] args) {
		
		int score = 85;
		
//		if(score >= 90){
//			System.out.println("�ɼ�����");
//		}
//		else{
//			if(score >= 80){
//				System.out.println("�ɼ�����");
//			}
//			else{
//				if(score >= 60){
//					System.out.println("�ɼ�һ��");
//				}
//				else{
//					System.out.println("�ɼ��ǳ���");
//				}
//			}
//		}
		
		//ʹ�ö��������ṹ����������
		if(score >= 90){
			System.out.println("�ɼ�����");
		}
		else if(score >= 80){
			System.out.println("�ɼ�����");
		}
		else if(score >= 60){
			System.out.println("�ɼ�һ��");
		}
		else{
			System.out.println("�ɼ��ǳ���");
		}
	}

}
