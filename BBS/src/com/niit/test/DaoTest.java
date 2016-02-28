package com.niit.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.niit.dao.impl.BlockDao;
import com.niit.dao.impl.ReplyDao;
import com.niit.dao.impl.TopicDao;
import com.niit.dao.impl.UserDao;
import com.niit.entity.Block;
import com.niit.entity.Reply;
import com.niit.entity.Topic;
import com.niit.entity.User;

public class DaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UserDao userDao = new UserDao();
//		User user = new User("mitty", "0000", 1, "mitty@qq.com",new Timestamp(new Date().getTime()), "i am mitty",new Timestamp(new Date().getTime()),1,"7.gif");
//		System.out.println(user.getuEmail());
//		userDao.addUser(user);
		
		User user = userDao.findUserById(2);
		if(user != null){
			System.out.println(user.getuName());
		}
		
//		User user = userDao.findUserByName("mitty");
//		if(user != null){
//			System.out.println(user.getuHead());
//		}
		
//		BlockDao boardDao = new BlockDao();
////		Block board = boardDao.findBlockById(11);
////		if(board != null){
////			System.out.println(board.getPrarentId());
////		}
//		
//		ArrayList<Block> list = boardDao.findBlockListById(0);
//		for(Block b : list){
//			System.out.println(b.getbName());
//		}
////		
//		TopicDao topicDao = new TopicDao();
//		Topic t = topicDao.findTopicById(1);
//		System.out.println(t.gettContent());
		//Topic t = new Topic(1, 10, 4, "test", "daotest_topic_insert", new Timestamp(new Date().getTime()), new Timestamp(new Date().getTime()), 1, 0);
		//topicDao.addTopic(t);
//		Topic t = topicDao.findLastTopicByBoardId(9);
//		Topic t = topicDao.findTopicById(10);
//		System.out.println(t.gettContent());
//		int count  = topicDao.findTopicCountByBlockdId(20);
//		System.out.println(count);
		
//		ArrayList<Topic> list = topicDao.findTopicListByBlockId(22, 1);
//		for(Topic t:list){
//			System.out.println(t.gettTitle());
//		}
		
//		topicDao.modifyTopicFlag(21, 1);
//		ArrayList<Topic> list = topicDao.findTopicListByBoardId(8, 1);
//		for(Topic t : list){
//			System.out.println(t.getTitle());
//		}
////		Topic topic = topicDao.findLastTopicByBoardId(4);
////		if(topic != null){
////			System.out.println(topic.getTitle());
////		}
//		
////		int count = topicDao.findTopicCountByBoardId(4);
////		System.out.println(count);
//		
//		ReplyDao replyDao = new ReplyDao();
//		int count = replyDao.findReplyCountByTopicId(23);
//		System.out.println(count);
		
//		ReplyDao r = new ReplyDao();
////		int c = r.findReplyCountByTopicId(49);
////		System.out.println(c);
////		ArrayList<Reply> rlist = r.findReplyListByTopicId(49, 1);
////		for(Reply rl : rlist){
////			System.out.println(rl.getrContent());
////		}
////		Reply re = r.findReplyById(41);
////		System.out.println(re.getrContent());
//		Reply reply = new Reply();
//		reply.setrTid(61);
//		reply.setrUserid(3);
//		reply.setrContent("DAO≤‚ ‘ªÿÃ˚");
//		r.addReply(reply);
		
		TopicDao top = new TopicDao();
		Topic t = top.findLastTopicByBlockdId(17);
		System.out.println(t.gettTitle());
//		ArrayList<Topic> list = top.findTopicListByUserId(1, 1);
//		for(Topic t : list){
//			System.out.println(t.gettContent()+t.gettTitle());
//			
//		}
//		System.out.println(top.findTopicCountByUserId(1));
//		ReplyDao replyDao = new ReplyDao();
//		Reply r = replyDao.findReplyById(1);
//		System.out.println(r.getrTid());
//		Topic t = top.findTopicById(2);
//		System.out.println(t.gettTitle());
//		System.out.println(t.gettContent());
//		System.out.println(t.getTbId());
		
//		top.modifyLastEdit(2);
//		replyDao.deleteReplysByTopicId(121);
//		top.deleteTopicByTopicId(121);
	}

}
