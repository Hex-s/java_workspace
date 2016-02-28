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
		//����Map���ϣ��洢�Ӹ������Ϣ
		HashMap<String, ArrayList<Board>> boardMap = new HashMap<String, ArrayList<Board>>();
		//HashMap<String, ArrayList<HashMap<Board, Topic>>> map = new HashMap<String, ArrayList<HashMap<Board,Topic>>>();
		//��ѯ���еĸ����
		ArrayList<Board> parentList = boardDao.findBoardListById(0);
		//���������
		for(Board parentBoard : parentList){
			//��ѯ�������Ӱ��
			ArrayList<Board> childList = boardDao.findBoardListById(parentBoard.getBoardId());
			//����Ӧ�ĸ�������ƺ����Ӱ��д��map
			boardMap.put(parentBoard.getBoardName(), childList);
		}
		//�����а����Ϣд������
		req.setAttribute("boardMap", boardMap);
		req.getRequestDispatcher("WEB-INF/board.jsp").forward(req, resp);
	}
	
}
