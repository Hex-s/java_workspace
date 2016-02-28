package com.niit;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.beans.FeatureDescriptor;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
/**
 * ���������ʹ��
 * @author Administrator
 *
 */
public class ComponentExam1 extends JFrame {
	
	//��������ӵ������Ӧд������
	//��ǩ �����ڴ�����־�̬��Ϣ
	private JLabel lbl;
	//�ı���
	private JTextField txtName;
	//�����
	private JPasswordField txtPwd;
	//�����б��
	private JComboBox cboCourse;
	//��ѡ��ť
	private JRadioButton rdoMale;
	private JRadioButton rdoFemale;
	//һ�鵥ѡ��ťΪ�˱���ѭ����������д������
	private JRadioButton[] rdoSex;
	private String[] sexArray;
	//��ѡ��
	private JCheckBox[] chkHobby;
	private String[] hobbyArray;
	//��ť
	private JButton btnPress;
	//��ť��
	private ButtonGroup group;
	//���  �������
	private JPanel pnlContainer;
	
	public ComponentExam1(){
		
		//��ʼ������
		setBounds(400, 200, 400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//getContentPane().setBackground(Color.orange);
		//�޸Ĵ���Ĳ��ַ�ʽ
		setLayout(new FlowLayout());
		
		/***********************JLable*************************/
		//ʵ������ǩ
		//lbl = new JLabel();
//		//���ñ�ǩ����������
		//lbl.setText("�û���");
//		//��ȡ��ǩ���õ�����
//		//System.out.println(lbl.getText());
//		//����ͼƬ,ͼƬ�ļ��з�������Ŀ�ĸ�·����
//		ImageIcon imageIcon = new ImageIcon("image/back.jpg");
//		//����ͼƬ�Ĵ�С   �Ƚ�ImageIconת����Image�����ٶ����С�����ػ�
//		Image image = imageIcon.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT);
//		//�ٽ�Imageת����ImageIcon
//		imageIcon = new ImageIcon(image);
//		lbl.setIcon(imageIcon);
		//���ñ�ǩ���ֵ�ˮƽ���뷽ʽ
		//lbl.setHorizontalAlignment(JLabel.LEFT);
		
		/***********************JTextField*************************/
//		txtName = new JTextField();
//		//�����ı��������
//		txtName.setColumns(10);
//		//�����ı����Ĭ��ֵ
//		txtName.setText("Ĭ��ֵ");
//		//��ȡ�ı�����д���ֵ
//		System.out.println(txtName.getText());
		
		/***********************JPasswordField*************************/
//		txtPwd = new JPasswordField();
//		txtPwd.setColumns(20);
//		//����Ĭ������ֵ
//		txtPwd.setText("tom's password");
//		//��ȡ����ֵ
//		//System.out.println(txtPwd.getText());
//		String pwd = new String(txtPwd.getPassword());
//		System.out.println(pwd);
//		//�����������ֵ��ַ�
//		txtPwd.setEchoChar('$');
		
		/***********************JComboBox*************************/
		//�ղι���
//		cboCourse = new JComboBox();
		//���ѡ��
//		cboCourse.addItem("html");
//		cboCourse.addItem("java");
//		cboCourse.addItem("oracle");
//		cboCourse.addItem("JDBC");
		//��ȡѡ��
		//ֱ�ӻ�ȡѡ���ֵ
//		Object value = cboCourse.getSelectedItem();
		//��ȡѡ���������
//		int index = cboCourse.getSelectedIndex();
//		System.out.println(index);
//		Object value = cboCourse.getItemAt(index);
//		System.out.println(value);
		//��ȡѡ�������
//		System.out.println(cboCourse.getItemCount());
		//����Ĭ��ѡ��
//		cboCourse.setSelectedIndex(2);
		//�Ƴ�ѡ��
		//cboCourse.removeItem("oracle");
		//cboCourse.removeItemAt(2);
		
		//ͨ�����鹹��
		//cboCourse = new JComboBox(new String[]{"A","B","C","D"});
		
		//ͨ�����Ϲ���
//		Vector<String> vector = new Vector<String>();
//		vector.add("A");
//		vector.add("B");
//		cboCourse = new JComboBox(vector);
		
		//ͨ��ģ�͹���
		//����ģ�Ͷ���
//		DefaultComboBoxModel model = new DefaultComboBoxModel();
//		cboCourse = new JComboBox(model);
//		//ʹ��ģ�͹��������в�����Ӧ����ģ�Ͷ�����ʵ��
//		//���Ԫ��
//		model.addElement("A");
//		model.addElement("B");
//		//�Ƴ�Ԫ��
//		model.removeElementAt(0);

		/***********************JRadioButton*************************/
//		rdoMale = new JRadioButton("��");
//		rdoFemale = new JRadioButton("Ů");
//		//Ҫʵ�ֻ�����뽫��ѡ��ť�����ͬһ�������
//		//��ť�鲻����swing�����
//		group = new ButtonGroup();
//		group.add(rdoMale);
//		group.add(rdoFemale);
//		//����Ĭ��ѡ�еİ�ť
//		rdoFemale.setSelected(true);
		//��ȡѡ�е��� ͨ���ж�ÿ����ť��ѡ��״̬����ȡ
//		if(rdoMale.isSelected()){
//			System.out.println("ѡ��������");
//		}
//		else if(rdoFemale.isSelected()){
//			System.out.println("ѡ������Ů");
//		}
		
		//��Ӱ�ť
//		this.add(rdoMale);
//		this.add(rdoFemale);
		
		//ͨ�����������е�������ж��Ƿ�ѡ��
//		for(Component component : this.getContentPane().getComponents()){
//			//�ж�����Ƿ��ǵ�ѡ��ť����
//			if(component instanceof JRadioButton){
//				//�����JRadioButton
//				JRadioButton rdo = (JRadioButton)component;
//				//�ж��Ƿ�ѡ��
//				if(rdo.isSelected()){
//					System.out.println(rdo.getText());
//					break;
//				}
//			}
//		}
		
		//ʹ�����������ѡ��ť
//		rdoSex = new JRadioButton[2];
//		sexArray = new String[]{"male","female"};
//		//ѭ��������ѡ��ť
//		for(int i = 0; i < rdoSex.length; i++){
//			rdoSex[i] = new JRadioButton(sexArray[i]);
//			//�������ť��
//			group.add(rdoSex[i]);
//			//���������
//			this.add(rdoSex[i]);
//		}
//		//Ĭ��ѡ����
//		rdoSex[1].setSelected(true);
//		//��ȡѡ�е���
//		String result = "";
//		for(JRadioButton rdo : rdoSex){
//			//�ж��Ƿ�ѡ��
//			if(rdo.isSelected()){
//				result = rdo.getText();
//				break;
//			}
//		}
//		System.out.println("ѡ�����ǣ�"+result);
		
		
		/***********************JCheckBox*************************/
//		chkHobby = new JCheckBox[4];
//		hobbyArray = new String[]{"Game","Music","Sprort","Sleep"};
//		//ѭ��������ѡ��
//		for(int i = 0; i < chkHobby.length; i++){
//			chkHobby[i] = new JCheckBox(hobbyArray[i]);
//			//���������
//			this.add(chkHobby[i]);
//		}
//		//����Ĭ��ѡ����
//		chkHobby[0].setSelected(true);
		
		
		/***********************JButton*************************/
		//��ť���Գ������ֺ�ͼƬ
		btnPress = new JButton("press");
		//��ȡ��ť�ϵ��ı�ֵ
		//btnPress.getText();
		
		/***********************JPanel*************************/
		pnlContainer = new JPanel();
		//����ť��������
		pnlContainer.add(btnPress);
		//�������������壬ͬʱ����е����Ҳ����֮�ӵ�������
		this.add(pnlContainer);
		//���һ����ѡ��
		//pnlContainer.add(new JCheckBox("A"));
		
		pnlContainer.setBackground(Color.orange);
		
		//����ǩ���������
		//this.add(lbl);
		//this.add(txtName);
		//this.add(txtPwd);
		//this.add(cboCourse);
		//this.add(btnPress);
		
	}
	
	public static void main(String[] args) {
		//������ʵ����
		ComponentExam1 frm = new ComponentExam1();
		//���ִ���
		frm.setVisible(true);
	}
}
