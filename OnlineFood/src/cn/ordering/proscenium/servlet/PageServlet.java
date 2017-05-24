package cn.ordering.proscenium.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.ordering.proscenium.bean.Item;
import cn.ordering.proscenium.bean.PageItem;
import cn.ordering.proscenium.dao.PageDao;
import cn.ordering.proscenium.dao.impl.PageDaoImpl;
import cn.ordering.proscenium.service.PageService;

/**
 * 分页处理servlet
 * @author baodu
 *
 */
public class PageServlet extends HttpServlet{

	 //定义关联
	private PageDao pd=new PageDaoImpl();
	private PageService ps=new PageService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//定义页面长度数
		int pagesize=9;
		//得到页码数
		int page=getPage(req);
		//调用service方法获得pageItem
		PageItem<Item> pit=ps.getItems(page, pagesize);
		//绑定数据到请求作用域
		req.setAttribute("pit", pit);
		//转发到页面
		req.getRequestDispatcher("index.jsp").forward(req, resp);
		System.out.println("执行来这里了");
		
	}
	
	//获得页面的当前页码数
	public int getPage(HttpServletRequest req){
		String page=null;
		//获得页面传递的页码数
		if(req.getParameter("page")!=null){
		 page=req.getParameter("page");
		/*//判断传递的页码数
		if(page==null||page.trim().isEmpty()){
			return 1; //为空情况返回默认首次页码数为1
		}*/
		 return Integer.parseInt(page); //否则直接返回传递的页码
	}
		return 1;
}
}
