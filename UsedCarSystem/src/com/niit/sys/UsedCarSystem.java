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
 * ���ֳ�����ϵͳ
 * @author Administrator
 *
 */
public class UsedCarSystem {
	//������
	Data data;
	//��½�û�
	User loginUser;
	Scanner sc;
	//�˵���ת��ѡ��
	int choice = 0;
	//����Աȵ�����
	Car[] compareCars;
	//�洢ֵ��Ϊ�յ�����
	Car[] car;
	//��¼������ֵ��Ϊ�յ�����
	int count = 0;
	
	/**
	 * ��ʼ��ϵͳ �������ݿ�
	 * @param data
	 */
	private void init(Data data){
		this.data = data;
		sc = new Scanner(System.in);
		compareCars = new Car[4];
		car = new Car[100];
	}
	
	
	/**
	 * ����ϵͳ
	 */
	public void start(Data data){
		init(data);
		System.out.println("----------------------NIIT���ֳ�����ƽ̨-----------------------");
		//��ʾ���˵�
		mainMenu();
	}
	
	
	/**
	 * ���˵�
	 */
	private void mainMenu(){
		//����û���½�ɹ�����Ҫ��ʾ��½��ע��ѡ��
		if(loginUser == null){
			System.out.println("1. ��½");
			System.out.println("2. ע��");
		}
		System.out.println("3. ���¶��ֳ���Ϣ");
		System.out.println("4. ��������");
		System.out.println("5. �Աȳ���");
		System.out.println("6. �ҵ��ղ�");
		System.out.println("7. ������ʷ");
		System.out.println("8. ��̨����");
		System.out.println("9. �˳�ϵͳ");
		System.out.println("��ѡ��");
		choice = sc.nextInt();
		switch(choice){
		//��¼
		case 1:
			login();
			break;
		//ע��
		case 2:
			register();
			break;
		//���¶��ֳ���Ϣ
		case 3:
			newestCarInfo();
			break;
		//��������	
		case 4:
			searchCar();
			break;
		//�Աȳ���
		case 5:
			showCompare(compareCars);
			break;
		//�ҵ��ղ�
		case 6:
			showCollection();
			break;
		//������ʷ
		case 7:
			showBuy();
			break;
		//��̨����	
		case 8:
			adminManage();
			break;
		//�˳�ϵͳ
		case 9:
			System.out.println("----------------------�˳�ϵͳ����ӭ�ٴι��٣�-----------------------");
			System.exit(0);
		default:
			System.out.println("�Ƿ����룡������ѡ��\n");
			mainMenu();
		}
	}
	
	
	/**
	 * ��̨����
	 */
	private void adminManage() {
		if(loginUser == null){
			System.out.println("����δ��½��");
			mainMenu();
		}
		if(loginUser.isAdmin == false){
			System.out.println("�ǹ���Ա��Ȩ���к�̨����");
			mainMenu();
		}
		System.out.println("---------------------��̨����--------------------------");
		System.out.println("1.Ʒ�ƹ���");
		System.out.println("2.���͹���");
		System.out.println("3.����������Ϣ");
		System.out.println("4.���˵�");
		System.out.println("��ѡ��");
		choice = sc.nextInt();
		switch(choice){
		//1.Ʒ�ƹ���
		case 1:
			brandManage();
			break;
		//2.���͹���	
		case 2:
			carTypeManage();
			break;
		//3.����������Ϣ
		case 3:
			addCar();
			break;
		//4.���˵�	
		case 4:
			mainMenu();
			break;
		//�Ƿ�����	
		default:
			System.out.println("�Ƿ����룡");
			mainMenu();
		}	
	}

