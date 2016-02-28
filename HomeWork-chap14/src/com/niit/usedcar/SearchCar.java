package com.niit.usedcar;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.niit.bean.Brand;
import com.niit.bean.Car;
import com.niit.bean.CarType;
import com.niit.dao.impl.BrandDao;
import com.niit.dao.impl.CarDao;
import com.niit.dao.impl.CarTypeDao;
import com.niit.data.Data;
import com.niit.util.CommonUtil;

public class SearchCar extends JFrame{

	private Data data;
	private JTabbedPane tapSearchCar;
	private JPanel pnlSearchByBrand;
	private JPanel pnlSearchByBoardTime;
	private JPanel pnlSearchByPrice;
	private JComboBox cboBrand;
	private JComboBox cboCarType;
	private BrandDao brandDao;
	private CarTypeDao carTypeDao;
	private CarDao carDao;
	private Brand[] allBrand;
	private JLabel lblBrand;
	private JLabel lblCarType;
	private JButton btnSearch;
	private ArrayList<Brand> allBrandList;
	private ArrayList<CarType> allCarTypeList;
	private JComboBox cboStartYear;
	private JComboBox cboStartMonth;
	private JComboBox cboStartDay;
	private JComboBox cboEndYear;
	private JComboBox cboEndMonth;
	private JComboBox cboEndDay;
	private JLabel lblStartDate;
	private JLabel lblEndDate;
	private Calendar cal;
	private JLabel lblPrice;
	private ButtonGroup group;
	private JRadioButton[] rdoPrice;
	private String[] priceArray;
	private ArrayList<Car> showCars;
	
	public SearchCar(Data data){
		//初始化数据库
		this.data = data;
		brandDao = new BrandDao(data);
		carDao = new CarDao(data);
		carTypeDao = new CarTypeDao(data);
		//初始化窗体
		initFrame();
		//初始化组件
		initComponent();
		//绑定监听器
		bindListener();
	}
	
