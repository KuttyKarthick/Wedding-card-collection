package com.niit.util;

import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class FileUtil {
	
	//private static String workingDir = System.getProperty("user.dir");//D:\Softwares\IDE\eclipse-jee-neon-RC3-win32-x86_64\eclipse
	  
	
  //"D:\\ShoppingCart\\Images";
	public static void upload(String path, MultipartFile file, String fileName) {

		Util.removeComman(fileName);
		if (!file.isEmpty()) {
			
			
		
			
			try {
			byte[] bytes = file.getBytes();

			// Creating the directory to store file
			File dir = new File(path);
			if (!dir.exists())
				dir.mkdirs(); //Make/create directory
			
			// Create the file on server
			//D:\\ShoppingCart\\Images\\fileName.jpg
			File serverFile = new File(dir.getAbsolutePath()
					+ File.separator + fileName);
			
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();
            }
			catch (Exception e) {
			e.printStackTrace();
		}}
		

	}
	
	
	//using nio
	public void fileCopy(String src, String dest)
	{
		
	Path sourcePath=	  Paths.get(src);
	Path destinationPath = Paths.get(dest);
	
	
	try {
		Files.copy(sourcePath, destinationPath);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
			
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}

