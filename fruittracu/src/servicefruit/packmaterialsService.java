package servicefruit;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dbmanger.DBManger;

public class packmaterialsService {
	public List<Map<String,Object>> packmaterialsList() {
		List<Map<String,Object>> lists= new ArrayList<Map<String,Object>>();
		
		String sql = "select TOP  1 * from ft_packmaterials order by newid()";
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
		
				String name=resultSet.getString("PmName");
				String cat=resultSet.getString("PmCategory");
				String mat=resultSet.getString("PmMaterial");		
				String status=resultSet.getString("PmStatus");
				String time=resultSet.getString("DateTime");
		
				map.put("name", name);
				map.put("cat", cat);
				map.put("mat",mat);
			    map.put("status", status);
			    map.put("time",time );
			    
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
