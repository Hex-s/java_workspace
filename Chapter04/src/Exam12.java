
public class Exam12 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		for(int i = 1; i <= 10; i++){
			if(i == 5){
				continue;
			}
			System.out.println(i);
		}
		
		//����1-100����ż���ĺ�
		int sum = 0;
		for(int i = 1; i <= 100; i++){
			//�ж��Ƿ������������������������
			if(i % 2 != 0){
				continue;
			}
			sum += i;
		}
		System.out.println(sum);
	}

}
