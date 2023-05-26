package n1exercici5;

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
		
		//Exercise 5 - Store object into .ser
		Customer customer1 = new Customer("Jordi", "12345678Ñ", 30);
		customer1.setPassword("1234abcd+");
		
		//We set file name same as DNI
		path += "\\"+customer1.getDNI()+".ser";
		try {
			ListFilesInDirectory.storeObject(path, customer1);
		} catch (IOException e) {
			e.getMessage();
		}
		
		//Exercise 5 - Read object from .ser
		try {
			Customer customer2 = ListFilesInDirectory.readCustomer(path);
			System.out.println(customer2);
		} catch (ClassNotFoundException | IOException e) {
			e.getMessage();
		}
		
	}
}
