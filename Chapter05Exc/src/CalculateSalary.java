import java.util.Scanner;


/**
 * 税前工资（包含基本工资，考核工资，加班费等等，即这个月的所有收入）
 *每个月需要缴纳个人所得税，个人所得税的起征点是3500，
 *如果工资是在8000以内缴税10%，如果工资是在8000-15000缴税比例是15%，15000以上是20%
 *个人所得税扣完后还需要缴纳养老金和公基金，
 *公基金可交可不交，除公积金外的养老金（包含其他如失业保险金等）的最低位8%，最高是11%，
 *如果有交公基金，最高比例是11%，加起来的总比重最高为22%
 * @author Administrator
 *
 */
public class CalculateSalary {

	/**
	 * 计算税后工资的方法
	 * @param beforeSalary 税前工资
	 * @param flag 是否交公基金的标识
	 * @param rate1 公基金的缴纳比例
	 * @param rate2养老金的缴纳比例
	 * @return
	 */
	public double getSalary(double beforeSalary, boolean flag, double rate1, double rate2){
		//税后工资
		double afterSalary = 0;
		//计算扣完个人所得税后的工资
		//低于3500
		if(beforeSalary < 3500){
			//不需要缴纳个税
			afterSalary = beforeSalary;
		}
		//低于8000
		else if(beforeSalary < 8000){
			afterSalary = 3500+(beforeSalary-3500)*(1-0.1);
		}
		//低于15000
		else if(beforeSalary < 15000){
			afterSalary = 3500+(8000-3500)*(1-0.1)+(beforeSalary-8000)*(1-0.15);
		}
		//15000以上的
		else{
			afterSalary = 3500+(8000-3500)*(1-0.1)+(15000-8000)*(1-0.15)+(beforeSalary-15000)*(1-0.2);
		}
		//个税后的工资继续用于缴纳公基金和养老金
		//扣除的公基金
		double money = 0;
		//判断公基金是否需要缴纳
		if(flag){
			//需要缴纳公基金,计算公基金的金额
			money = afterSalary*rate1;
		}
		//无论公基金是否需要缴纳，养老金都比继续缴纳
		afterSalary = afterSalary-afterSalary*rate2-money;
		return afterSalary;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		CalculateSalary ex = new CalculateSalary();
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入你的税前工资：");
		double beforeSalary = sc.nextDouble();
		System.out.println("是否需要缴纳公基金：");
		boolean flag = sc.nextBoolean();
		double rate1 = 0;
		if(flag){
			System.out.println("缴纳的公基金比例：");
			rate1 = sc.nextDouble();
			if(rate1 < 0 || rate1 > 0.11){
				System.out.println("非法的公基金比例");
				return;
			}
		}
		System.out.println("缴纳的养老金的比例：");
		double rate2 = sc.nextDouble();
		if(rate2 < 0 || rate2 > 0.11 ){
			System.out.println("非法的养老金比例");
			return;
		}
		
		double afterSalary = ex.getSalary(beforeSalary, flag, rate1, rate2);
		System.out.println("税后工资是："+afterSalary);

	}

}
