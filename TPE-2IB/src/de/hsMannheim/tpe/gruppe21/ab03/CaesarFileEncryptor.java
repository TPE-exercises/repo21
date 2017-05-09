package de.hsMannheim.tpe.gruppe21.ab03;

import java.io.File;

public class CaesarFileEncryptor implements IFileEncrypter {
	
	@Override
	public File encrypt(File sourceDirectory) {
		if(!sourceDirectory.isFile()){
			File[] inFile = sourceDirectory.listFiles();
			for(int i = 0; i < inFile.length; i++){
				encrypt(inFile[i]);
			}
		}
		else{
			//TODO: encrypt
		}
		return null;
	}

	@Override
	public File decrypt(File sourceDirectory) {
		if(!sourceDirectory.isFile()){
			File[] inFile = sourceDirectory.listFiles();
			for(int i = 0; i < inFile.length; i++){
				encrypt(inFile[i]);
			}
		}
		else{
			//TODO: decrypt
		}
		return null;
	}

}
