package de.hsMannheim.tpe.gruppe21.ab03;

import java.io.*;

public class CaesarWriter extends FilterWriter {
	
	private int key;
	
	protected CaesarWriter(Writer arg0, int key) {
		super(arg0);
		this.key = key;
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		// TODO Auto-generated method stub
		super.write(cbuf, off, len);
	}

	@Override
	public void write(int c) throws IOException {
		// TODO Auto-generated method stub
		super.write(c);
	}

	@Override
	public void write(String str, int off, int len) throws IOException {
		// TODO Auto-generated method stub
		super.write(str, off, len);
	}
	
	
}
