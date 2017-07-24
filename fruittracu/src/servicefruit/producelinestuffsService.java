package servicefruit;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dbmanger.DBManger;

public class producelinestuffsService {
	public List<Map<String,Object>> producelinestuffsList() {
		List<Map<String,Object>> lists= new ArrayList<Map<String,Object>>();
		
		String sql = "select TOP  1 DateTime,StuffNum,Name,HealthInfo from  ft_producelinestuffs order by newid()";
		//获取DB对象
		DBManger sqlDbManage = DBManger.creatInstance();
		sqlDbManage.connectDB(); 
		//System.out.println(lists+"haha");
		try{
			//操作DB对象 
			ResultSet resultSet = sqlDbManage.excuteQuery(sql);
			//int count = 0;	
			while(resultSet.next()){
				Map<String,Object> map = new HashMap<String, Object>();
		
				String time=resultSet.getString("DateTime");
				String stuff=resultSet.getString("StuffNum");
				String name=resultSet.getString("Name");		
				String health=resultSet.getString("HealthInfo");
				
				
				map.put("stuff", stuff);
				map.put("time", time);
				map.put("name",name);
			    map.put("health", health);
			    
				
				lists.add(map);
			}
			//System.out.println(lists+"haha");
			return lists;
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return lists;
	}


}
