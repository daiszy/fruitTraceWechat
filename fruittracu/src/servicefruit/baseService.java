package servicefruit;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import org.apache.tomcat.jni.Lock;

import dbmanger.DBManger;

public class baseService {
	public <BASE64Decoder> List<Map<String,Object>> baseList() {
		List<Map<String,Object>> lists= new ArrayList<Map<String,Object>>();
		
		String sql = "SELECT OchdName,Admin,OchdArea,NumoFruitree,"
				+ "FarmerImages,SpringOchdImg,SummerochdImg,AutumnochdImg,"
				+ "WinterochdImg,Elevation,IlluminationHours FROM ft_orchardbases";
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
			
				String Oname=resultSet.getString("OchdName");
				String Oadmin=resultSet.getString("Admin");		
				String area=resultSet.getString("OchdArea");
				String tree=resultSet.getString("NumoFruitree");				
				String image=resultSet.getString("FarmerImages");
				String spring=resultSet.getString("SpringochdImg");
				String summer=resultSet.getString("SummerochdImg");
				String autum=resultSet.getString("AutumnochdImg");
				String winter=resultSet.getString("WinterochdImg");			
				String ele=resultSet.getString("Elevation");
				String ill=resultSet.getString("IlluminationHours");
				map.put("Oname", Oname);
				map.put("Oadmin",Oadmin);
				map.put("area", area);
				map.put("tree",tree );
				map.put("image",image );
				map.put("spring",spring );
				map.put("summer",summer );
				map.put("autum",autum );
				map.put("winter",winter );
				map.put("ele",ele );
				map.put("ill", ill);
				
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
