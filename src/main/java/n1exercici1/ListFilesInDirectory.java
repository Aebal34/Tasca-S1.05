package n1exercici1;

import java.io.*;
import java.util.*;

public class ListFilesInDirectory {

	public static void listDirectoryFiles(String path) {
		
		File directory = new File(path);
		SortedSet<File> files = new TreeSet<File>(Arrays.asList(directory.listFiles()));
		
		if(files != null && !files.isEmpty()) {
				
			for(File file : files) {
				
				if(file.isDirectory()) {
					System.out.println(file.getAbsolutePath());
				}else if(file.isFile()){
					System.out.println(file.getName());
				}
			}
		}
	}
}
