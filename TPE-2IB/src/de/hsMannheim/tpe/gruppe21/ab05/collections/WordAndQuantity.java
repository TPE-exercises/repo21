package de.hsMannheim.tpe.gruppe21.ab05.collections;

public class WordAndQuantity implements Comparable<WordAndQuantity> {

	private int quantity;
	private String word;

	public WordAndQuantity(String word,int quantity) {
		this.quantity = quantity;
		this.word = word;
	}

	/**
	 * 
	 * @return quantity of the word
	 */
	public int getQuantity() {
		return quantity;
	}

	
	/**
	 * @return word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * compares the quantity of two WordAndQuantity objects
	 */
	@Override
	public int compareTo(WordAndQuantity o) {
		return Integer.compare(quantity, o.getQuantity());
	}


}
