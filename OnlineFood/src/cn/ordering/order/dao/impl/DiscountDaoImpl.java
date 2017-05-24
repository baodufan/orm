package cn.ordering.order.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.ordering.order.bean.Discount;
import cn.ordering.order.dao.DiscountDao;
import cn.ordering.util.DBUtil;

/**
 * 优惠券接口实现类
 * @author baodu
 *
 */
public class DiscountDaoImpl implements DiscountDao{

	//定义连接对象
	Connection conn=null;
	//根据id查看优惠券信息
	@Override
	public Discount listDiscount(Integer discountId) {
		//定义返回对象
		Discount dt=null;
			//获得连接对象
		try {
			conn=DBUtil.getConnection();
			//定义sql语句
			String sql="select*from tab_discount where discount_id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, discountId);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				dt=new Discount();
				dt.setDiscountId(rs.getInt("DISCOUNT_ID"));
				dt.setTimeLimit(rs.getString("TIME_LIMIT"));
				dt.setNum(rs.getInt("DISCOUNT_NUM"));
				dt.setUseLimit(rs.getInt("DISCOUNT_LIMIT"));
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

}
