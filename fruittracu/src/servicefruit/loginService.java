package servicefruit;

import java.sql.ResultSet;


import dbmanger.DBManger;

public class loginService {
	public Boolean login(String username,String password) {
		//获取sql查询语句
		String logSql = "select * from ft_datacollection"
				+ username+"'"
			   + "and UserPassword = '"+password+"'";
		//获取DB对象
		DBManger sqlDbManage = DBManger.creatInstance();
		sqlDbManage.connectDB(); 
		
		//操作DB对象
		try {
			ResultSet resultSet = sqlDbManage.excuteQuery(logSql);
			if(resultSet.next())
			{
				sqlDbManage.closeDB();
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		sqlDbManage.closeDB();
		return false;
	}
}
