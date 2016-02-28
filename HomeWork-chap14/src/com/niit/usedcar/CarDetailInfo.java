package com.niit.usedcar;

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
import com.niit.util.CommonUtil;

public class CarDetailInfo extends JFrame{
	
	private SearchCar searchFrm;
	private JScrollPane sclContainer;
	private String[] columnName;
	private JTable tabCarData;
	private DefaultTableModel model;
	private JButton btnCollect;
	private JButton btnBuy;
	private JButton btnCompare;
	
	public CarDetailInfo(int carId,SearchCar searchFrm){
		this.searchFrm = searchFrm;
		this.setSize(1000, 300);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		this.setResizable(false);
		//初始化组件
		initComponent();
		loadData(carId,searchFrm);
	}
	/**
	 * 初始化组件
	 */
	private void initComponent() {
		btnCollect = new JButton("收藏");
		btnBuy = new JButton("购买");
		btnCompare = new JButton("对比");
		
		//创建列标题
		columnName = new String[]{"汽车编号","品牌","车型","里程数","价格","发布时间","上牌时间","排量","离合器类型"};
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
		//设置表格数据内容居中对齐
		((DefaultTableCellRenderer)tabCarData.getDefaultRenderer(Object.class)).setHorizontalAlignment(JLabel.CENTER);
		//设置表格的选择模式
		tabCarData.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		hidenFirstColum();
		
		//实例化滑动面板
		sclContainer = new JScrollPane();
		sclContainer.setBounds(0, 0, 1000, 200);
		sclContainer.getViewport().add(tabCarData);
		
		btnCollect.setBounds(330, 210, 70, 30);
		btnBuy.setBounds(450, 210, 70, 30);
		btnCompare.setBounds(570, 210, 70, 30);
		this.add(btnCollect);
		this.add(btnBuy);
		this.add(btnCompare);
		//添加滚动面板
		this.add(sclContainer);
	}

	/**
	 * 下载数据
	 */
	private void loadData(int carId,SearchCar searchFrm){
		
		Object[][] cars = new Object[1][];
		Car car = searchFrm.getCarDao().findCarByCarId(carId);
		cars[0] = new Object[]{car.getCarId(),searchFrm.getBrandDao().findBrandNameByBrandId(car.getBrandId()),
				searchFrm.getCarTypeDao().findCarTypeNameByCarTypeId(car.getTypeId()),
				car.getMileage(),car.getPrice(),
				CommonUtil.formatDate(car.getPublishTime()),
				CommonUtil.formatDate(car.getBoardTime()),
				car.getOutputVolume(),car.getClucthType()};
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
