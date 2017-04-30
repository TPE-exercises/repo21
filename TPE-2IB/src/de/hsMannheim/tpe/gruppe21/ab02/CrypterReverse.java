package de.hsMannheim.tpe.gruppe21.ab02;

public class CrypterReverse implements Crypter {

	@Override
	/**
	 * encrypts Strings by reverse encryption
	 * @param: message to encrypt
	 * @return: encrypted message
	 */
	public String encrypt(String message) {
		String newMessage = "";
		for (int i = message.length() - 1; i >= 0; i--) {
			newMessage += message.charAt(i);
		}
		return newMessage;
	}

	@Override
	/**
	 * decrypts is the same as encrypt
	 */
	public String decrypt(String cypherText) {
		return encrypt(cypherText);
	}

}
