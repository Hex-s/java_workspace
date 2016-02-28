package com.niit.sys;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import com.niit.bean.Brand;
import com.niit.bean.Car;
import com.niit.bean.CarType;
import com.niit.bean.User;
import com.niit.data.Data;
import com.niit.util.CommonUtil;

/**
 * 二手车管理系统
 * @author Administrator
 *
 */
public class UsedCarSystem {
	//数据类
	Data data;
	//登陆用户
	User loginUser;
	Scanner sc;
	//菜单跳转的选项
	int choice = 0;
	//加入对比的汽车
	Car[] compareCars;
	//存储值不为空的汽车
	Car[] car;
	//记录数组中值不为空的数量
	int count = 0;
	
	/**
	 * 初始化系统 传入数据库
	 * @param data
	 */
	private void init(Data data){
		this.data = data;
		sc = new Scanner(System.in);
		compareCars = new Car[4];
		car = new Car[100];
	}
	
	
	/**
	 * 开启系统
	 */
	public void start(Data data){
		init(data);
		System.out.println("----------------------NIIT二手车交易平台-----------------------");
		//显示主菜单
		mainMenu();
	}
	
	
	/**
	 * 主菜单
	 */
	private void mainMenu(){
		//如果用户登陆成功则不需要显示登陆和注册选项
		if(loginUser == null){
			System.out.println("1. 登陆");
			System.out.println("2. 注册");
		}
		System.out.println("3. 最新二手车信息");
		System.out.println("4. 搜索车辆");
		System.out.println("5. 对比车辆");
		System.out.println("6. 我的收藏");
		System.out.println("7. 购物历史");
		System.out.println("8. 后台管理");
		System.out.println("9. 退出系统");
		System.out.println("请选择：");
		choice = sc.nextInt();
		switch(choice){
		//登录
		case 1:
			login();
			break;
		//注册
		case 2:
			register();
			break;
		//最新二手车信息
		case 3:
			newestCarInfo();
			break;
		//搜索车辆	
		case 4:
			searchCar();
			break;
		//对比车辆
		case 5:
			showCompare(compareCars);
			break;
		//我的收藏
		case 6:
			showCollection();
			break;
		//购物历史
		case 7:
			showBuy();
			break;
		//后台管理	
		case 8:
			adminManage();
			break;
		//退出系统
		case 9:
			System.out.println("----------------------退出系统！欢迎再次光临！-----------------------");
			System.exit(0);
		default:
			System.out.println("非法输入！请重新选择！\n");
			mainMenu();
		}
	}
	
	
	/**
	 * 后台管理
	 */
	private void adminManage() {
		if(loginUser == null){
			System.out.println("您尚未登陆！");
			mainMenu();
		}
		if(loginUser.isAdmin == false){
			System.out.println("非管理员无权进行后台管理！");
			mainMenu();
		}
		System.out.println("---------------------后台管理--------------------------");
		System.out.println("1.品牌管理");
		System.out.println("2.车型管理");
		System.out.println("3.发布车辆信息");
		System.out.println("4.主菜单");
		System.out.println("请选择：");
		choice = sc.nextInt();
		switch(choice){
		//1.品牌管理
		case 1:
			brandManage();
			break;
		//2.车型管理	
		case 2:
			carTypeManage();
			break;
		//3.发布车辆信息
		case 3:
			addCar();
			break;
		//4.主菜单	
		case 4:
			mainMenu();
			break;
		//非法输入	
		default:
			System.out.println("非法输入！");
			mainMenu();
		}	
	}

	/**
	 * 发布车辆信息
	 */
	private void addCar() {
		Car car = new Car();
		car.init();
		int count = 0;
		int[] array = new int[100];
		int[] array1 = new int[100];
		//根据现有的品牌进行选择
		System.out.println("请在如下品牌中选择：");
		System.out.println("序列\t品牌名称");
		//列出所有的品牌
		for(int i = 0; i < data.brandData.length; i++){
			if(data.brandData[i] != null){
				System.out.print((count+1)+"\t");
				array[count] = i;
				System.out.println(data.brandData[i].brandName);
				count++;
			}
		}
		System.out.println("请选择要插入汽车的品牌序号：");
		choice = sc.nextInt();
		car.brandId = data.brandData[array[choice-1]].brandId;
		//在品牌下的车型中继续进行选择
		System.out.println("请在如下该品牌下的车型中选择：");
		System.out.println("序列\t车型名称");
		count = 0 ;
		//列出品牌下所有的车型
		for(int i = 0; i < data.carTypeData.length; i++){
			if(data.carTypeData[i] != null && data.carTypeData[i].brandId == data.brandData[array[choice-1]].brandId){
				System.out.print((count+1)+".\t");
				System.out.println(data.carTypeData[i].typeName);
				array1[count] = i;
				count++;				
			}
		}
		System.out.println("请选择要插入汽车的车型序号：");
		choice = sc.nextInt();
		car.typeId = data.carTypeData[array1[choice-1]].typeId;
		//插入其他信息
		car.carId = CommonUtil.getCarId();
		car.isSold = false;
		System.out.println("请输入价格：");
		car.price = sc.nextInt();
		System.out.println("请输入里程(km)：");
		car.mileage = sc.nextDouble();
		System.out.println("请输入排量：");
		car.outputVolume = sc.nextDouble();
		System.out.println("请输入离合器类型（1 手动档   2 自动挡）：");
		choice = sc.nextInt();
		if(choice == 1){
			car.clutchType = "手动档";
		}
		else{
			car.clutchType = "自动档";
		}
		System.out.println("请输入上牌年份：");
		int year = sc.nextInt();
		System.out.println("请输入上牌月份：");
		int month = sc.nextInt();
		System.out.println("请输入上牌日期：");
		int day = sc.nextInt();
		car.boardTime.set(year, month, day);
		Date date = new Date();
		car.publishTime.setTime(date);
		//加入汽车信息
		System.out.println("确认添加（1） 取消添加（2）");
		choice = sc.nextInt();
		if(choice == 1){
			for(int i = 0; i < data.carData.length; i++){
				if(data.carData[i] == null){
					data.carData[i] = car;
					System.out.println("插入成功！");
					break;
				}
			}
		}
		System.out.println("添加汽车（1） 后台管理（2）主菜单（3）");
		choice = sc.nextInt();
		if(choice == 1){
			addCar();
		}
		else if(choice == 2){
			adminManage();
		}
		else{
			mainMenu();
		}
	}
	
	

