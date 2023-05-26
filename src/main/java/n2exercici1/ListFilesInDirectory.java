package n2exercici1;

import java.io.*;
import java.util.*;

import org.apache.commons.io.FileUtils;

import java.text.SimpleDateFormat;

public class ListFilesInDirectory {
	
	public static void listDirectoryFilesRecursive(String path, int level, File targetFile) throws IOException{
		
		File directory = new File(path);
		File[] files = directory.listFiles();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		if(files != null) {
			
			for(File file : files) {
				
				Arrays.sort(files);
				String indentation = getIndentation(level);
				
				if(file.isDirectory()) {
					FileUtils.write(targetFile, indentation+"D: "+file.getName()+" Last modified: "+dateFormat.format(file.lastModified())+"\n", "UTF-8", true);
					listDirectoryFilesRecursive(file.getAbsolutePath(), level+1, targetFile);
				}else if(file.isFile()){
					FileUtils.write(targetFile, indentation+"F: "+file.getName()+" Last modified: "+dateFormat.format(file.lastModified())+"\n", "UTF-8", true);
				}
			}
		}
	}
	
	private static String getIndentation(int level) {
		
		String indentation = "";
		
		for(int i=0; i<level; i++) {
			
			indentation+="|  ";
		}
		return indentation;
	}
}
