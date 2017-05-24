package cn.ordering.proscenium.service;
import java.sql.SQLException;
/**
 * 分页处理service
 * @author baodu
 *
 */
import java.util.List;

import cn.ordering.proscenium.bean.Item;
import cn.ordering.proscenium.bean.PageItem;
import cn.ordering.proscenium.dao.PageDao;
import cn.ordering.proscenium.dao.impl.PageDaoImpl;

public class PageService {
	
	private PageDao pd=new PageDaoImpl();
//调用dao层方法获得pageitem对象
	public PageItem<Item> getItems(int page,int pagesize){
		PageItem pit=new PageItem();
		pit.setPage(page);
		pit.setPagesize(pagesize);
		//定义查询返回集合
		List<Item>list=null;
		try {
			//调用dao层查询方法获得商品集合
			list=pd.findByItems(page, pagesize);
			pit.setList(list); //设置查询出的集合到对象属性中
			//调用dao层方法查询总记录数
			int pagecount=pd.getCount();
			pit.setPagecount(pagecount); //设置中记录数到对象属性
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pit;
	}
	
	
}
