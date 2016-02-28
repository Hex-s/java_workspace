package com.niit.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.tree.DefaultMutableTreeNode;

import com.niit.bean.Brand;
import com.niit.bean.Car;
import com.niit.bean.CarType;
import com.niit.bean.User;
import com.niit.dao.impl.BrandDao;
import com.niit.dao.impl.CarDao;
import com.niit.dao.impl.CarTypeDao;
import com.niit.dao.impl.UserDao;
import com.niit.data.Data;
import com.niit.util.CommonUtil;
/**
 * 主窗体
 * @author Administrator
 *
 */
public class MainFrame extends JFrame {
	//组件
	private LoginFrame loginFrm;
	private Data data;
	private JSplitPane splPnl;
	private JScrollPane scrollPnlTab;
	private JScrollPane scrollPnlTree;
	private JTree tree;
	private DefaultMutableTreeNode root;
	private String[] columnName;
	private DefaultTableModel modelTab;
	private JTable tabData;
	private JPanel pnlRight;
	private JToolBar tbarCollection;
	private JButton btnCollection;
	private DefaultMutableTreeNode selectedNode;
	//右键菜单
	private JPopupMenu popMenu;
	private JMenuItem itemCellect;
	private JMenuItem itemDelete;
	private JMenuItem itemModify;
	private JMenuItem itemNew;
	//数据
	private BrandDao brandDao;
	private CarTypeDao carTypeDao;
	private CarDao carDao;
	private UserDao userDao;
	private User loginUser;
	
