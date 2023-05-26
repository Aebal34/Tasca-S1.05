package n1exercici2;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class ListFilesInDirectory {
	
	public static void listDirectoryFilesRecursive(String path, int level) throws IOException{
		
		File directory = new File(path);
		File[] files = directory.listFiles();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		if(files != null) {
			
			for(File file : files) {
				
				Arrays.sort(files);
				String indentation = getIndentation(level);
				
				if(file.isDirectory()) {
					System.out.println(indentation+"D: "+file.getName()+" Last modified: "+dateFormat.format(file.lastModified()));
					listDirectoryFilesRecursive(file.getAbsolutePath(), level+1);
				}else if(file.isFile()){
					System.out.println(indentation+"F: "+file.getName()+" Last modified: "+dateFormat.format(file.lastModified()));
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
