package dbmanger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;





public class DBManger {

//数据库连接常量
	  private final static String URL = "jdbc:sqlserver://202.200.112.87:1433;DatabaseName=fruittrace";
	  private static final String USER="sa";
	  private static final String PASSWORD="xautnic";
	    
//静态成员，支持单台模式
private static DBManger per = null;
private Connection connection = null;
private Statement statement = null;
public DBManger(){
	
}
public static DBManger creatInstance() {
	if(per == null)
	{
		per = new DBManger();
		per.initDB();
	}
	return per;
}
public void initDB() {
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
//连接数据库，获取句柄+对象
public void connectDB() {
	System.out.println("正在连接数据库...");
	try { 
		 
		connection = DriverManager.getConnection(URL, USER, PASSWORD);
	
		statement = connection.createStatement();
		System.out.println("SqlManage:Connect to database successful.");
	} catch (Exception e) {
		// TODO: handle exceptionso
	//	e.printStackTrace();
		System.out.println("数据库连接失败");
	}
	
}
//关闭数据库，关闭对象，释放句柄
public void closeDB() {
	System.out.println("Close connection to database...");
	try {
		statement.close();
		connection.close();
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	System.out.println("Close database successful.");
}
//查询
public ResultSet excuteQuery(String sql) {
	ResultSet rSet = null;
	try {
		rSet = statement.executeQuery(sql);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return rSet;
}

//增添，删除，修改
public int executeUpdate(String sql) {
	int ret = 0;
	try {
		ret = statement.executeUpdate(sql);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return ret;
}
}