	/**
	 * 车型管理
	 */
	private void carTypeManage() {
		System.out.println("-----------------------车型管理------------------------");
		System.out.println("1.添加车型");
		System.out.println("2.删除车型");
		System.out.println("3.后台管理");
		System.out.println("4.主界面");
		System.out.println("请选择：");
		choice = sc.nextInt();
		switch (choice){
		//1.添加车型
		case 1:
			addCarType();
			break;
		//2.删除车型	
		case 2:
			delCarType();
			break;
		//3.后台管理	
		case 3:
			adminManage();
			break;
		//4.主界面	
		case 4:
			mainMenu();
			break;
		//非法输入	
		default:
			System.out.println("非法输入！");
			System.out.println("车型管理（1） 后台管理（2） 主界面（3）：");
			choice = sc.nextInt();
			if(choice == 1){
				carTypeManage();
			}
			else if(choice == 2){
				adminManage();
			}
			else{
				mainMenu();
			}
			break;
		}
		
	}

	
	public void delCarType() {
		//数组下标
		int count = 0;
		//记录brand的索引位置
		int[] array = new int[100];
		//记录type的索引位置
		int[] array1 = new int[100];
		System.out.println("-------------------删除车型----------------");
		//输出系统中所有的品牌名称，根据序号进行选择
		System.out.println("--在如下品牌中选择删除车型的品牌--：");
		System.out.println("序号\t品牌");
		for(int i = 0; i < data.brandData.length; i++){
			if(data.brandData[i] != null){
				array[count] = i;
				System.out.println((count+1)+"\t"+data.brandData[i].brandName);
				count++;
			}
		}
		System.out.println("请根据序号选择品牌：");
		choice = sc.nextInt();
		//数组下标重置为0
		count = 0;
		//输出该品牌下的所有车型信息
		System.out.println("---该品牌下的车型如下---");
		System.out.println("序号\t车型");
		for(int i = 0; i < data.carTypeData.length; i++){
			if(data.carTypeData[i] != null && data.carTypeData[i].brandId == data.brandData[array[choice-1]].brandId){
				array1[count] = i;
				System.out.println((count+1)+"\t"+data.carTypeData[i].typeName);
				count++;
			}
		}	
		System.out.println("请根据序号选择要删除的车型：");
		choice = sc.nextInt();
		System.out.println("确认删除（1） 取消删除（2）");
		int choiceint = sc.nextInt();
		//删除车型
		if(choiceint == 1){
			//删除车型前将该车型下的所有汽车设为空  再将车型设为空
			for(int i = 0; i < data.carData.length; i++){
				if(data.carData[i] != null && data.carData[i].typeId == data.carTypeData[array1[choice-1]].typeId){
					data.carData[i] = null;
				}
			}
			//将对比中的车型删除
			for(int i = 0; i < compareCars.length; i++){
				if(compareCars[i] != null && compareCars[i].typeId ==  data.carTypeData[array1[choice-1]].typeId){
					compareCars[i] = null;
				}
			}
			//将收藏中的车型删除
			for(int i = 0; i < loginUser.collectCars.length; i++){
				if(loginUser.collectCars[i] != null && loginUser.collectCars[i].typeId ==  data.carTypeData[array1[choice-1]].typeId){
					loginUser.collectCars[i] = null;
				}
			}
			data.carTypeData[array1[choice-1]] = null;
			System.out.println("该车型已删除！");
		}
		System.out.println(" 车型管理（1） 后台管理（2） 主界面（3）");
		choice = sc.nextInt();
		if(choice == 1){
			carTypeManage();
		}
		else if(choice == 2){
			adminManage();
		}
		else{
			mainMenu();
		}
	}