	public MainFrame(Data data,LoginFrame loginFrm){
		//获取构造传入的登陆窗体
		this.data = data;
		this.brandDao = new BrandDao(data);
		this.carDao = new CarDao(data);
		this.carTypeDao = new CarTypeDao(data);
		this.userDao = new UserDao(data);
		this.loginFrm = loginFrm;
		this.loginUser = userDao.findUserByName(loginFrm.getTxtName().getText());
		//初始化主窗体
		this.setTitle(loginFrm.getTxtName().getText()+" 登陆中");
		this.setSize(1000, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		//初始化组件
		initComponent();
		//初始化树结构
		initTree();
		//绑定监听器
		bindListener();
	}
	/**
	 * 绑定监听器
	 */
	private void bindListener(){
		tree.addTreeSelectionListener(new TreeListener());
		tabData.addMouseListener(new doubleClickForDetailInfo());
		popMenu.addPopupMenuListener(new PopMenuListener());
		MenuClickListener menuClickListener = new MenuClickListener();
		itemCellect.addActionListener(menuClickListener);
		itemDelete.addActionListener(menuClickListener);
		itemModify.addActionListener(menuClickListener);
		itemNew.addActionListener(menuClickListener);
	}
	
	/**
	 * 构造树结构
	 */
	private void initTree(){
		//获取所有的品牌信息
		ArrayList<Brand> allBrands = brandDao.findAllBrand();
		//遍历品牌集合
		for(Brand brand : allBrands){
			//创造品牌节点
			DefaultMutableTreeNode brandNode  = new DefaultMutableTreeNode(brand.getBrandName());
			//获取该品牌下的所有车型
			ArrayList<CarType> carTypes = carTypeDao.findBrandCarType(brand);
			//遍历车型集合
			for(CarType carType : carTypes){
				//创造车型节点，将车型对象写入
				DefaultMutableTreeNode carTypeNode = new DefaultMutableTreeNode(carType);
				//将车型节点添加入品牌节点
				brandNode.add(carTypeNode);
			}
			
			//将品牌添加至根节点
			root.add(brandNode);
		}
	}
	/**
	 * 树结构监听器
	 * @author Administrator
	 *
	 */
	private class TreeListener implements TreeSelectionListener{

		@Override
		public void valueChanged(TreeSelectionEvent e) {
			//获取当前选中的节点对象
			DefaultMutableTreeNode node = (DefaultMutableTreeNode)e.getPath().getLastPathComponent();
			//当前选择节点为
			selectedNode = node;
			//判断节点是否是车型节点
			if(node.getLevel() == 2){
				//在表格中加载该车型节点的数据
				loadData(node);
			}
		}
	}
	
	/**
	 * 加载数据
	 * @param node
	 */
	public void loadData(DefaultMutableTreeNode node){
		//获取节点中的对象 车型
		CarType carType = (CarType)node.getUserObject();
		//获取该车型下的所有汽车
		ArrayList<Car> cars = carDao.findCarTypeCar(carType);
		//汽车集合转变成二维数组
		Object[][] carsObj = new Object[cars.size()][];
		//遍历集合
		for(int i = 0; i < cars.size(); i++){
			//获取集合下的每一个汽车对象
			Car car = cars.get(i);
			//根据品牌id获取品牌名称
			String brandName = brandDao.findBrandNameByBrandId(car.getBrandId());
			//根据车型id获取车型名称
			String carTypeName = carTypeDao.findCarTypeNameByCarTypeId(car.getTypeId());
			//构造该汽车的数组
			carsObj[i] = new Object[]{car.getCarId()+"",brandName,carTypeName,car.getMileage()+"",car.getPrice()+"",CommonUtil.formatDate(car.getPublishTime()),CommonUtil.formatDate(car.getBoardTime()),false};
		}
		//重新绑定表格数据
		modelTab.setDataVector(carsObj, columnName);
		//隐藏第一列
		CommonUtil.hidenFirstColum(tabData, 0);
		//如果登陆用户非管理员，则删除列不可见
		if(loginUser.getIsAdmin() != true){
			CommonUtil.hidenFirstColum(tabData,7);
		}
		
	}
	/**
	 * 双击获取汽车详细信息
	 * @author Administrator
	 *
	 */
	private class doubleClickForDetailInfo implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			//双击
			if(e.getClickCount() == 2){
				//获取该行的汽车id
				int carId = Integer.parseInt((modelTab.getValueAt(tabData.getSelectedRow(), 0).toString()));
				//实例化详细信息界面
				CarDetailInfo frm = new CarDetailInfo(carId,MainFrame.this);
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
	 * 右键菜单选择监听器
	 * @author Administrator
	 *
	 */
	
	private class MenuClickListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//获取选中的菜单项
			JMenuItem menu =(JMenuItem) e.getSource();
			//收藏
			if(menu == itemCellect){
				addCollection();
			}
			//删除
			else if(menu == itemDelete){
				deleteCars();
			}
			//修改
			else if(menu == itemModify){
				modify();
			}
			//新增
			else{
				addNewCar frm = new addNewCar(MainFrame.this);
				frm.setVisible(true);
			}
			//重新加载数据
			loadData(selectedNode);
		}

		/**
		 * 修改汽车信息
		 */
		private void modify() {
			//获取要收藏车辆的ID
			int carId = Integer.parseInt(tabData.getValueAt(tabData.getSelectedRow(), 0).toString());
			System.out.println(carId);
			//实例化修改车型界面
			modifyCar frm = new modifyCar(carId, MainFrame.this);
			frm.setVisible(true);
		}

		/**
		 * 收藏汽车
		 */
		private void addCollection() {
			//获取要收藏车辆的ID
			int carId = Integer.parseInt(tabData.getValueAt(tabData.getSelectedRow(), 0).toString());
			//获取该Id的汽车
			Car car = carDao.findCarByCarId(carId);
			//判断用户收藏的车辆中是否已含有该车
			boolean has = loginUser.getCollectCars().contains(car);
			//用户已经收藏过该车
			if(has){
				JOptionPane.showMessageDialog(null, "您已经收藏过该车！");
			}
			else{
				//用户收藏汽车数量
				int count = loginUser.getCollectCars().size();
				//数量超过10辆
				if(count == 10){
					int choice = JOptionPane.showConfirmDialog(null, "收藏车辆已满10辆，继续收藏将删除收藏的第一辆车","收藏",JOptionPane.YES_NO_OPTION);
					//删除第一个收藏车辆
					if(choice == JOptionPane.YES_OPTION){
						//删除第一个
						loginUser.getCollectCars().remove(0);
						//添加新的车辆
						loginUser.getCollectCars().add(car);
					}
				}
				else{
					int choice = JOptionPane.showConfirmDialog(null, "确认收藏","收藏",JOptionPane.YES_NO_OPTION);
					if(choice == JOptionPane.YES_OPTION){
						//添加新的车辆
						loginUser.getCollectCars().add(car);
					}
				}
			}
			
		}
		
	}
	
	/**
	 * 批量删除汽车
	 */
	private void deleteCars() {
	
		//存储要删除的汽车
		ArrayList<Car> deleteCars = new ArrayList<Car>();
		//遍历表格中的所有行
		for(int i = 0; i < tabData.getRowCount(); i++){
			if((Boolean)tabData.getValueAt(i, 7)){
				int carId = Integer.parseInt(tabData.getValueAt(i, 0).toString());
				Car car = carDao.findCarByCarId(carId);
				deleteCars.add(car);
			}
		}
		//判断是否有选中行
		if(deleteCars.size() == 0){
			JOptionPane.showMessageDialog(null, "没有选择要删除的汽车！");
		}
		else{
			int choice =  JOptionPane.showConfirmDialog(null,"确认删除选中的"+deleteCars.size()+"辆车", "删除",JOptionPane.YES_NO_OPTION);
			if(choice == JOptionPane.YES_OPTION){
				//循环删除
				for(Car car : deleteCars){
					carDao.deleteCar(car);
				}
			}
		}
	}
	
