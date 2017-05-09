package de.hsMannheim.tpe.gruppe21.ab03;

import java.io.File;

public class CaesarFileEncryptor implements IFileEncrypter {
	
	
	private int key;
	
	public CaesarFileEncryptor(int key){
		this.key = key;
	}
	
	@Override
	public File encrypt(File sourceDirectory) {
		String encryptedFilePath = createFilePath(sourceDirectory, true);
		return encryptRecursively(sourceDirectory, encryptedFilePath);
	}
	
	public File encryptRecursively(File sourceDirectory, String filePath){
		
	}

	@Override
	public File decrypt(File sourceDirectory) {
		String decryptedFilePath = createFilePath(sourceDirectory, false);
		return decryptRecursively(sourceDirectory, decryptedFilePath);
	}
	
	public File decryptRecursively(File sourceDirectory, String filePath){
		
	}
	
	
	private String createFilePath(File sourceDirectory, boolean encrypt){
		String endr = sourceDirectory.getPath();
		if(encrypt){
			endr += "_encrypted";
		}
		else{
			endr += "_decrypted";
		}
		int counter = 0;
		if(new File(endr).exists()){
			endr += "0";
		}
		while(new File(endr).exists()){
			counter++;
			char[] endrChar = endr.toCharArray();
			endrChar[endrChar.length-1] = (char) counter;
			endr = new String(endrChar);
		}
		return endr;
	}

}
