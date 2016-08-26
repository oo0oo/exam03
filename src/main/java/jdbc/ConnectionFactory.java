package jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
	private static String driver;
	private static String dburl;
	private static String user;
	private static String password;

	static {
		Properties pro = new Properties();
		try{
			InputStream in = ConnectionFactory.class.getClassLoader().getResourceAsStream("dbconfig.properties");
			pro.load(in);
		}catch(Exception e){
			System.out.println("获取properties文件");
		}
		driver = pro.getProperty("driver");
		dburl = pro.getProperty("dburl");
		user = pro.getProperty("user");
		password = pro.getProperty("password");
		System.out.println(driver);
		System.out.println(dburl);
		System.out.println(user);
		System.out.println(password);
		

	}
	
	private static final ConnectionFactory factory = new ConnectionFactory();
	private ConnectionFactory(){

	}
	public static ConnectionFactory getInstance(){
		return factory;
	}

	private Connection con ;
	public Connection makeConnection(){
		try {
			
			
			Class.forName(driver);
			
			con = DriverManager.getConnection(dburl, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
		
	}

}



