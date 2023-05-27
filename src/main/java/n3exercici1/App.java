package n3exercici1;

import java.io.*;

public class App {

	public static void main(String[] args) {
		
		String path = System.getProperty("user.dir");
		File textFile = new File(path+"\\directories.txt");
		
		try {
			ListFilesInDirectory.listDirectoryFilesRecursive(path, 0, textFile);
		}catch(IOException e) {
			System.out.println("Ha ocurrido un error IO.");
		}
		
		try {
			CryptoFiles.encryptFile(path, textFile, ListFilesInDirectory.getText());
			System.out.println("Content succesfully encrypted.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File decryptedFile = new File(path+"\\directoriesD.txt");
		try {
			CryptoFiles.decryptFile(path, textFile, decryptedFile);
			System.out.println("Content succesfully decrypted.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
