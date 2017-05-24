package cn.ordering.proscenium.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.ordering.proscenium.bean.Item;
import cn.ordering.proscenium.dao.PageDao;
import cn.ordering.util.DBUtil;

/**
 * 分页查询业务接口的实现类
 * @author baodu
 *
 */
public class PageDaoImpl implements PageDao{

	//定义连接
	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	//分页查询商品记录
	@Override
	public List<Item> findByItems(int pageindex, int pagesize) throws ClassNotFoundException, SQLException {
		//定义返回集合
		List<Item>list=new ArrayList<Item>();
		//获得连接对象	
		conn=DBUtil.getConnection();
			//sql语句
		String sql="select*from(select*from(select a.* ,rownum r from tab_item a)b where r<=?)c where r>?";
		ps=conn.prepareStatement(sql);
		ps.setInt(1, pageindex*pagesize);
		ps.setInt(2, (pageindex-1)*pagesize);
		rs=ps.executeQuery();
		//定义商品对象
		Item it=null;
		while(rs.next()){
			it=new Item();
			it.setItemId(rs.getInt("item_id"));
			it.setItemName(rs.getString("item_name"));
			it.setPrice(rs.getInt("item_price")+"");
			it.setImage(rs.getString("item_img"));
			it.setType(rs.getString("item_type"));
			it.setDescipt(rs.getString("item_descript"));
			it.setItemStatus(rs.getString("item_status"));
			list.add(it);
		}
		DBUtil.closeAll(conn, ps, rs);
		return list;
	}

	//查询商品表总记录数
	@Override
	public int getCount() throws ClassNotFoundException, SQLException {
		//获得连接对象	
	 conn=DBUtil.getConnection();
	 //定义返回值
	 int count=0;
	 //定义sql语句
	 String sql="select count(*) a from tab_item";
	 ps=conn.prepareStatement(sql);
	 rs=ps.executeQuery();
	 	if(rs.next()){
	 		count=rs.getInt("a");
	 	}
		return count;
	}

}
