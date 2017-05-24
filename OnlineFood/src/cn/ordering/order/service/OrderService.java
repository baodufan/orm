package cn.ordering.order.service;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.ordering.login.bean.User;
import cn.ordering.order.bean.Discount;
import cn.ordering.order.bean.Order;
/**
 * 订单业务service
 * @author baodu
 *
 */
import cn.ordering.order.dao.OrderDao;
import cn.ordering.order.dao.impl.OrderDaoImpl;
import cn.ordering.util.DBUtil;

public class OrderService {
		//定义关联
	private OrderDao od=new OrderDaoImpl();
	private Connection conn=null;
	
	//调用增加订单和订单条目的方法
	public void addOrderItem(Order order){
		try {
			//获得对象
			conn=DBUtil.getConnection();
			//开启事务为手动提交
			conn.setAutoCommit(false);
			//调用dao层方法增加数据
			od.addOrder(order, conn);
			od.addOrderItem(order.getOrderitems(), conn);
			System.out.println("订单条目："+order.getOrderitems().size());
			//提交事务
			conn.commit();
		} catch (Exception e) {
			//出现异常回滚
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	//查询所有订单
	public List<Order> listOrders(User user){
		return od.myOrders(user);  //调用dao层方法直接返回集合
	}
	
	//查看单个订单
	public Order listOrder(String orderId,User user){
		return od.loadOrder(orderId, user); //调用dao层方法直接返回集合
	}
	
	
	//查看订单状态
	public void  ExamineStatus(String orderId,String status){
		//调用dao层方法查看订单状态
		String sta=od.getOrderStatus(orderId);
		//进行判断
		if(sta.equals("未接收")){
			//调用dao层方法修改订单状态
			od.updateStatus(orderId, status);
		}
		else if(sta.equals("已接收")){
			//调用dao层方法修改订单状态
			od.updateStatus(orderId, status);
		}
		else if(sta.equals("已配送")){
			//调用dao层方法修改订单状态
			od.updateStatus(orderId, status);
		}
	}
	
	//取消订单方法
	public void AbolishOrder(String orderId) throws OrderException{
		//调用dao层方法查看订单状态
		String status=od.getOrderStatus(orderId);
		//进行判断
		if(status.equals("已接收")&&status.equals("已配送")&&status.equals("已完成")){
			throw new OrderException("订单已接收正在配送中，不能取消订单！");
		}else{
			//调用dao层方法修改订单状态
			od.updateStatus(orderId, "已取消");
		}
	}
}
