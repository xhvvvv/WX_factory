package HB;

import java.io.File;
import java.io.FileFilter;

public class MyFilter implements FileFilter {

	@Override
	public boolean accept(File file) {
		// TODO Auto-generated method stub
		if(file.isDirectory()) 
			 return true;
		         
		else 
			return false;
		
		 
	}
	
}
