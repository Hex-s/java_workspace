
public class Exam4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//����ľ���ֵ
		double nowExp = 0;
		//ÿһ������ľ���ֵ
		int monsterExp = 15;
		//��������ľ���
		double lvupExp = 100;
		//ɱ���Ĺ�������
		int count = 0;
		//�����ĵȼ�
		int maxLevel = 20;
		//��ǰ�ĵȼ�
		int nowLevel = 1;
		//ÿ���ȼ�������Ƿ�
		double rate = 1.2;
		
		//�����û����
		while(nowLevel < maxLevel){
			//���������û�дﵽ��������ľ��飬�����ɱ��
			while(nowExp < lvupExp){
				//�ۼ�ɱ�����������
				count++;
				System.out.println("�����˵�"+count+"������");
				//��������ֵ
				nowExp+=monsterExp;
			}
			nowLevel++;
			System.out.println("Level Up!��ǰ�ȼ�����"+nowLevel+"!");
			//��վ�����
			nowExp -= lvupExp;
			//��һ�����辭�����
			lvupExp = (long)(lvupExp * rate);
		}
		
	}

}