	/**
	 * 插入车型信息
	 */
	public void addCarType() {
		int[] array = new int[100];
		int count = 0;
		CarType cartype = new CarType();
		System.out.println("-------------------添加车型----------------");
		//输出系统中所有的品牌名称，根据序号进行选择
		System.out.println("--在如下品牌中选择添加车型的品牌--：");
		System.out.println("序号\t品牌");
		for(int i = 0; i < data.brandData.length; i++){
			if(data.brandData[i] != null){
				array[count] = i;
				System.out.println((count+1)+"\t"+data.brandData[i].brandName);
				count++;
			}
		}
		System.out.println("请根据序号选择品牌：");
		choice = sc.nextInt();
		//将选择的品牌id赋值给变量
		cartype.brandId = data.brandData[array[choice-1]].brandId;
		//数组下标重置为0
		count = 0;
		//输出该品牌下的所有车型信息
		System.out.println("---该品牌下的车型如下（请不要添加重复车型）---");
		System.out.println("序号\t车型");
		for(int i = 0; i < data.carTypeData.length; i++){
			if(data.carTypeData[i] != null && data.carTypeData[i].brandId == cartype.brandId){
				array[count] = i;
				System.out.println((count+1)+"\t"+data.carTypeData[i].typeName);
				count++;
			}
		}	
		//自动获取车型id
		cartype.typeId = CommonUtil.getTypeId();
		System.out.println("请输入车型名称：");
		cartype.typeName = sc.next();
		//判断车型Id是否已经存在
		if(hasCayType(cartype.typeName)){
			System.out.println("该车型已经存在！");
		}
		//车型id不重复,在车型数组空值的地方插入车型信息
		else{
			System.out.println("确认插入（1） 取消插入（2）:");
			choice = sc.nextInt();
			if(choice == 1){
				for(int i = 0; i < data.carTypeData.length; i++){
					if(data.carTypeData[i] == null){
						data.carTypeData[i] = cartype;
						break;
					}
				}
				System.out.println("插入成功");
			}		
		}
		//插入操作结束后的界面选择
		System.out.println("添加车型（1） 车型管理（2） 后台管理（3）主菜单（4）");
		choice = sc.nextInt();
		if(choice == 1){
			addCarType();		
		}
		else if(choice == 2){
			carTypeManage();
		}
		else if(choice == 3){
			adminManage();
		}
		else{
			mainMenu();
		}
	}


	/**
	 * 品牌管理
	 */
	public void brandManage() {
		System.out.println("---------------品牌管理---------------");
		//输出现有的品牌信息
		System.out.println("已有的品牌信息：");
		System.out.println("品牌id\t品牌名称");
		for(int i = 0; i < data.brandData.length; i++){
			if(data.brandData[i] != null){
				System.out.print(data.brandData[i].brandId+"\t");
				System.out.println(data.brandData[i].brandName);
			}
		}
		addBrand();		
	}
	/**
	 * 添加品牌信息
	 */
	public void addBrand(){
		System.out.println("---添加品牌信息(请不要添加重复的品牌信息)---");
		Brand brand = new Brand();
		brand.brandId = CommonUtil.getBrandId();
		System.out.println("请输入品牌名称：");
		brand.brandName = sc.next();
		System.out.println("确认插入（1） 取消插入（2）:");
		choice = sc.nextInt();
		if(choice == 1){
			for(int i = 0; i < data.brandData.length; i++){
				if(data.brandData[i] == null){
					data.brandData[i] = brand;
					break;
				}
			}
			System.out.println("插入成功");
		}			
		//插入操作结束后的界面选择
		System.out.println("添加品牌（1） 后台管理（2）主菜单（3）");
		choice = sc.nextInt();
		if(choice == 1){
			addBrand();
		}
		else if(choice == 2){
			adminManage();
		}
		else{
			mainMenu();
		}
	}

	/**
	 * 插入的品牌信息是否在现有的品牌中存在
	 * @param brandId
	 * @return
	 */
	public Boolean hasBrand(int brandId){
		//判断输入的品牌编号是否与已经存在的品牌编号重复
		for(int i = 0; i < data.brandData.length; i++){
			if(data.brandData[i] != null && data.brandData[i].brandId == brandId){
				return true;
			}
		}
		return false;
	}
	/**
	 * 插入的车型信息是否在现有的品车型中存在
	 * @param brandId
	 * @return
	 */
	public Boolean hasCayType(String caytyname){
		//判断输入的车型编号是否与已经存在的车型编号重复
		for(int i = 0; i < data.carTypeData.length; i++){
			if(data.carTypeData[i] != null && data.carTypeData[i].typeName.equalsIgnoreCase(caytyname)){
				return true;
			}
		}
		return false;
	}

	/**
	 * 购物历史
	 */
	public void showBuy() {
		count = 0 ;
		if(loginUser == null){
			System.out.println("未登陆用户无法查看购物历史！");
			System.out.println("登陆（1） 返回主菜单（2）：");
			choice = sc.nextInt();
			if(choice == 1){
				login();
			}
			else{
				mainMenu();
			}
			
		}
		for(int i = 0; i < loginUser.buyCars.length; i++){
			if(loginUser.buyCars[i] != null){
				count++;
			}		
		}
		if(count == 0){
			System.out.println("您还没有购买任何车辆！");
		}
		else{
			count = 0;
			System.out.println("------------------------购物历史-------------------------");
			carInfTitle();
			System.out.println();
			//输出用户收藏的车辆
			for(int i = 0; i < loginUser.buyCars.length; i++){
				if(loginUser.buyCars[i] != null){
					System.out.print((count+1)+"\t");
					showCarInfo(loginUser.buyCars[i]);
					System.out.println();
					count++;
				}		
			}
		}
		System.out.println();
		System.out.println("最新二手车信息（1） 返回主菜单（2）");
		choice = sc.nextInt();
		if(choice == 1){
		newestCarInfo();
		}
		else{
			mainMenu();
		}
	}


