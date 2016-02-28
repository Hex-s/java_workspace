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
 * ������
 * @author Administrator
 *
 */
public class MainFrame extends JFrame {
	//���
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
	//�Ҽ��˵�
	private JPopupMenu popMenu;
	private JMenuItem itemCellect;
	private JMenuItem itemDelete;
	private JMenuItem itemModify;
	private JMenuItem itemNew;
	//����
	private BrandDao brandDao;
	private CarTypeDao carTypeDao;
	private CarDao carDao;
	private UserDao userDao;
	private User loginUser;
	
	public MainFrame(Data data,LoginFrame loginFrm){
		//��ȡ���촫��ĵ�½����
		this.data = data;
		this.brandDao = new BrandDao(data);
		this.carDao = new CarDao(data);
		this.carTypeDao = new CarTypeDao(data);
		this.userDao = new UserDao(data);
		this.loginFrm = loginFrm;
		this.loginUser = userDao.findUserByName(loginFrm.getTxtName().getText());
		//��ʼ��������
		this.setTitle(loginFrm.getTxtName().getText()+" ��½��");
		this.setSize(1000, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		//��ʼ�����
		initComponent();
		//��ʼ�����ṹ
		initTree();
		//�󶨼�����
		bindListener();
	}
	/**
	 * �󶨼�����
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
	 * �������ṹ
	 */
	private void initTree(){
		//��ȡ���е�Ʒ����Ϣ
		ArrayList<Brand> allBrands = brandDao.findAllBrand();
		//����Ʒ�Ƽ���
		for(Brand brand : allBrands){
			//����Ʒ�ƽڵ�
			DefaultMutableTreeNode brandNode  = new DefaultMutableTreeNode(brand.getBrandName());
			//��ȡ��Ʒ���µ����г���
			ArrayList<CarType> carTypes = carTypeDao.findBrandCarType(brand);
			//�������ͼ���
			for(CarType carType : carTypes){
				//���쳵�ͽڵ㣬�����Ͷ���д��
				DefaultMutableTreeNode carTypeNode = new DefaultMutableTreeNode(carType);
				//�����ͽڵ������Ʒ�ƽڵ�
				brandNode.add(carTypeNode);
			}
			
			//��Ʒ����������ڵ�
			root.add(brandNode);
		}
	}
	/**
	 * ���ṹ������
	 * @author Administrator
	 *
	 */
	private class TreeListener implements TreeSelectionListener{

		@Override
		public void valueChanged(TreeSelectionEvent e) {
			//��ȡ��ǰѡ�еĽڵ����
			DefaultMutableTreeNode node = (DefaultMutableTreeNode)e.getPath().getLastPathComponent();
			//��ǰѡ��ڵ�Ϊ
			selectedNode = node;
			//�жϽڵ��Ƿ��ǳ��ͽڵ�
			if(node.getLevel() == 2){
				//�ڱ���м��ظó��ͽڵ������
				loadData(node);
			}
		}
	}
	
	/**
	 * ��������
	 * @param node
	 */
	public void loadData(DefaultMutableTreeNode node){
		//��ȡ�ڵ��еĶ��� ����
		CarType carType = (CarType)node.getUserObject();
		//��ȡ�ó����µ���������
		ArrayList<Car> cars = carDao.findCarTypeCar(carType);
		//��������ת��ɶ�ά����
		Object[][] carsObj = new Object[cars.size()][];
		//��������
		for(int i = 0; i < cars.size(); i++){
			//��ȡ�����µ�ÿһ����������
			Car car = cars.get(i);
			//����Ʒ��id��ȡƷ������
			String brandName = brandDao.findBrandNameByBrandId(car.getBrandId());
			//���ݳ���id��ȡ��������
			String carTypeName = carTypeDao.findCarTypeNameByCarTypeId(car.getTypeId());
			//���������������
			carsObj[i] = new Object[]{car.getCarId()+"",brandName,carTypeName,car.getMileage()+"",car.getPrice()+"",CommonUtil.formatDate(car.getPublishTime()),CommonUtil.formatDate(car.getBoardTime()),false};
		}
		//���°󶨱������
		modelTab.setDataVector(carsObj, columnName);
		//���ص�һ��
		CommonUtil.hidenFirstColum(tabData, 0);
		//�����½�û��ǹ���Ա����ɾ���в��ɼ�
		if(loginUser.getIsAdmin() != true){
			CommonUtil.hidenFirstColum(tabData,7);
		}
		
	}
	/**
	 * ˫����ȡ������ϸ��Ϣ
	 * @author Administrator
	 *
	 */
	private class doubleClickForDetailInfo implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			//˫��
			if(e.getClickCount() == 2){
				//��ȡ���е�����id
				int carId = Integer.parseInt((modelTab.getValueAt(tabData.getSelectedRow(), 0).toString()));
				//ʵ������ϸ��Ϣ����
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
	 * �Ҽ��˵�ѡ�������
	 * @author Administrator
	 *
	 */
	
	private class MenuClickListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//��ȡѡ�еĲ˵���
			JMenuItem menu =(JMenuItem) e.getSource();
			//�ղ�
			if(menu == itemCellect){
				addCollection();
			}
			//ɾ��
			else if(menu == itemDelete){
				deleteCars();
			}
			//�޸�
			else if(menu == itemModify){
				modify();
			}
			//����
			else{
				addNewCar frm = new addNewCar(MainFrame.this);
				frm.setVisible(true);
			}
			//���¼�������
			loadData(selectedNode);
		}

		/**
		 * �޸�������Ϣ
		 */
		private void modify() {
			//��ȡҪ�ղس�����ID
			int carId = Integer.parseInt(tabData.getValueAt(tabData.getSelectedRow(), 0).toString());
			System.out.println(carId);
			//ʵ�����޸ĳ��ͽ���
			modifyCar frm = new modifyCar(carId, MainFrame.this);
			frm.setVisible(true);
		}

		/**
		 * �ղ�����
		 */
		private void addCollection() {
			//��ȡҪ�ղس�����ID
			int carId = Integer.parseInt(tabData.getValueAt(tabData.getSelectedRow(), 0).toString());
			//��ȡ��Id������
			Car car = carDao.findCarByCarId(carId);
			//�ж��û��ղصĳ������Ƿ��Ѻ��иó�
			boolean has = loginUser.getCollectCars().contains(car);
			//�û��Ѿ��ղع��ó�
			if(has){
				JOptionPane.showMessageDialog(null, "���Ѿ��ղع��ó���");
			}
			else{
				//�û��ղ���������
				int count = loginUser.getCollectCars().size();
				//��������10��
				if(count == 10){
					int choice = JOptionPane.showConfirmDialog(null, "�ղس�������10���������ղؽ�ɾ���ղصĵ�һ����","�ղ�",JOptionPane.YES_NO_OPTION);
					//ɾ����һ���ղس���
					if(choice == JOptionPane.YES_OPTION){
						//ɾ����һ��
						loginUser.getCollectCars().remove(0);
						//����µĳ���
						loginUser.getCollectCars().add(car);
					}
				}
				else{
					int choice = JOptionPane.showConfirmDialog(null, "ȷ���ղ�","�ղ�",JOptionPane.YES_NO_OPTION);
					if(choice == JOptionPane.YES_OPTION){
						//����µĳ���
						loginUser.getCollectCars().add(car);
					}
				}
			}
			
		}
		
	}
	
