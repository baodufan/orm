package cn.ordering.proscenium.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.regexp.internal.recompile;

import cn.ordering.proscenium.bean.Item;
import cn.ordering.proscenium.dao.ItemDao;
import cn.ordering.util.DBUtil;

/**
 * 商品业务接口的实现类
 * @author baodu
 *
 */
public class ItemDaoImpl implements ItemDao {

	//定义连接对象属性
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	//实现查询所有商品的方法
	@Override
	public List<Item> listItem() {
		//定义集合
		List<Item>list=new ArrayList<Item>();
		//获得连接对象
		try {
			conn=DBUtil.getConnection();
			//定义sql语句
			String sql="select *from tab_item";
			//获得预编译对象
			ps=conn.prepareStatement(sql);
			//获得结果集对象
			ResultSet rs=ps.executeQuery();
			//定义商品对象
			Item it=null;
			while (rs.next()) {
				it=new Item();
				it.setItemId(rs.getInt("item_id"));
				it.setItemName(rs.getString("item_name"));
				it.setPrice(rs.getInt("item_price")+"");
				it.setImage(rs.getString("item_img"));
				it.setType(rs.getString("item_type "));
				it.setDescipt(rs.getString("item_descript "));
				it.setItemStatus(rs.getString("item_status "));
				list.add(it);
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
		return list;
	}
	
	
	//查询单个商品方法
	@Override
	public Item SingleItem(Item item) {
		//定义返回对象
		Item ite=null;
		//获得连接对象
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		//定义sql语句
		String sql="select*from tab_item where item_id=?";
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			//设置参数值
			ps.setInt(1, item.getItemId());
			rs=ps.executeQuery();
			if(rs.next()){
				ite=new Item();
				ite.setItemId(rs.getInt("ITEM_ID"));
				ite.setItemName(rs.getString("ITEM_NAME"));
				ite.setPrice(rs.getInt("ITEM_PRICE")+"");
				ite.setImage(rs.getString("ITEM_IMG"));
				ite.setType(rs.getString("ITEM_TYPE"));
				ite.setDescipt(rs.getString("ITEM_DESCRIPT"));
				ite.setItemStatus(rs.getString("ITEM_STATUS"));
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ite;
	}

	//模糊查询之名字查询
	@Override
	public List<Item> MoreItem(Item item,String price1,String price2) {
		List<Item>list=new ArrayList<Item>();
		PreparedStatement pd=null;
		//连接对象
		try {
			conn=DBUtil.getConnection();
			//sql语句
			String sql="select*from tab_item";
			if(item.getItemName()!=null){
				sql+="where item_name like '%?%'";
				pd=conn.prepareStatement(sql);
				pd.setString(1, item.getItemName());
			}
			if(price1!=null&&price2!=null){
				sql+="where item_price between ? and ?";
				pd=conn.prepareStatement(sql);
				pd.setString(1, price1);
				ps.setString(2, price2);
			}
			ResultSet rs=pd.executeQuery();
			Item it=null;
			while (rs.next()) {
				it=new Item();
				it.setItemId(rs.getInt("ITEM_ID"));
				it.setItemName(rs.getString("ITEM_NAME"));
				it.setPrice(rs.getInt("ITEM_PRICE")+"");
				it.setImage(rs.getString("ITEM_IMG"));
				it.setType(rs.getString("ITEM_TYPE"));
				it.setDescipt(rs.getString("ITEM_DESCRIPT"));
				it.setItemStatus(rs.getString("ITEM_STATUS"));
				list.add(it);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
