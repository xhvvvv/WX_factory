package HB;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;


public class FileDo {


	public static void  ReplaceFile(String filePath, String outPath)  {

        File file1 = new File(filePath);
        file1.renameTo(new File(filePath.substring(0, filePath.indexOf("."))+".txt"));
        File file = new File(outPath);
        System.out.println(file.length());
        byte[] temp = new byte[1024];
        int len=0 ;
        StringBuffer sb = new StringBuffer();
        try{
        	System.out.println("运行到这里了");
        	FileInputStream in = new FileInputStream(file);
        	BufferedInputStream bis =new BufferedInputStream(in);
        	while ((len= bis.read(temp)) != -1) {
                sb.append(new String(temp, 0, len));
            }    
               int index=sb.indexOf("<a id=\"name\"></a>") ;
               System.out.println("<a id=\"name\"></a>"+"在"+index);
               sb.insert(index+13, "wode");//  
               in.close();
               bis.close();
               BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file))); 
           	  writer.write(sb.toString());  
               writer.flush();
               writer.close();
            file.renameTo(new File(outPath.substring(0, outPath.indexOf("."))+".html"));
               
        }catch(Exception e) {
        	e.printStackTrace();
        }  
      
    }
	public static File[]  Get_Directory(String filePath)  {//负责检查目录下的文件名
		File f=new File(filePath);
		if(f.exists()&&f.isDirectory()) {
			File[] filegroup=f.listFiles(new MyFilter());
			return filegroup;
		}else {
			System.out.println("文件不存在或者非文件夹");
			return null;
		}
		
		
	}
	public static File[]  Get_File(String filePath)  {//负责检查目录下的文件名
		File f=new File(filePath);
		if(f.exists()) {
			File[] filegroup=f.listFiles(new HisFilter());
			return filegroup;
		}else {
			System.out.println("文件不存在或者非文件夹");
			return null;
		}
		
		
	}
	
}





























