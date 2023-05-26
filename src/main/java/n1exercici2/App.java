package n1exercici2;

import java.io.*;

public class App {

	public static void main(String[] args) {

		try {
			ListFilesInDirectory.listDirectoryFilesRecursive(System.getProperty("user.dir"), 0);
		}catch(IOException e) {
			System.out.println("Fecha no reconocida");
		}
		
	}
}
