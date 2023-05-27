package n3exercici1;

import java.io.*;
import java.util.*;

import org.apache.commons.io.FileUtils;

import java.text.SimpleDateFormat;

public class ListFilesInDirectory {
	
	private static String text;
	
	public static String getText() {
		return text;
	}
	
	public static void listDirectoryFilesRecursive(String path, int level, File targetFile) throws IOException{
		
		File directory = new File(path);
		File[] files = directory.listFiles();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		if(files != null) {
			
			for(File file : files) {
				
				Arrays.sort(files);
				String indentation = getIndentation(level);
				
				if(file.isDirectory()) {
					text += indentation+"D: "+file.getName()+" Last modified: "+dateFormat.format(file.lastModified())+"\n";
					FileUtils.write(targetFile, indentation+"D: "+file.getName()+" Last modified: "+dateFormat.format(file.lastModified())+"\n", "UTF-8", true);
					listDirectoryFilesRecursive(file.getAbsolutePath(), level+1, targetFile);
				}else if(file.isFile()){
					text +=indentation+"F: "+file.getName()+" Last modified: "+dateFormat.format(file.lastModified())+"\n";
					FileUtils.write(targetFile, indentation+"F: "+file.getName()+" Last modified: "+dateFormat.format(file.lastModified())+"\n", "UTF-8", true);
					readTXTFile(file);
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
	
	private static void readTXTFile(File file) throws IOException {
		
		if(file.getName().endsWith(".txt")) {
			
			if(Input.readYesOrNo("We found the "+file.getName()+" file in "+file.getAbsolutePath()+"\n"
									+"Do you want to print it on the console? Y/N")) {
				System.out.println(FileUtils.readFileToString(file, "UTF-8"));
			}
		}
	}
}
