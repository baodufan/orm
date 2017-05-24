package cn.ordering.order.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.ordering.login.bean.User;
import cn.ordering.order.bean.Discount;
import cn.ordering.order.bean.Order;
import cn.ordering.order.bean.Orderitem;
import cn.ordering.order.dao.OrderDao;
import cn.ordering.proscenium.bean.Item;
import cn.ordering.util.DBUtil;

/**
 * 订单业务接口实现类
 * @author baodu
 *
 */
public class OrderDaoImpl implements OrderDao{

	
	//增加订单方法
	@Override
	public void addOrder(Order order,Connection conn) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		//获得连接对象
		try {
			conn=DBUtil.getConnection();
			
			//定义sql语句
			String sql="insert into tab_order values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			//预编译语句对象
			ps=conn.prepareStatement(sql);
			//设置参数值
			ps.setString(1, order.getOrderId());
			Date date=new Date(order.getOrdertime().getTime());
			ps.setDate(2, date);
			ps.setInt(3, order.getUser().getUserid());
			ps.setInt(4, order.getDiscount().getDiscountId());
			ps.setString(5, order.getPayWay());
			ps.setString(6, order.getSendType());
			ps.setInt(7, 1);
			ps.setString(8, order.getAddress());
			ps.setString(9, order.getPhone());
			ps.setString(10, order.getOrderStatus());
			ps.setString(11, order.getMessage());
			ps.setString(12, order.getEvaluate());
			ps.setString(13, order.getTotal());
			int a=ps.executeUpdate();
			System.out.println("增加订单了");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DBUtil.closeAll(conn, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	//增加订单条目
	@Override
	public void addOrderItem(List<Orderitem> orderitems,Connection conn) {
		PreparedStatement psp=null;
		ResultSet rs=null;
		//获得连接对象
		try {
			conn=DBUtil.getConnection();
			//定义sql语句
			String sql="insert into order_list values(?,?,?,?,?,?)";
			//获得预编译对象
			 psp=conn.prepareStatement(sql);
			for(Orderitem ort:orderitems){
				psp.setString(1, ort.getOrder().getOrderId());
				psp.setInt(2, ort.getItem().getItemId());
				psp.setString(3, ort.getItem().getItemName());
				psp.setString(4, ort.getItem().getPrice());
				psp.setInt(5, ort.getCount());
				psp.setString(6, ort.getSubtotal());
				psp.addBatch();
			}
			psp.executeBatch();
			System.out.println("增加订单条目了");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DBUtil.closeAll(conn, psp, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	//查询我的所有订单
	@Override
	public List<Order> myOrders(User user) {
		ResultSet rs=null;
		PreparedStatement pspt=null;
		Connection conn=null;
		//定义返回集合
		List<Order>list=new ArrayList<Order>();
		//获得连接对象
		try {
			conn=DBUtil.getConnection();
			//定义sql语句
			String sql="select*from tab_order where user_id=?";
			//预编译语句对象
			pspt=conn.prepareStatement(sql);
			//设置参数值
			pspt.setInt(1, user.getUserid());
			 rs=pspt.executeQuery();
			Order od=null;
			while (rs.next()) {
			od=new Order();
			od.setOrderId(rs.getString("order_id"));
			od.setOrdertime(rs.getDate("order_time"));
			od.setUser(user);
			od.setPayWay(rs.getString("pay_way"));
			od.setSendType(rs.getString("send_type"));
			od.setAddress(rs.getString("order_address"));
			od.setPhone(rs.getString("order_phone"));
			od.setOrderStatus(rs.getString("order_status"));
			od.setMessage(rs.getString("order_message"));
			od.setEvaluate(rs.getString("order_evaluate"));
			od.setTotal(rs.getString("order_total"));
			int id=rs.getInt("discount_id");
			od.setDiscount(getDiscount(id));
			list.add(od);//加入到集合中
		}
			//循环遍历集合为每个订单类加载它所有的订单条目
			for(Order ord:list){
				loadorderItems(ord);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DBUtil.closeAll(conn, pspt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public Discount getDiscount(int id){
		ResultSet rs=null;
		PreparedStatement pt=null;
		Connection conn=null;
		Discount dt=null;
		try {
			conn=DBUtil.getConnection();
			String sq="select*from tab_discount where discount_id=?";
			pt=conn.prepareStatement(sq);
			pt.setInt(1, id);
			ResultSet rs1=pt.executeQuery();
			if(rs1.next()){
				dt=new Discount();
				dt.setDiscountId(rs1.getInt("DISCOUNT_ID"));
				dt.setNum(rs1.getInt("DISCOUNT_NUM"));
				dt.setTimeLimit(rs1.getString("TIME_LIMIT"));
				dt.setUseLimit(rs1.getInt("discount_limit"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dt;
	}
	
	//加载订单的所有订单条目信息
	private void loadorderItems(Order od) {
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection conn=null;
		//获得连接对象
		try {
			conn=DBUtil.getConnection();
			//定义sql语句
			String sql="select *from order_list a,tab_item b where a.item_id=b.item_id and order_id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, od.getOrderId());
			//定义一个集合存放连表查询出来的结果
			List<Map<String, Object>>listmap=new ArrayList<Map<String,Object>>();
			//定义订单对象接受传入的对象
			//Order ord=od;
			//定义结果集
			rs=ps.executeQuery();
			//定义map集合
			Map<String, Object>map=null;
			int count=1;
			while (rs.next()) {
				map=new HashMap<String, Object>();
				map.put("order_id", rs.getString("order_id"));
				map.put("item_id", rs.getInt("item_id"));
				map.put("item_name", rs.getString("item_name"));
				map.put("item_price", rs.getString("item_price"));
				map.put("item_count", rs.getInt("item_count"));
				map.put("(order_subtotal", rs.getString("order_subtotal"));
				map.put("item_img", rs.getString("item_img"));
				map.put("item_type", rs.getString("item_type"));
				map.put("item_descript", rs.getString("item_descript"));
				map.put("item_status", rs.getString("item_status"));
				Collection<Object> st = map.values();
				for(Object object : st){
					System.out.println(count+"----"+object);
				}
				count++;
				listmap.add(map);
			}
			List<Orderitem>orderitems=toitems(listmap, od); //调用下面的方法转换集合为对象
			od.setOrderitems(orderitems);  //将返回的集合设置到订单类的集合属性
			System.out.println("---"+orderitems.size());
			System.out.println("订单集合长度："+od.getOrderitems().size());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//遍历集合转换为两个对象
	private List<Orderitem> toitems(List<Map<String, Object>> listmap, Order od) {
		List<Orderitem>listOrderitems=new ArrayList<Orderitem>();
		Order or=od;
		for(Map<String, Object> ma:listmap){
			Orderitem om=toOrderitems(ma,or); //循环调用下面的方法将map集合转为订单条目类和商品类
			listOrderitems.add(om);
		}
		return listOrderitems;
	}

	//获取集合的值为商品类和订单条目类赋值，并建立关系
	private Orderitem toOrderitems(Map<String, Object> ma, Order od) {
			Item item=new Item();//获得商品类
			item.setItemId((Integer)ma.get("item_id"));
			item.setItemName((String)ma.get("item_name"));
			item.setPrice((String)ma.get("item_price"));
			item.setImage((String)ma.get("item_img"));
			item.setType((String)ma.get("item_type"));
			item.setDescipt((String)ma.get("item_descript"));
			item.setItemStatus((String)ma.get("item_status"));

			Orderitem ordt=new Orderitem(); //获得订单项类
			ordt.setOrder(od);
			ordt.setCount((Integer)ma.get("item_count"));
			ordt.setItem(item);
			ordt.setSubtotal((String)ma.get("order_subtotal"));
			return ordt;
	}

	
	//查看单个订单
	@Override
	public Order loadOrder(String orderId, User user) {
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection conn=null;
		
		//定义返回对象
		Order ord=null;
		//获得连接对象
		try {
			conn=DBUtil.getConnection();
			//定义sql语句
			String sql="select*from tab_order where order_id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, orderId);
			rs=ps.executeQuery();
			if(rs.next()){
				ord=new Order();
				ord.setOrderId(rs.getString("order_id"));
				ord.setOrdertime(rs.getDate("order_time"));
				ord.setUser(user);
				int id=rs.getInt("discount_id");
				ord.setDiscount(getDiscount(id)); //调用上述方法返回优惠券对象
				ord.setPayWay(rs.getString("pay_way"));
				ord.setSendType(rs.getString("send_type"));
				ord.setAddress(rs.getString("order_address"));
				ord.setPhone(rs.getString("order_phone"));
				ord.setOrderStatus(rs.getString("order_status"));
				ord.setMessage(rs.getString("order_message"));
				ord.setEvaluate(rs.getString("order_evaluate"));
				ord.setTotal(rs.getString("order_total"));
				System.out.println("单个订单："+ord);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loadorderItems(ord);//调用上述定义方法为订单加载它所有的订单条目信息
		
		return ord;
	}

	//查看订单状态
	@Override
	public String getOrderStatus(String orderId) {
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection conn=null;
			//定义返回状态值
		String orderStatus=null;
			//获得连接对象
			try {
				conn=DBUtil.getConnection();
				//定义sql语句
				String sql="select order_status from tab_order where order_id=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, orderId);
				rs=ps.executeQuery();
				if(rs.next()){
					orderStatus=rs.getString("order_status");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					DBUtil.closeAll(conn, ps, rs);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return orderStatus;
	}

	//修改订单状态
	@Override
	public void updateStatus(String orderId, String status) {
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection conn=null;
		//获得连接对象
		try {
			conn=DBUtil.getConnection();
			//定义sql语句
			String sql="update tab_order set order_status=? where order_id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, status);
			ps.setString(2, orderId);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DBUtil.closeAll(conn, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
