package cn.ordering.shopcart.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.ordering.login.bean.User;
import cn.ordering.order.bean.Orderitem;
import cn.ordering.shopcart.bean.ShopCart;
import cn.ordering.shopcart.bean.ShopCartitem;
import cn.ordering.shopcart.bean.ShoppingCart;
import cn.ordering.shopcart.dao.ShopCartDao;
import cn.ordering.util.DBUtil;

/**
 * 购物车接口实现类
 * @author baodu
 *
 */
public class ShopCartDaoImpl implements ShopCartDao{

	//定义连接处理对象
	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	
	//增加数据到数据库购物车表
	@Override
	public void addShopcart(ShoppingCart sca) {
		//获得连接对象
		try {
			conn=DBUtil.getConnection();
			//定义sql语句
			String sql="insert into shop_car values(?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, sca.getUser().getUserid());
			ps.setInt(2, sca.getItemId());
			ps.setString(3, sca.getImage());
			ps.setString(4, sca.getItemName());
			ps.setString(5, sca.getPrice());
			ps.setInt(6, sca.getCount());
			ps.setString(7, sca.getSubtotal());
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

	
	//查询数据库购物车表数据
	@Override
	public List<ShoppingCart> listShopCart(User user) {
		//定义返回集合
		List<ShoppingCart>listcart=new ArrayList<ShoppingCart>();
		//获得连接对象
		try {
			conn=DBUtil.getConnection();
			//sql语句
			String sql="select*from shop_car where user_id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, user.getUserid());
			ResultSet rs=ps.executeQuery();
			ShoppingCart shc=null;
			while (rs.next()) {
				shc=new ShoppingCart();
				shc.setUser(user);
				shc.setItemId(rs.getInt("item_id"));
				shc.setImage(rs.getString("item_img"));
				shc.setItemName(rs.getString("item_name"));
				shc.setPrice(rs.getString("item_price"));
				shc.setCount(rs.getInt("item_count"));
				shc.setSubtotal(rs.getString("car_subtotal"));
				listcart.add(shc);
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
		return listcart;
	}


	//查询购物车表中是否存在该id商品
	@Override
	public ShoppingCart listcat(User user, Integer itemid) {
		  ShoppingCart sc=null;
		//获得连接
		try {
			conn=DBUtil.getConnection();
			//sql语句
			String sql="select*from shop_car where user_id=? and item_id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, user.getUserid());
			ps.setInt(2, itemid);
			rs=ps.executeQuery();
			if(rs.next()){
				sc=new ShoppingCart();
				sc.setUser(user);
				sc.setItemId(rs.getInt("item_id"));
				sc.setImage(rs.getString("item_img"));
				sc.setItemName(rs.getString("item_name"));
				sc.setPrice(rs.getString("item_price"));
				sc.setCount(rs.getInt("item_count"));
				sc.setSubtotal(rs.getString("car_subtotal"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sc;
	}


	//修改购物车表中数量
	@Override
	public void uodatecart(User user, Integer itemid, int num) {
		//获得连接对象
		try {
			conn=DBUtil.getConnection();
			//sql语句
			String sql="update shop_car set item_count=? where user_id=? and item_id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, num);
			ps.setInt(2, user.getUserid());
			ps.setInt(3, itemid);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
