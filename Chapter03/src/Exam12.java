
public class Exam12 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {  
//		char ch = 'a';
//		switch(ch){
//		//char����caseʱ�ȿ�����charֵ��Ҳ����ΪASCIIֵ
//		case 97:
//			System.out.println("a");
//			break;
//		case 'b':
//			System.out.println("b");
//			break;
//		case 'c':
//			System.out.println("c");
//			break;
//		default:
//			System.out.println("�Ƿ��ַ�");
//		}
		
		//switch�ṹ��case�����û�����ʱ����ʡ��break
		//1-5�賿ʱ�䣬6-10����ʱ�䣬11-13������ʱ�䣬14-18������ʱ�䣬19-24������ʱ��
		//����ʱ�����ݲ�ͬ��ʱ��δ��к�
		int hour = 16;
		switch(hour){
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			System.out.println("�賿��");
			break;
		case 6:
		case 7:
		case 8:
		case 9:
		case 10:
			System.out.println("�����");
			break;
		//...........
		}
		
	}

}