	/**
	 * ����������Ϣ
	 */
	private void addCar() {
		Car car = new Car();
		car.init();
		int count = 0;
		int[] array = new int[100];
		int[] array1 = new int[100];
		//�������е�Ʒ�ƽ���ѡ��
		System.out.println("��������Ʒ����ѡ��");
		System.out.println("����\tƷ������");
		//�г����е�Ʒ��
		for(int i = 0; i < data.brandData.length; i++){
			if(data.brandData[i] != null){
				System.out.print((count+1)+"\t");
				array[count] = i;
				System.out.println(data.brandData[i].brandName);
				count++;
			}
		}
		System.out.println("��ѡ��Ҫ����������Ʒ����ţ�");
		choice = sc.nextInt();
		car.brandId = data.brandData[array[choice-1]].brandId;
		//��Ʒ���µĳ����м�������ѡ��
		System.out.println("�������¸�Ʒ���µĳ�����ѡ��");
		System.out.println("����\t��������");
		count = 0 ;
		//�г�Ʒ�������еĳ���
		for(int i = 0; i < data.carTypeData.length; i++){
			if(data.carTypeData[i] != null && data.carTypeData[i].brandId == data.brandData[array[choice-1]].brandId){
				System.out.print((count+1)+".\t");
				System.out.println(data.carTypeData[i].typeName);
				array1[count] = i;
				count++;				
			}
		}
		System.out.println("��ѡ��Ҫ���������ĳ�����ţ�");
		choice = sc.nextInt();
		car.typeId = data.carTypeData[array1[choice-1]].typeId;
		//����������Ϣ
		car.carId = CommonUtil.getCarId();
		car.isSold = false;
		System.out.println("������۸�");
		car.price = sc.nextInt();
		System.out.println("���������(km)��");
		car.mileage = sc.nextDouble();
		System.out.println("������������");
		car.outputVolume = sc.nextDouble();
		System.out.println("��������������ͣ�1 �ֶ���   2 �Զ�������");
		choice = sc.nextInt();
		if(choice == 1){
			car.clutchType = "�ֶ���";
		}
		else{
			car.clutchType = "�Զ���";
		}
		System.out.println("������������ݣ�");
		int year = sc.nextInt();
		System.out.println("�����������·ݣ�");
		int month = sc.nextInt();
		System.out.println("�������������ڣ�");
		int day = sc.nextInt();
		car.boardTime.set(year, month, day);
		Date date = new Date();
		car.publishTime.setTime(date);
		//����������Ϣ
		System.out.println("ȷ����ӣ�1�� ȡ����ӣ�2��");
		choice = sc.nextInt();
		if(choice == 1){
			for(int i = 0; i < data.carData.length; i++){
				if(data.carData[i] == null){
					data.carData[i] = car;
					System.out.println("����ɹ���");
					break;
				}
			}
		}
		System.out.println("���������1�� ��̨����2�����˵���3��");
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
	 * ���͹���
	 */
	private void carTypeManage() {
		System.out.println("-----------------------���͹���------------------------");
		System.out.println("1.��ӳ���");
		System.out.println("2.ɾ������");
		System.out.println("3.��̨����");
		System.out.println("4.������");
		System.out.println("��ѡ��");
		choice = sc.nextInt();
		switch (choice){
		//1.��ӳ���
		case 1:
			addCarType();
			break;
		//2.ɾ������	
		case 2:
			delCarType();
			break;
		//3.��̨����	
		case 3:
			adminManage();
			break;
		//4.������	
		case 4:
			mainMenu();
			break;
		//�Ƿ�����	
		default:
			System.out.println("�Ƿ����룡");
			System.out.println("���͹���1�� ��̨����2�� �����棨3����");
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
		//�����±�
		int count = 0;
		//��¼brand������λ��
		int[] array = new int[100];
		//��¼type������λ��
		int[] array1 = new int[100];
		System.out.println("-------------------ɾ������----------------");
		//���ϵͳ�����е�Ʒ�����ƣ�������Ž���ѡ��
		System.out.println("--������Ʒ����ѡ��ɾ�����͵�Ʒ��--��");
		System.out.println("���\tƷ��");
		for(int i = 0; i < data.brandData.length; i++){
			if(data.brandData[i] != null){
				array[count] = i;
				System.out.println((count+1)+"\t"+data.brandData[i].brandName);
				count++;
			}
		}
		System.out.println("��������ѡ��Ʒ�ƣ�");
		choice = sc.nextInt();
		//�����±�����Ϊ0
		count = 0;
		//�����Ʒ���µ����г�����Ϣ
		System.out.println("---��Ʒ���µĳ�������---");
		System.out.println("���\t����");
		for(int i = 0; i < data.carTypeData.length; i++){
			if(data.carTypeData[i] != null && data.carTypeData[i].brandId == data.brandData[array[choice-1]].brandId){
				array1[count] = i;
				System.out.println((count+1)+"\t"+data.carTypeData[i].typeName);
				count++;
			}
		}	
		System.out.println("��������ѡ��Ҫɾ���ĳ��ͣ�");
		choice = sc.nextInt();
		System.out.println("ȷ��ɾ����1�� ȡ��ɾ����2��");
		int choiceint = sc.nextInt();
		//ɾ������
		if(choiceint == 1){
			//ɾ������ǰ���ó����µ�����������Ϊ��  �ٽ�������Ϊ��
			for(int i = 0; i < data.carData.length; i++){
				if(data.carData[i] != null && data.carData[i].typeId == data.carTypeData[array1[choice-1]].typeId){
					data.carData[i] = null;
				}
			}
			//���Ա��еĳ���ɾ��
			for(int i = 0; i < compareCars.length; i++){
				if(compareCars[i] != null && compareCars[i].typeId ==  data.carTypeData[array1[choice-1]].typeId){
					compareCars[i] = null;
				}
			}
			//���ղ��еĳ���ɾ��
			for(int i = 0; i < loginUser.collectCars.length; i++){
				if(loginUser.collectCars[i] != null && loginUser.collectCars[i].typeId ==  data.carTypeData[array1[choice-1]].typeId){
					loginUser.collectCars[i] = null;
				}
			}
			data.carTypeData[array1[choice-1]] = null;
			System.out.println("�ó�����ɾ����");
		}
		System.out.println(" ���͹���1�� ��̨����2�� �����棨3��");
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
	 * ���복����Ϣ
	 */
	public void addCarType() {
		int[] array = new int[100];
		int count = 0;
		CarType cartype = new CarType();
		System.out.println("-------------------��ӳ���----------------");
		//���ϵͳ�����е�Ʒ�����ƣ�������Ž���ѡ��
		System.out.println("--������Ʒ����ѡ����ӳ��͵�Ʒ��--��");
		System.out.println("���\tƷ��");
		for(int i = 0; i < data.brandData.length; i++){
			if(data.brandData[i] != null){
				array[count] = i;
				System.out.println((count+1)+"\t"+data.brandData[i].brandName);
				count++;
			}
		}
		System.out.println("��������ѡ��Ʒ�ƣ�");
		choice = sc.nextInt();
		//��ѡ���Ʒ��id��ֵ������
		cartype.brandId = data.brandData[array[choice-1]].brandId;
		//�����±�����Ϊ0
		count = 0;
		//�����Ʒ���µ����г�����Ϣ
		System.out.println("---��Ʒ���µĳ������£��벻Ҫ����ظ����ͣ�---");
		System.out.println("���\t����");
		for(int i = 0; i < data.carTypeData.length; i++){
			if(data.carTypeData[i] != null && data.carTypeData[i].brandId == cartype.brandId){
				array[count] = i;
				System.out.println((count+1)+"\t"+data.carTypeData[i].typeName);
				count++;
			}
		}	
		//�Զ���ȡ����id
		cartype.typeId = CommonUtil.getTypeId();
		System.out.println("�����복�����ƣ�");
		cartype.typeName = sc.next();
		//�жϳ���Id�Ƿ��Ѿ�����
		if(hasCayType(cartype.typeName)){
			System.out.println("�ó����Ѿ����ڣ�");
		}
		//����id���ظ�,�ڳ��������ֵ�ĵط����복����Ϣ
		else{
			System.out.println("ȷ�ϲ��루1�� ȡ�����루2��:");
			choice = sc.nextInt();
			if(choice == 1){
				for(int i = 0; i < data.carTypeData.length; i++){
					if(data.carTypeData[i] == null){
						data.carTypeData[i] = cartype;
						break;
					}
				}
				System.out.println("����ɹ�");
			}		
		}
		//�������������Ľ���ѡ��
		System.out.println("��ӳ��ͣ�1�� ���͹���2�� ��̨����3�����˵���4��");
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
	 * Ʒ�ƹ���
	 */
	public void brandManage() {
		System.out.println("---------------Ʒ�ƹ���---------------");
		//������е�Ʒ����Ϣ
		System.out.println("���е�Ʒ����Ϣ��");
		System.out.println("Ʒ��id\tƷ������");
		for(int i = 0; i < data.brandData.length; i++){
			if(data.brandData[i] != null){
				System.out.print(data.brandData[i].brandId+"\t");
				System.out.println(data.brandData[i].brandName);
			}
		}
		addBrand();		
	}
	/**
	 * ���Ʒ����Ϣ
	 */
	public void addBrand(){
		System.out.println("---���Ʒ����Ϣ(�벻Ҫ����ظ���Ʒ����Ϣ)---");
		Brand brand = new Brand();
		brand.brandId = CommonUtil.getBrandId();
		System.out.println("������Ʒ�����ƣ�");
		brand.brandName = sc.next();
		System.out.println("ȷ�ϲ��루1�� ȡ�����루2��:");
		choice = sc.nextInt();
		if(choice == 1){
			for(int i = 0; i < data.brandData.length; i++){
				if(data.brandData[i] == null){
					data.brandData[i] = brand;
					break;
				}
			}
			System.out.println("����ɹ�");
		}			
		//�������������Ľ���ѡ��
		System.out.println("���Ʒ�ƣ�1�� ��̨����2�����˵���3��");
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
	 * �����Ʒ����Ϣ�Ƿ������е�Ʒ���д���
	 * @param brandId
	 * @return
	 */
	public Boolean hasBrand(int brandId){
		//�ж������Ʒ�Ʊ���Ƿ����Ѿ����ڵ�Ʒ�Ʊ���ظ�
		for(int i = 0; i < data.brandData.length; i++){
			if(data.brandData[i] != null && data.brandData[i].brandId == brandId){
				return true;
			}
		}
		return false;
	}
	/**
	 * ����ĳ�����Ϣ�Ƿ������е�Ʒ�����д���
	 * @param brandId
	 * @return
	 */
	public Boolean hasCayType(String caytyname){
		//�ж�����ĳ��ͱ���Ƿ����Ѿ����ڵĳ��ͱ���ظ�
		for(int i = 0; i < data.carTypeData.length; i++){
			if(data.carTypeData[i] != null && data.carTypeData[i].typeName.equalsIgnoreCase(caytyname)){
				return true;
			}
		}
		return false;
	}

	/**
	 * ������ʷ
	 */
	public void showBuy() {
		count = 0 ;
		if(loginUser == null){
			System.out.println("δ��½�û��޷��鿴������ʷ��");
			System.out.println("��½��1�� �������˵���2����");
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
			System.out.println("����û�й����κγ�����");
		}
		else{
			count = 0;
			System.out.println("------------------------������ʷ-------------------------");
			carInfTitle();
			System.out.println();
			//����û��ղصĳ���
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
		System.out.println("���¶��ֳ���Ϣ��1�� �������˵���2��");
		choice = sc.nextInt();
		if(choice == 1){
		newestCarInfo();
		}
		else{
			mainMenu();
		}
	}


	/**
	 * ��ʾ�û��ղس�������Ϣ
	 * @param collectCars
	 */
	public void showCollection() {
		//�ղس�������
		int count = 0;
		if(loginUser == null){
			System.out.println("�Բ��𣡵�¼����ܲ鿴�����ղأ�");
			mainMenu();
		}
		//�û��ղصĳ�����
		for(int i = 0; i < loginUser.collectCars.length; i++){
			if(loginUser.collectCars[i] != null && loginUser.collectCars[i].isSold != true){			
				count++;
			}
		}
		//���ղس���
		if(count == 0){		
			System.out.println("����û���ղ��κ�������");
			System.out.println("���˵���1�����¶��ֳ���Ϣ��2�� ");	
		}
		else{
			count = 0;
			System.out.println("---------------------�ҵ��ղ�-------------------------");
			carInfTitle();
			System.out.println();
			//����û��ղصĳ���
			for(int i = 0; i < loginUser.collectCars.length; i++){
				if(loginUser.collectCars[i] != null && loginUser.collectCars[i].isSold != true){
					System.out.print((count+1)+"\t");
					showCarInfo(loginUser.collectCars[i]);
					System.out.println();
					count++;
				}
			}
			System.out.println();		
			System.out.println("���˵���1�����¶��ֳ���Ϣ��2���鿴������ϸ��Ϣ��3��  ");
		}
		
		choice = sc.nextInt();
		if(choice == 3){
			//����������Ϣ�е����ѡ����Ҫ�˽������
			System.out.println("��������ѡ�����˽��������");
			choice = sc.nextInt();
			//���ѡ����������ϸ��Ϣ���˵�
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
	 * ��½
	 */
	private void login() {
		System.out.println("----------��¼-----------");
		//��֤��
		String code = seCode();
		System.out.print("�������û�����");
		String userName = sc.next();
		System.out.print("���������룺");
		String password = sc.next();
		System.out.print("��������֤��("+code+")��");
		String seCode = sc.next();
		//�ж���֤���Ƿ���ȷ
		if(!seCode.equals(code)){
			System.out.println("��֤�벻��ȷ��");
			returnToLoginRegister();
		}
		
		//��½�û��������������λ��
		int index;
		//У���û���
		index = validateUserName(userName);
		//�û�������
		if(index != -1){
			if(password.equals(data.userData[index].password)){
				//��½�ɹ�
				System.out.println("��ӭ  "+userName+"  ����");
				//��¼��ǰ��½���û�
				loginUser = data.userData[index];
				//�������˵�
				mainMenu();
			}
			else{
				System.out.println("�������");
				returnToLoginRegister();
			}
		}
		else{
			System.out.println("�û��������ڣ�");
			returnToLoginRegister();
		}
	}
	
	
	/**
	 * ע��
	 */
	private void register(){
		System.out.println("----------ע��-----------");
		System.out.print("�������û�����");
		String userName = sc.next();
		System.out.print("���������룺");
		String password = sc.next();
		System.out.print("���ٴ��������룺");
		String passwordAffirm = sc.next();
		//�ж���������������Ƿ�һ��
		if(!password.equals(passwordAffirm)){
			System.out.println("������������벻һ�£�");
			returnToLoginRegister();
		}	
		//�ж��û����Ƿ����
		int index = validateUserName(userName);
		//����û��������ڵ�
		if(index == -1){
			//�����µ��û�����
			User user = new User();
			user.init();
			user.userName = userName;
			user.password = password;
			//���������û�д��data
			insertUser(user);
			System.out.println("ע��ɹ���");
			//�������˵�
			mainMenu();
		}
		else{
			System.out.println("�û����Ѿ����ڣ�");
			returnToLoginRegister();
		}
	}
	
	
	/**
	 * ��������
	 */
	public void searchCar(){
		System.out.println("-----------------------��������----------------------------");
		System.out.println("1.����Ʒ������");
		System.out.println("2.���ݼ۸�����");
		System.out.println("3.����������������");
		System.out.println("4.�������˵�");
		System.out.println("��ѡ��");
		choice = sc.nextInt();
		switch(choice){
		//1.����Ʒ������
		case 1:
			searchByBrand();
			break;
		//2.���ݼ۸�����	
		case 2:
			searchByPrice();
			break;
		//3.����������������	
		case 3:
			searchByBoardTime();
			break;
		//4.�������˵�	
		case 4:
			mainMenu();
			break;
		//�Ƿ�����	
		default:
			System.out.println("�Ƿ������룡");
			System.out.println("��������������1�� �������˵���2��:");
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
	 * ����������������
	 */
	private void searchByBoardTime() {
		System.out.println("-----------------------����ʱ������----------------------------");
		//�����±�
		int count = 0;
		//�����ʼ����·� ��������·�
		System.out.println("��������ʼ��ݣ�");
		int startYear = sc.nextInt();
		System.out.println("��������ʼ�·ݣ�");
		int startMonth = sc.nextInt();
		System.out.println("�����������ݣ�");
		int endYear = sc.nextInt();
		System.out.println("����������·ݣ�");
		int endMonth = sc.nextInt();
		
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		start.set(startYear, startMonth, 0);
		end.set(endYear, endMonth, 0);
		carInfTitle();
		System.out.println("����ʱ��");
		//�����������ʱ�������
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
		System.out.println("�������ѡ���˽���������ϸ��Ϣ��1�� ��������������2�� �������˵���3��");
		choice = sc.nextInt();
		if(choice == 1){
			System.out.println("��������ţ�");
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
	 * ���ݼ۸���������
	 */
	private void searchByPrice() {
		System.out.println("-----------------------�۸�����----------------------------");
		int count = 0;
		int upMoney = 0;
		int lowMoney = 0;
		System.out.println("1. 5������");
		System.out.println("2. 5-10��");
		System.out.println("3. 10-15��");
		System.out.println("4. 15������");
		System.out.println("��ѡ��");
		choice = sc.nextInt();
		//����ѡ���趨�۸����������º�����
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
			System.out.println("�Ƿ����룡");
			System.out.println("���ݼ۸�����������1�� ����������2�� ���˵���3����");
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
		//��������ڼ۸�Χ�ڵ�����
		for(int i = 0 ; i < data.carData.length; i++){
			if(data.carData[i] != null && data.carData[i].isSold != true && data.carData[i].price >= lowMoney && data.carData[i].price <= upMoney){
				car[count] = data.carData[i];
				System.out.print((count+1)+"\t");
				showCarInfo(data.carData[i]);
				System.out.println();
				count++;
			}
		}
		System.out.println("��������˽�������ϸ��Ϣ��1��  ����������2�� ���˵���3��");
		choice = sc.nextInt();
		if(choice == 1){
			System.out.println("�������ѡ�������˽��������");
			choice = sc.nextInt();
			newestInfoMore(car[choice-1], 1);					
		}
		//��������������2��
		else if(choice ==2){
			searchCar();
		}
		else{
			searchCar();
		}
	}


	/**
	 * ����Ʒ����������
	 */
	public void searchByBrand() {
		Brand[] brand = new Brand[100];
		CarType[] cartype = new CarType[100];
		System.out.println("-----------------------Ʒ������----------------------------");
		int count = 0;	
		System.out.println("��ǰ���ֳ�ϵͳ������Ʒ����Ϣ��ʾ���£�");
		System.out.println("���\tƷ��\t");
		//������е�Ʒ������,����ֵ�����µ�����
		for(int i = 0; i < data.brandData.length; i++){
			if(data.brandData[i] != null){
				System.out.print((count+1)+"\t");
				System.out.println(data.brandData[i].brandName);
				brand[count] = data.brandData[i];
				count++;
			}
		}
		System.out.println("�������ѡ����Ҫ�鿴��Ʒ�ƣ�1�� ����������2�� ���˵���3����");
		choice = sc.nextInt();
		//�������ѡ����Ҫ�鿴��Ʒ�ƣ�1��
		if(choice == 1){
			count = 0;
			//���Ʒ��id
			System.out.println("��������ţ�");
			choice = sc.nextInt();
			System.out.println("��Ʒ������Ӧ�����г�����ʾ���£�");
			System.out.println("���\t����");
			//����Ʒ�Ƶ�id��ȡ��ǰ���и�Ʒ�Ƶĳ�����
			for(int i = 0; i < data.carTypeData.length; i++){
				if(data.carTypeData[i] != null && data.carTypeData[i].brandId == brand[choice-1].brandId){
					cartype[count] = data.carTypeData[i];
					System.out.print((count+1)+"\t");
					System.out.println(data.carTypeData[i].typeName);
					count++;
				}
			}
			System.out.println("��������˽⳵���µ�������Ϣ��1�� ����������2�� ���˵���3��");
			choice = sc.nextInt();
			//��������˽⳵���µľ��峵�ͣ�1��
			if(choice == 1){
				count = 0;
				//��ó���id
				System.out.println("��������ţ�");
				choice = sc.nextInt();
				System.out.println("�ó�������Ӧ�������������£�");
				carInfTitle();
				System.out.println();
				//���ݳ���id��ȡ��ǰ���иó��͵�������Ϣ
				for(int i = 0; i < data.carData.length; i++){
					if(data.carData[i] != null && data.carData[i].isSold != true && data.carData[i].typeId == cartype[choice-1].typeId){
						car[count] = data.carData[i];
						System.out.print((count+1)+"\t");
						showCarInfo(data.carData[i]);
						System.out.println();
						count++;
					}
				}			
				//��ȡ���ͺ��˽�������ϸ��Ϣ���Ƿ��ز˵�
				System.out.println("��������˽�������ϸ��Ϣ��1�� ����������2�� ���˵���3��");
				choice = sc.nextInt();
				if(choice == 1){
					System.out.println("�������ѡ�������˽��������");
					choice = sc.nextInt();
					newestInfoMore(car[choice-1], 1);					
				}
				//��������������2��
				else if(choice ==2){
					searchCar();
				}
				//�������˵�
				else{
					mainMenu();
				}
			}
			//��������������2��
			else if(choice == 2){
				searchCar();
			}
			//�������˵���3��
			else{
				mainMenu();
			}
		}
		//��������������2��
		else if(choice ==2){
			searchCar();
		}
		//�������˵�
		else{
			mainMenu();
		}		
	}


	/**
	 * ��ʾ���¶��ֳ��ķ���
	 */
	private void newestCarInfo() {
		System.out.println("-------------------���¶��ֳ���Ϣ--------------------");
		Car[] newestCar = new Car[100];
		int index = 0;
		int count = 0;
		//��ʾ������
		carInfTitle();
		System.out.println();
		//���ݷ���ʱ���Ϊ���ֳ������������ǰʮ��
		carOrder();
		//�ҳ���һ��car��Ϊ�գ�����������״̬Ϊδ���۵�����
		for(int i = data.carData.length-1 ;i >= 0; i--){
			if(data.carData[i] != null && data.carData[i].isSold != true){
				index = i;
				break;
			}
		}
		//������������10�������carArray�����У���һ���ĸ�����Ų��Ҽ�Ϊ����carArray�������±�
		//carArray�ĳ���ֻ��10��д��index-10,������±�Խ��
		for(int i = index; i > index - 10 && i >= 0; i--){
			if(data.carData[i] != null &&  data.carData[i].isSold != true){
				newestCar[count] = data.carData[i];
				System.out.print((count+1)+"\t");
				showCarInfo(data.carData[i]);
				System.out.println();
				count++;
			}
		}		
		//�鿴������Ϣ��ѡ���Ƿ��һ���˽�������ϸ��Ϣ
		System.out.println("��������˽�������ϸ��Ϣ��1��  ���˵���2��:");
		choice = sc.nextInt();
		if(choice == 1){
			//����������Ϣ�е����ѡ����Ҫ�˽������
			System.out.println("��������ѡ�����˽��������");
			choice = sc.nextInt();
			//���ѡ����������ϸ��Ϣ�������˵�
			newestInfoMore(newestCar[choice-1],1);
			
		}
		else{
			mainMenu();
		}

		
	}
	
	/**
	 * ��ϸ�˽���������Ϣ
	 */
	public void newestInfoMore(Car car,int index){
		System.out.println("------------------------------------������ϸ��Ϣ-------------------------------------");
		carInfDetailTitle();
		showCarDetail(car,index);
		System.out.println();
		//���ѡ����������ϸ��Ϣ
		carMenu(car);
		
	}
	
	/**
	 * ������Ϣ�ı���
	 */
	public void carInfTitle(){
		System.out.print("���\t");
		System.out.print("Ʒ��\t");
		System.out.print("����\t");
		System.out.print("�����(km)\t");
		System.out.print("�۸�\t");
		System.out.print("����ʱ��\t\t");
	}
	
	/**
	 * ������ϸ��Ϣ�ı���
	 */
	public void carInfDetailTitle(){
		carInfTitle();
		System.out.print("����(T)\t");
		System.out.print("�����\t");
		System.out.println("����ʱ��");
		
	}
	/**
	 * ��ʾ��������ϸ��Ϣ������ʾ�����ղأ�����ԱȵĲ˵�
	 * @param car
	 */
	public void showCarDetail(Car car,int i){
		//���ѡ����������ϸ��Ϣ
		System.out.print(i+"\t");
		showCarInfo(car);
		System.out.print(car.outputVolume+"\t");
		System.out.print(car.clutchType+"\t");
		System.out.print(timeFormat(car.boardTime));
		System.out.println();
	}
	
	/**
	 * �����˵�����ѯ������ϸ��Ϣ����е��ղضԱȡ���������
	 * @param car
	 */
	public void carMenu(Car car){
		//����˵�
		System.out.println("1. �����ղ�");
		System.out.println("2. ����Ա�");
		System.out.println("3. ����");
		System.out.println("4. �������˵�");	
		System.out.println("��ѡ��");
		choice = sc.nextInt();
		switch(choice){
		//�����ղ�
		case 1:
			addCollection(car);
			break;
		//����Ա�	
		case 2:
			addCompare(car);
			break;
		//����	
		case 3:
			buyCar(car);
			break;
		//�������˵�	
		case 4:
			mainMenu();
			break;
		default:
			System.out.println("�Ƿ������룡������ѡ��");
			carMenu(car);
			break;
		}
	}
	
	/**
	 * �û����������ķ���
	 * @param car
	 */
	public void buyCar(Car car) {
		//����û�û�н��е�½�����ܹ�������
		if(loginUser == null){
			System.out.println("��¼����ܹ���������");
			//ѡ���Ƿ���е�½�������Ƿ������˵�
			toLoginMainMenu();
		}
		//�û���½�󽫽��й��������Ĳ���
		else{			
			System.out.println("ȷ�Ϲ����������1��ȡ�������������2��:");
			choice = sc.nextInt();
			if(choice == 1){
				//�û�����㹻��������û����������󣬽����٣�����������״̬�ı䣬�û��Ĺ�����������������������
				if(loginUser.money >= car.price){
					car.isSold = true;
					loginUser.money -= car.price;
					System.out.println("����ɹ���");
					//�ҵ��û������������в������ݵ�λ�ý����¹������Ĳ���
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
					System.out.println("���Ľ����Թ����������");
				}
			}	
			//������������Ƿ�ɹ�����������ʾ��Ϣ
			System.out.println("���¶��ֳ���Ϣ��1�� ������ʷ��2�� �����棨3��:");
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
	 * δ���е�¼����ʱ��ѡ������Ҫ��¼�����ʹ�õĹ��ܣ�ѡ���¼���Ƿ������˵�
	 */
	public void toLoginMainMenu(){
		System.out.println("���¶��ֳ���Ϣ��1�� ��¼��2�� ���˵���3��");
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
	 * �û���½��ſ��Խ��н���������ԱȵĲ���
	 * @param car
	 */
	public void addCompare(Car car){
		boolean has = false;
		//����Աȳ���ʱ�������ж��Ƿ��Ѿ�������ó���
		for(int i = 0; i < compareCars.length; i++){
			if(compareCars[i] == car){
				has = true;
				break;
			}
		}
		//�Ѿ��ղع��ó�
		if(has){
			System.out.println("���Ѿ����ó������˶Աȣ�");
		}
		else{
			//�ж϶Ա������Ƿ�������������������ʾ��ʾ��Ϣ
			int i;
			//���ҿ��Բ����µĶԱȳ����������±�
			for(i = 0; i < compareCars.length; i++){
				if(compareCars[i] == null){
					break;
				}
			}	
			//�±������鳤�ȣ����ʾ��������
			if(i == compareCars.length){
				System.out.println("���ֻ�ܽ���4����������Ϣ�ĶԱȣ��Աȳ���������");		
			}	
			//�����������û��ĶԱ�
			else{
				System.out.println("ȷ�ϼ���Աȣ�1�� ȡ������Աȣ�2��");
				choice = sc.nextInt();
				if(choice == 1){
					compareCars[i] = car;
					System.out.println("�ѽ��ó��������ĶԱȣ�");
				}
				
			}		
		}
		showCompare(compareCars);		
	}
	
	
	public void showCompare(Car[] car){
		int[] array = new int[100];
		count = 0;
		System.out.println("1.�鿴�Ա���Ϣ");
		System.out.println("2.ɾ���Աȳ���");
		System.out.println("3.���¶��ֳ���Ϣ");
		System.out.println("4.�������˵�");
		System.out.println("��ѡ��");
		choice = sc.nextInt();
		//�Աȳ�����
		for(int i = 0;  i < car.length; i++){
			if(car[i] != null && car[i].isSold != true){
				count++;
			}
		}	
		if(choice ==1 || choice == 2){
			//�Աȳ�����������
			if(count == 0 || count == 1){
				if(count == 0){
					System.out.println("����û�м���Աȳ�����");
				}
				if(count == 1){
					System.out.println("��ֻ��һ���Աȳ��������ܽ��жԱȣ�");
				}
				System.out.println("���¶��ֳ���Ϣ��1�� ���˵���2��");
				int choiceint = sc.nextInt();
				if(choiceint == 1){
					newestCarInfo();
				}
				else{
					mainMenu();
				}			
			}
			//��ʾ�Աȳ�����Ϣ
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
	
		//�鿴�Ա���Ϣ
		if(choice  == 1){				
			showCompare(car);
		}	
		//ɾ���Աȳ��� ������Ž���ɾ��
		else if(choice == 2){	
			System.out.println("��������ѡ������ɾ���ĶԱȳ�����");
			choice = sc.nextInt();
			System.out.println("ȷ��ɾ����1�� ȡ��ɾ����2����");
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
	 * �û�ע���ϲ���ĳ��������ղ�
	 * @param car
	 */
	public void addCollection(Car car){
		if(loginUser == null){
			System.out.println("��¼��ſ��Խ����������ղأ�");
			toLoginMainMenu();
		}
		else{
			boolean has = false;
			//�����ղس���ʱ�������ж��Ƿ��Ѿ��ղع��ó���
			for(int i = 0; i < loginUser.collectCars.length; i++){
				if(loginUser.collectCars[i] == car){
					has = true;
					break;
				}
			}
			//�Ѿ��ղع��ó�
			if(has){
				System.out.println("���Ѿ��ղع��ó���");
			}
			//�ó���δ���ղ�
			else{
				int i;
				//��ȡ���복����λ��
				for(i = 0; i < loginUser.collectCars.length; i++){
					if(loginUser.collectCars[i] == null){
						break;
					}
				}
				//���index�����������ĩβ����˵���û��ղ����������ж��Ƿ񽫵�һ������ɾ��
				if(i == loginUser.collectCars.length){
					System.out.println("�����ղس����Ѿ���10���������������ղس��������ղصĵ�һ�������������ղ��б���ɾ����");
					System.out.println("ȷ���ղأ�1�� ȡ���ղأ�2��:");
					choice = sc.nextInt();
					//��������ͼ��������ղأ����ղصĵ�һ�����ݽ��и���
					if(choice == 1){
						loginUser.collectCars[0] = car;
						System.out.println("�ѽ��ó����������ղأ�");
					}
					else{
						newestCarInfo();
					}
				}
				//�û��ղ���δ���������ղ�����
				else{
					loginUser.collectCars[i] = car;
					System.out.println("�ѽ��ó����������ղأ�");
				}
			}				
		}
		//�ղس��������һ������
		System.out.println("�鿴�ղأ�1�����¶��ֳ���Ϣ��2�� ���˵���3��:");
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
	 * ��ʾ�����Ĵ�����Ϣ
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
	 * У���û����ķ���
	 * @param userName
	 * @return
	 */
	public int validateUserName(String userName){
		//�ж��û����Ƿ����
		for(int i = 0; i < data.userData.length; i++){
			if(data.userData[i] != null){
				//��������û������û������е�ÿһ���û������бȽ�
				if(userName.equals(data.userData[i].userName)){
					return i;
				}
			}
		}
		return -1;
	}
	
	
	
	/**
	 * ���û�д��data�ķ���
	 * @param user
	 */
	public void insertUser(User user){
		for(int i = 0; i < data.userData.length; i++){
			//���������е�һ��Ϊnull��Ԫ��λ�ã���λ�ü�Ҫע��д��������±�
			if(data.userData[i] == null){
				data.userData[i] = user;
				break;
			}
		}
	}

	
	/**
	 * ������֤��ķ���
	 * @return
	 */
	public String seCode(){
		String str = "";
		int random = 0;
		//�������һ��0-9������
		for(int i = 1; i <=4; i++){
			random = (int)(Math.random() * 10);
			str += random;
		}
		return str;
	}
	
	
	
	/**
	 *  ��¼ʱ����֤�룬�û������������������Ƿ�������е�¼�����ķ���
	 *  ע��ʱ���û����ظ��������������벻һ�º��Ƿ��������ע������ķ���
	 */
	public void returnToLoginRegister(){
		System.out.println("��¼��1�� ע�ᣨ2�� �����棨3����");
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
			System.out.println("�Ƿ����ݣ������½��в�����");
			mainMenu();
		}
	}
	
	
	/**
	 * ���ݷ���ʱ��������������� ѡ������
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
	 * ��ʽ�����ʱ��ĸ�ʽ
	 */	
	public String timeFormat(Calendar calendar){
		//��ʽ��ʱ��  ������ʾʱ���еĵ�λ
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String time = format.format(calendar.getTime());
		return time;
	}
	
	
	/**
	 * ����Car��brandId��Brand��ȥ����brandName
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
	 * ����Car��typeId��CarType��ȥ����typeName
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
