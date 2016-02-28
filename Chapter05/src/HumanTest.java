
/**
 * 该类用来编写入口方法，测试Human类的结果
 * @author Administrator
 *
 */
public class HumanTest {

	public static void main(String[] args) {
		
		//类是抽象的，使用类必须要将类变成对象才能应用，因此需要将类进行实例化
		Human man1 = new Human();
		//通过对象名.属性名访问对象的属性
		//System.out.println(man1.name+","+man1.sex+","+man1.age);
		man1.name = "奥巴马";
		man1.sex = '男';
		man1.age = 53;
		//实例化
		Human man2 = new Human();
		man2.name = "孙燕姿";
		man2.sex = '女';
		man2.age = 32;
		//实例化
		Human man3 = new Human();
		//实例化
		Human man4 = new Human();
		
//		System.out.println(man1.name+","+man1.sex+","+man1.age);
//		System.out.println(man2.name+","+man2.sex+","+man2.age);
//		System.out.println(man3.name+","+man3.sex+","+man3.age);
//		System.out.println(man4.name+","+man4.sex+","+man4.age);
		
		//通过对象名.方法名访问方法
//		man1.details();
//		man2.details();
//		man1.interView();
		
		//执行带有回值的方法
		String ware = man1.shopping();
		System.out.println(man1.name+"通过购物方法购买了"+ware);
	}
}