	/**
	 * 显示用户收藏车辆的信息
	 * @param collectCars
	 */
	public void showCollection() {
		//收藏车辆个数
		int count = 0;
		if(loginUser == null){
			System.out.println("对不起！登录后才能查看您的收藏！");
			mainMenu();
		}
		//用户收藏的车辆数
		for(int i = 0; i < loginUser.collectCars.length; i++){
			if(loginUser.collectCars[i] != null && loginUser.collectCars[i].isSold != true){			
				count++;
			}
		}
		//无收藏车辆
		if(count == 0){		
			System.out.println("您还没有收藏任何汽车！");
			System.out.println("主菜单（1）最新二手车信息（2） ");	
		}
		else{
			count = 0;
			System.out.println("---------------------我的收藏-------------------------");
			carInfTitle();
			System.out.println();
			//输出用户收藏的车辆
			for(int i = 0; i < loginUser.collectCars.length; i++){
				if(loginUser.collectCars[i] != null && loginUser.collectCars[i].isSold != true){
					System.out.print((count+1)+"\t");
					showCarInfo(loginUser.collectCars[i]);
					System.out.println();
					count++;
				}
			}
			System.out.println();		
			System.out.println("主菜单（1）最新二手车信息（2）查看汽车详细信息（3）  ");
		}
		
		choice = sc.nextInt();
		if(choice == 3){
			//根据汽车信息中的序号选择想要了解的汽车
			System.out.println("请根据序号选择想了解的汽车：");
			choice = sc.nextInt();
			//输出选中汽车的详细信息及菜单
			newestInfoMore(loginUser.collectCars[choice-1],1);
		}
		else if(choice == 2){
			newestCarInfo();
		}
		else{
			mainMenu();
		}
	}


	/**
	 * 登陆
	 */
	private void login() {
		System.out.println("----------登录-----------");
		//验证码
		String code = seCode();
		System.out.print("请输入用户名：");
		String userName = sc.next();
		System.out.print("请输入密码：");
		String password = sc.next();
		System.out.print("请输入验证码("+code+")：");
		String seCode = sc.next();
		//判断验证码是否正确
		if(!seCode.equals(code)){
			System.out.println("验证码不正确！");
			returnToLoginRegister();
		}
		
		//登陆用户所在数组的索引位置
		int index;
		//校验用户名
		index = validateUserName(userName);
		//用户名存在
		if(index != -1){
			if(password.equals(data.userData[index].password)){
				//登陆成功
				System.out.println("欢迎  "+userName+"  回来");
				//记录当前登陆的用户
				loginUser = data.userData[index];
				//返回主菜单
				mainMenu();
			}
			else{
				System.out.println("密码错误！");
				returnToLoginRegister();
			}
		}
		else{
			System.out.println("用户名不存在！");
			returnToLoginRegister();
		}
	}
	
	
	/**
	 * 注册
	 */
	private void register(){
		System.out.println("----------注册-----------");
		System.out.print("请输入用户名：");
		String userName = sc.next();
		System.out.print("请输入密码：");
		String password = sc.next();
		System.out.print("请再次输入密码：");
		String passwordAffirm = sc.next();
		//判断两次输入的密码是否一致
		if(!password.equals(passwordAffirm)){
			System.out.println("两次输入的密码不一致！");
			returnToLoginRegister();
		}	
		//判断用户名是否存在
		int index = validateUserName(userName);
		//如果用户名不存在的
		if(index == -1){
			//构建新的用户对象
			User user = new User();
			user.init();
			user.userName = userName;
			user.password = password;
			//将创建的用户写入data
			insertUser(user);
			System.out.println("注册成功！");
			//返回主菜单
			mainMenu();
		}
		else{
			System.out.println("用户名已经存在！");
			returnToLoginRegister();
		}
	}
	
	
	/**
	 * 搜索车辆
	 */
	public void searchCar(){
		System.out.println("-----------------------车辆搜索----------------------------");
		System.out.println("1.根据品牌搜索");
		System.out.println("2.根据价格搜索");
		System.out.println("3.根据上牌日期搜索");
		System.out.println("4.返回主菜单");
		System.out.println("请选择：");
		choice = sc.nextInt();
		switch(choice){
		//1.根据品牌搜索
		case 1:
			searchByBrand();
			break;
		//2.根据价格搜索	
		case 2:
			searchByPrice();
			break;
		//3.根据上牌日期搜索	
		case 3:
			searchByBoardTime();
			break;
		//4.返回主菜单	
		case 4:
			mainMenu();
			break;
		//非法输入	
		default:
			System.out.println("非法的输入！");
			System.out.println("继续搜索车辆（1） 返回主菜单（2）:");
			choice = sc.nextInt();
			if(choice == 1){
				searchCar();
			}
			else{
				mainMenu();
			}
		}
		
	}
	
	
	/**
	 * 根据上牌搜索车辆
	 */
	private void searchByBoardTime() {
		System.out.println("-----------------------上牌时间搜索----------------------------");
		//数组下表
		int count = 0;
		//获得起始年份月份 结束年份月份
		System.out.println("请输入起始年份：");
		int startYear = sc.nextInt();
		System.out.println("请输入起始月份：");
		int startMonth = sc.nextInt();
		System.out.println("请输入结束年份：");
		int endYear = sc.nextInt();
		System.out.println("请输入结束月份：");
		int endMonth = sc.nextInt();
		
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		start.set(startYear, startMonth, 0);
		end.set(endYear, endMonth, 0);
		carInfTitle();
		System.out.println("上牌时间");
		//输出符合上牌时间的汽车
		for(int i = 0 ; i < data.carData.length; i++){
			if(data.carData[i] != null && data.carData[i].isSold != true){
				if(data.carData[i].boardTime.after(start) && data.carData[i].boardTime.before(end)){
					car[count] = data.carData[i];
					System.out.print((count+1)+"\t");
					showCarInfo(data.carData[i]);
					System.out.println(timeFormat(data.carData[i].boardTime));
					count++;
				}
			}
		}
		System.out.println("根据序号选择了解汽车的详细信息（1） 返回搜索车辆（2） 返回主菜单（3）");
		choice = sc.nextInt();
		if(choice == 1){
			System.out.println("请输入序号：");
			choice = sc.nextInt();
			newestInfoMore(car[choice-1], 1);
		}
		else if(choice == 2){
			searchCar();
		}
		else{
			mainMenu();
		}
	}


