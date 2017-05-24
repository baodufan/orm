package cn.ordering.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import sun.security.x509.PrivateKeyUsageExtension;

/**
 * 数据库连接工具类
 * @author baodu
 *
 */
public class DBUtil {

	//定义属性
	private static String driver;
	private static String url;
	private static String user;
	private static String pwd;
	//加载配置
	static{
		//获得配置文件对象
		Properties p=new Properties();
		//加载配置文件
		try {
			p.load(DBUtil.class.getClassLoader().getResourceAsStream("cn/ordering/conf/jdbc.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//活动参数值
		driver=p.getProperty("driver");
		url=p.getProperty("url");
		user=p.getProperty("user");
		pwd=p.getProperty("pwd");
	}
	
	//定义获得连接对象的方法
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		//	定义连接对象
		Connection conn=null;
		//加载驱动
		Class.forName(driver);
		//获得连接对象
		conn=DriverManager.getConnection(url, user, pwd);
		return conn;
	}
	
	//定义关于连接的方法
	public static void closeAll(Connection conn,PreparedStatement ps,ResultSet rs) throws SQLException{
		//关闭前进行判断
		if(rs!=null){
			rs.close();
		}
		if(ps!=null){
			ps.close();
		}
		if(conn!=null){
			conn.close();
		}
	}
}
