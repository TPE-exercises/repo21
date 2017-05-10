package de.hsMannheim.tpe.gruppe21.ab03;

import java.io.*;

public class CaesarFileEncryptor implements IFileEncrypter {
	
	public static void main(String[] args) throws IOException{
		File test = new File("caesar");
		CaesarFileEncryptor cfe = new CaesarFileEncryptor(5);
		cfe.encrypt(test);
		
	}
	
	
	private int key;
	
	public CaesarFileEncryptor(int key){
		this.key = key;
	}
	
	@Override
	public File encrypt(File sourceDirectory) throws IOException {
		String encryptedFilePath = createFilePath(sourceDirectory, true);
		String sourceFilePath = sourceDirectory.getAbsolutePath();
		encryptRecursively(sourceDirectory, encryptedFilePath, sourceFilePath);
		return new File(encryptedFilePath);
	}
	
	public void encryptRecursively(File sourceDirectory, String encryptedFilePath, String sourceFilePath) throws IOException{
		if(!sourceDirectory.isFile()){
			File[] nextOnes = sourceDirectory.listFiles();
			File dire = new File(encryptedFilePath);
			dire.mkdirs();
			for(int i = 0; i<nextOnes.length; i++){
				String encryptedFilePathOfThisOne = encryptedFilePath +"\\" + nextOnes[i].getName();
				String sourceFilePathOfThisOne = sourceFilePath + "\\" + nextOnes[i].getName();
				
				//---------PRINT--------
				System.out.println(sourceFilePathOfThisOne);
				System.out.println(encryptedFilePathOfThisOne);
				//---------PRINT--------
				
				encryptRecursively(nextOnes[i], encryptedFilePathOfThisOne, sourceFilePathOfThisOne);
			}
		}
		else if(sourceDirectory.isFile() && sourceDirectory.getName().toLowerCase().endsWith(".txt")){
			encryptRealFile(sourceFilePath, encryptedFilePath);
		}
	}
	
	/**
	 * works only if File.isFile() is true
	 * @param sourceDirectory
	 * @return
	 * @throws IOException 
	 */
	public void encryptRealFile(String sourceDirectory, String encryptDirectory) throws IOException{
		if(new File(sourceDirectory).isFile()){
			BufferedReader buffreader = new BufferedReader(new FileReader(sourceDirectory));
			CaesarWriter caesarWriter = new CaesarWriter(new FileWriter(encryptDirectory), this.key);
			
			String toEncrypt = "";
			while(toEncrypt != null){
				toEncrypt = buffreader.readLine();
				if(toEncrypt != null){
					caesarWriter.write(toEncrypt + "\n");
				}
			}
			
			caesarWriter.close();
			buffreader.close();
		}
	}

	@Override
	public File decrypt(File sourceDirectory) {
		String decryptedFilePath = createFilePath(sourceDirectory, false);
		decryptRecursively(sourceDirectory, decryptedFilePath);
		return new File(decryptedFilePath);
	}
	
	public void decryptRecursively(File sourceDirectory, String filePath){
		
	}
	
	
	private String createFilePath(File sourceDirectory, boolean encrypt){
		String endr = sourceDirectory.getAbsolutePath();
		if(encrypt){
			endr += "_encrypted";
		}
		else{
			endr += "_decrypted";
		}
		String testIsAvailible = endr;
		int counter = 0;
		while(new File(testIsAvailible).exists()){
			testIsAvailible = endr + counter;
			counter++;
		}
		endr = testIsAvailible;
		return endr;
	}

}
