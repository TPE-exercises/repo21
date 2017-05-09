package de.hsMannheim.tpe.gruppe21.ab03;

import java.io.*;

public class CaesarWriter extends FilterWriter {
	
	public static final char[] caesarAlph = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
			'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
			'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'Ä', 'Ö', 'Ü', 'ä', 'ö', 'ü' };
	
	private int key;
	
	protected CaesarWriter(Writer arg0, int key) {
		super(arg0);
		this.key = key;
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		char [] copyCbuf = copyCharArr(cbuf);
		for(int i = 0; i < copyCbuf.length ; i++){
			copyCbuf[i] = caesarCrypt(copyCbuf[i]);
		}
		super.write(copyCbuf, off, len);
	}

	@Override
	public void write(int c) throws IOException {
		int copyC = c;
		copyC = caesarCrypt((char) copyC);
		super.write(copyC);
	}

	@Override
	public void write(String str, int off, int len) throws IOException {
		char[] copyStrC = str.toCharArray();
		for(int i = 0; i < copyStrC.length ; i++){
			copyStrC[i] = caesarCrypt(copyStrC[i]);
		}
		String copyStrS = copyStrC.toString();
		super.write(copyStrS, off, len);
	}
	
	private char[] copyCharArr(char[] tca){
		char [] copyArr = new char[tca.length];
		for(int i = 0; i < tca.length; i++){
			copyArr[i] = tca[i];
		}
		return copyArr;
	}
	
 	private char caesarCrypt(char toCrypt){
		int position = -1;
		for(int i = 0; i < caesarAlph.length; i++){
			if(caesarAlph[i] == toCrypt){
				position = i;
			}
		}
		position += key;
		//if there is an overflow
		while(position > caesarAlph.length-1){
			position -= caesarAlph.length;
		}
		if(position>=0){
			return caesarAlph[position];
		}
		//else:= toCrypt is special char
		else{
			return toCrypt;
		}
	}
}