	/**
	 * 初始化组件
	 */
	private void initComponent(){
		//实例化组件
		tapSearchCar = new JTabbedPane();
		btnSearch = new JButton("搜索");
		pnlSearchByBrand = new JPanel();
		pnlSearchByBrand.setLayout(null);
		pnlSearchByBoardTime = new JPanel();
		pnlSearchByBoardTime.setLayout(null);
		pnlSearchByPrice = new JPanel();
		pnlSearchByPrice.setLayout(null);
		cboBrand = new JComboBox();
		lblBrand = new JLabel("品牌");
		lblCarType = new JLabel("车型");
		btnSearch = new JButton("搜索");
		cboCarType = new JComboBox();
		lblStartDate = new JLabel("开始日期");
		lblEndDate = new JLabel("结束日期");
		cboStartYear = new JComboBox();
		cboStartMonth = new JComboBox();
		cboStartDay = new JComboBox();
		cboEndYear = new JComboBox();
		cboEndMonth = new JComboBox();
		cboEndDay = new JComboBox();
		cal = Calendar.getInstance();
		group = new ButtonGroup();
		lblPrice = new JLabel("价格分区");
		rdoPrice = new JRadioButton[4];

		/**************************按照品牌搜索*********************************/
		//构建品牌下拉菜单
		//获取所有的品牌
		allBrandList = brandDao.findAllBrand();
		//将品牌名称加入到下拉菜单中
		for(int i = 0; i < allBrandList.size(); i++){
			cboBrand.addItem(allBrandList.get(i).getBrandName());
		}
		//构建第一个品牌下的车型的下拉菜单
		//获取品牌下的车型
		allCarTypeList = carTypeDao.findBrandCarType(allBrandList.get(0));
		for(int i = 0; i < allCarTypeList.size(); i++){
			cboCarType.addItem(allCarTypeList.get(i).getTypeName());
		}
		//品牌组件位置
		tapSearchCar.setBounds(0, 0, 300, 250);
		btnSearch.setBounds(110, 260, 80, 40);
		lblBrand.setBounds(10, 10, 100, 15);
		cboBrand.setBounds(10, 26, 100, 20);
		lblCarType.setBounds(120, 10, 100, 15);
		cboCarType.setBounds(120, 26, 100, 20);
		//将品牌搜索下的组件添加到品牌面板中
		pnlSearchByBrand.add(lblCarType);
		pnlSearchByBrand.add(lblBrand);
		pnlSearchByBrand.add(cboBrand);
		pnlSearchByBrand.add(cboCarType);
		
		/**************************按照上牌日期搜索*********************************/
		//初始化开始年份
		int year = cal.get(Calendar.YEAR);
		for(int i = 1990; i <= year; i++){
			cboStartYear.addItem(i);
		}
		//初始化开始月份
		for(int i = 1; i <= 12 ; i++){
			cboStartMonth.addItem(i);
		}
		//初始化开始日子
		for(int i = 1; i <= 31; i++){
			cboStartDay.addItem(i);
		}
		//初始化结束年份
		for(int i = 1990; i <= year; i++){
			cboEndYear.addItem(i);
		}
		//初始化结束月份
		for(int i = 1; i <= 12 ; i++){
			cboEndMonth.addItem(i);
		}
		//初始化结束日子
		for(int i = 1; i <= 31; i++){
			cboEndDay.addItem(i);
		}

		//上牌日期组件位置
		lblStartDate.setBounds(10, 10, 70, 20);
		cboStartYear.setBounds(10, 30, 70, 20);
		cboStartMonth.setBounds(95, 30, 50, 20);
		cboStartDay.setBounds(160, 30, 50, 20);
		lblEndDate.setBounds(10, 60, 70, 20);
		cboEndYear.setBounds(10, 80, 70, 20);
		cboEndMonth.setBounds(95, 80, 50, 20);
		cboEndDay.setBounds(160, 80, 50, 20);
		
		//将上牌日期搜索下的组件添加到上牌日期面板中
		pnlSearchByBoardTime.add(lblStartDate);
		pnlSearchByBoardTime.add(cboStartYear);
		pnlSearchByBoardTime.add(cboStartMonth);
		pnlSearchByBoardTime.add(cboStartDay);
		pnlSearchByBoardTime.add(lblEndDate);
		pnlSearchByBoardTime.add(cboEndYear);
		pnlSearchByBoardTime.add(cboEndMonth);
		pnlSearchByBoardTime.add(cboEndDay);
		
		/**************************按照价格搜索*********************************/
		lblPrice.setBounds(10, 10, 80, 20);
		//将按钮加到价格面板中
		pnlSearchByPrice.add(lblPrice);
		//将单选按钮添加到按扭组中
		priceArray = new String[]{"5万以下","5-10万","10-15万","15万以上"};
		for(int i = 0 , y = 40; i < rdoPrice.length; i++ , y += 30){
			rdoPrice[i] = new JRadioButton(priceArray[i]);
			group.add(rdoPrice[i]);
			rdoPrice[i].setBounds(10, y, 100, 20);
			pnlSearchByPrice.add(rdoPrice[i]);
		}
		
		
		//将组件添加到选项卡里
		tapSearchCar.add("品牌",pnlSearchByBrand);
		tapSearchCar.add("上牌时间", pnlSearchByBoardTime);
		tapSearchCar.add("价格",pnlSearchByPrice);
		
		this.add(btnSearch);
		this.add(tapSearchCar);
	}
	
	/**
	 * 绑定监听器
	 */
	private void bindListener(){
		//品牌下车型监听器
		cboBrand.addItemListener(new BrandListener());
		cboStartYear.addItemListener(new StartYearListener());
		btnSearch.addActionListener(new searchCars());
		CboDaysListener cboDayListeneer = new CboDaysListener();
		cboStartMonth.addItemListener(cboDayListeneer);
		cboEndMonth.addItemListener(cboDayListeneer);
		
	}
	

	/**
	 * 选项卡选项变更监听器
	 * @author Administrator
	 *
	 */
	private class searchCars implements ActionListener{
		
		String title = "";

