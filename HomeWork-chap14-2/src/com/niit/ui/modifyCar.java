package com.niit.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.tree.DefaultMutableTreeNode;

import com.niit.bean.Brand;
import com.niit.bean.Car;
import com.niit.bean.CarType;
import com.niit.dao.impl.BrandDao;
import com.niit.dao.impl.CarDao;
import com.niit.dao.impl.CarTypeDao;
import com.niit.data.Data;
import com.niit.util.CommonUtil;

public class modifyCar extends JFrame{
	
	private JLabel[] lbl;
	private String[] lblArray;
	private JLabel lblCarId;
	private ButtonGroup group;
	private JRadioButton[] rdoClutch;
	private JComboBox cboBrand;
	private String[] rdoArray;
	private JComboBox cboCarType;
	private JTextField txtOutput;
	private JTextField txtMileage;
	private JTextField txtPrice;
	private BrandDao brandDao;
	private CarDao carDao;
	private CarTypeDao cartypeDao;
	private JComboBox cboBoardYear;
	private JComboBox cboBoardMonth;
	private JComboBox cboBoardDay;
	private JButton btnSave;
	private JButton btnCancel;
	private MainFrame mainFrm;
	private Car car;
	
	//int carId, MainFrame mainFrm
	public modifyCar(int carId, MainFrame mainFrm){
		//初始化数据
		brandDao = new BrandDao(mainFrm.getData());
		carDao = new CarDao(mainFrm.getData());
		cartypeDao = new CarTypeDao(mainFrm.getData());
		this.mainFrm = mainFrm;
		this.setSize(500, 700);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setTitle("修改汽车信息");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//初始化组件
		initComponent(carId, mainFrm);
		//绑定监听器
		bindListener();
	}

	/**
	 * 绑定监听器
	 */
	private void bindListener() {
		cboBoardMonth.addItemListener(new CboDaysListener());
		cboBrand.addItemListener(new BrandListener());
		BtnListener btnListener = new BtnListener();
		btnSave.addActionListener(btnListener);
		btnCancel.addActionListener(btnListener);
	}

	/**
	 * 初始化组件
	 */
	private void initComponent(int carId, MainFrame mainFrm) {
		//初始化标题数组
		lblArray = new String[]{"编号","品牌","车型","排量","里程","价格","离合器","上牌时间"};
		//遍历数组，构建标题
		lbl = new JLabel[lblArray.length];
		for(int i = 0, y = 10; i < lblArray.length; i++ , y+=70){
			lbl[i] = new JLabel(lblArray[i]);
			//设置标题位置和大小
			lbl[i].setBounds(30, y, 70, 20);
			//将标题加入到界面中
			this.add(lbl[i]);
		}
		car = carDao.findCarByCarId(carId);
		lblCarId = new JLabel(car.getCarId()+"");
		lblCarId.setBounds(110, 10, 100, 20);
		//构建品牌下拉列表
		cboBrand = new JComboBox();
		ArrayList<Brand> allbrand = brandDao.findAllBrand();
		for(int i = 0; i < allbrand.size(); i++){
			cboBrand.addItem(allbrand.get(i).getBrandName());
		}
		//将汽车的品牌设置为默认选择项
		cboBrand.setSelectedIndex(car.getBrandId()-1);
		//设置品牌下拉列表的位置
		cboBrand.setBounds(110, 80, 100, 20);
		
		//构建车型下拉列表
		cboCarType = new JComboBox();
		ArrayList<CarType> allCarType = cartypeDao.findBrandCarType(car.getBrandId());
		
		for(int i = 0; i < allCarType.size(); i++){
			cboCarType.addItem(allCarType.get(i).getTypeName());
			if(car.getTypeId() == allCarType.get(i).getTypeId()){
				cboCarType.setSelectedIndex(i);
			}
		}
		cboCarType.setBounds(110, 150, 100, 20);
		//构架文本框
		txtOutput = new JTextField(car.getOutputVolume()+"");
		txtMileage = new JTextField(car.getMileage()+"");
		txtPrice = new JTextField(car.getPrice()+"");
		txtOutput.setBounds(110, 220, 100, 20);
		txtMileage.setBounds(110, 290, 100, 20);
		txtPrice.setBounds(110,360, 100, 20);
		//构建离合器单选按钮
		group = new ButtonGroup();
		rdoClutch = new JRadioButton[2];
		rdoArray = new String[]{"手动档","自动档"};
		for(int i = 0 , x = 110; i < rdoClutch.length; i++ , x+=90){
			rdoClutch[i] = new JRadioButton(rdoArray[i]);
			rdoClutch[i].setBounds(x, 430, 80, 20);
			group.add(rdoClutch[i]);
			this.add(rdoClutch[i]);
			if(rdoClutch[i].getText().trim().equals(car.getClucthType().trim())){
				rdoClutch[i].setSelected(true);
			}
		}
		//初始化上牌年份
		cboBoardDay = new JComboBox();
		cboBoardMonth = new JComboBox();
		cboBoardYear = new JComboBox();
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		for(int i = 1990; i <= year; i++){
			cboBoardYear.addItem(i);
		}
		//初始化开始月份
		for(int i = 1; i <= 12 ; i++){
			cboBoardMonth.addItem(i);
		}
		//初始化开始日子
		for(int i = 1; i <= 31; i++){
			cboBoardDay.addItem(i);
		}
		cboBoardYear.setSelectedItem(car.getBoardTime().get(Calendar.YEAR));
		cboBoardMonth.setSelectedItem(car.getBoardTime().get(Calendar.MONTH)+1);
		cboBoardDay.setSelectedItem(car.getBoardTime().get(Calendar.DATE));
		cboBoardYear.setBounds(110, 500, 70, 20);
		cboBoardMonth.setBounds(190, 500, 70, 20);
		cboBoardDay.setBounds(270, 500, 70, 20);
		//实例化保存 取消按钮
		btnSave = new JButton("保存");
		btnCancel = new JButton("取消");
		btnSave.setBounds(120, 600, 70, 20);
		btnCancel.setBounds(240, 600, 70, 20);
		
		this.add(lblCarId);
		this.add(btnSave);
		this.add(btnCancel);
		this.add(cboBoardYear);
		this.add(cboBoardMonth);
		this.add(cboBoardDay);
		this.add(cboBrand);
		this.add(cboCarType);
		this.add(txtMileage);
		this.add(txtOutput);
		this.add(txtPrice);
	}

