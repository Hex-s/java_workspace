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
		//初始化组件
		initComponent();
		//下载表格数据
		loadData(searchFrm.getShowCars());
	}

	/**
	 * 初始化组件
	 */
	private void initComponent() {
		
		//创建列标题
		columnName = new String[]{"汽车编号","品牌","车型","里程数","价格","发布时间","上牌时间"};
		//构造模型
		model = new DefaultTableModel(columnName,0);
		//实例化table是使其不能进行修改
		tabCarData = new JTable(){

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tabCarData.setModel(model);
		//禁止列标题拖拽
		tabCarData.getTableHeader().setReorderingAllowed(false);
		//设置表格的选择模式
		tabCarData.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//设置表格数据内容居中对齐
		((DefaultTableCellRenderer)tabCarData.getDefaultRenderer(Object.class)).setHorizontalAlignment(JLabel.CENTER);
		tabCarData.addMouseListener(new detailListener());
		//隐藏第一列
		hidenFirstColum();
		//实例化滑动面板
		sclContainer = new JScrollPane();
		sclContainer.setBounds(0, 0, 800, 230);
		sclContainer.getViewport().add(tabCarData);
		lblSearchWay = new JLabel("双击查看汽车详细信息");
		lblSearchWay.setBounds(0, 230, 200, 50);
		//添加滚动面板
		this.add(sclContainer);
		this.add(lblSearchWay);
		
	}
	
	/**
	 * 双击获取汽车详细信息
	 * @author Administrator
	 *
	 */
	private class detailListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount() == 2){//获取选中项的编号
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
	 * 下载表格数据
	 */
	private void loadData(ArrayList<Car> showCars){
		//将汽车信息集合转换成二维数组
		cars = new Object[showCars.size()][];
		//遍历集合
		for(int i = 0; i < showCars.size(); i++){
			Car car = showCars.get(i);
			//将每个学生的信息依次写入二维数组
			cars[i] = new Object[]{car.getCarId(),searchFrm.getBrandDao().findBrandNameByBrandId(car.getBrandId()),
					searchFrm.getCarTypeDao().findCarTypeNameByCarTypeId(car.getTypeId()),
							car.getMileage(),car.getPrice(),CommonUtil.formatDate(car.getPublishTime()),CommonUtil.formatDate(car.getBoardTime())};
		}
		//通过模型对象重载数据源
		model.setDataVector(cars, columnName);
		//隐藏第一列
		hidenFirstColum();
	}
	/**
	 * 隐藏第一列
	 */
	private void hidenFirstColum(){
		//隐藏第一列
		TableColumn firstColumn = tabCarData.getColumnModel().getColumn(0);
		firstColumn.setMinWidth(0);
		firstColumn.setMaxWidth(0);
		firstColumn.setPreferredWidth(0);
	}

}
