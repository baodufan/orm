package cn.ordering.shopcart.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.ordering.proscenium.bean.Item;
import cn.ordering.proscenium.dao.ItemDao;
import cn.ordering.proscenium.dao.impl.ItemDaoImpl;
import cn.ordering.shopcart.bean.ShopCart;
import cn.ordering.shopcart.bean.ShopCartitem;

/**
 * 购物车业务servlet类
 * @author baodu
 *
 */
public class ShopCartServlet extends HttpServlet{

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			this.doPost(req, resp);
	}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//获得请求方法值
			String method=req.getParameter("method");
			//获得会话
			HttpSession hs=req.getSession();
			//获得购物车
			ShopCart scr=null;
					
			//针对method值进行判断调用对应的方法
			
			if(method==null){ //增加商品到购物车
				if(hs.getAttribute("ShopCart")!=null){
				scr=(ShopCart)hs.getAttribute("ShopCart");
			//获得请求参数值
			Integer itemId=Integer.parseInt(req.getParameter("itemId"));
			//获得商品对象封装值
			Item it=new Item();
			it.setItemId(itemId);
			//调用dao层方法传入商品id查询获得商品对象
			ItemDao ido=new ItemDaoImpl();
			//获得商品对象
			Item im=ido.SingleItem(it);
			//实例购物车条目类实例
			ShopCartitem sct=new ShopCartitem();
			sct.setItem(im);
			sct.setNum(im.getNum());
			//将购物车条目类增加到购物车类
			System.out.println(sct.getNum()+"--"+sct.getSubtotal()+"--"+sct.getItem().getItemName()+"--"+sct.getItem().getItemId());
			scr.addShopcartitem(sct);
			//重定向到主页
			resp.sendRedirect("index.jsp");
				}
			}
			//调用删除购物车商品方法
			else if(method.equals("close")){
				if(hs.getAttribute("ShopCart")!=null){
					scr=(ShopCart)hs.getAttribute("ShopCart");
				//活动请求参数值
			Integer id=Integer.parseInt(req.getParameter("itemId"));
			System.out.println("商品id："+id);
				scr.close(id);
				//重定向到购物车页面
				resp.sendRedirect("pages/shoppingcar/car.jsp");
				}
			}
			//调用清除购物车
			else if(method.equals("chear")){
				if(hs.getAttribute("ShopCart")!=null){
					scr=(ShopCart)hs.getAttribute("ShopCart");
				scr.chear();
				//重定向到购物车页面
				resp.sendRedirect("pages/shoppingcar/car.jsp");
				}
			}
			//调用修改数量的方法
			else if(method.equals("updateCart")){
				if(hs.getAttribute("ShopCart")!=null){
					scr=(ShopCart)hs.getAttribute("ShopCart");
				//获得商品id
				Integer itemId=Integer.parseInt(req.getParameter("itemid"));
				//获得修改的商品数量
				int num=Integer.parseInt(req.getParameter("num"));
				//调用购物车类方法修改
				scr.updateCart(itemId, num);
				//重定向到购物车页面
				resp.sendRedirect("pages/shoppingcar/car.jsp");
			}
			}
		}
}