	/**
	 * 根据价格搜索车辆
	 */
	private void searchByPrice() {
		System.out.println("-----------------------价格搜索----------------------------");
		int count = 0;
		int upMoney = 0;
		int lowMoney = 0;
		System.out.println("1. 5万以下");
		System.out.println("2. 5-10万");
		System.out.println("3. 10-15万");
		System.out.println("4. 15万以上");
		System.out.println("请选择：");
		choice = sc.nextInt();
		//根据选项设定价格搜索的上下和下限
		switch(choice){
		case 1:
			lowMoney = 0;
			upMoney = 50000;
			break;
		case 2:
			lowMoney = 50001;
			upMoney = 100000;
			break;
		case 3:
			lowMoney = 100001;
			upMoney = 150000;
			break;
		case 4:
			lowMoney = 150001;
			upMoney = 99999999;
			break;
		default:
			System.out.println("非法输入！");
			System.out.println("根据价格搜索汽车（1） 车辆搜索（2） 主菜单（3）：");
			choice = sc.nextInt();
			if(choice ==1){
				searchByPrice();
			}
			else if(choice == 2){
				searchCar();
			}
			else{
				mainMenu();
			}
		}
		carInfTitle();
		System.out.println();
		//查找输出在价格范围内的汽车
		for(int i = 0 ; i < data.carData.length; i++){
			if(data.carData[i] != null && data.carData[i].isSold != true && data.carData[i].price >= lowMoney && data.carData[i].price <= upMoney){
				car[count] = data.carData[i];
				System.out.print((count+1)+"\t");
				showCarInfo(data.carData[i]);
				System.out.println();
				count++;
			}
		}
		System.out.println("根据序号了解汽车详细信息（1）  车辆搜索（2） 主菜单（3）");
		choice = sc.nextInt();
		if(choice == 1){
			System.out.println("根据序号选择你想了解的汽车：");
			choice = sc.nextInt();
			newestInfoMore(car[choice-1], 1);					
		}
		//返回搜索车辆（2）
		else if(choice ==2){
			searchCar();
		}
		else{
			searchCar();
		}
	}


	/**
	 * 根据品牌搜索汽车
	 */
	public void searchByBrand() {
		Brand[] brand = new Brand[100];
		CarType[] cartype = new CarType[100];
		System.out.println("-----------------------品牌搜索----------------------------");
		int count = 0;	
		System.out.println("当前二手车系统的所有品牌信息显示如下：");
		System.out.println("序号\t品牌\t");
		//输出所有的品牌名称,并将值付给新的数组
		for(int i = 0; i < data.brandData.length; i++){
			if(data.brandData[i] != null){
				System.out.print((count+1)+"\t");
				System.out.println(data.brandData[i].brandName);
				brand[count] = data.brandData[i];
				count++;
			}
		}
		System.out.println("根据序号选择想要查看的品牌（1） 车辆搜索（2） 主菜单（3）：");
		choice = sc.nextInt();
		//根据序号选择想要查看的品牌（1）
		if(choice == 1){
			count = 0;
			//获得品牌id
			System.out.println("请输入序号：");
			choice = sc.nextInt();
			System.out.println("该品牌所对应的所有车型显示如下：");
			System.out.println("序号\t车型");
			//根据品牌的id获取当前所有该品牌的车型类
			for(int i = 0; i < data.carTypeData.length; i++){
				if(data.carTypeData[i] != null && data.carTypeData[i].brandId == brand[choice-1].brandId){
					cartype[count] = data.carTypeData[i];
					System.out.print((count+1)+"\t");
					System.out.println(data.carTypeData[i].typeName);
					count++;
				}
			}
			System.out.println("根据序号了解车型下的汽车信息（1） 车辆搜索（2） 主菜单（3）");
			choice = sc.nextInt();
			//根据序号了解车型下的具体车型（1）
			if(choice == 1){
				count = 0;
				//获得车型id
				System.out.println("请输入序号：");
				choice = sc.nextInt();
				System.out.println("该车型所对应的所有汽车如下：");
				carInfTitle();
				System.out.println();
				//根据车型id获取当前所有该车型的汽车信息
				for(int i = 0; i < data.carData.length; i++){
					if(data.carData[i] != null && data.carData[i].isSold != true && data.carData[i].typeId == cartype[choice-1].typeId){
						car[count] = data.carData[i];
						System.out.print((count+1)+"\t");
						showCarInfo(data.carData[i]);
						System.out.println();
						count++;
					}
				}			
				//获取车型后，了解汽车详细信息或是返回菜单
				System.out.println("根据序号了解汽车详细信息（1） 车辆搜索（2） 主菜单（3）");
				choice = sc.nextInt();
				if(choice == 1){
					System.out.println("根据序号选择你想了解的汽车：");
					choice = sc.nextInt();
					newestInfoMore(car[choice-1], 1);					
				}
				//返回搜索车辆（2）
				else if(choice ==2){
					searchCar();
				}
				//返回主菜单
				else{
					mainMenu();
				}
			}
			//返回汽车搜索（2）
			else if(choice == 2){
				searchCar();
			}
			//返回主菜单（3）
			else{
				mainMenu();
			}
		}
		//返回搜索车辆（2）
		else if(choice ==2){
			searchCar();
		}
		//返回主菜单
		else{
			mainMenu();
		}		
	}


