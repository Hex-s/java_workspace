
public class Exam12 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {  
//		char ch = 'a';
//		switch(ch){
//		//char类型case时既可以是char值，也可以为ASCII值
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
//			System.out.println("非法字符");
//		}
		
		//switch结构的case中如果没有语句时允许省略break
		//1-5凌晨时间，6-10上午时间，11-13点中午时间，14-18点下午时间，19-24点晚上时间
		//输入时间点根据不同的时间段打招呼
		int hour = 16;
		switch(hour){
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			System.out.println("凌晨好");
			break;
		case 6:
		case 7:
		case 8:
		case 9:
		case 10:
			System.out.println("上午好");
			break;
		//...........
		}
		
	}

}
