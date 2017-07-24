package servicefruit;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dbmanger.DBManger;

public class datacollectionService {
	public List<Map<String,Object>> datacollectionList() {
		List<Map<String,Object>> lists= new ArrayList<Map<String,Object>>();
		
		String sql = "select TOP  1 * from  ft_datacollection order by newid()";
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
				
				String light=resultSet.getString("LightData");
				String time=resultSet.getString("DateTime");
				String temper=resultSet.getString("SoilTemperatureData");
				String moist=resultSet.getString("SoilMoistureData");
				String hum=resultSet.getString("AirHumidityData");
				String atemper=resultSet.getString("AirTemperatureData");
				
				map.put("light", light);
				map.put("time",time );
				map.put("temper",temper );
				map.put("moist",moist );
				map.put("hum",hum );
				map.put("atemper",atemper );
				
			
				
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
