package de.hsMannheim.tpe.gruppe21.ab022;

public class CrypterReverse implements Crypter {

	@Override
	public String encrypt(String message) {
		String newMessage = "";
		for (int i = message.length() - 1; i >= 0; i--) {
			newMessage += message.charAt(i);
		}
		return newMessage;
	}

	@Override
	public String decrypt(String cypherText) {
		return encrypt(cypherText);
	}

}
