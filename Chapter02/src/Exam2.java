
/**
 * �����������͵�ʹ��
 * @author Administrator
 *
 */
public class Exam2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//int����
		int width = 1234567891;
		//int�ĳ��ȷ�Χ��ͨ����װ���ȡ
		int maxValue = Integer.MAX_VALUE;
		int minValue = Integer.MIN_VALUE;
		//��ʱ�ļӺű�ʾΪ���ӷ�����������ֵ�ͱ�������ƴ��
		System.out.println("int�����ֵ��"+maxValue+",��Сֵ��"+minValue);
		
		//short����
		//Ĭ�������ֱ��д��������������ʶ��Ϊint��
		short age = 22; 
		short shortMax = Short.MAX_VALUE;
		short shortMin = Short.MIN_VALUE;
		System.out.println("short�����ֵ��"+shortMax+",��Сֵ��"+shortMin);
		
		//long����  ��Ҫ��ֵ�ĺ������l��ʾ��ֵΪlong��
		long length = 1234l;
		long longMax = Long.MAX_VALUE;
		long longMin = Long.MIN_VALUE;
		System.out.println("long�����ֵ��"+longMax+",��Сֵ��"+longMin);
		
		//float �����ȸ���С��,Ĭ������´���С������ֵ����ʶ��Ϊdouble��
		//ʹ��f��ʾfloat���͵�ֵ
		float price = 10.5f;
		float floatMax = Float.MAX_VALUE;
		float floatMin = Float.MIN_VALUE;
		System.out.println("float�����ֵ��"+floatMax+",��Сֵ��"+floatMin);
		
		//double ˫���ȸ���С��
		double toSunLength = 11111111.1212312323;
		double doubleMax = Double.MAX_VALUE;
		double doubleMin = Double.MIN_VALUE;
		System.out.println("double�����ֵ��"+doubleMax+",��Сֵ��"+doubleMin);
	}

}
