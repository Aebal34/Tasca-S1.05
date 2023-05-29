package n3exercici1;

import javax.crypto.*;
import javax.crypto.spec.*;

import org.apache.commons.io.FileUtils;

import java.security.*;
import java.io.*;


public class CryptoFiles {

	//CONSTANTS
	private static final String AES_ALGORITHM = "AES";
    private static final String ENCRYPTION_MODE = "CBC";
    private static final String PADDING_SCHEME = "PKCS5Padding";
    
	public static void encryptFile(String path, File targetFile, String content) throws Exception {
		
		//We generate a random key on a SecretKey object getting it's bytes from AES algorithm
		KeyGenerator keyGenerator = KeyGenerator.getInstance(AES_ALGORITHM);
		SecretKey secretKey = keyGenerator.generateKey();
		String keyPath = path+"\\key.txt";
		saveKeyToFile(keyPath, secretKey);
		
		//We instantiate a Cipher with the proper encrypt algorithms
		Cipher cipher = Cipher.getInstance(AES_ALGORITHM + "/" + ENCRYPTION_MODE + "/" + PADDING_SCHEME);
		
		//GENERATE RANDOM IV
		SecureRandom secureRandom = new SecureRandom();//Instantiate a SecureRandom
		byte[] ivBytes = new byte[(cipher.getBlockSize())];//we establish array size with block size from cipher
		secureRandom.nextBytes(ivBytes);//We replenish array with a random number given from SecureRandom
		
		//We instantiate the initialization Vector we'll need to encrypt the file with the encryption mode CBC
		IvParameterSpec iv = new IvParameterSpec(ivBytes);
		
		//SAVE IV
		String ivPath = path+"\\iv.txt";
		try {
			saveIvToFile(iv, ivPath);
		}catch(IOException e) {
			e.getCause();
		}
		
		//CIPHER INIT with the secretKey and iv
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
		
		//Convert content to bytes
		byte[] textBytes = content.getBytes();		
		
		//Encrypt bytes
		byte[] encryptedBytes = cipher.doFinal(textBytes);
		
		//We open a FileoutputStream to write the encrypted bytes to a .txt
		String outputFile = targetFile.getAbsolutePath();
        FileOutputStream fos = new FileOutputStream(outputFile);
        fos.write(encryptedBytes);
        fos.close();
		
	}
	
	public static void decryptFile(String path, File encryptedFile, File targetfile) throws Exception {
		
		//Load key from file
		String keyPath = path + "\\key.txt";
		SecretKey secretKey = loadKeyFromFile(keyPath);
		
		//Instantiate cipher
		Cipher cipher = Cipher.getInstance(AES_ALGORITHM + "/" + ENCRYPTION_MODE + "/" + PADDING_SCHEME);
		
		//Load IV from file
		String ivPath = path + "\\iv.txt";
		IvParameterSpec iv = loadIvFromFile(ivPath);
		
		cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
		
		byte[] encryptedBytes = FileUtils.readFileToByteArray(encryptedFile);
		
		byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
		
		FileUtils.writeByteArrayToFile(targetfile, decryptedBytes);
		
	}
	
	private static void saveKeyToFile(String keyPath, SecretKey secretKey) throws IOException {
		
		byte[] keyBytes = secretKey.getEncoded();
		FileUtils.writeByteArrayToFile(new File(keyPath), keyBytes);
	}
	
	private static SecretKey loadKeyFromFile(String keyPath) throws IOException {
		
		byte[] keyBytes = FileUtils.readFileToByteArray(new File(keyPath));
		return new SecretKeySpec(keyBytes, AES_ALGORITHM);
	}
	
	private static void saveIvToFile(IvParameterSpec iv, String ivPath) throws IOException {
		
		byte[] ivBytes = iv.getIV();
		
		FileUtils.writeByteArrayToFile(new File(ivPath), ivBytes);
	}
	
	public static IvParameterSpec loadIvFromFile(String ivPath) throws IOException {
		
	    byte[] ivBytes = FileUtils.readFileToByteArray(new File(ivPath));
	    
	    return new IvParameterSpec(ivBytes);
	}
}