	/**
	 * 保存汽车信息修改内容
	 * @author Administrator
	 *
	 */
	private class BtnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			//保存按钮
			if(btn == btnSave){
				//获取carId
				int carId = car.getCarId();
				//获取brandId
				int brandId = cboBrand.getSelectedIndex()+1;
				ArrayList<CarType> allCartypeList = cartypeDao.findBrandCarType(brandId);
				//获取typeId
				int typeId = allCartypeList.get(cboCarType.getSelectedIndex()).getTypeId();
				//获取排量
				double output = Double.parseDouble(txtOutput.getText().toString()); 
				//获取里程数
				long mileage = Long.parseLong(txtMileage.getText().toString());
				//获取价格
				int price = Integer.parseInt(txtPrice.getText().toString());
				//获取离合器类型
				String clutch = "";
				for(int i = 0; i < rdoClutch.length; i++){
					if(rdoClutch[i].isSelected()){
						clutch = rdoClutch[i].getText();
						break;
					}
				}
				//获取上牌时间
				int year =(Integer) cboBoardYear.getSelectedItem();
				int month = (Integer)cboBoardMonth.getSelectedItem();
				int day = (Integer) cboBoardDay.getSelectedItem();
				Calendar boardTime = CommonUtil.getCalendar(year, month, day);
				Calendar publishTime = Calendar.getInstance();
				//构建新的汽车对象
				Car newCar = new Car(brandId,typeId,output,mileage,price,clutch,boardTime,publishTime,false);
				newCar.setCarId(carId);
				//修改车辆信息
				carDao.deleteCar(car);
				carDao.add(newCar);
				//刷新数据
				mainFrm.loadData(mainFrm.getSelectedNode());
				modifyCar.this.dispose();
			}
			else{
				modifyCar.this.dispose();
			}
				
			
		}

	}
	
	/**
	 * 品牌下车型监听器
	 * @author Administrator
	 *
	 */
	private class BrandListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			//判断选项变更
			if(e.getStateChange() == ItemEvent.SELECTED){
				ArrayList<Brand> allBrandList = brandDao.findAllBrand();
				ArrayList<CarType> allCartypeList = new ArrayList<CarType>();
				//清空车型下拉列表
				cboCarType.removeAllItems();
				int index = cboBrand.getSelectedIndex();
				//获取选择的品牌
				Brand brand = allBrandList.get(index);
				//获取该品牌下的车型
				allCartypeList = cartypeDao.findBrandCarType(brand);
				for(int i = 0; i < allCartypeList.size(); i++){
					cboCarType.addItem(allCartypeList.get(i).getTypeName());
				}
			}
		}
		
	}
	/**
	 * 下拉列表中的day
	 * @author Administrator
	 *
	 */
	private class CboDaysListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			//判断选中项
			if(e.getStateChange() == ItemEvent.SELECTED){
				setDays(cboBoardYear, cboBoardMonth, cboBoardDay);
			}
		}
		
		/**
		 * 设置日子中的天数
		 */
		private void setDays(JComboBox cboYear, JComboBox cboMonth ,JComboBox cboDay){
			//将日中的数据清空
			cboDay.removeAllItems();
			//获取选中的年
			int year =(Integer) cboYear.getSelectedItem();
			//获取选中的月
			int month =(Integer)cboMonth.getSelectedItem();
			//添加日期
			int days = CommonUtil.getDaysInMonth(year, month);
			for(int i = 1; i <= days; i++){
				cboDay.addItem(i);
			}
		}
	
	}	
	
}
