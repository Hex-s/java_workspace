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
		//��ʼ������
		brandDao = new BrandDao(mainFrm.getData());
		carDao = new CarDao(mainFrm.getData());
		cartypeDao = new CarTypeDao(mainFrm.getData());
		this.mainFrm = mainFrm;
		this.setSize(500, 700);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setTitle("�޸�������Ϣ");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//��ʼ�����
		initComponent(carId, mainFrm);
		//�󶨼�����
		bindListener();
	}

	/**
	 * �󶨼�����
	 */
	private void bindListener() {
		cboBoardMonth.addItemListener(new CboDaysListener());
		cboBrand.addItemListener(new BrandListener());
		BtnListener btnListener = new BtnListener();
		btnSave.addActionListener(btnListener);
		btnCancel.addActionListener(btnListener);
	}

	/**
	 * ��ʼ�����
	 */
	private void initComponent(int carId, MainFrame mainFrm) {
		//��ʼ����������
		lblArray = new String[]{"���","Ʒ��","����","����","���","�۸�","�����","����ʱ��"};
		//�������飬��������
		lbl = new JLabel[lblArray.length];
		for(int i = 0, y = 10; i < lblArray.length; i++ , y+=70){
			lbl[i] = new JLabel(lblArray[i]);
			//���ñ���λ�úʹ�С
			lbl[i].setBounds(30, y, 70, 20);
			//��������뵽������
			this.add(lbl[i]);
		}
		car = carDao.findCarByCarId(carId);
		lblCarId = new JLabel(car.getCarId()+"");
		lblCarId.setBounds(110, 10, 100, 20);
		//����Ʒ�������б�
		cboBrand = new JComboBox();
		ArrayList<Brand> allbrand = brandDao.findAllBrand();
		for(int i = 0; i < allbrand.size(); i++){
			cboBrand.addItem(allbrand.get(i).getBrandName());
		}
		//��������Ʒ������ΪĬ��ѡ����
		cboBrand.setSelectedIndex(car.getBrandId()-1);
		//����Ʒ�������б��λ��
		cboBrand.setBounds(110, 80, 100, 20);
		
		//�������������б�
		cboCarType = new JComboBox();
		ArrayList<CarType> allCarType = cartypeDao.findBrandCarType(car.getBrandId());
		
		for(int i = 0; i < allCarType.size(); i++){
			cboCarType.addItem(allCarType.get(i).getTypeName());
			if(car.getTypeId() == allCarType.get(i).getTypeId()){
				cboCarType.setSelectedIndex(i);
			}
		}
		cboCarType.setBounds(110, 150, 100, 20);
		//�����ı���
		txtOutput = new JTextField(car.getOutputVolume()+"");
		txtMileage = new JTextField(car.getMileage()+"");
		txtPrice = new JTextField(car.getPrice()+"");
		txtOutput.setBounds(110, 220, 100, 20);
		txtMileage.setBounds(110, 290, 100, 20);
		txtPrice.setBounds(110,360, 100, 20);
		//�����������ѡ��ť
		group = new ButtonGroup();
		rdoClutch = new JRadioButton[2];
		rdoArray = new String[]{"�ֶ���","�Զ���"};
		for(int i = 0 , x = 110; i < rdoClutch.length; i++ , x+=90){
			rdoClutch[i] = new JRadioButton(rdoArray[i]);
			rdoClutch[i].setBounds(x, 430, 80, 20);
			group.add(rdoClutch[i]);
			this.add(rdoClutch[i]);
			if(rdoClutch[i].getText().trim().equals(car.getClucthType().trim())){
				rdoClutch[i].setSelected(true);
			}
		}
		//��ʼ���������
		cboBoardDay = new JComboBox();
		cboBoardMonth = new JComboBox();
		cboBoardYear = new JComboBox();
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		for(int i = 1990; i <= year; i++){
			cboBoardYear.addItem(i);
		}
		//��ʼ����ʼ�·�
		for(int i = 1; i <= 12 ; i++){
			cboBoardMonth.addItem(i);
		}
		//��ʼ����ʼ����
		for(int i = 1; i <= 31; i++){
			cboBoardDay.addItem(i);
		}
		cboBoardYear.setSelectedItem(car.getBoardTime().get(Calendar.YEAR));
		cboBoardMonth.setSelectedItem(car.getBoardTime().get(Calendar.MONTH)+1);
		cboBoardDay.setSelectedItem(car.getBoardTime().get(Calendar.DATE));
		cboBoardYear.setBounds(110, 500, 70, 20);
		cboBoardMonth.setBounds(190, 500, 70, 20);
		cboBoardDay.setBounds(270, 500, 70, 20);
		//ʵ�������� ȡ����ť
		btnSave = new JButton("����");
		btnCancel = new JButton("ȡ��");
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
	 * ����������Ϣ�޸�����
	 * @author Administrator
	 *
	 */
	private class BtnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			//���水ť
			if(btn == btnSave){
				//��ȡcarId
				int carId = car.getCarId();
				//��ȡbrandId
				int brandId = cboBrand.getSelectedIndex()+1;
				ArrayList<CarType> allCartypeList = cartypeDao.findBrandCarType(brandId);
				//��ȡtypeId
				int typeId = allCartypeList.get(cboCarType.getSelectedIndex()).getTypeId();
				//��ȡ����
				double output = Double.parseDouble(txtOutput.getText().toString()); 
				//��ȡ�����
				long mileage = Long.parseLong(txtMileage.getText().toString());
				//��ȡ�۸�
				int price = Integer.parseInt(txtPrice.getText().toString());
				//��ȡ���������
				String clutch = "";
				for(int i = 0; i < rdoClutch.length; i++){
					if(rdoClutch[i].isSelected()){
						clutch = rdoClutch[i].getText();
						break;
					}
				}
				//��ȡ����ʱ��
				int year =(Integer) cboBoardYear.getSelectedItem();
				int month = (Integer)cboBoardMonth.getSelectedItem();
				int day = (Integer) cboBoardDay.getSelectedItem();
				Calendar boardTime = CommonUtil.getCalendar(year, month, day);
				Calendar publishTime = Calendar.getInstance();
				//�����µ���������
				Car newCar = new Car(brandId,typeId,output,mileage,price,clutch,boardTime,publishTime,false);
				newCar.setCarId(carId);
				//�޸ĳ�����Ϣ
				carDao.deleteCar(car);
				carDao.add(newCar);
				//ˢ������
				mainFrm.loadData(mainFrm.getSelectedNode());
				modifyCar.this.dispose();
			}
			else{
				modifyCar.this.dispose();
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
				ArrayList<Brand> allBrandList = brandDao.findAllBrand();
				ArrayList<CarType> allCartypeList = new ArrayList<CarType>();
				//��ճ��������б�
				cboCarType.removeAllItems();
				int index = cboBrand.getSelectedIndex();
				//��ȡѡ���Ʒ��
				Brand brand = allBrandList.get(index);
				//��ȡ��Ʒ���µĳ���
				allCartypeList = cartypeDao.findBrandCarType(brand);
				for(int i = 0; i < allCartypeList.size(); i++){
					cboCarType.addItem(allCartypeList.get(i).getTypeName());
				}
			}
		}
		
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
				setDays(cboBoardYear, cboBoardMonth, cboBoardDay);
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
			int days = CommonUtil.getDaysInMonth(year, month);
			for(int i = 1; i <= days; i++){
				cboDay.addItem(i);
			}
		}
	
	}	
	
}
