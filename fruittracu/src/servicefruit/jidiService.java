package servicefruit;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dbmanger.DBManger;

public class jidiService {
	public List<Map<String,Object>> jidiList() {
		List<Map<String,Object>> lists= new ArrayList<Map<String,Object>>();
		
		String sql = "select TOP  1 * from ft_jidis  order by newid()";
		//获取DB对象
		DBManger sqlDbManage = DBManger.creatInstance();
		sqlDbManage.connectDB(); 

		try{
			//操作DB对象 
			ResultSet resultSet = sqlDbManage.excuteQuery(sql);
			
			while(resultSet.next()){
				
				Map<String,Object> map = new HashMap<String, Object>();
				
				String Jname=resultSet.getString("jidiName");
				String Jadmin=resultSet.getString("Admin");
				
				String Jaddress=resultSet.getString("Address");
				
				map.put("Jname", Jname);
				map.put("Jadmin",Jadmin);
				
				map.put("Jaddress",Jaddress);
				
				lists.add(map);
			}
			
			return lists;
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return lists;
	}


}
