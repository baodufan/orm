package cn.ordering.shopcart.bean;
/**
 * 购物车对应数据库表的实体类
 * @author baodu
 *
 */
import cn.ordering.login.bean.User;
import cn.ordering.proscenium.bean.Item;

 public class ShoppingCart {
	
	private User user; //用户信息类
	private Integer itemId; //商品id
	private String itemName; //菜品名称
	private String  price; //菜品单价
	private String image; //菜品图片
	private Integer count;  //数量
	private String subtotal; //小计价格
	
	
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	}