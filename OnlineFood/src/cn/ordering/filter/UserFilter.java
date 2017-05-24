package cn.ordering.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.ordering.login.bean.User;

/**
 * 用户登录过滤器
 * @author baodu
 *
 */
public class UserFilter implements Filter{

	//用户登录过滤器核心方法
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("来这里了");
		//转换参数
		HttpServletRequest hsr=(HttpServletRequest)arg0;
		HttpServletResponse hsrp=(HttpServletResponse)arg1;
		//获得会话
		HttpSession hs=hsr.getSession();
		//获得用户对象
		User user=(User)hs.getAttribute("user");
		//判断对象值
		if(user!=null){
			arg2.doFilter(arg0, arg1);
		}else{
			System.out.println("没登陆");
			hs.setAttribute("mes", "您还没有登陆账户，不能订购菜品！请点击登录");
			hsr.getRequestDispatcher("/pages/extra/abnormal.jsp").forward(hsr, hsrp);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		Filter.super.init(filterConfig);
	}

	
}
