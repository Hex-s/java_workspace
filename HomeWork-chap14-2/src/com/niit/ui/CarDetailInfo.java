package com.niit.ui;

import java.util.ArrayList;

import javax.jws.soap.SOAPBinding.Use;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.niit.bean.Car;
import com.niit.bean.User;
import com.niit.dao.impl.BrandDao;
import com.niit.dao.impl.CarDao;
import com.niit.dao.impl.CarTypeDao;
import com.niit.data.Data;
import com.niit.util.CommonUtil;

public class CarDetailInfo extends JFrame{
	
	private JScrollPane sclContainer;
	private String[] columnName;
	private JTable tabCarData;
	private DefaultTableModel model;
	private JButton btnCollect;
	private JButton btnBuy;
	private JButton btnCompare;
	private MainFrame mainFrm;
	private User loginUser;
	private Data data;
	private BrandDao brandDao;
	private CarTypeDao carTypeDao;
	private CarDao carDao;
	
	public CarDetailInfo(int carId,MainFrame mainFrm){
		this.mainFrm = mainFrm;
		this.loginUser = mainFrm.getLoginUser();
		this.data = mainFrm.getData();
		this.brandDao = new BrandDao(data);
		this.carTypeDao = new CarTypeDao(data);
		this.carDao = new CarDao(data);
		
		this.setSize(1000, 300);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		this.setResizable(false);
		//��ʼ�����
		initComponent();
		loadData(carId);
	}
	/**
	 * ��ʼ�����
	 */
	private void initComponent() {
		btnCollect = new JButton("�ղ�");
		btnBuy = new JButton("����");
		btnCompare = new JButton("�Ա�");
		
		//�����б���
		columnName = new String[]{"�������","Ʒ��","����","�����","�۸�","����ʱ��","����ʱ��","����","���������"};
		//����ģ��
		model = new DefaultTableModel(columnName,0);
		//ʵ����table��ʹ�䲻�ܽ����޸�
		tabCarData = new JTable(){

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tabCarData.setModel(model);
		//��ֹ�б�����ק
		tabCarData.getTableHeader().setReorderingAllowed(false);
		//���ñ���������ݾ��ж���
		((DefaultTableCellRenderer)tabCarData.getDefaultRenderer(Object.class)).setHorizontalAlignment(JLabel.CENTER);
		//���ñ���ѡ��ģʽ
		tabCarData.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//���ص�һ��
		CommonUtil.hidenFirstColum(tabCarData, 0);
		
		//ʵ�����������
		sclContainer = new JScrollPane();
		sclContainer.setBounds(0, 0, 1000, 200);
		sclContainer.getViewport().add(tabCarData);
		
		btnCollect.setBounds(330, 210, 70, 30);
		btnBuy.setBounds(450, 210, 70, 30);
		btnCompare.setBounds(570, 210, 70, 30);
		this.add(btnCollect);
		this.add(btnBuy);
		this.add(btnCompare);
		//��ӹ������
		this.add(sclContainer);
	}

	/**
	 * ��������
	 */
	private void loadData(int carId){
		
		Object[][] cars = new Object[1][];
		Car car = carDao.findCarByCarId(carId);
		cars[0] = new Object[]{car.getCarId()+"",brandDao.findBrandNameByBrandId(car.getBrandId()),
				carTypeDao.findCarTypeNameByCarTypeId(car.getTypeId()),
				car.getMileage()+"",car.getPrice()+"",
				CommonUtil.formatDate(car.getPublishTime()),
				CommonUtil.formatDate(car.getBoardTime()),
				car.getOutputVolume(),car.getClucthType()};
		//ͨ��ģ�Ͷ�����������Դ
		model.setDataVector(cars, columnName);
		//���ص�һ��
		CommonUtil.hidenFirstColum(tabCarData, 0);
	}
	
}
