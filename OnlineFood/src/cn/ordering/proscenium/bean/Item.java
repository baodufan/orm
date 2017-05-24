package cn.ordering.proscenium.bean;
/**
 * 菜品实体类
 * @author baodu
 *
 */
public class Item {

	private Integer itemId; //菜品id
	private String itemName; //菜品名称
	private String  price; //菜品单价
	private String image; //菜品图片
	private String type; //菜品类型
	private String descipt; // 菜品简述
	private String itemStatus; //菜品状态
	private Integer num=1;   //菜品数量初始化为1
	
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescipt() {
		return descipt;
	}
	public void setDescipt(String descipt) {
		this.descipt = descipt;
	}
	public String getItemStatus() {
		return itemStatus;
	}
	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", price=" + price + ", image=" + image + ", type="
				+ type + ", descipt=" + descipt + ", itemStatus=" + itemStatus + ", num=" + num + "]";
	}
	
}
