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
        	System.out.println("��File_Download��");
			try {
				
				fis = new FileInputStream(f);
	            String filename=URLEncoder.encode(f.getName(),"utf-8"); //��������ļ������غ����������  
	            b = new byte[fis.available()];  
	            fis.read(b); 
		            
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
				System.out.println("��File_Download��");
				e.printStackTrace();
			}    
			 
        }else {
        	System.out.println("·��������");
        }
		
        return b;    
		 
          
    }  
}
