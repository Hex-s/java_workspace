
public class Code {

	public String testCode(){
		String code = "";

		for(int i = 1; i <= 4; i++){
			//0-9
			int n = (int)(Math.random()*10);
			code += n;
		}
		return code;
	}
	
}
