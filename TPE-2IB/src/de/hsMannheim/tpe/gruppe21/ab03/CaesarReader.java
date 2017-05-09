package de.hsMannheim.tpe.gruppe21.ab03;

import java.io.*;

public class CaesarReader extends FilterReader {
	
	public static final char[] caesarAlph = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
			'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
			'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'Ä', 'Ö', 'Ü', 'ä', 'ö', 'ü' };
	
	private int key;

	protected CaesarReader(Reader arg0, int key) {
		super(arg0);
		this.key = key;
	}

	@Override
	public int read() throws IOException {		
		return caesarDecrypt((char)super.read());
	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		int ret = super.read(cbuf, off, len);
		for(int i = 0; i < cbuf.length; i++){
			cbuf[i] = caesarDecrypt(cbuf[i]);
		}
		return ret;
	}

	private char caesarDecrypt(char toDecrypt){
		int position = caesarAlph.length;
		for(int i = 0; i < caesarAlph.length; i++){
			if(caesarAlph[i] == toDecrypt){
				position = i - key;
			}
		}
		//if there is an underflow
		while(position < 0){
			position += caesarAlph.length;
		}
		if(position < caesarAlph.length){
			return caesarAlph[position];
		}
		//else:= toCrypt is special char
		else{
			return toDecrypt;
		}
	}
	
	
}
