
public class Exam2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		int a = 1;
//		a = a + 2;
//		//��ͬ����������
//		a+=2;
		
		//����1-100�������ĺ�
		//int i = 1;
		//���������򣬱����ķ��ʷ�Χȡ���������������ڵĴ����ŵķ�Χ��
//		int sum = 0;
//		while(i <= 100){
//			//sum = sum + i;
//			sum += i;
//			i++;
//		}
//		System.out.println("1-100�������ĺͣ�"+sum);
		
		
		//Ҫ���50-200������ż���ĺ�
		int i = 50;
		int sum = 0;
		while(i <= 200){
			//�ж�ÿһ�����Ƿ���ż��
//			if(i % 2 == 0){
//				sum += i;
//			}
//			i++;
			sum += i;
			i += 2;
		}
		System.out.println(sum);
		
	}

}
