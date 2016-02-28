package com.niit.entity;
/**
 * °å¿éÀà
 * @author Administrator
 *
 */
public class Board {
	private int boardId;
	private String boardName;
	private int prarentId;
	
	public int getBoardId() {
		return boardId;
	}
	
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public int getPrarentId() {
		return prarentId;
	}

	public void setPrarentId(int prarentId) {
		this.prarentId = prarentId;
	}
	
	
	
}
