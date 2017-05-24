package cn.ordering.shopcart.bean;
import java.math.BigDecimal;

import cn.ordering.proscenium.bean.Item;

/**
 * 购物车条目类
 * @author baodu
 *
 */

	public class ShopCartitem {
	
	private Item item; //菜品信息实体
	private int num;   //菜品数量
	
	//计算商品小计价格（转换为double类型避免丢失精度）
	public double getSubtotal(){
		BigDecimal bd=new BigDecimal(item.getPrice()+"");
		BigDecimal bde=new BigDecimal(num+"");
		return bd.multiply(bde).doubleValue();
	}
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
}