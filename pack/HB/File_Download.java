package HB;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;

public class File_Download {
	public  static Object  Get_DownLoad(String filename_Adress)  {  
		File f=new File(filename_Adress);
		 byte[] b = null ;
		 FileInputStream  fis;
        if(f.exists()){  
        	System.out.println("类File_Download中");
			try {
				
				fis = new FileInputStream(f);
	            String filename=URLEncoder.encode(f.getName(),"utf-8"); //解决中文文件名下载后乱码的问题  
	            b = new byte[fis.available()];  
	            fis.read(b); 
		            
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
				System.out.println("类File_Download中");
				e.printStackTrace();
			}    
			 
        }else {
        	System.out.println("路径不存在");
        }
		
        return b;    
		 
          
    }  
}
