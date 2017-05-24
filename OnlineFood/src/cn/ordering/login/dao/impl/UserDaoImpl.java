package cn.ordering.login.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.ordering.login.bean.User;
import cn.ordering.login.dao.UserDao;
import cn.ordering.util.DBUtil;

/**
 * 用户接口实现类
 * @author baodu
 *
 */
public class UserDaoImpl implements UserDao {

	//定义连接属性
	private Connection conn=null;
	
	
	//用户登录方法
	@Override
	public User loginUser(User user) {
			
			//定义返回对象
			User us=null;
		try {
			//获得连接对象
			conn=DBUtil.getConnection();
			//定义sql语句
			String sql="select*from tab_user where user_account=? and user_password=?";
			//定义预编译对象
			PreparedStatement ps=conn.prepareStatement(sql);
			//设置参数
			ps.setString(1, user.getAccount());
			ps.setString(2, user.getPassword());
			//活动结果集对象
			ResultSet rs=ps.executeQuery();
			//判断如果有数据创建对象实例
			if(rs.next()){
				us=new User();
				//设置参数
				us.setUserid(rs.getInt("user_id"));
				us.setUsername(rs.getString("user_name"));
				us.setAccount(rs.getString("user_account"));
				us.setPassword(rs.getString("user_password"));
				us.setSex(rs.getString("user_sex"));
				us.setUserphone(rs.getString("user_phone"));
				us.setAddress(rs.getString("user_address"));
				us.setLevel(rs.getString("user_level"));
				us.setUserstatus(rs.getString("user_status"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return us;
	}

	//用户注册方法
	@Override
	public void addUser(User user) {
		//定义连接对象
		try {
			conn=DBUtil.getConnection();
			//sql语句
			String sql="insert into tab_user values(seq_user_id.NEXTVAL,?,?,?,?,?,?,?,?)";
			//预编译对象
			PreparedStatement ps=conn.prepareStatement(sql);
			//设置参数
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getAccount());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getSex());
			ps.setString(5, user.getUserphone());
			ps.setString(6, user.getAddress());
			ps.setString(7, user.getLevel());
			ps.setString(8, user.getUserstatus());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//注册时查询账户名是否存在方法
	@Override
	public User listUname(User user) {
		//定义返回对象
		User use=null;
		//定义连接对象
		try {
			conn=DBUtil.getConnection();
			//定义sql语句
			String sql="select*from tab_user where user_account=?";
			//预编译对象
			PreparedStatement ps=conn.prepareStatement(sql);
			//设置值
			ps.setString(1, user.getAccount());
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				use=new User();
				//设置参数
				use.setUserid(rs.getInt("user_id"));
				use.setUsername(rs.getString("user_name"));
				use.setAccount(rs.getString("user_account"));
				use.setPassword(rs.getString("user_password"));
				use.setSex(rs.getString("user_sex"));
				use.setUserphone(rs.getString("user_phone"));
				use.setAddress(rs.getString("user_address"));
				use.setLevel(rs.getString("user_level"));//等级默认是
				use.setUserstatus(rs.getString("user_status"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return use;
	}

	//修改个人信息方法
	@Override
	public void updateUser(User user) {
		//定义连接对象
		try {
			conn=DBUtil.getConnection();
			//sql语句
			String sql="update tab_user set user_password=?,user_phone=?,user_address=?,user_name=? where user_id=?";
			//预编译语句对象
			PreparedStatement psp=conn.prepareStatement(sql);
			psp.setString(1, user.getPassword());
			psp.setString(2, user.getUserphone());
			psp.setString(3, user.getAddress());
			psp.setString(4, user.getUsername());
			psp.setInt(5, user.getUserid());
			psp.executeUpdate(); 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	//查看电话号码是否已注册方法
	@Override
	public User listphone(User user) {
		//定义返回对象
				User usr=null;
				//定义连接对象
				try {
					conn=DBUtil.getConnection();
					//定义sql语句
					String sql="select*from tab_user where user_phone=?";
					//预编译对象
					PreparedStatement ps=conn.prepareStatement(sql);
					//设置值
					ps.setString(1, user.getUserphone());
					ResultSet rs=ps.executeQuery();
					if(rs.next()){
						usr=new User();
						//设置参数
						usr.setUserid(rs.getInt("user_id"));
						usr.setUsername(rs.getString("user_name"));
						usr.setAccount(rs.getString("user_account"));
						usr.setPassword(rs.getString("user_password"));
						usr.setSex(rs.getString("user_sex"));
						usr.setUserphone(rs.getString("user_phone"));
						usr.setAddress(rs.getString("user_address"));
						usr.setLevel(rs.getString("user_level"));//等级默认是
						usr.setUserstatus(rs.getString("user_status"));
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return usr;
	}

	//查看用户状态的方法
	@Override
	public String listStatus(User user) {
		//定义返回字符串
		String status=null;
		//获得连接对象
		try {
			conn=DBUtil.getConnection();
			//定义sql语句
			String sql="select user_status from tab_user where user_id=?";
			//获得预编译对象
			PreparedStatement ps=conn.prepareStatement(sql);
			//设置参数
			ps.setInt(1, user.getUserid());
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				status=rs.getString("user_status");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

}
