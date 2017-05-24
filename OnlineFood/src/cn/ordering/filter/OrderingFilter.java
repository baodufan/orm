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

/**
 * 项目字符编码过滤器
 * @author baodu
 *
 */
public class OrderingFilter implements Filter{

	//定义编码属性
	private String reqCondig;
	private String respCondig;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
	}
	
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
			//强制转换请求响应对象
		HttpServletRequest hre=(HttpServletRequest)arg0;
		HttpServletResponse hsr=(HttpServletResponse)arg1;
		//设置请求字符编码
		hre.setCharacterEncoding(reqCondig);
		//过滤器核心方法
		arg2.doFilter(hre, hsr);
		//设置响应字符编码
		hsr.setContentType(respCondig);
	}
	

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//过滤器初始化时获得配置参数值
		reqCondig=filterConfig.getInitParameter("request");
		respCondig=filterConfig.getInitParameter("response");
		
	}
	

}
