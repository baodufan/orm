package cn.ordering.proscenium.service;
/**
 * 商品业务处理中转service
 * @author baodu
 *
 */

import java.util.List;

import cn.ordering.proscenium.bean.Item;
import cn.ordering.proscenium.dao.ItemDao;
import cn.ordering.proscenium.dao.impl.ItemDaoImpl;

public class ItemService {
      //定义关联
	private ItemDao ido=new ItemDaoImpl();
	
	//定义查询单个商品方法
	public Item listItem(Item item){
		return ido.SingleItem(item);
	}
	
	//模糊查询
	public List<Item> lists(Item item,String price1,String price2){
		return ido.MoreItem(item, price1, price2);
	}
}
