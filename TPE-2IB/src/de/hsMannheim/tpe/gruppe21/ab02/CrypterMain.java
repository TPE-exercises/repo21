package de.hsMannheim.tpe.gruppe21.ab02;

import static gdi.MakeItSimple.*;

public class CrypterMain {
	
	public static void main(String[] args) {
		CrypterReverse reverse = new CrypterReverse();

		String message = reverse.encrypt("Hallo");

		println(message);
		
		
		CrypterCaesar caesar = new CrypterCaesar();

		String message2 = caesar.encrypt("XYZ");

		println(message2);

		String message3 = caesar.decrypt(message2);

		println(message3);
		
		
	}
}
