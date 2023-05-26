package n1exercici5;

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
	
	public static void storeObject(String path, Object object) throws IOException {
		
		FileOutputStream fos = new FileOutputStream(path);
		ObjectOutputStream output = new ObjectOutputStream(fos);
		
		output.writeObject(object);
		output.close();
	}
	public static Customer readCustomer(String path) throws IOException, ClassNotFoundException {
		
		FileInputStream fos = new FileInputStream(path);
		ObjectInputStream input = new ObjectInputStream(fos);
		Customer customer1;
		
		customer1 = (Customer)input.readObject();
		input.close();
		return customer1;
	}
}
