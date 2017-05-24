package cn.ordering.proscenium.dao;
/**
 * 商品业务接口类
 * @author baodu
 *
 */
import java.util.List;

import cn.ordering.proscenium.bean.Item;

 
  public interface ItemDao {
	  //查询所有菜品方法
	public List<Item> listItem();
	
	//根据id查询单个菜品信息
	public Item SingleItem(Item item);
	
	//模糊查询及多条件查询
	public List<Item> MoreItem(Item item,String price1,String price2);
	
}