	/**
	 * 根据用户身份显示不同的右键菜单
	 * @author Administrator
	 *
	 */
	private class PopMenuListener implements PopupMenuListener{

		@Override
		public void popupMenuCanceled(PopupMenuEvent e) {
			
		}

		@Override
		public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
			
		}

		@Override
		public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
			//判断是否选中行
			if(tabData.getSelectedRow() != -1){
//				System.out.println("使用右键");
				//判断登陆了用户的身份
				if(loginUser.getIsAdmin()){
					itemCellect.setVisible(false);
					itemDelete.setVisible(true);
					itemModify.setVisible(true);
					itemNew.setVisible(true);
				}
				else{
					itemCellect.setVisible(true);
					itemDelete.setVisible(false);
					itemModify.setVisible(false);
					itemNew.setVisible(false);
				}
				
			}
			else{
				itemCellect.setVisible(false);
				itemDelete.setVisible(false);
				itemModify.setVisible(false);
				itemNew.setVisible(false);
			}
			
		}
		
	}
	/**
	 * 初始化组件
	 */
	private void initComponent() {
		//实例化树结构滚动面板
		scrollPnlTree = new JScrollPane();
		//实例化右部面板
		pnlRight = new JPanel();
		pnlRight.setLayout(null);
		//实例化分割面板
		splPnl = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPnlTree, pnlRight);
		splPnl.setDividerSize(5);
		splPnl.setDividerLocation(150);
		splPnl.setEnabled(false);
		
		//实例化表格滚动面板
		scrollPnlTab = new JScrollPane();
		scrollPnlTab.setBounds(0, 0, 700, 600);
	
		//实例化收藏按钮
		btnCollection = new JButton("我的收藏");
		//实例化收藏工具条
		tbarCollection = new JToolBar();
		tbarCollection.add(btnCollection);
		tbarCollection.setBounds(720, 10, 100, 30);
		//实例化根节点
		root = new DefaultMutableTreeNode("车辆信息");
		//构建树结构
		tree = new JTree(root);
		
		//实例化表格模型
		//表格标题
		columnName = new String[]{"汽车编号","品牌","车型","里程数","价格","发布时间","上牌时间","删除"};
		modelTab = new DefaultTableModel(columnName,0);
		tabData = new JTable(modelTab){

			public Class<?> getColumnClass(int column) {
//				System.out.println(tabData.getValueAt(0, 7));
				return tabData.getValueAt(0, column).getClass();
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				if(column < 7){
					return false;
				}
				return true;
			}
			
		};
		//隐藏第一列
		CommonUtil.hidenFirstColum(tabData, 0);
		//如果登陆用户非管理员，则删除列不可见
		if(loginUser.getIsAdmin() != true){
			CommonUtil.hidenFirstColum(tabData,7);
		}
		//使列不能移动
		tabData.getTableHeader().setReorderingAllowed(false);
		//设置表格数据内容居中对齐
		((DefaultTableCellRenderer)tabData.getDefaultRenderer(Object.class)).setHorizontalAlignment(JLabel.CENTER);
		//设置表格的选择模式
		tabData.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		pnlRight.add(scrollPnlTab);
		pnlRight.add(tbarCollection);
		scrollPnlTree.getViewport().add(tree);
		scrollPnlTab.getViewport().add(tabData);
		
		/*************************右键菜单的使用****************************/
		//右键菜单实例化
		popMenu = new JPopupMenu();
		//实例化菜单项
		itemCellect = new JMenuItem("收藏");
		itemDelete = new JMenuItem("删除");
		itemModify = new JMenuItem("修改");
		itemNew = new JMenuItem("新增");
		//添加菜单项到右键菜单
		popMenu.add(itemCellect);
		popMenu.add(itemDelete);
		popMenu.add(itemModify);
		popMenu.add(itemNew);
		//将右键绑定在指定的组件上
		tabData.setComponentPopupMenu(popMenu);
		
		this.add(splPnl);
	}
	
	
	public Data getData() {
		return data;
	}
	public User getLoginUser() {
		return loginUser;
	}
	public JTable getTabData() {
		return tabData;
	}

	public DefaultMutableTreeNode getSelectedNode() {
		// TODO Auto-generated method stub
		return selectedNode;
	}
	
	
}
