package com.niit.model;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niit.bean.Record;
import com.niit.bean.Ware;
import com.niit.dao.impl.WareDao;

public class AddWareModel implements IModel {

	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		//��ȡ��Ʒ���
		int wareId = Integer.parseInt(request.getParameter("wareId"));
		//��ȡ��������
		int buyNum = Integer.parseInt(request.getParameter("buyNum"));
		WareDao wareDao = new WareDao();
		//���ݱ�Ų�ѯ
		Ware ware = wareDao.findWareById(wareId);
		
		//�жϹ��������Ϳ���Ƿ�Ϸ�
		if(buyNum > ware.getNum()){
			//����д����Ʒ��Ϣ���������
			request.setAttribute("ware", ware);
			request.setAttribute("error", "�������������˿�棡");
			return "WEB-INF/info.jsp";
		}
		//�޸���Ʒ���
		ware.setNum(ware.getNum()-buyNum);
		wareDao.modifyWare(ware);
		//����һ�����ﳵ�Ĺ����¼
		Record record = new Record(wareId, ware.getWareName(), ware.getPrice(), 0, buyNum, buyNum*ware.getPrice(),new Date());
		//��ȡsession
		HttpSession session = request.getSession();
		//��ȡ���ﳵ
		ArrayList<Record> list = (ArrayList<Record>)session.getAttribute("shoppingCar");
		if(list != null || !list.isEmpty()){
			//����ͬ������Ϣ�ϲ�
			boolean addFalg = false;
			for(int i = 0; i < list.size(); i++){
				if(list.get(i).getWareId() == record.getWareId()){
					list.get(i).setBuyNum(list.get(i).getBuyNum() + record.getBuyNum());
					list.get(i).setPayPrice(list.get(i).getPayPrice() + record.getPayPrice());
					list.get(i).setBuyTime(record.getBuyTime());
					addFalg = true;
					break;
				}
			}
			if(addFalg == false){
				//д�빺�ﳵ
				list.add(record);
			}
		}
		else{
			
			list.add(record);
		}
		//���½����ﳵд��session
		session.setAttribute("shoppingCar", list);
		//����д����Ʒ��Ϣ���������
		request.setAttribute("ware", ware);
		//��ӹ��ﳵ�ɹ��ı�ʶ
		request.setAttribute("flag", "true");
		return "WEB-INF/info.jsp";
	}

}
