package de.hsMannheim.tpe.gruppe21.ab05.collections;

public class WordQuantity implements Comparable<WordQuantity>{

	private int quantity;

	private String word;

	public WordQuantity(String word,int quantity) {
		this.quantity = quantity;
		this.word = word;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getWord() {
		return word;
	}

	@Override
	public int compareTo(WordQuantity arg0) {
		return Integer.compare(quantity, arg0.getQuantity());
	}



}
