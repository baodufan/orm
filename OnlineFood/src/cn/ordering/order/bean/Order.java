package cn.ordering.order.bean;
/**
 * 订单实体类
 * @author baodu
 *
 */
import java.util.Date;
import java.util.List;

import cn.ordering.login.bean.User;
import cn.ordering.proscenium.bean.Item;

public class Order {
	//定义属性
	private String orderId;  //订单ID
	private Date ordertime;   //下订单时间
	private User user;        //用户ID
	private Discount discount;  //优惠券类
	private String payWay;      //支付方式
	private String sendType;   //配送方式
	private Delivery delivery;  //配送员类
	private String orderStatus;  //订单状态
	private String message;      //订单预留言
	private String evaluate;     //订单评论
	private String total;        //订单总金额
	private String address;     //配送地址
	private String phone;       //收货人电话
	private List<Orderitem>orderitems;  //订单条目集合
	 
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPayWay() {
		return payWay;
	}
	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}
	public List<Orderitem> getOrderitems() {
		return orderitems;
	}
	public void setOrderitems(List<Orderitem> orderitems) {
		this.orderitems = orderitems;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public Discount getDiscount() {
		return discount;
	}
	public void setDiscount(Discount discount) {
		this.discount = discount;
	}
	
	public String getSendType() {
		return sendType;
	}
	public void setSendType(String sendType) {
		this.sendType = sendType;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getEvaluate() {
		return evaluate;
	}
	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}
	public Delivery getDelivery() {
		return delivery;
	}
	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
