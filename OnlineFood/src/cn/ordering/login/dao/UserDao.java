package cn.ordering.login.dao;

import cn.ordering.login.bean.User;

/**
 * 用户dao层业务接口类
 * @author baodu
 *
 */
public interface UserDao {

	//用户登录
	public User loginUser(User user);
	//用户注册
	public void addUser(User user);
	//查询用户账湖名是否已经注册
	public User listUname(User user);
	//查看用户电话号码是否已经注册
	public User listphone(User user);
	//修改个人信息
	public void updateUser(User user);
	//查看用户状态
	public String listStatus(User user);
	
}
