package de.hsMannheim.tpe.gruppe21.ab03;

import java.io.*;

public class CaesarFileEncryptor implements IFileEncrypter {
	
	public static void main(String[] args) throws IOException{
		File testEncr = new File("caesar");
		CaesarFileEncryptor cfe = new CaesarFileEncryptor(5);
		cfe.encrypt(testEncr);
		
		File testDecr = new File("caesar_encrypted");
		cfe.decrypt(testDecr);
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
	
	@Override
	public File decrypt(File sourceDirectory) throws IOException {
		String decryptedFilePath = createFilePath(sourceDirectory, false);
		String sourceFilePath = sourceDirectory.getAbsolutePath();
		decryptRecursively(sourceDirectory, decryptedFilePath, sourceFilePath);
		return new File(decryptedFilePath);
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
	
	public void decryptRecursively(File sourceDirectory, String decryptedFilePath, String sourceFilePath) throws IOException{
		if(!sourceDirectory.isFile()){
			File[] nextOnes = sourceDirectory.listFiles();
			File dire = new File(decryptedFilePath);
			dire.mkdirs();
			for(int i = 0; i < nextOnes.length; i++){
				String decryptedFilePathOfThisOne = decryptedFilePath + "\\" + nextOnes[i].getName();
				String sourceFilePathOfThisOne = sourceFilePath + "\\" + nextOnes[i].getName();
				
				//---------PRINT--------
				System.out.println(sourceFilePathOfThisOne);
				System.out.println(decryptedFilePathOfThisOne);
				//---------PRINT--------
				
				decryptRecursively(nextOnes[i], decryptedFilePathOfThisOne, sourceFilePathOfThisOne);
			}
		}
		else if(sourceDirectory.isFile() && sourceDirectory.getName().toLowerCase().endsWith(".txt")){
			decryptRealFile(sourceFilePath, decryptedFilePath);
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
			BufferedReader buffReader = new BufferedReader(new FileReader(sourceDirectory));
			CaesarWriter caesarWriter = new CaesarWriter(new FileWriter(encryptDirectory), this.key);
			
			String toEncrypt;
			do{
				toEncrypt = buffReader.readLine();
				if(toEncrypt != null){
					caesarWriter.write(toEncrypt + "\n");
				}
			}while(toEncrypt != null);
			
			caesarWriter.close();
			buffReader.close();
		}
	}
	
	public void decryptRealFile(String sourceDirectory, String decryptDirectory) throws IOException{
		if(new File(sourceDirectory).isFile()){
			CaesarReader caesarReader = new CaesarReader(new FileReader(sourceDirectory), 5);
			FileWriter fileWriter = new FileWriter(decryptDirectory);
			
			int toDecrypt;
			do{
				toDecrypt = (caesarReader.read());
				
				//------------PRINT---------------
				System.out.println("toDecrypt: " + toDecrypt);
				//------------PRINT---------------
				
				if(toDecrypt != -1 && toDecrypt != 65535){
					fileWriter.write(toDecrypt);
				}
			}while(toDecrypt != -1 && toDecrypt!= 65535);
			
			fileWriter.close();
			caesarReader.close();
		}
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
