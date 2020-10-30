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
//		String param_name = request.getQueryString();ȡ������֪����ʲô����
		String param_name = request.getParameter("name");
		
		System.out.println("��GetFileNameServlet��param_nameΪ"+param_name);
		String path="F:/EPWO1/WxFwu/web/Filepath/"+param_name;
		File[] Filegroup_Directory=FileDo.Get_Directory(path);
		File[] Filegroup_File=FileDo.Get_File(path);
		System.out.println("��GetFileNameServlet�� Filegroup_Directory��СΪ"+Filegroup_Directory.length);
		System.out.println("��GetFileNameServlet��Filegroup_File��СΪ"+Filegroup_File.length);
		JSONObject json = new JSONObject();
		JSONArray jsonarray_Directory = new JSONArray();
		JSONArray jsonarray_file = new JSONArray();
		
		for(int i=0;i<Filegroup_Directory.length;i++) {
			
			jsonarray_Directory.add(Filegroup_Directory[i].getName());
		}
		for(int i=0;i<Filegroup_File.length;i++) {
			jsonarray_file.add(Filegroup_File[i].getName());
			
		}
		System.out.println("��GetFileNameServlet�����ﵽ��Ϊֹ");
		
		json.put("DirectoryName",jsonarray_Directory);
		json.put("FileName",jsonarray_file);
		System.out.println("��GetFileNameServlet��-jsonΪ"+json);
	     response.setContentType("text/html;charset=utf-8"); 
	      
	       try {
			response.getWriter().print(json);
			System.out.println("��GetFileNameServlet��Ӧ���/*********************************************/");			
	       } catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("��GetFileNameServlet��Ӧ��ë��");
			e.printStackTrace();
		}
		
	}
}
