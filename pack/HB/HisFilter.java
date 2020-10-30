package HB;

import java.io.File;
import java.io.FileFilter;

public class HisFilter implements FileFilter{

	@Override
	public boolean accept(File arg0) {
		// TODO Auto-generated method stub
		if(arg0.isDirectory()) 
			 return  false;
		         
		else 
			return true;
	}

}
