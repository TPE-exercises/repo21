package de.hsMannheim.tpe.gruppe21.ab03;

import java.io.*;

import de.hsMannheim.tpe.gruppe21.ab03.myutil.*;


public interface IFileEncrypter {
	
	/**
	 * File gets encrypted
	 * @param sourceDirectory file to encrypt
	 * @return encrypted file
	 * @throws IOException 
	 */
	public File encrypt(File sourceDirectory) throws IOException;
	
	
	/**
	 * File gets decrypted
	 * @param sourceDirectory file to decrypt
	 * @return decrypted file
	 * @throws IOException 
	 */
	public File decrypt(File sourceDirectory) throws IOException;
	

}
