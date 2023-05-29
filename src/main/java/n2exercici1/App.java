package n2exercici1;

import java.io.*;
import java.util.*;



public class App {

	public static void main(String[] args) throws IOException {
		
		Properties properties = new Properties();
        try{
        	InputStream input = new FileInputStream("D:\\eclipse-workspace\\S1.05\\config.properties");
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		String path = properties.getProperty("directoryPath");

		File textFile = new File(path, properties.getProperty("fileName"));
		


		try {
			ListFilesInDirectory.listDirectoryFilesRecursive(path, 0, textFile);
		}catch(IOException e) {
			System.out.println("Ha ocurrido un error IO.");
		}
	}
}
