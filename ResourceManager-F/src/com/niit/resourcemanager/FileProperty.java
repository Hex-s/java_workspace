package com.niit.resourcemanager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.tree.DefaultMutableTreeNode;

public class FileProperty  extends JFrame{
	
	private JTabbedPane tabpnl;
	private JPanel pnlPro;
	private JLabel lblPic;
	private JTextField txtFileName;
	private JLabel lblFileType;
	private JLabel lblFilePath;
	private JLabel lblFileLength;
	private JLabel lblModifyTime;
	private String[] array;
	private JLabel[] lblArray;
	private JCheckBox chkReadOnly;
	private JCheckBox chkHidden;
	private JButton btnConfirm;
	private JButton btnCancel;
	private JButton btnApply;
	private DefaultMutableTreeNode selectedNode;
	private File file;
	private ResourceManager resFrm;
	
	
	public FileProperty(File file,ResourceManager resFrm){
		this.resFrm = resFrm;
		this.selectedNode = resFrm.getSelectedNode();
		this.file = file;
		this.setSize(400,500);
		this.setLocationRelativeTo(resFrm);
		this.setTitle(file.getName()+"  "+"����");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//��ʼ�����
		initComponent();
		//���ô����Ĭ�ϻس���ť
		this.getRootPane().setDefaultButton(btnConfirm);
		
	}
	
	/**
	 * ��ʼ�����
	 */
	private void initComponent(){
		
		pnlPro = new JPanel();
		pnlPro.setLayout(null);
		tabpnl = new JTabbedPane();
		lblPic = new JLabel();
		txtFileName = new JTextField();
		chkHidden = new JCheckBox("����");
		chkReadOnly = new JCheckBox("ֻ��");
		btnConfirm = new JButton("ȷ��");
		btnCancel = new JButton("ȡ��");
		btnApply = new JButton("Ӧ��");
		
		//ͼ��
		lblPic.setIcon(new ImageIcon("image/��Դ������.gif"));
		//�ļ���
		txtFileName.setText(file.getName());
		
		
		
		array = new String[]{"�ļ����ͣ�","λ�ã�","��С��","�޸�ʱ�䣺","���ԣ�"};
		lblArray = new JLabel[array.length];
		for(int i = 0 , y = 50; i < lblArray.length; i++ , y+=50){
			lblArray[i] = new JLabel(array[i]);
			lblArray[i].setBounds(10, y, 80, 20);
			pnlPro.add(lblArray[i]);
		}
		
		String name = file.getName();
		String type = "";
		int index = name.lastIndexOf(".");
		name = name.substring(index+1);
		System.out.println(name);
		if(name.equalsIgnoreCase("txt")){
			type = "�ı��ĵ�";
		}
		else if(name.equalsIgnoreCase("doc") || name.equalsIgnoreCase("docx")){
			type = "word�ĵ�";
		}
		else if(name.equalsIgnoreCase("excel")){
			type = "excel�ļ�";
		}
		else if(name.equalsIgnoreCase("gif") || name.equalsIgnoreCase("bmp") || name.equalsIgnoreCase("jpg")){
			type = "ͼƬ�ļ�";
		}
		else{
			type = "�����ļ�";
		}
		lblFileType = new JLabel(type);
		lblFilePath = new JLabel(file.getParent());
		lblFileLength = new JLabel(file.length()/1024+"KB ("+file.length()+"�ֽ�)");
		long time = file.lastModified();
		Date date = new Date(time);
		lblModifyTime = new JLabel(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
		
		//���λ��
		lblPic.setBounds(10, 10, 80, 30);
		txtFileName.setBounds(100, 15, 250, 20);
		lblFileType.setBounds(100, 50, 250, 20);
		lblFilePath.setBounds(100, 100, 250, 20);
		lblFileLength.setBounds(100, 150, 250, 20);
		lblModifyTime.setBounds(100, 200, 250, 20);
		chkReadOnly.setBounds(100, 250, 100, 20);
		chkHidden.setBounds(220, 250, 100, 20);
		btnConfirm.setBounds(100, 300, 70 , 20);
		btnCancel.setBounds(180, 300, 70, 20);
		btnApply.setBounds(260, 300, 70, 20);
		btnApply.setEnabled(false);
		if(!file.canWrite()){
			chkReadOnly.setSelected(true);
		}
		//�󶨼�����
		ButtonListener btnLintener = new ButtonListener();
		btnCancel.addActionListener(btnLintener);
		btnConfirm.addActionListener(btnLintener);
		btnApply.addActionListener(btnLintener);
		//������
		tabpnl.add("����", pnlPro);
		pnlPro.add(lblPic);
		pnlPro.add(txtFileName);
		pnlPro.add(lblFileType);
		pnlPro.add(lblFilePath);
		pnlPro.add(lblFileLength);
		pnlPro.add(lblModifyTime);
		pnlPro.add(chkReadOnly);
		pnlPro.add(chkHidden);
		pnlPro.add(btnApply);
		pnlPro.add(btnCancel);
		pnlPro.add(btnConfirm);
		this.add(tabpnl);
		
	}
	
	/**
	 * ��ť������
	 * @author Administrator
	 *
	 */
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			if(btn == btnConfirm){
				//������
				String fileName = txtFileName.getText();
				if(!fileName.equals(file.getName())){
					rename(file,fileName);
				}
				//ֻ��
				if(chkReadOnly.isSelected()){
					file.setReadable(true);
					file.setWritable(false);
				}
				else{
					file.setReadable(true);
					file.setWritable(true);
				}
				//����
				if(chkHidden.isSelected()){
					
				}
				FileProperty.this.dispose();
				//���±���������
				resFrm.loadData(selectedNode);
			}
			else if(btn == btnCancel){
				FileProperty.this.dispose();
			}
			else{
				
			}
		}
		
	}
	
	/**
	 * ������
	 * @param file ��Ҫ���������ļ�
	 * @param newFileName �ļ���������
	 */
	public void rename(File file, String newFileName){
		//�ж��ļ��Ƿ����
		if(file.exists()){
			//����ļ�����
			//������������ļ�����
			File newFile = new File(file.getParent(), newFileName);
			//�жϸ�������ļ��Ƿ����
			if(!newFile.exists()){
				//�����������ļ������ڵ�
				//������
				file.renameTo(newFile);
			}
			else{
				JOptionPane.showMessageDialog(null, "���ļ����Ѿ����ڣ�");
			}
		}
		
	}

}
