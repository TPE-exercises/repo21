package de.hsMannheim.tpe.gruppe21.ab022;

public class CrypterCaesar implements Crypter{
	
	private final int GROßZUKLEIN = 32;
	private final int GROßA = 65;
	private final int GROßZ = 90;
	private final int KLEINA = 97;
	private final int KLEINZ = 122;	
	
	@Override
	public String encrypt(String message) {
		int key = 5;
		String newMessage = "";
		for(int i = 0; i< message.length(); i++){
			
			if(!isLetter(message.charAt(i))){
				//TODO: Throw new exception
			}
			
			//Upper case
			if(message.charAt(i) < KLEINA){
				if(message.charAt(i)+ key > GROßZ){
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
		return ((GROßA <= toTest &&  toTest <= GROßZ) || (KLEINA <= toTest &&  toTest <= KLEINZ));
	}
	
	@Override
	public String decrypt(String cypherText) {
		// TODO Auto-generated method stub
		return null;
	}

}