package cn.ordering.filter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.ordering.proscenium.bean.Item;
import cn.ordering.proscenium.bean.PageItem;
import cn.ordering.proscenium.dao.ItemDao;
import cn.ordering.proscenium.dao.PageDao;
import cn.ordering.proscenium.dao.impl.ItemDaoImpl;
import cn.ordering.proscenium.dao.impl.PageDaoImpl;
import cn.ordering.proscenium.service.PageService;

/**
 * 主页过滤器
 * @author baodu
 *
 */
public class MyindexFilter implements Filter {

	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
						//转换参数
				HttpServletRequest hsr=(HttpServletRequest)arg0;
				HttpServletResponse hsrp=(HttpServletResponse)arg1;
				//定义关联
				PageService ps=new PageService();
				//定义页面长度数
				int pagesize=9;
				//调用下面方法得到页码数
				int page=getPage(hsr);
				//调用service方法获得pageItem
				PageItem<Item> pit=ps.getItems(page, pagesize);
				//绑定数据到请求作用域
				hsr.setAttribute("pit", pit);
				//转发到页面
				hsr.getRequestDispatcher("index.jsp").forward(hsr, hsrp);
		   arg2.doFilter(hsr, hsrp);
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		Filter.super.init(filterConfig);
	}
	
			//获得页面的当前页码数
		public int getPage(HttpServletRequest hsr){
			
			//获得页面传递的页码数
			if(hsr.getParameter("page")!=null){
				String page=null;
			 page=hsr.getParameter("page");
			/*//判断传递的页码数
			if(page==null||page.trim().isEmpty()){
				return 1; //为空情况返回默认首次页码数为1
			}*/
			 return Integer.parseInt(page); //否则直接返回传递的页码
		}
			return 1;
	}
}
