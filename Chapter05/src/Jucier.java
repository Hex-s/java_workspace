import java.io.ObjectInputStream.GetField;

/**
 * 榨汁机类
 * @author Administrator
 *
 */
public class Jucier {

	/**
	 * 榨汁的方法
	 * @return
	 */
	public String getJuice(String fruit){
		return fruit+"汁";
	}
	
	public static void main(String[] args) {
		//实例化榨汁机
		Jucier jucier = new Jucier();
		//进行榨汁
		//调用带参数的方法，外部传入的参数应和方法定义时参数的类型，数量，顺序应匹配
		String jucie = jucier.getJuice("苹果");
		System.out.println("获得了："+jucie);
		
	}
}
