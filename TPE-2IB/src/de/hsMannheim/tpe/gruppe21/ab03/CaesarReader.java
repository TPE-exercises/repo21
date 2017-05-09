package de.hsMannheim.tpe.gruppe21.ab03;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class CaesarReader extends FilterReader {
	
	private int key;

	protected CaesarReader(Reader arg0, int key) {
		super(arg0);
		this.key = key;
	}

	@Override
	public int read() throws IOException {
		super.read();
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		super.read(cbuf, off, len);
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
