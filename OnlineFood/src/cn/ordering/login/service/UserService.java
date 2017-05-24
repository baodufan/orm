package cn.ordering.login.service;
/**
 * 用户登录注册业务方法调用service
 * @author baodu
 *
 */
import cn.ordering.login.bean.User;
import cn.ordering.login.dao.UserDao;
import cn.ordering.login.dao.impl.UserDaoImpl;

public class UserService {
      //定义关联
	UserDao ud=new UserDaoImpl();
	
	//用户登录
	public User selectUser(User user) throws UserException{
		//定义返回对象
		User ur=null;
		ur=ud.loginUser(user);
		//进行判断
		if(ur==null){
			throw new UserException("用户名或密码错误"); //如果为空抛出异常信息
		}
		else if(ud.listStatus(ur).equals("禁用")){
			throw new UserException("该用户已被禁止登陆！");  //如果状态为禁用抛出异常信息
		}
		return ur;  //没有问题则正常返回对象
	}
	
	
	//用户注册
	public void registerUser(User user) throws UserException{
		
		//调用dao层方法查询账户名是否存在
		User us=ud.listUname(user);
		//如果有结果则表明已被注册。抛出异常
		if(us!=null){
			throw new UserException("账户名已注册");
		}
		
		//调用dao层方法查看电话是否注册
		User ur=ud.listphone(user);
		//如果有结果则表明已被注册。抛出异常
		if(ur!=null){
			throw new UserException("电话号码已注册");
		}
		//没有问题直接调用注册方法
		ud.addUser(user);
	}
	
	
	//用户修改个人信息方法s
	public void amendUser(User user){
		//调用dao层方法
		ud.updateUser(user);
	}
}
