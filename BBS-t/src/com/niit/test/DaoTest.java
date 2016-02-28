package com.niit.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.niit.dao.impl.BoardDao;
import com.niit.dao.impl.ReplyDao;
import com.niit.dao.impl.TopicDao;
import com.niit.dao.impl.UserDao;
import com.niit.entity.Board;
import com.niit.entity.Topic;
import com.niit.entity.User;

public class DaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UserDao userDao = new UserDao();
//		User user = new User("jack", "jack123", "6.gif", new Timestamp(new Date().getTime()), 1);
//		userDao.addUser(user);
		
//		User user = userDao.findUserById(1);
//		if(user != null){
//			System.out.println(user.getUserName());
//		}
		
//		User user = userDao.findUserByName("jack");
//		if(user != null){
//			System.out.println(user.getHead());
//		}
		
		BoardDao boardDao = new BoardDao();
//		Board board = boardDao.findBoardById(1);
//		if(board != null){
//			System.out.println(board.getBoardName());
//		}
//		ArrayList<Board> list = boardDao.findBoardListById(0);
//		for(Board board : list){
//			System.out.println(board.getBoardName());
//		}
		
		TopicDao topicDao = new TopicDao();
		ArrayList<Topic> list = topicDao.findTopicListByBoardId(8, 1);
		for(Topic t : list){
			System.out.println(t.getTitle());
		}
//		Topic topic = topicDao.findLastTopicByBoardId(4);
//		if(topic != null){
//			System.out.println(topic.getTitle());
//		}
		
//		int count = topicDao.findTopicCountByBoardId(4);
//		System.out.println(count);
		
		ReplyDao replyDao = new ReplyDao();
//		int count = replyDao.findReplyCountByTopicId(23);
//		System.out.println(count);
	}

}
