package com.niit.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.dao.impl.BoardDao;
import com.niit.entity.Board;
import com.niit.entity.Topic;

public class InitbbsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BoardDao boardDao = new BoardDao();
		//创建Map集合，存储子父板块信息
		HashMap<String, ArrayList<Board>> boardMap = new HashMap<String, ArrayList<Board>>();
		//HashMap<String, ArrayList<HashMap<Board, Topic>>> map = new HashMap<String, ArrayList<HashMap<Board,Topic>>>();
		//查询所有的父版块
		ArrayList<Board> parentList = boardDao.findBoardListById(0);
		//遍历父版块
		for(Board parentBoard : parentList){
			//查询父版块的子版块
			ArrayList<Board> childList = boardDao.findBoardListById(parentBoard.getBoardId());
			//将对应的父版块名称和其子版块写入map
			boardMap.put(parentBoard.getBoardName(), childList);
		}
		//将所有板块信息写入请求
		req.setAttribute("boardMap", boardMap);
		req.getRequestDispatcher("WEB-INF/board.jsp").forward(req, resp);
	}
	
}
