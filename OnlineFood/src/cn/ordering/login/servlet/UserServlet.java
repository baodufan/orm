package cn.ordering.login.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.bcel.internal.generic.NEW;

import cn.ordering.login.bean.User;
import cn.ordering.login.service.UserException;
import cn.ordering.login.service.UserService;
import cn.ordering.shopcart.bean.ShopCart;

/**
 * 用户登录注册业务操作servlet类
 * @author baodu
 *
 */
public class UserServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获得method参数值
		String method=req.getParameter("method");
		//定义关联
		UserService use=new UserService();
		//进行判断如果为空，
		
		if(method==null){  //调用用户登录方法
			//接收参数值
			String account=req.getParameter("account");
			String password=req.getParameter("password");
			//定义用户对象
			HttpSession hs=req.getSession();
			User user=new User();
			user.setAccount(account);
			user.setPassword(password);
			//调用service方法
			User ue=null;
			try {
				//调用service类方法
				ue = use.selectUser(user);
				if(ue!=null){ //登陆成功后
					//绑定用户对象数据到请求作用域
					//获得会话对象
					hs.setAttribute("user", ue);
					//创建购物车给用户
					hs.setAttribute("ShopCart", new ShopCart());
					//转发到主页
					resp.sendRedirect("index.jsp");
				}
			} catch (UserException e) {
				req.setAttribute("mes", e.getMessage()); //有异常绑定异常信息
				req.setAttribute("user", user);          //回显信息到页面
				req.getRequestDispatcher("pages/login/loginIn.jsp").forward(req, resp);  //转发到显示信息页面(这个页面需要单独建立一个)
			}
			
		}
		   //调用注册方法
		else if(method.equals("registerUser")){
			//接收表单参数值
			String account =req.getParameter("account");
			String password=req.getParameter("password");
			String name=req.getParameter("username");
			String sex=req.getParameter("sex");
			String phone=req.getParameter("userphone");
			String address=req.getParameter("address");
			//实例化对象
			User form=new User();
			//封装数据
			form.setAccount(account);
			form.setPassword(password);
			form.setUsername(name);
			form.setSex(sex);
			form.setUserphone(phone);
			form.setAddress(address);
			form.setLevel("普通用户");
			form.setUserstatus("正常");
			//调用service类方法
			try {
				use.registerUser(form);
				req.setAttribute("mes", "注册成功！欢迎登陆网上订餐系统！"); //没有异常绑定成功信息
				HttpSession session = req.getSession();
				session.setAttribute("user",form);//将用户信息放入session
				resp.sendRedirect("index.jsp");    //转发到显示成功信息页面
			} catch (UserException e) {
				req.setAttribute("mes", e.getMessage()); //有异常绑定异常信息
				req.setAttribute("form", form);          //回显信息到页面
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}
		}
		//调用用户个人信息修改方法
		else if(method.equals("amendUser")){
			//接收表单参数值
			Integer userid=Integer.parseInt(req.getParameter("id"));
			String name=req.getParameter("username");
			String password=req.getParameter("password");
			String phone=req.getParameter("userphone");
			String address=req.getParameter("address");
			//实例化对象
			User uer=new User();
			uer.setUserid(userid);
			uer.setUsername(name);
			uer.setPassword(password);
			uer.setUserphone(phone);
			uer.setAddress(address);
			//调用service方法
			use.amendUser(uer);
			HttpSession hs=req.getSession();
			hs.setAttribute("mes", "修改信息成功！");  //绑定修改信息到显示页面（abnormal.jsp）
			req.getRequestDispatcher("/pages/extra/abnormal.jsp").forward(req, resp);
		}
		//调用退出登录方法
		else if(method.equals("removed")){
			HttpSession hs=req.getSession();
			hs.removeAttribute("user");
			req.getRequestDispatcher("pages/login/loginIn.jsp").forward(req, resp);
		}
	}
	
}
