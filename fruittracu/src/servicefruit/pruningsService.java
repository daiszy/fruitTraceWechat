package servicefruit;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dbmanger.DBManger;

public class pruningsService {
	public List<Map<String,Object>> pruningsList() {
		List<Map<String,Object>> lists= new ArrayList<Map<String,Object>>();
		
		String sql = "SELECT DateTime,Instruction FROM ft_prunings  ORDER BY DateTime";
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
				String instruct=resultSet.getString("Instruction");		
				
				map.put("time", time);
				map.put("instruct",instruct);
				
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
