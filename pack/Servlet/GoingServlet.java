package Servlet;


import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import HB.FileDo;
import pojo.User;


public class GoingServlet extends HttpServlet{
	 protected void doPost(HttpServletRequest request, HttpServletResponse response){
		 	HttpSession srequest = request.getSession();
	        String name = request.getParameter("name");
	        String password = request.getParameter("password");
	        System.out.println("name:" + name);
	        System.out.println("哈哈password:" + password);
	        SessionFactory sf = new Configuration().configure().buildSessionFactory();
	        Session s = sf.openSession();
	        /*
	         	* 查询账户密码
	         */
	        String hql="from User users where users.name=? and users.Password=?";
	                Query q =s.createQuery(hql);
	                q.setString(0,name);
	                q.setString(1,password);
	                List<User> Userlist = q.list();
	                System.out.print("路径时"+ GoingServlet.class.getProtectionDomain().getCodeSource().getLocation().getPath());
	               
	                if(Userlist.size()==1)
		                for(User usera:Userlist) {
		                	User user=usera;
		                	System.out.print(user.getName());
		                	System.out.print(user.getPassword());
		                	srequest.setAttribute("user", user);
		                	try {
		                		System.out.println("进来了");
		                		
		                		request.getRequestDispatcher("/Home/Home.jsp").forward(request, response);
//		                		response.sendRedirect("/Home/Home.html?name=aa");
								} catch (IOException | ServletException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
					        }else {
					        	System.out.println("没进去");
					        }
	 }
	    
}
