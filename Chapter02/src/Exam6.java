
public class Exam6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**************��ʽת���ֳ�Ϊ�Զ�����ת��****************/
		//�����ǽ���ΧС�����ݸ�ֵ����Χ�����Ŀ����������ʱ����JVM�Զ�����ת��
//		long num1;
//		int num2 = 10;
//		num1 = num2;
//		double num3;
//		float num4=10.0f;
//		num4 = num1; 
//		num3 = num4;
		
		/***********ǿ������ת���ǽ���Χ������ݸ�ֵ����ΧС��Ŀ�����ݲ�ȡ��ת���ֶ�*********/
		
//		long num2 = 10000000000000000l;
//		int num3;
//		//ʹ��ǿ������ת����longת����int��
//		num3 = (int)num2;
//		System.out.println(num3);
		
		
//		float n1 = (float)15.56;
//		//��������ת���������������С�����ȵĶ�ʧ
//		int n2 = (int)n1;
//		System.out.println(n2);
//		int n3 = 10;
//		n1 = n3;
//		System.out.println(n1);
		
		
		
		/***********toString����������Java����ת����String����***********/
		int n1 = 100;
		double n2 = 100.999;
		boolean flag = true;
		String str;
		//������������ͨ���Ӻ�����""������ȡһ���µ�String��ֵ
		str = n1+"";
		str = n2+"";
		str = flag+"";
		//��int��ת���ɰ�װ��,�ù��̳�Ϊװ��
		Integer num1 = new Integer(n1);
		//����װ���ж�Ӧ������ת���ɻ���������ʱ��������̳�Ϊ����
		int n3 = num1.intValue();
		//��double����װ�����
		Double num2 = new Double(n2);
		n2 = num2.doubleValue();
		//char����װ��Ͳ���
		Character ch = new Character('a');
		char word = ch.charValue();
		//System.out.println(word);
		
		//��int��ʹ��toStringת����String����
		//����Ҫ�Ƚ�int����װ�䣬Ȼ����ͨ����װ���toStringʵ��ת��
		str = num1.toString();
		System.out.println(str);
		
		
		/***************parse������Stringת����������������*******************/
//		String str = "100.1";
//		//ת����int��
//		//int num1 = Integer.parseInt(str);
//		//ת����float��
//		float num2 = Float.parseFloat(str);
//		//�ַ����ɲ���ͨ��parse����ת����char����
		
	}

}
