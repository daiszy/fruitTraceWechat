package fruitservle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicefruit.packmaterialsService;
import net.sf.json.JSONArray;


public class packmaterialsServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setHeader("Access-Control-Allow-Origin","*");
		
		List<Map<String,Object>> lists= new ArrayList<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String, Object>();
		
		packmaterialsService listService = new packmaterialsService();
		lists = listService.packmaterialsList();
		
		JSONArray jsonArray = JSONArray.fromObject(lists);
				 
		
		//返回信息到客户端
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print(jsonArray.toString());
		//writer.print(jsonArray.toString());
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		                // TODO Auto-generated method stub
		                 doGet(request, response);
		             }


}