	/**
	 * ����ɾ������
	 */
	private void deleteCars() {
	
		//�洢Ҫɾ��������
		ArrayList<Car> deleteCars = new ArrayList<Car>();
		//��������е�������
		for(int i = 0; i < tabData.getRowCount(); i++){
			if((Boolean)tabData.getValueAt(i, 7)){
				int carId = Integer.parseInt(tabData.getValueAt(i, 0).toString());
				Car car = carDao.findCarByCarId(carId);
				deleteCars.add(car);
			}
		}
		//�ж��Ƿ���ѡ����
		if(deleteCars.size() == 0){
			JOptionPane.showMessageDialog(null, "û��ѡ��Ҫɾ����������");
		}
		else{
			int choice =  JOptionPane.showConfirmDialog(null,"ȷ��ɾ��ѡ�е�"+deleteCars.size()+"����", "ɾ��",JOptionPane.YES_NO_OPTION);
			if(choice == JOptionPane.YES_OPTION){
				//ѭ��ɾ��
				for(Car car : deleteCars){
					carDao.deleteCar(car);
				}
			}
		}
	}
	
	/**
	 * �����û������ʾ��ͬ���Ҽ��˵�
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
			//�ж��Ƿ�ѡ����
			if(tabData.getSelectedRow() != -1){
//				System.out.println("ʹ���Ҽ�");
				//�жϵ�½���û������
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
	 * ��ʼ�����
	 */
	private void initComponent() {
		//ʵ�������ṹ�������
		scrollPnlTree = new JScrollPane();
		//ʵ�����Ҳ����
		pnlRight = new JPanel();
		pnlRight.setLayout(null);
		//ʵ�����ָ����
		splPnl = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPnlTree, pnlRight);
		splPnl.setDividerSize(5);
		splPnl.setDividerLocation(150);
		splPnl.setEnabled(false);
		
		//ʵ�������������
		scrollPnlTab = new JScrollPane();
		scrollPnlTab.setBounds(0, 0, 700, 600);
	
		//ʵ�����ղذ�ť
		btnCollection = new JButton("�ҵ��ղ�");
		//ʵ�����ղع�����
		tbarCollection = new JToolBar();
		tbarCollection.add(btnCollection);
		tbarCollection.setBounds(720, 10, 100, 30);
		//ʵ�������ڵ�
		root = new DefaultMutableTreeNode("������Ϣ");
		//�������ṹ
		tree = new JTree(root);
		
		//ʵ�������ģ��
		//������
		columnName = new String[]{"�������","Ʒ��","����","�����","�۸�","����ʱ��","����ʱ��","ɾ��"};
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
		//���ص�һ��
		CommonUtil.hidenFirstColum(tabData, 0);
		//�����½�û��ǹ���Ա����ɾ���в��ɼ�
		if(loginUser.getIsAdmin() != true){
			CommonUtil.hidenFirstColum(tabData,7);
		}
		//ʹ�в����ƶ�
		tabData.getTableHeader().setReorderingAllowed(false);
		//���ñ���������ݾ��ж���
		((DefaultTableCellRenderer)tabData.getDefaultRenderer(Object.class)).setHorizontalAlignment(JLabel.CENTER);
		//���ñ���ѡ��ģʽ
		tabData.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		pnlRight.add(scrollPnlTab);
		pnlRight.add(tbarCollection);
		scrollPnlTree.getViewport().add(tree);
		scrollPnlTab.getViewport().add(tabData);
		
		/*************************�Ҽ��˵���ʹ��****************************/
		//�Ҽ��˵�ʵ����
		popMenu = new JPopupMenu();
		//ʵ�����˵���
		itemCellect = new JMenuItem("�ղ�");
		itemDelete = new JMenuItem("ɾ��");
		itemModify = new JMenuItem("�޸�");
		itemNew = new JMenuItem("����");
		//��Ӳ˵���Ҽ��˵�
		popMenu.add(itemCellect);
		popMenu.add(itemDelete);
		popMenu.add(itemModify);
		popMenu.add(itemNew);
		//���Ҽ�����ָ���������
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
