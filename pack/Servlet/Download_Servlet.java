package Servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HB.File_Download;

public class Download_Servlet extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		try {
			ServletContext application = getServletContext();
			System.out.println("类Download_Servlet中上下文路径为为"+application);
			request.setCharacterEncoding("utf-8");
			String filename_Adress = request.getParameter("filename_Adress");
			String path="F:/EPWO1/WxFwu/web/Filepath/"+filename_Adress;
			 ServletOutputStream  out =response.getOutputStream();  
			 System.out.println("类Download_Servlet响应路径"+path);
			out.write((byte[])File_Download.Get_DownLoad(path));  
            out.flush();  
            out.close();  
            System.out.println("类Download_Servlet响应完成");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
