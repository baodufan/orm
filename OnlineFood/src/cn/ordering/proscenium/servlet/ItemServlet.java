package cn.ordering.proscenium.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.ordering.proscenium.bean.Item;
import cn.ordering.proscenium.dao.ItemDao;
import cn.ordering.proscenium.dao.impl.ItemDaoImpl;
import cn.ordering.proscenium.service.ItemService;

/**
 * 商品业务处理servlet
 * @author baodu
 *
 */
public class ItemServlet extends HttpServlet {

	//定义关联
	private ItemService its=new ItemService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		//获得请求参数值
		String method=req.getParameter("method");
		//获得商品id并封装对象
		Integer itemid=Integer.parseInt(req.getParameter("itemId"));
		Item item=new Item();
		item.setItemId(itemid);
		//获得会话对象
		HttpSession hs=req.getSession();
		//判断调用的方法
		if(method==null){
			Item im=its.listItem(item);
			//绑定数据
			hs.setAttribute("Item", im);
			//转发到单品页面
			resp.sendRedirect("pages/food/itemInfo.jsp");
		}
		
	}
}