	/**
	 * 显示最新二手车的方法
	 */
	private void newestCarInfo() {
		System.out.println("-------------------最新二手车信息--------------------");
		Car[] newestCar = new Car[100];
		int index = 0;
		int count = 0;
		//显示标题栏
		carInfTitle();
		System.out.println();
		//根据发布时间对为二手车进行排序，输出前十个
		carOrder();
		//找出第一个car不为空，汽车的销售状态为未销售的索引
		for(int i = data.carData.length-1 ;i >= 0; i--){
			if(data.carData[i] != null && data.carData[i].isSold != true){
				index = i;
				break;
			}
		}
		//将符合条件的10辆车存进carArray数组中，下一步的根据序号查找即为查找carArray的索引下标
		//carArray的长度只有10，写成index-10,否则会下标越界
		for(int i = index; i > index - 10 && i >= 0; i--){
			if(data.carData[i] != null &&  data.carData[i].isSold != true){
				newestCar[count] = data.carData[i];
				System.out.print((count+1)+"\t");
				showCarInfo(data.carData[i]);
				System.out.println();
				count++;
			}
		}		
		//查看汽车信息后，选择是否进一步了解汽车详细信息
		System.out.println("根据序号了解汽车详细信息（1）  主菜单（2）:");
		choice = sc.nextInt();
		if(choice == 1){
			//根据汽车信息中的序号选择想要了解的汽车
			System.out.println("请根据序号选择想了解的汽车：");
			choice = sc.nextInt();
			//输出选中汽车的详细信息及二级菜单
			newestInfoMore(newestCar[choice-1],1);
			
		}
		else{
			mainMenu();
		}

		
	}
	
	/**
	 * 详细了解汽车的信息
	 */
	public void newestInfoMore(Car car,int index){
		System.out.println("------------------------------------汽车详细信息-------------------------------------");
		carInfDetailTitle();
		showCarDetail(car,index);
		System.out.println();
		//输出选中汽车的详细信息
		carMenu(car);
		
	}
	
	/**
	 * 汽车信息的标题
	 */
	public void carInfTitle(){
		System.out.print("序号\t");
		System.out.print("品牌\t");
		System.out.print("车型\t");
		System.out.print("里程数(km)\t");
		System.out.print("价格\t");
		System.out.print("发布时间\t\t");
	}
	
	/**
	 * 汽车详细信息的标题
	 */
	public void carInfDetailTitle(){
		carInfTitle();
		System.out.print("排量(T)\t");
		System.out.print("离合器\t");
		System.out.println("上牌时间");
		
	}
	/**
	 * 显示汽车的详细信息，并显示加入收藏，加入对比的菜单
	 * @param car
	 */
	public void showCarDetail(Car car,int i){
		//输出选中汽车的详细信息
		System.out.print(i+"\t");
		showCarInfo(car);
		System.out.print(car.outputVolume+"\t");
		System.out.print(car.clutchType+"\t");
		System.out.print(timeFormat(car.boardTime));
		System.out.println();
	}
	
	/**
	 * 二级菜单，查询汽车详细信息后进行的收藏对比。。。操作
	 * @param car
	 */
	public void carMenu(Car car){
		//输出菜单
		System.out.println("1. 加入收藏");
		System.out.println("2. 加入对比");
		System.out.println("3. 购买");
		System.out.println("4. 返回主菜单");	
		System.out.println("请选择：");
		choice = sc.nextInt();
		switch(choice){
		//加入收藏
		case 1:
			addCollection(car);
			break;
		//加入对比	
		case 2:
			addCompare(car);
			break;
		//购买	
		case 3:
			buyCar(car);
			break;
		//返回主菜单	
		case 4:
			mainMenu();
			break;
		default:
			System.out.println("非法的输入！请重新选择！");
			carMenu(car);
			break;
		}
	}
	
