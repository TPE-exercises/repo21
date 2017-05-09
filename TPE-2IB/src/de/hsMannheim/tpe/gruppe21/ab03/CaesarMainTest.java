package de.hsMannheim.tpe.gruppe21.ab03;

import java.io.*;

public class CaesarMainTest {

	public static void main(String[] args) throws IOException{
		int key = 5;
		String original = "Das ist ein Test mit vielen Grenzfällen A Z a z @ { Ä Ö Ü ä ö ü .";
		CaesarWriter caesarW5 = new CaesarWriter(new FileWriter("forCaesarEncryption.txt"), key);
		caesarW5.write(original, 0, original.length());
		caesarW5.close();
		
		CaesarReader caesarR5 = new CaesarReader(new FileReader("forCaesarEncryption.txt"), key);
		char [] cbuf = new char[original.length()];
		caesarR5.read(cbuf);
		caesarR5.close();
		
		String endresult = new String(cbuf);
		System.out.println(endresult);
	}

}
