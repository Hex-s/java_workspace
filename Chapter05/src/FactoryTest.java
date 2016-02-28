
public class FactoryTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//实例化工厂类
		Factory factory = new Factory();
		//生产商品
		Ware ware = factory.buildWare();
		//Ware ware = new Ware();
		//System.out.println(ware.wareName);
		//实例化代理商
		Proxyer proxyer = new Proxyer();
		//代理商代理了该商品
		proxyer.getProxyWare(ware);
		System.out.println(proxyer.ware);
		//实例化一个买家
		Human man = new Human();
		//买家购买了代理商的商品
		Ware buyWare = man.shopping(proxyer);
		System.out.println("购买的商品是："+ware.wareName);
		
	}

}
