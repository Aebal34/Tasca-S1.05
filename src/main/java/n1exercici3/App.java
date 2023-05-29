package n1exercici3;

import java.io.*;

public class App {

	public static void main(String[] args) {
		
		String path = System.getProperty("user.dir");
		File textFile = new File(path+"\\directories.txt");
		
		try {
			ListFilesInDirectory.listDirectoryFilesRecursive(path, 0, textFile);
			System.out.println("Archivo guardado con exito");
		}catch(IOException e) {
			System.out.println("Ha ocurrido un error IO.");
		}
	}
}
