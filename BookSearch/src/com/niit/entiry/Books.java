package com.niit.entiry;

/**
 * ͼʾ��
 * @author Administrator
 *
 */
public class Books {

	//ͼ����
	private int bookId;
	//ͼ������
	private String bookName;
	//���߱��
	private int bWriterId;
	//ͼƬ
	private String bPic;
	//��������
	private int bPublishId;
	//�����
	private int bVarity;
	//���
	private String bInfo;
	
	public Books(){
		
	}
	
	public Books(String bookName,int bWriterId,String bPic,int bPublishId,int bVarity,String bInfo){
		this.bookName = bookName;
		this.bWriterId = bWriterId;
		this.bPic = bPic;
		this.bPublishId = bPublishId;
		this.bVarity = bVarity;
		this.bInfo = bInfo;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getbWriterId() {
		return bWriterId;
	}

	public void setbWriterId(int bWriterId) {
		this.bWriterId = bWriterId;
	}

	public String getbPic() {
		return bPic;
	}

	public void setbPic(String bPic) {
		this.bPic = bPic;
	}

	public int getbPublishId() {
		return bPublishId;
	}

	public void setbPublishId(int bPublishId) {
		this.bPublishId = bPublishId;
	}

	public int getbVarity() {
		return bVarity;
	}

	public void setbVarity(int bVarity) {
		this.bVarity = bVarity;
	}

	public String getbInfo() {
		return bInfo;
	}

	public void setbInfo(String bInfo) {
		this.bInfo = bInfo;
	}
	
	
}
