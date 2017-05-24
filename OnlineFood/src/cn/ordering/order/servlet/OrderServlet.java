package cn.ordering.order.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;
import com.sun.crypto.provider.RSACipher;

import cn.ordering.login.bean.User;
import cn.ordering.order.bean.Discount;
import cn.ordering.order.bean.Order;
import cn.ordering.order.bean.Orderitem;
import cn.ordering.order.dao.DiscountDao;
import cn.ordering.order.dao.impl.DiscountDaoImpl;
import cn.ordering.order.service.OrderException;
import cn.ordering.order.service.OrderService;
import cn.ordering.shopcart.bean.ShopCart;
import cn.ordering.shopcart.bean.ShopCartitem;

/**
 * 订单业务处理servlet
 * @author baodu
 *
 */
public class OrderServlet extends HttpServlet{

	//定义关联
	private OrderService ods=new OrderService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//获得请求方法method的参数值
		String method=req.getParameter("method");
		//获得会话
		HttpSession hs=req.getSession();
		//获得当前用户对象
		User user=(User)hs.getAttribute("user");
		System.out.println("当前用户："+user.getAccount());
		//判断请求的方法类型
		if(method==null){   //该方法为执行添加订单操作方法
			
			//调用dao层方法获得优惠券对象
			Integer discountId=Integer.parseInt(req.getParameter("discountId")); //获得优惠券id
			DiscountDao ds=new DiscountDaoImpl();
			Discount discount=ds.listDiscount(discountId);//获得优惠券对象
			//获得请求表单中参数值
			String address=req.getParameter("address"); //地址
			String phone=req.getParameter("phone");   //电话
			String sendType=req.getParameter("ps");  //配送方式
			String payWay=req.getParameter("payWay");  //支付方式
			String message=req.getParameter("message");//订单预留言
			//获得购物车
			ShopCart shc=(ShopCart)hs.getAttribute("ShopCart");
			//获得订单实例
			Order order=new Order();
			//设置参数值
			String oid=UUID.randomUUID().toString();
			order.setOrderId(oid);
			order.setOrdertime(new Date());
			order.setUser(user);
			order.setDiscount(discount);
			order.setPayWay(payWay);
			order.setSendType(sendType);
			order.setOrderStatus("已付款");
			order.setMessage(message);
			order.setTotal(shc.getTotal()+"");
			order.setAddress(address);
			order.setPhone(phone);
			
			//定义订单项集合
			List<Orderitem>list=new ArrayList<Orderitem>();
			//循环遍历购物车项类为订单项类赋值
			for(ShopCartitem od:shc.getCartitem()){
				Orderitem odt=new Orderitem();
				odt.setCount(od.getNum());
				odt.setItem(od.getItem());
				odt.setOrder(order);
				odt.setSubtotal(od.getSubtotal()+"");
				list.add(odt); //将每个订单项表添加到集合中
			}
			//设置订单类集合属性
			order.setOrderitems(list);
			System.out.println(list.get(0).getItem().getItemName());
			//清空购物车
			shc.chear();
			//调用service类方法完成订单数据插入
			ods.addOrderItem(order);
			System.out.println(order.getOrderId()+order.getAddress());
			//绑定数据到作用域中
			req.setAttribute("order", order);
			//转发到订单显示页面
			req.getRequestDispatcher("pages/shoppingcar/orderView.jsp").forward(req, resp);
			
		}
		    
			//调用查看我的所有订单
		else if(method.equals("myOrders")){
			//调用service类方法完成订单数据插入
			List<Order>listorder=ods.listOrders(user);
			//绑定订单集合数据到请求中
			req.setAttribute("listorder", listorder);
			//转发到订单查看页面
			req.getRequestDispatcher("pages/shoppingcar/orderList.jsp").forward(req, resp);
		}
		    
			//查看订单状态并进行修改
		else if(method.equals("ExamineStatus")){
			//获得订单id
			String orderid=req.getParameter("orderId");
			//获得订单状态
			String status=req.getParameter("status");
			ods.ExamineStatus(orderid,status); //调用方法
			//转发到后台订单操作页面
			req.getRequestDispatcher("？？？").forward(req, resp);
		}
		    
		     //取消订单
		else if(method.equals("AbolishOrder")){
			//获得订单id
			String orderid=req.getParameter("orderid");
			System.out.println(orderid);
			try {
				ods.AbolishOrder(orderid);
				req.setAttribute("mes", "订单取消成功！");
				//转发到用户订单操作页面
				req.getRequestDispatcher("Order?method=myOrders").forward(req, resp);
			} catch (OrderException e) {
				req.setAttribute("mes", e.getMessage()); //绑定异常信息
				req.getRequestDispatcher("#").forward(req, resp);  //转发到显示信息页面(这个页面需要单独建立一个)
			}
		}
		
		//查看单个订单
		else if(method.equals("listOrder")){
			//获得订单id
			String orderid=req.getParameter("orderId");
			//调用service方法返回订单类
			 Order odr=ods.listOrder(orderid, user);
			 System.out.println("条目信息："+odr.getOrderitems().size());
			 //绑定数据
			 req.setAttribute("order", odr);
			 //转发到单个订单查看页面
			 req.getRequestDispatcher("pages/shoppingcar/orderView.jsp").forward(req, resp);
		}
	}
	
}
