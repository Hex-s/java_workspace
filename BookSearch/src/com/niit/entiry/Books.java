package com.niit.entiry;

/**
 * 图示类
 * @author Administrator
 *
 */
public class Books {

	//图书编号
	private int bookId;
	//图书名称
	private String bookName;
	//作者编号
	private int bWriterId;
	//图片
	private String bPic;
	//出版社编号
	private int bPublishId;
	//类别编号
	private int bVarity;
	//简介
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
