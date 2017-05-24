package cn.ordering.proscenium.dao;

import java.sql.SQLException;
import java.util.List;

import cn.ordering.proscenium.bean.Item;

/**
 * 分页查询业务接口
 * @author baodu
 *
 */
public interface PageDao {

	
	       //分页查询商品
		public List<Item> findByItems(int pageindex,int pagesize) throws ClassNotFoundException, SQLException;
		//查询商品表总记录数
		public int getCount() throws ClassNotFoundException, SQLException;
}
