package cn.ordering.shopcart.dao;

import java.util.List;

import cn.ordering.login.bean.User;
import cn.ordering.shopcart.bean.ShopCart;
import cn.ordering.shopcart.bean.ShoppingCart;

/**
 * 购物车业务接口类
 * @author baodu
 *
 */
public interface ShopCartDao {

	//向购物车表插入数据
	public void addShopcart(ShoppingCart shoppingCart);
	//查询数据库购物车列表
	public List<ShoppingCart> listShopCart(User user);
	//查询数据库购物车存储表单个数据
	public ShoppingCart listcat(User user,Integer itemid);
	//修改数据库购物车表中的数量
	public void uodatecart(User user,Integer itemid,int num);
}
