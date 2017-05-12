package de.hsMannheim.tpe.gruppe21.ab03;

import java.io.*;

public class CaesarFileEncryptor implements IFileEncrypter {
	
	public static void main(String[] args) throws IOException{
		File testEncr = new File("caesar");
		File testDecr = new File("caesar_encrypted");
		
		CaesarFileEncryptor cfe = new CaesarFileEncryptor(5);
		cfe.encrypt(testEncr);
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
	
	/**
	 * encrypt the file,
	 * if its a path, files of this path get encrypted recursively
	 * @param sourceDirectory file to encrypt
	 * @param encryptedFilePath path of the new file, with encrypted file
	 * @param sourceFilePath file Path of the file to encrypt
	 * @throws IOException
	 */
	private void encryptRecursively(File sourceDirectory, String encryptedFilePath, String sourceFilePath) throws IOException{
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
	 * encrypt the file,
	 * if its a path, files of this path get decrypted recursively
	 * @param sourceDirectory file to encrypt
	 * @param decryptedFilePath path of the new file, with decrypted file
	 * @param sourceFilePath file path of the file to decrypt
	 * @throws IOException
	 */
	private void decryptRecursively(File sourceDirectory, String decryptedFilePath, String sourceFilePath) throws IOException{
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
	 * encrypt files if there are real files
	 * @param sourceDirectory path of file to encrypt
	 * @param encryptDirectory path of file with encrypted file
	 * @throws IOException 
	 */
	private void encryptRealFile(String sourceDirectory, String encryptDirectory) throws IOException{
		if(new File(sourceDirectory).isFile()){
			BufferedReader buffReader = new BufferedReader(new FileReader(sourceDirectory));
			CaesarWriter caesarWriter = new CaesarWriter(new BufferedWriter(new FileWriter(encryptDirectory)), this.key);
			
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
	
	/**
	 * decrypt files if they are real files
	 * @param sourceDirectory path of the file to decrypt
	 * @param decryptDirectory path of file with decrypted file
	 * @throws IOException
	 */
	private void decryptRealFile(String sourceDirectory, String decryptDirectory) throws IOException{
		if(new File(sourceDirectory).isFile()){
			CaesarReader caesarReader = new CaesarReader(new BufferedReader(new FileReader(sourceDirectory)), 5);
			BufferedWriter buffWriter = new BufferedWriter(new FileWriter(decryptDirectory));
			
			int toDecrypt;
			
			do{
				toDecrypt = (caesarReader.read());
				if(toDecrypt != -1){
					buffWriter.write(toDecrypt);
				}
			}while(toDecrypt != -1);
			
			buffWriter.close();
			caesarReader.close();
		}
	}
	
	/**
	 * creates the file path for encrypted or decrypted files by adding "_encrypted" or "_decrypted" to the original String
	 * @param sourceDirectory file with the path to change to the encrypted or decrypted version
	 * @param encrypt true, if it should be encrypted, false, if it should be decrypted
	 * @return the new file path for the encrypted or decrypted files
	 */
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
