
public class Exam3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//�ٳ�һȦ��400�ף������Ҫ��11800�ף���������ܶ���Ȧ
		//��ǰ�ܲ��ľ���
		int length = 0;
		//�ܲ���Ȧ��
		int count = 0;
		//���û������11800�ף���Ӧ�ü����ܲ�
		while(length < 11800){
			//Ȧ���ۼ�
			count++;
			//�ܹ�һȦ400��
			length += 400;
		}
		System.out.println("һ������"+count+"Ȧ");
	}

}
