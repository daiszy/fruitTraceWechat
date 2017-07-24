package servicefruit;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.junit.Test;

import dbmanger.DBManger;



public class getNameService {
	
	public List<Map<String,Object>> getNameList() {
		List<Map<String,Object>> lists= new ArrayList<Map<String,Object>>();
		
		String sql = "select TOP  1 * from  ft_brandinfoes order by newid()";
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
				String name=resultSet.getString("BrandName");
				String grade=resultSet.getString("Grade");
				map.put("name", name);
				map.put("grade", grade);
			
				
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
