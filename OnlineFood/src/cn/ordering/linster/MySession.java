package cn.ordering.linster;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.jspsmart.upload.Request;

import cn.ordering.login.bean.User;
import cn.ordering.proscenium.bean.Item;
import cn.ordering.shopcart.bean.ShopCart;
import cn.ordering.shopcart.bean.ShopCartitem;
import cn.ordering.shopcart.bean.ShoppingCart;
import cn.ordering.shopcart.dao.ShopCartDao;
import cn.ordering.shopcart.dao.impl.ShopCartDaoImpl;
import oracle.net.aso.s;

/**
 * 购物车监听器
 * @author baodu
 *
 */
public class MySession implements HttpSessionListener,HttpSessionAttributeListener{

		 
	//定义关联
	private ShopCartDao scd=new ShopCartDaoImpl();
	 
	//会话设置参数调用
	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		//获得会话对象
		HttpSession hs=se.getSession();
		User use=null;
		//获得当前用户对象
	if(hs.getAttribute("user")!=null){
		  use=(User)hs.getAttribute("user");  
		 //定义集合保存数据
		List<ShoppingCart> listcart=null;
		//调用dao层方法传入对象查询购物车表数据返回集合
		listcart=scd.listShopCart(use);
		
		//获得购物车
		if(hs.getAttribute("ShopCart") !=null){
			ShopCart spc=(ShopCart)hs.getAttribute("ShopCart");
		//定义购物车条目类
		ShopCartitem sct=null;
		ShoppingCart sop =null;
		//定义商品类
		Item item=null;
		
		if(listcart.size()!=0){
		//循环遍历为条目类赋值
		for(int i =0; i<listcart.size();i++){
			sop=listcart.get(i);
			item=new Item();
			item.setItemName(sop.getItemName());
			item.setItemId(sop.getItemId());
			item.setImage(sop.getImage());
			item.setNum(sop.getCount());
			item.setPrice(sop.getPrice());
			sct=new ShopCartitem();
			sct.setNum(sop.getCount());
			sct.setItem(item);
			if(sct!=null){
				 spc.addShopcartitem(sct);
			}
		  }
		}
	  }
	}
	}
	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		HttpSessionAttributeListener.super.attributeRemoved(se);
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		HttpSessionAttributeListener.super.attributeReplaced(se);
	}

	//会话创建时调用
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		HttpSessionListener.super.sessionCreated(se);
	}

	//会话销毁时调用
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		//获得会话对象
		HttpSession hs=se.getSession();
		//获得购物车类
		ShopCart shc=(ShopCart)hs.getAttribute("ShopCart");
		//获得用户对象
		User user=(User)hs.getAttribute("user");
		//实例化数据库对应的购物车表
		ShoppingCart sct=null;
		//判断购物车不为空则赋值调用dao层方法插入数据
		if(shc!=null){
		for(ShopCartitem sc:shc.getCartitem()){  //循环遍历购物车为购物车表赋值
			//先调用方法查询购物车表商品是否存在数据库
			ShoppingCart shpp=scd.listcat(user, sc.getItem().getItemId());  //调用dao层方法先查看数据库是否存在商品
			if(shpp==null){
			sct=new ShoppingCart();
			sct.setUser(user);
			sct.setItemId(sc.getItem().getItemId());
			sct.setItemName(sc.getItem().getItemName());
			sct.setImage(sc.getItem().getImage());
			sct.setPrice(sc.getItem().getPrice());
			sct.setCount(sc.getNum());
			sct.setSubtotal(sc.getSubtotal()+"");
			   scd.addShopcart(sct);      //调用dao层方法插入数据
			System.out.println("数据插入了");
			}else {
				scd.uodatecart(user, sc.getItem().getItemId(), sc.getNum());  //如果存在那么直接循环调用方法修改数据库商品数量即可
				System.out.println("数据修改了");
			}
		}
		}	
	}

	
}
