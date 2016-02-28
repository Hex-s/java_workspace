import java.util.Scanner;


public class TaxTest {

	public static void main(String[] args){
		//税前工资
		double salary;
		//最终工资
		double money;
		//养老保险金的缴纳比例
		double old;
		//是否缴纳公积金 true表示缴纳 false表示不缴纳
		boolean fundChoose = false;;
		int fundInt;
		//公积金缴纳比例
		double fund = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("请输入起征工资：");
		double startSalary = sc.nextDouble();
		System.out.print("请输入第二个起征工资：");
		double startSalary2 = sc.nextDouble();
		System.out.print("请输入第三个起征工资：");
		double startSalary3 = sc.nextDouble();
		System.out.print("请输入你的税前工资：");
		salary = sc.nextDouble();
		System.out.print("请输入你要缴纳的养老金比例（0.08-0.11）：");
		old = sc.nextDouble();
		System.out.print("请选择您是否要缴纳公积金（1表示缴纳 0表示不缴纳）：");
		fundInt = sc.nextInt();
		if(fundInt == 1){
			fundChoose = true;
			System.out.print("请输入您要缴纳的公积金比例（0-0.11）：");
			fund = sc.nextDouble();
		}
		
		Tax tax = new Tax();
		money = tax.getSalary(salary,old,fundInt,fund,startSalary);
		System.out.println("您的最终工资为："+money);
	}
}
