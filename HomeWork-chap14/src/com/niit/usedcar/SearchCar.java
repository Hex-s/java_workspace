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
		//��ʼ�����ݿ�
		this.data = data;
		brandDao = new BrandDao(data);
		carDao = new CarDao(data);
		carTypeDao = new CarTypeDao(data);
		//��ʼ������
		initFrame();
		//��ʼ�����
		initComponent();
		//�󶨼�����
		bindListener();
	}
	
	/**
	 * ��ʼ�����
	 */
	private void initComponent(){
		//ʵ�������
		tapSearchCar = new JTabbedPane();
		btnSearch = new JButton("����");
		pnlSearchByBrand = new JPanel();
		pnlSearchByBrand.setLayout(null);
		pnlSearchByBoardTime = new JPanel();
		pnlSearchByBoardTime.setLayout(null);
		pnlSearchByPrice = new JPanel();
		pnlSearchByPrice.setLayout(null);
		cboBrand = new JComboBox();
		lblBrand = new JLabel("Ʒ��");
		lblCarType = new JLabel("����");
		btnSearch = new JButton("����");
		cboCarType = new JComboBox();
		lblStartDate = new JLabel("��ʼ����");
		lblEndDate = new JLabel("��������");
		cboStartYear = new JComboBox();
		cboStartMonth = new JComboBox();
		cboStartDay = new JComboBox();
		cboEndYear = new JComboBox();
		cboEndMonth = new JComboBox();
		cboEndDay = new JComboBox();
		cal = Calendar.getInstance();
		group = new ButtonGroup();
		lblPrice = new JLabel("�۸����");
		rdoPrice = new JRadioButton[4];

		/**************************����Ʒ������*********************************/
		//����Ʒ�������˵�
		//��ȡ���е�Ʒ��
		allBrandList = brandDao.findAllBrand();
		//��Ʒ�����Ƽ��뵽�����˵���
		for(int i = 0; i < allBrandList.size(); i++){
			cboBrand.addItem(allBrandList.get(i).getBrandName());
		}
		//������һ��Ʒ���µĳ��͵������˵�
		//��ȡƷ���µĳ���
		allCarTypeList = carTypeDao.findBrandCarType(allBrandList.get(0));
		for(int i = 0; i < allCarTypeList.size(); i++){
			cboCarType.addItem(allCarTypeList.get(i).getTypeName());
		}
		//Ʒ�����λ��
		tapSearchCar.setBounds(0, 0, 300, 250);
		btnSearch.setBounds(110, 260, 80, 40);
		lblBrand.setBounds(10, 10, 100, 15);
		cboBrand.setBounds(10, 26, 100, 20);
		lblCarType.setBounds(120, 10, 100, 15);
		cboCarType.setBounds(120, 26, 100, 20);
		//��Ʒ�������µ������ӵ�Ʒ�������
		pnlSearchByBrand.add(lblCarType);
		pnlSearchByBrand.add(lblBrand);
		pnlSearchByBrand.add(cboBrand);
		pnlSearchByBrand.add(cboCarType);
		
		/**************************����������������*********************************/
		//��ʼ����ʼ���
		int year = cal.get(Calendar.YEAR);
		for(int i = 1990; i <= year; i++){
			cboStartYear.addItem(i);
		}
		//��ʼ����ʼ�·�
		for(int i = 1; i <= 12 ; i++){
			cboStartMonth.addItem(i);
		}
		//��ʼ����ʼ����
		for(int i = 1; i <= 31; i++){
			cboStartDay.addItem(i);
		}
		//��ʼ���������
		for(int i = 1990; i <= year; i++){
			cboEndYear.addItem(i);
		}
		//��ʼ�������·�
		for(int i = 1; i <= 12 ; i++){
			cboEndMonth.addItem(i);
		}
		//��ʼ����������
		for(int i = 1; i <= 31; i++){
			cboEndDay.addItem(i);
		}

		//�����������λ��
		lblStartDate.setBounds(10, 10, 70, 20);
		cboStartYear.setBounds(10, 30, 70, 20);
		cboStartMonth.setBounds(95, 30, 50, 20);
		cboStartDay.setBounds(160, 30, 50, 20);
		lblEndDate.setBounds(10, 60, 70, 20);
		cboEndYear.setBounds(10, 80, 70, 20);
		cboEndMonth.setBounds(95, 80, 50, 20);
		cboEndDay.setBounds(160, 80, 50, 20);
		
		//���������������µ������ӵ��������������
		pnlSearchByBoardTime.add(lblStartDate);
		pnlSearchByBoardTime.add(cboStartYear);
		pnlSearchByBoardTime.add(cboStartMonth);
		pnlSearchByBoardTime.add(cboStartDay);
		pnlSearchByBoardTime.add(lblEndDate);
		pnlSearchByBoardTime.add(cboEndYear);
		pnlSearchByBoardTime.add(cboEndMonth);
		pnlSearchByBoardTime.add(cboEndDay);
		
		/**************************���ռ۸�����*********************************/
		lblPrice.setBounds(10, 10, 80, 20);
		//����ť�ӵ��۸������
		pnlSearchByPrice.add(lblPrice);
		//����ѡ��ť��ӵ���Ť����
		priceArray = new String[]{"5������","5-10��","10-15��","15������"};
		for(int i = 0 , y = 40; i < rdoPrice.length; i++ , y += 30){
			rdoPrice[i] = new JRadioButton(priceArray[i]);
			group.add(rdoPrice[i]);
			rdoPrice[i].setBounds(10, y, 100, 20);
			pnlSearchByPrice.add(rdoPrice[i]);
		}
		
		
		//�������ӵ�ѡ���
		tapSearchCar.add("Ʒ��",pnlSearchByBrand);
		tapSearchCar.add("����ʱ��", pnlSearchByBoardTime);
		tapSearchCar.add("�۸�",pnlSearchByPrice);
		
		this.add(btnSearch);
		this.add(tapSearchCar);
	}
	
	/**
	 * �󶨼�����
	 */
	private void bindListener(){
		//Ʒ���³��ͼ�����
		cboBrand.addItemListener(new BrandListener());
		cboStartYear.addItemListener(new StartYearListener());
		btnSearch.addActionListener(new searchCars());
		CboDaysListener cboDayListeneer = new CboDaysListener();
		cboStartMonth.addItemListener(cboDayListeneer);
		cboEndMonth.addItemListener(cboDayListeneer);
		
	}
	

	/**
	 * ѡ�ѡ����������
	 * @author Administrator
	 *
	 */
	private class searchCars implements ActionListener{
		
		String title = "";

		@Override
		public void actionPerformed(ActionEvent e) {
			//��ȡ��ǰѡ�����
			int index = tapSearchCar.getSelectedIndex();
			//index==0 Ʒ��
			if(index == 0){
				int choice = cboCarType.getSelectedIndex();
				CarType carType = allCarTypeList.get(choice);
				showCars = carDao.findCarTypeCar(carType);
				title = "��Ʒ������";
				
			}
			//index==1 ����ʱ��
			else if(index == 1){
				int startYear =(Integer) cboStartYear.getSelectedItem();
				int startMonth =(Integer) cboStartMonth.getSelectedItem();
				int startDay = (Integer)cboStartDay.getSelectedItem();
				int endYear = (Integer)cboEndYear.getSelectedItem();
				int endMonth = (Integer)cboEndMonth.getSelectedItem();
				int endDay = (Integer)cboEndDay.getSelectedItem();
				//��ȡ��ʼ���ںͽ�������
				Calendar startDate = Calendar.getInstance();
				Calendar endDate = Calendar.getInstance();
				startDate =CommonUtil.getCalendar(startYear, startMonth, startDay);
				endDate = CommonUtil.getCalendar(endYear, endMonth, endDay);
				showCars = carDao.findCarsByBoardTime(startDate, endDate);
				title = "������ʱ������";
			}
			//index==2 �۸�
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
				//�ж��Ƿ�����˼۸����ѡ��
				if(range > -1){
					//5������
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
					JOptionPane.showMessageDialog(SearchCar.this, "��ѡ��۸����");
					return;
				}
				title = "���۸�����";
			}
			
			//��������Ϣ���ܽ���
			CarInfo frm = new CarInfo(SearchCar.this);
			frm.setVisible(true);
			frm.setTitle(title);
			
		}

		
	}
	
	/**
	 * ����������ڿ�ʼ���
	 * @author Administrator
	 *
	 */
	private class StartYearListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			//�ж�ѡ����
			if(e.getStateChange() == ItemEvent.SELECTED){
				//��ս�����ݵ�ѡ��
				cboEndYear.removeAllItems();
				//��ȡ��ʼ���
				int startYear =(Integer) cboStartYear.getSelectedItem();
				for(int i = startYear; i<= cal.get(Calendar.YEAR); i++){
					cboEndYear.addItem(i);
				}
			}
		}
		
	}
	/**
	 * Ʒ���³��ͼ�����
	 * @author Administrator
	 *
	 */
	private class BrandListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			//�ж�ѡ����
			if(e.getStateChange() == ItemEvent.SELECTED){
				//��ճ��������б�
				cboCarType.removeAllItems();
				int index = cboBrand.getSelectedIndex();
				//��ȡѡ���Ʒ��
				Brand brand = allBrandList.get(index);
				//��ȡ��Ʒ���µĳ���
				allCarTypeList = carTypeDao.findBrandCarType(brand);
				for(int i = 0; i < allCarTypeList.size(); i++){
					cboCarType.addItem(allCarTypeList.get(i).getTypeName());
				}
			}
		}
		
	}
	/**
	 * ��ʼ������
	 */
	private void initFrame(){
		this.setSize(300, 350);
		this.setTitle("��������");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setBackground(Color.orange);
		this.setResizable(false);
	}
	
	
	/**
	 * �����б��е�day
	 * @author Administrator
	 *
	 */
	private class CboDaysListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			//�ж�ѡ����
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
	 * ���������е�����
	 */
	private void setDays(JComboBox cboYear, JComboBox cboMonth ,JComboBox cboDay){
		//�����е��������
		cboDay.removeAllItems();
		//��ȡѡ�е���
		int year =(Integer) cboYear.getSelectedItem();
		//��ȡѡ�е���
		int month =(Integer)cboMonth.getSelectedItem();
		//�������
		int days = daysInMonth(year, month);
		
		for(int i = 1; i <= days; i++){
			cboDay.addItem(i);
		}
	}
		
	/**
	 * ��ȡ���굱�µ�����
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
