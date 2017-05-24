package cn.ordering.order.dao;

import java.sql.Connection;
import java.util.List;

import cn.ordering.login.bean.User;
import cn.ordering.order.bean.Discount;
import cn.ordering.order.bean.Order;
import cn.ordering.order.bean.Orderitem;
import cn.ordering.proscenium.bean.Item;

/**
 * 订单dao层业务处理接口
 * @author baodu
 *
 */
public interface OrderDao {
 
	//增加订单
	public void addOrder(Order order,Connection conn);
	//增加订单条目
	public void addOrderItem(List<Orderitem> orderitems,Connection conn);
	//查询所有订单及订单项
	public List<Order> myOrders(User user);
	//加载单个订单
	public Order loadOrder(String orderId,User user);
	//查询订单状态
	public String getOrderStatus(String orderId);
	//确认收货修改订单状态
	public void updateStatus(String orderId,String status);
	//查看用户所有订单表
}
