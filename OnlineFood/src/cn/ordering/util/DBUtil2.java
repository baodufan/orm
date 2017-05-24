package cn.ordering.util;
/**
 * 利用JNDI访问服务器配置文件
 * @author baodu
 *
 */

import javax.activation.DataSource;
import javax.naming.InitialContext;

import org.apache.catalina.Context;

public class DBUtil2 {
	
	private static DataSource dataSource;
	
	static{
		try {
			//Context context=new InitialContext();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
