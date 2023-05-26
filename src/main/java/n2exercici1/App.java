package n2exercici1;

import java.io.*;
import org.apache.commons.configuration2.*;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.*;

import org.apache.commons.configuration2.ex.ConfigurationException;



public class App {

	public static void main(String[] args) {
		
		FileBasedConfiguration config = null;
		Parameters params = new Parameters();
		FileBasedConfigurationBuilder<PropertiesConfiguration> builder = 
				new FileBasedConfigurationBuilder<PropertiesConfiguration>(PropertiesConfiguration.class)
				.configure(params.properties()
						.setFileName("config.properties")
						.setBasePath(System.getProperty("user.dir")));
		
		try {
			config = builder.getConfiguration();
			System.out.println("No ha pillado exception!");
		} catch (ConfigurationException e) {
			e.getMessage();
			System.out.println("Ha pillado exception!");
		}
		
		String path = (String) config.getProperty("directoryPath");
		File textFile = new File(path+(String)config.getProperty("fileName"));
		
		try {
			ListFilesInDirectory.listDirectoryFilesRecursive(path, 0, textFile);
		}catch(IOException e) {
			System.out.println("Ha ocurrido un error IO.");
		}
	}
}
