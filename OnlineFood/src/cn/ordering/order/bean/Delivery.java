package cn.ordering.order.bean;
/**
 * 配送员实体类
 * @author baodu
 *
 */
public class Delivery {

	private Integer staffId; //配送员id
	private String staffName; //配送员姓名
	private String staffPhone; //配送员手机号码
	private String position; //配送区域
	public Integer getStaffId() {
		return staffId;
	}
	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getStaffPhone() {
		return staffPhone;
	}
	public void setStaffPhone(String staffPhone) {
		this.staffPhone = staffPhone;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
}
