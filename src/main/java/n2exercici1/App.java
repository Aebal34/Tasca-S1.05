package n2exercici1;

import java.io.*;
import org.apache.commons.configuration2.*;

public class App {

	public static void main(String[] args) {
		
		PropertiesConfiguration config = new PropertiesConfiguration();
		
		String path = System.getProperty("user.dir");
		File textFile = new File(path+"\\directories.txt");
		
		try {
			ListFilesInDirectory.listDirectoryFilesRecursive(path, 0, textFile);
		}catch(IOException e) {
			System.out.println("Ha ocurrido un error IO.");
		}
	}
}
