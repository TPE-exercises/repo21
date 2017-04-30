package de.hsMannheim.tpe.gruppe21.ab02;

import static gdi.MakeItSimple.*;

public class CrypterMain {
	
	public static void main(String[] args) {
		CrypterReverse reverse = new CrypterReverse();
		CrypterCaesar caesar = new CrypterCaesar();

		String message = "XHMSNYYXYJQQJS";
		message = reverse.decrypt(message);
		println(message);
		message = caesar.decrypt(message);
		println(message);
		message = reverse.decrypt(message);
		println(message);
		
	}
}
