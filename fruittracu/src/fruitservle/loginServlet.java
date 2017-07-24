package fruitservle;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicefruit.loginService;

public class loginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException{
		
		//接收客户端信息
				String username = request.getParameter("username");
				username = new String(username.getBytes("ISO-8859-1"),"UTF-8");
				String password = request.getParameter("password");
				System.out.println(username+"--"+password);
				
				//新建服务对象
				loginService service = new loginService();
				//验证处理
				boolean loged = service.login(username, password);
				if(loged)
				{
					System.out.println("success");
					request.getSession().setAttribute("username", username);
				}else {
					System.out.println("failed");
				}
				
				//返回信息到客户端
				response.setCharacterEncoding("UTF-8");
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.println("用户名："+username);
				out.println("密码："+password);
				out.println(loged);
				out.flush();
				out.close();
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException{
		
		
		//接收客户端信息
		String username = request.getParameter("username");
		username = new String(username.getBytes("ISO-8859-1"),"UTF-8");
		String password = request.getParameter("password");
		System.out.println(username+"--"+password);
				
		//新建服务对象
		loginService service = new loginService();
		//验证处理
		boolean loged = service.login(username, password);
		//返回信息到客户端
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		if(loged)
		{
			System.out.println("success");
			request.getSession().setAttribute("username", username);		
			out.print("登录成功");
			out.flush();
			out.close();
		}else {
			System.out.println("failed");
			out.print("登录失败");
			out.flush();
			out.close();	
		}
	}
}
