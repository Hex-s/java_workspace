/**
 * 代理商类
 * @author Administrator
 *
 */
public class Proxyer {

	//商品属性，表示代理商贩卖的内容
	//所有的java类的默认值都为null
	Ware ware;
	//代理商的品牌
	String band = "XX品牌";
	/**
	 * 代理商品的方法
	 */
	public void getProxyWare(Ware ware){
		System.out.println("代理了商品，商品名称是："+ware.wareName);
		//代理获取了商品
		this.ware = ware;
	}
	
	/**
	 * 销售商品的方法
	 */
	public void sellWare(){
		
	}
}
