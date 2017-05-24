package cn.ordering.order.bean;
/**
 * 优惠券实体类
 * @author baodu
 *
 */

import java.util.Date;

public class Discount {

	private Integer discountId;  //优惠券ID
	private Integer useLimit;   //使用下限金额
	private Integer num;        //折扣金额
	private String  timeLimit;  
	//使用时间限制
	public Integer getDiscountId() {
		return discountId;
	}
	public void setDiscountId(Integer discountId) {
		this.discountId = discountId;
	}
	public Integer getUseLimit() {
		return useLimit;
	}
	public void setUseLimit(Integer useLimit) {
		this.useLimit = useLimit;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getTimeLimit() {
		return timeLimit;
	}
	public void setTimeLimit(String timeLimit) {
		this.timeLimit = timeLimit;
	}
	
}