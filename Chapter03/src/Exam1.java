
public class Exam1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 4;
		double num3 = 10.5;
		
		//�ӷ�����,�κ����㶼��Ҫͨ�������������Ľ��
		//num1 = num1 + num2;
		int result = num1 + num2;
		//�����������д��ڲ�ͬ����ʱ���������ȡ���ڷ�Χ�������������
		//result = (int)(num1 + num3);
		//result = num1 + (int)num3;
		
		//System.out.println(result);
		//�κ���������ͨ���Ӻ������ַ������ս�����Ͷ�ΪString
		//С������Java������ߵ��������ȼ�
		//System.out.println("num1+num2="+((num1+num2)+(num1+num2)));
		//System.out.println(num1+num2+"����������"+num1+num2);
		//System.out.println(num1+"+"+num2+"="+(num1+num2));
		
		//�˷�
		result = num1 * num2;
		System.out.println(result);
		
		//����
		result = num1 - num2;
		System.out.println(result);
		
		//���� �������������������򽫶�ʧ����С������
		//��ĸ����Ϊ0
		double res = (double)num1 / num2;
		System.out.println(res);
	}

}
