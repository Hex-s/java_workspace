package com.niit.usedcar;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

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
import com.niit.dao.impl.BrandDao;
import com.niit.util.CommonUtil;

public class CarInfo extends JFrame{
	private SearchCar searchFrm;
	private Object[][] cars;
	private JScrollPane sclContainer;
	private String[] columnName;
	private JTable tabCarData;
	private DefaultTableModel model;
	private JLabel lblSearchWay;
	
	public CarInfo(SearchCar searchFrm){
		this.searchFrm = searchFrm;
		this.setSize(800, 300);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		this.setResizable(false);
		//��ʼ�����
		initComponent();
		//���ر������
		loadData(searchFrm.getShowCars());
	}

	/**
	 * ��ʼ�����
	 */
	private void initComponent() {
		
		//�����б���
		columnName = new String[]{"�������","Ʒ��","����","�����","�۸�","����ʱ��","����ʱ��"};
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
		//���ñ���ѡ��ģʽ
		tabCarData.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//���ñ���������ݾ��ж���
		((DefaultTableCellRenderer)tabCarData.getDefaultRenderer(Object.class)).setHorizontalAlignment(JLabel.CENTER);
		tabCarData.addMouseListener(new detailListener());
		//���ص�һ��
		hidenFirstColum();
		//ʵ�����������
		sclContainer = new JScrollPane();
		sclContainer.setBounds(0, 0, 800, 230);
		sclContainer.getViewport().add(tabCarData);
		lblSearchWay = new JLabel("˫���鿴������ϸ��Ϣ");
		lblSearchWay.setBounds(0, 230, 200, 50);
		//��ӹ������
		this.add(sclContainer);
		this.add(lblSearchWay);
		
	}
	
	/**
	 * ˫����ȡ������ϸ��Ϣ
	 * @author Administrator
	 *
	 */
	private class detailListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount() == 2){//��ȡѡ����ı��
				int carId = (Integer)model.getValueAt(tabCarData.getSelectedRow(), 0);
				int index =(Integer) model.getValueAt(tabCarData.getSelectedRow(), 0);
//				System.out.println(carId);
				CarDetailInfo frm = new CarDetailInfo(carId,searchFrm);
				frm.setVisible(true);
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	/**
	 * ���ر������
	 */
	private void loadData(ArrayList<Car> showCars){
		//��������Ϣ����ת���ɶ�ά����
		cars = new Object[showCars.size()][];
		//��������
		for(int i = 0; i < showCars.size(); i++){
			Car car = showCars.get(i);
			//��ÿ��ѧ������Ϣ����д���ά����
			cars[i] = new Object[]{car.getCarId(),searchFrm.getBrandDao().findBrandNameByBrandId(car.getBrandId()),
					searchFrm.getCarTypeDao().findCarTypeNameByCarTypeId(car.getTypeId()),
							car.getMileage(),car.getPrice(),CommonUtil.formatDate(car.getPublishTime()),CommonUtil.formatDate(car.getBoardTime())};
		}
		//ͨ��ģ�Ͷ�����������Դ
		model.setDataVector(cars, columnName);
		//���ص�һ��
		hidenFirstColum();
	}
	/**
	 * ���ص�һ��
	 */
	private void hidenFirstColum(){
		//���ص�һ��
		TableColumn firstColumn = tabCarData.getColumnModel().getColumn(0);
		firstColumn.setMinWidth(0);
		firstColumn.setMaxWidth(0);
		firstColumn.setPreferredWidth(0);
	}

}