	/**
	 * 用户购买汽车的方法
	 * @param car
	 */
	public void buyCar(Car car) {
		//如果用户没有进行登陆，则不能购买汽车
		if(loginUser == null){
			System.out.println("登录后才能购买汽车！");
			//选择是否进行登陆操作或是返回主菜单
			toLoginMainMenu();
		}
		//用户登陆后将进行购买汽车的操作
		else{			
			System.out.println("确认购买该汽车（1）取消购买该汽车（2）:");
			choice = sc.nextInt();
			if(choice == 1){
				//用户金额足够的情况，用户购买汽车后，金额减少，汽车的销售状态改变，用户的购买车辆数组里加入新买的汽车
				if(loginUser.money >= car.price){
					car.isSold = true;
					loginUser.money -= car.price;
					System.out.println("购买成功！");
					//找到用户购买车辆数组中插入数据的位置进行新购买车辆的插入
					int index = 0;
					for(int i = 0; i < loginUser.buyCars.length; i++){
						if(loginUser.buyCars[i] == null){
							index = i;
							break;
						}
					}
					loginUser.buyCars[index] = car;
					
				}
				else{
					System.out.println("您的金额不足以购买该汽车！");
				}
			}	
			//购买操作无论是否成功，都给出提示信息
			System.out.println("最新二手车信息（1） 购物历史（2） 主界面（3）:");
			choice = sc.nextInt();
			if(choice == 1){
				newestCarInfo();
			}
			else if(choice == 2){
				showBuy();
			}
			else{
				mainMenu();
			}
			
		}
	}

	/**
	 * 未进行登录操作时，选择了需要登录后才能使用的功能，选择登录或是返回主菜单
	 */
	public void toLoginMainMenu(){
		System.out.println("最新二手车信息（1） 登录（2） 主菜单（3）");
		choice = sc.nextInt();
		if(choice == 1){
			newestCarInfo();
		}
		else if(choice == 2){
			login();
		}
		else{
			mainMenu();
		}
	}
	
	
	/**
	 * 用户登陆后才可以进行将汽车加入对比的操作
	 * @param car
	 */
	public void addCompare(Car car){
		boolean has = false;
		//加入对比车辆时，首先判断是否已经加入过该车辆
		for(int i = 0; i < compareCars.length; i++){
			if(compareCars[i] == car){
				has = true;
				break;
			}
		}
		//已经收藏过该车
		if(has){
			System.out.println("您已经将该车加入了对比！");
		}
		else{
			//判断对比数组是否已满，如已满，则显示提示信息
			int i;
			//查找可以插入新的对比车辆的数组下标
			for(i = 0; i < compareCars.length; i++){
				if(compareCars[i] == null){
					break;
				}
			}	
			//下标是数组长度，则表示数组已满
			if(i == compareCars.length){
				System.out.println("最多只能进行4辆汽车的信息的对比，对比车辆已满！");		
			}	
			//将汽车加入用户的对比
			else{
				System.out.println("确认加入对比（1） 取消加入对比（2）");
				choice = sc.nextInt();
				if(choice == 1){
					compareCars[i] = car;
					System.out.println("已将该车加入您的对比！");
				}
				
			}		
		}
		showCompare(compareCars);		
	}
	
	
	public void showCompare(Car[] car){
		int[] array = new int[100];
		count = 0;
		System.out.println("1.查看对比信息");
		System.out.println("2.删除对比车辆");
		System.out.println("3.最新二手车信息");
		System.out.println("4.返回主菜单");
		System.out.println("请选择：");
		choice = sc.nextInt();
		//对比车辆数
		for(int i = 0;  i < car.length; i++){
			if(car[i] != null && car[i].isSold != true){
				count++;
			}
		}	
		if(choice ==1 || choice == 2){
			//对比车辆不足两辆
			if(count == 0 || count == 1){
				if(count == 0){
					System.out.println("您还没有加入对比车辆！");
				}
				if(count == 1){
					System.out.println("您只有一辆对比车辆！不能进行对比！");
				}
				System.out.println("最新二手车信息（1） 主菜单（2）");
				int choiceint = sc.nextInt();
				if(choiceint == 1){
					newestCarInfo();
				}
				else{
					mainMenu();
				}			
			}
			//显示对比车辆信息
			else{
				count = 0;
				carInfDetailTitle();
				for(int i = 0;  i < car.length; i++){
					if(car[i] != null && car[i].isSold != true){
						array[count] = i;
						showCarDetail(car[i],count+1);
						count++;
					}
				}	
			}
		}
	
		//查看对比信息
		if(choice  == 1){				
			showCompare(car);
		}	
		//删除对比车辆 根据序号进行删除
		else if(choice == 2){	
			System.out.println("请根据序号选择您想删除的对比车辆：");
			choice = sc.nextInt();
			System.out.println("确认删除（1） 取消删除（2）：");
			int choiceint = sc.nextInt();
			if(choiceint == 1){
				compareCars[array[choice-1]] = null;
			}
			showCompare(car);
		}
		else if(choice == 3){
			newestCarInfo();
		}
		else{
			mainMenu();
		}
	}
	
	
	/**
	 * 用户注册后将喜欢的车辆加入收藏
	 * @param car
	 */
	public void addCollection(Car car){
		if(loginUser == null){
			System.out.println("登录后才可以将汽车加入收藏！");
			toLoginMainMenu();
		}
		else{
			boolean has = false;
			//加入收藏车辆时，首先判断是否已经收藏过该车辆
			for(int i = 0; i < loginUser.collectCars.length; i++){
				if(loginUser.collectCars[i] == car){
					has = true;
					break;
				}
			}
			//已经收藏过该车
			if(has){
				System.out.println("您已经收藏过该车！");
			}
			//该车尚未被收藏
			else{
				int i;
				//获取插入车辆的位置
				for(i = 0; i < loginUser.collectCars.length; i++){
					if(loginUser.collectCars[i] == null){
						break;
					}
				}
				//如果index到达了数组的末尾，这说明用户收藏数已满，判断是否将第一个数据删除
				if(i == loginUser.collectCars.length){
					System.out.println("您的收藏车辆已经满10辆，如果继续添加收藏车辆，您收藏的第一辆车将从您的收藏列表中删除！");
					System.out.println("确认收藏（1） 取消收藏（2）:");
					choice = sc.nextInt();
					//如果继续就继续进行收藏，将收藏的第一个数据进行覆盖
					if(choice == 1){
						loginUser.collectCars[0] = car;
						System.out.println("已将该车加入您的收藏！");
					}
					else{
						newestCarInfo();
					}
				}
				//用户收藏数未满，加入收藏数组
				else{
					loginUser.collectCars[i] = car;
					System.out.println("已将该车加入您的收藏！");
				}
			}				
		}
		//收藏车辆后的下一步操作
		System.out.println("查看收藏（1）最新二手车信息（2） 主菜单（3）:");
		choice = sc.nextInt();
		if(choice == 2){
			newestCarInfo();
		}
		else if(choice == 3){
			mainMenu();
		}	
		else{
			showCollection();
		}
	}
	
