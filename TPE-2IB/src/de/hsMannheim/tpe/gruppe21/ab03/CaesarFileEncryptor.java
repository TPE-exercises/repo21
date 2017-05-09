package de.hsMannheim.tpe.gruppe21.ab03;

import java.io.File;

public class CaesarFileEncryptor implements IFileEncrypter {

	@Override
	public File encrypt(File sourceDirectory) {
		if(!sourceDirectory.isFile()){
			//TODO: an unter Files kommen!
		}
		else{
			//TODO: encrypt
		}
		return null;
	}

	@Override
	public File decrypt(File sourceDirectory) {
		if(!sourceDirectory.isFile()){
			//TODO: an unter Files kommen!
		}
		else{
			//TODO: encrypt
		}
		return null;
	}

}
