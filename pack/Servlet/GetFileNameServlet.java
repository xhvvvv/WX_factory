package Servlet;

import java.io.File;


import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HB.FileDo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class GetFileNameServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
//		String param_name = request.getQueryString();取出来不知道是什么东西
		String param_name = request.getParameter("name");
		
		System.out.println("类GetFileNameServlet中param_name为"+param_name);
		String path="F:/EPWO1/WxFwu/web/Filepath/"+param_name;
		File[] Filegroup_Directory=FileDo.Get_Directory(path);
		File[] Filegroup_File=FileDo.Get_File(path);
		System.out.println("类GetFileNameServlet中 Filegroup_Directory大小为"+Filegroup_Directory.length);
		System.out.println("类GetFileNameServlet中Filegroup_File大小为"+Filegroup_File.length);
		JSONObject json = new JSONObject();
		JSONArray jsonarray_Directory = new JSONArray();
		JSONArray jsonarray_file = new JSONArray();
		
		for(int i=0;i<Filegroup_Directory.length;i++) {
			
			jsonarray_Directory.add(Filegroup_Directory[i].getName());
		}
		for(int i=0;i<Filegroup_File.length;i++) {
			jsonarray_file.add(Filegroup_File[i].getName());
			
		}
		System.out.println("类GetFileNameServlet中这里到此为止");
		
		json.put("DirectoryName",jsonarray_Directory);
		json.put("FileName",jsonarray_file);
		System.out.println("类GetFileNameServlet中-json为"+json);
	     response.setContentType("text/html;charset=utf-8"); 
	      
	       try {
			response.getWriter().print(json);
			System.out.println("类GetFileNameServlet响应完成/*********************************************/");			
	       } catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("类GetFileNameServlet响应有毛病");
			e.printStackTrace();
		}
		
	}
}
