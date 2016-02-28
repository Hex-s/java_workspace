import java.util.Scanner;

/**
 * 工厂类
 * @author Administrator
 *
 */
public class Factory {
	
	/**
	 * 生产商品的方法，每一次调用该方法都表示生产一个商品对象
	 * @return
	 */
	public Ware buildWare(){
		System.out.println("工厂正在生产.......");
		//通过生产获得了产品
		Ware ware = new Ware();
		ware.wareName = "手机";
		System.out.println("通过生产获得了"+ware.wareName);
		//返回生产的商品
		return ware;
	}
}
