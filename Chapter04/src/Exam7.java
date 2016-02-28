import java.util.Scanner;


public class Exam7 {

	/**
	 * 模拟和聊天机器人小Q的对话，
		当你说”你好”的时候，小Q回答”你好呀”
		当你说”今天天气真不错”的时候，小Q回答”是呀，我吃过饭了”
		当你说其他话时，小Q回答”我听不见你在说什么,再说一次呢”
		当你说”再见”或者”88”或者”byebye”时，小Q回答”你终于走啦，再见！”
	 * @param args
	 */
	public static void main(String[] args) {
		//所说的话
		String say;
		//小Q的回答
		String answer;
		//退出的标示
		boolean isExit = false;
		Scanner sc = new Scanner(System.in);
		do{
			say = sc.next();
			//判断说的话决定小Q的对话内容
			if(say.equals("你好")){
				answer = "你好呀";
			}
			else if(say.equals("今天天气真不错")){
				answer = "是呀，我吃过饭了";
			}
			else if(say.equals("再见") || say.equals("88") || say.equals("byebye")){
				answer = "你终于走啦，再见！";
				//修改标示
				isExit = true;
			}
			else{
				answer = "我听不见你在说什么,再说一次呢";
			}
			//显示小Q的回答
			System.out.println("小Q说："+answer);
			
		}while(!isExit);
		
	}

}
