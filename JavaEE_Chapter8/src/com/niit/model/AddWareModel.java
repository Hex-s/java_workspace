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
		//获取商品编号
		int wareId = Integer.parseInt(request.getParameter("wareId"));
		//获取购买数量
		int buyNum = Integer.parseInt(request.getParameter("buyNum"));
		WareDao wareDao = new WareDao();
		//根据编号查询
		Ware ware = wareDao.findWareById(wareId);
		
		//判断购买数量和库存是否合法
		if(buyNum > ware.getNum()){
			//重新写入商品信息至请求对象
			request.setAttribute("ware", ware);
			request.setAttribute("error", "购买数量超过了库存！");
			return "WEB-INF/info.jsp";
		}
		//修改商品库存
		ware.setNum(ware.getNum()-buyNum);
		wareDao.modifyWare(ware);
		//生产一条购物车的购买记录
		Record record = new Record(wareId, ware.getWareName(), ware.getPrice(), 0, buyNum, buyNum*ware.getPrice(),new Date());
		//获取session
		HttpSession session = request.getSession();
		//获取购物车
		ArrayList<Record> list = (ArrayList<Record>)session.getAttribute("shoppingCar");
		if(list != null || !list.isEmpty()){
			//将相同购物信息合并
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
				//写入购物车
				list.add(record);
			}
		}
		else{
			
			list.add(record);
		}
		//重新将购物车写入session
		session.setAttribute("shoppingCar", list);
		//重新写入商品信息至请求对象
		request.setAttribute("ware", ware);
		//添加购物车成功的标识
		request.setAttribute("flag", "true");
		return "WEB-INF/info.jsp";
	}

}
