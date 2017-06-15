package de.hsMannheim.tpe.gruppe21.ab05.collections;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

public class WordCounter {
	private Map<String, Integer> words = new HashMap<>();

	
	
	
	
	public WordCounter(Path file) throws IOException   {
		countWords(file);
	}

	
	/**
	 * Scans the file for words and puts them into a Map with the quantity of the words
	 * 
	 * @param path of the text file
	 * @throws IOException if the file can not be scanned (maybe wrong path or no read rights)
	 */
	private void countWords(Path file) throws IOException {
		Scanner input = new Scanner(file).useDelimiter(" +|(\r\n|\r|\n)");
			while (input.hasNext()) {
				String word = input.next().toLowerCase();
				removePunctuationMarks(word);
				if (isWord(word)) {
						if (words.containsKey(word)) {
						words.put(word, words.get(word) + 1);
					} else {
						words.put(word, 1); 
					}
				}
			}
			input.close();
		
	}
	
	
	/**
	 * Removes all PunctuationMarks from entered string
	 * @param str, String to remove PunctuationMarks from
	 */
	private void removePunctuationMarks(String str) {
		str.replaceAll("(),.:;!?", "");
	}
	
	

	/**
	 * @return Map with scanned Words and the quantity of the words
	 */
	public Map<String, Integer> getWords() {
		return new HashMap<String, Integer>(words);

	}

	
	/**
	 * Checks if the inserted String is a word
	 * 
	 * @param checkString, to check if it is a word or not
	 * @return true if the String is a word, false if not
	 */
	private boolean isWord(String checkString) {
		if (checkString.length() == 0) {
			return false;
		}
		for (int i = 0; i < checkString.length(); i++) {
			char ch = checkString.charAt(i);
			if (ch < 61 || ch > 122) {
				return false;
			}
		}
		return true;

	}
}

