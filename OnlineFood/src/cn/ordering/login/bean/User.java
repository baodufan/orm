package cn.ordering.login.bean;
/**
 * 用户信息实体类
 * @author baodu
 *
 */
public class User {

	private Integer userid;//用户id
	private String username;//用户名
	private String account; //用户账户名称
	private String password; //账号密码
	private String sex; //用户性别
	private String userphone; //手机号码
	private String address; //用户地址
	private String level; //用户权限
	private String userstatus; //用户状态
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getUserphone() {
		return userphone;
	}
	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getUserstatus() {
		return userstatus;
	}
	public void setUserstatus(String userstatus) {
		this.userstatus = userstatus;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", account=" + account + ", password=" + password
				+ ", sex=" + sex + ", userphone=" + userphone + ", address=" + address + ", level=" + level
				+ ", userstatus=" + userstatus + "]";
	}
	
}