		@Override
		public void actionPerformed(ActionEvent e) {
			//获取当前选项卡界面
			int index = tapSearchCar.getSelectedIndex();
			//index==0 品牌
			if(index == 0){
				int choice = cboCarType.getSelectedIndex();
				CarType carType = allCarTypeList.get(choice);
				showCars = carDao.findCarTypeCar(carType);
				title = "按品牌搜索";
				
			}
			//index==1 上牌时间
			else if(index == 1){
				int startYear =(Integer) cboStartYear.getSelectedItem();
				int startMonth =(Integer) cboStartMonth.getSelectedItem();
				int startDay = (Integer)cboStartDay.getSelectedItem();
				int endYear = (Integer)cboEndYear.getSelectedItem();
				int endMonth = (Integer)cboEndMonth.getSelectedItem();
				int endDay = (Integer)cboEndDay.getSelectedItem();
				//获取开始日期和结束日期
				Calendar startDate = Calendar.getInstance();
				Calendar endDate = Calendar.getInstance();
				startDate =CommonUtil.getCalendar(startYear, startMonth, startDay);
				endDate = CommonUtil.getCalendar(endYear, endMonth, endDay);
				showCars = carDao.findCarsByBoardTime(startDate, endDate);
				title = "按上牌时间搜索";
			}
			//index==2 价格
			else if(index == 2){
				int range = -1;
				int low = 0;
				int up = 99999999;
				for(int i = 0; i < rdoPrice.length; i++){
					if(rdoPrice[i].isSelected()){
						range = i;
						break;
					}
				}
				//判断是否进行了价格分区选择
				if(range > -1){
					//5万以下
					if(range == 0){
						up = 50000;
					}
					else if(range == 1){
						low = 50001;
						up = 100000;
					}
					else if(range == 2){
						low = 100001;
						up = 150000;
					}
					else{
						low = 150001;
					}
					showCars = carDao.findCarsByPrice(low, up);
				}
				else{
					JOptionPane.showMessageDialog(SearchCar.this, "请选择价格分区");
					return;
				}
				title = "按价格搜索";
			}
			
			//打开汽车信息介绍界面
			CarInfo frm = new CarInfo(SearchCar.this);
			frm.setVisible(true);
			frm.setTitle(title);
			
		}

		
	}
	
	/**
	 * 结束年份晚于开始年份
	 * @author Administrator
	 *
	 */
	private class StartYearListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			//判断选项变更
			if(e.getStateChange() == ItemEvent.SELECTED){
				//清空结束年份的选项
				cboEndYear.removeAllItems();
				//获取开始年份
				int startYear =(Integer) cboStartYear.getSelectedItem();
				for(int i = startYear; i<= cal.get(Calendar.YEAR); i++){
					cboEndYear.addItem(i);
				}
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
				//清空车型下拉列表
				cboCarType.removeAllItems();
				int index = cboBrand.getSelectedIndex();
				//获取选择的品牌
				Brand brand = allBrandList.get(index);
				//获取该品牌下的车型
				allCarTypeList = carTypeDao.findBrandCarType(brand);
				for(int i = 0; i < allCarTypeList.size(); i++){
					cboCarType.addItem(allCarTypeList.get(i).getTypeName());
				}
			}
		}
		
	}
	/**
	 * 初始化窗体
	 */
	private void initFrame(){
		this.setSize(300, 350);
		this.setTitle("搜索汽车");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setBackground(Color.orange);
		this.setResizable(false);
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
				JComboBox cbo = (JComboBox)e.getSource();
				if(cbo == cboStartMonth){
					setDays(cboStartYear, cboStartMonth, cboStartDay);
				}
				else{
					setDays(cboEndYear, cboEndMonth, cboEndDay);
				}
			}
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
		int days = daysInMonth(year, month);
		
		for(int i = 1; i <= days; i++){
			cboDay.addItem(i);
		}
	}
		
	/**
	 * 获取当年当月的天数
	 * @param year
	 * @param month
	 * @return
	 */
	private int daysInMonth(int year,int month){
		int days = 0;
		switch(month){
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;
		case 2:
			if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
				days = 29;
			}
			else{
				days = 28;
			}
			break;
		default:
			days = 31;	
		}
		return days;
	}
	

	public BrandDao getBrandDao() {
		return brandDao;
	}

	public CarTypeDao getCarTypeDao() {
		return carTypeDao;
	}

	public CarDao getCarDao() {
		return carDao;
	}

	public ArrayList<Car> getShowCars() {
		return showCars;
	}
		
}
