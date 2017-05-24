package cn.ordering.order.bean;

import cn.ordering.proscenium.bean.Item;

/**
 * 订单项目表
 * @author baodu
 *
 */
public class Orderitem {

	private String itid;
	private Order order;
	private Item item;
	private Integer count;
	private String subtotal;
	
	
	public String getItid() {
		return itid;
	}
	public void setItid(String itid) {
		this.itid = itid;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public String getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Orderitem [itid=" + itid + ", order=" + order + ", item=" + item + ", count=" + count + ", subtotal="
				+ subtotal + "]";
	}
	
}