	/**
	 * 显示汽车的大致信息
	 * @param car
	 */
	public void showCarInfo(Car car){
		System.out.print(getBrandName(car)+"\t");
		System.out.print(getTypeName(car)+"\t");
		System.out.print(car.mileage+"\t\t");
		System.out.print(car.price+"\t");
		System.out.print(timeFormat(car.publishTime)+"\t");
	}
	/**
	 * 校验用户名的方法
	 * @param userName
	 * @return
	 */
	public int validateUserName(String userName){
		//判断用户名是否存在
		for(int i = 0; i < data.userData.length; i++){
			if(data.userData[i] != null){
				//将输入的用户名和用户数组中的每一个用户名进行比较
				if(userName.equals(data.userData[i].userName)){
					return i;
				}
			}
		}
		return -1;
	}
	
	
	
	/**
	 * 将用户写入data的方法
	 * @param user
	 */
	public void insertUser(User user){
		for(int i = 0; i < data.userData.length; i++){
			//查找数组中第一次为null的元素位置，该位置即要注册写入的数组下标
			if(data.userData[i] == null){
				data.userData[i] = user;
				break;
			}
		}
	}

	
	/**
	 * 产生验证码的方法
	 * @return
	 */
	public String seCode(){
		String str = "";
		int random = 0;
		//随机产生一个0-9的数字
		for(int i = 1; i <=4; i++){
			random = (int)(Math.random() * 10);
			str += random;
		}
		return str;
	}
	
	
	
	/**
	 *  登录时，验证码，用户名，密码输入错误后，是否继续进行登录操作的方法
	 *  注册时，用户名重复，两次密码输入不一致后，是否继续进行注册操作的方法
	 */
	public void returnToLoginRegister(){
		System.out.println("登录（1） 注册（2） 主界面（3）：");
		choice = sc.nextInt();
		if(choice == 1){
			login();
		}
		else if(choice == 2){
			register();
		}
		else if(choice ==3){
			mainMenu();
		}
		else{
			System.out.println("非法数据！请重新进行操作！");
			mainMenu();
		}
	}
	
	
	/**
	 * 根据发布时间对汽车进行排序 选择排序
	 * @param car
	 */
	public void carOrder(){
		for(int i = 0; i < data.carData.length-1; i++){
			for(int j = i+1; j < data.carData.length; j++){
				if(data.carData[i] != null && data.carData[j] != null){
					if(data.carData[i].publishTime.after(data.carData[j].publishTime)){
						Car temp = data.carData[i];
						data.carData[i] = data.carData[j];
						data.carData[j] = temp;
					}
				}
			}
			
		}
		
	}
	
	/**
	 * 格式化输出时间的格式
	 */	
	public String timeFormat(Calendar calendar){
		//格式化时间  参数表示时间中的单位
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String time = format.format(calendar.getTime());
		return time;
	}
	
	
	/**
	 * 根据Car的brandId到Brand中去查找brandName
	 * @param car
	 * @return
	 */
	public String getBrandName(Car car){
		String brandName = "";
		for(int i = 0; i < data.brandData.length; i++){
			if(data.brandData[i] != null){
				if(data.brandData[i].brandId == car.brandId){
					brandName = data.brandData[i].brandName;
					break;
				}
					
			}		
		}
		return brandName;
	}
	
	
	/**
	 * 根据Car的typeId到CarType中去查找typeName
	 * @param car
	 * @return
	 */
	public String getTypeName(Car car){
		String typeName = "";
		for(int i = 0; i < data.carTypeData.length; i++){
			if(data.carTypeData[i] != null){
				if(data.carTypeData[i].typeId == car.typeId){
					typeName = data.carTypeData[i].typeName;
					break;
				}
			}
		}
		return typeName;
	}
}
