package de.hsMannheim.tpe.gruppe21.ab02.crypter;
import static gdi.MakeItSimple.*;
public class CrypterCaesar implements Crypter{
	
	private final int GROSSA = 65;
	private final int GROSSZ = 90;
	private final int KLEINA = 97;
	private final int KLEINZ = 122;	
	private int key = 5;
	
	@Override
	/**
	 * encrypts a String with the key by ceasar encryption
	 * @param: message String to encrypt
	 * @return: String the encypted message 
	 */
	public String encrypt(String message) {
		String newMessage = "";
		for(int i = 0; i< message.length(); i++){
			
			if(!isLetter(message.charAt(i))){
				throw new GDIException("Only letters please...");
				
			}
			
			//Upper case
			if(message.charAt(i) < KLEINA){
				if(message.charAt(i)+ key > GROSSZ){
					newMessage += (char)(message.charAt(i)+key - 26);
				}
				else{
					newMessage += (char)(message.charAt(i)+key);
				}
			}
			//Lower case
			else{
				if(message.charAt(i)+ key > KLEINZ){
					newMessage += (char)(message.charAt(i)+key - 26);
				}
				else{
					newMessage += (char)(message.charAt(i)+key);
				}
			}
		}
		
		return newMessage;
	}
	
	public boolean isLetter(char toTest){
		return ((GROSSA <= toTest &&  toTest <= GROSSZ) || (KLEINA <= toTest &&  toTest <= KLEINZ));
	}
	
	@Override
	/**
	 * decrypts a String with the key by ceasar encryption
	 * @param: cypherText String to decrypt
	 * @return: String the decrypted message 
	 */
	public String decrypt(String cypherText) {
		String newMessage = "";
		for(int i = 0; i< cypherText.length(); i++){
			
			if(!isLetter(cypherText.charAt(i))){
				throw new GDIException("Only letters please...");
			}
			
			//Upper case
			if(cypherText.charAt(i) < KLEINA){
				if(cypherText.charAt(i)- key < GROSSA){
					newMessage += (char)(cypherText.charAt(i)-key + 26);
				}
				else{
					newMessage += (char)(cypherText.charAt(i)-key);
				}
			}
			//Lower case
			else{
				if(cypherText.charAt(i)- key < KLEINA){
					newMessage += (char)(cypherText.charAt(i)-key + 26);
				}
				else{
					newMessage += (char)(cypherText.charAt(i)-key);
				}
			}
		}
		
		return newMessage;
	}

}
