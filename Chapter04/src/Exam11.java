
public class Exam11 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		for(int i = 1; i <= 10; i++){
			//��� ѭ������5���˳�ѭ��
			if(i == 5){
				//break��ʾ�˳���ǰѭ����
				break;
			}
			//System.out.println(i);
		}
		
		//����1-100�ĺͣ����͵�ֵ���ڻ򳬹�2500��ʱ�򣬵�ǰ���ӵ����Ƕ���
		int sum = 0;
		for(int i = 1; i <= 100; i++){
			sum += i;
			//�Ժͽ����ж�
			if(sum >= 2500){
				System.out.println("���͵�ֵ���ڻ򳬹�2500��ʱ�򣬵�ǰ���ӵ�����"+i);
				//�˳�ѭ��
				break;
			}
		}
		
//		int i = 1;
//		while(true){
//			if(i == 10){
//				break;
//			}
//			i++;
//		}
	}

}
