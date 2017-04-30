package de.hsMannheim.tpe.gruppe21.ab02;

public interface Crypter {
	
	
	/**
	 * @param message gets encrypted
	 * @return encrypted message
	 */
	public String encrypt(String message);
	
	/**
	 * @param cypherText gets decrypted
	 * @return decrypted message
	 */
	public String decrypt(String cypherText);
}
