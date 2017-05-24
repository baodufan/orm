package cn.ordering.proscenium.bean;

import java.util.List;

/**
 * 分页泛型实体类
 * @author baodu
 *
 */
public class PageItem<T> {

	private int page;  //当前页
	private int pagesize;  //页面记录数
	private int pagecount;  //总记录数
	private List<T>list ; //存储的数据
	
	
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getPagetotal() { //计算总页数
		int pagetotal=pagecount/pagesize;
		return pagecount%pagesize==0 ? pagetotal :pagetotal+1;
	}
	public int getPagecount() {
		return pagecount;
	}
	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}
	
}
