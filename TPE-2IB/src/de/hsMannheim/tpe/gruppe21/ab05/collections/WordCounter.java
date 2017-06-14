package de.hsMannheim.tpe.gruppe21.ab05.collections;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

public class WordCounter {

	private Map<String, Integer> words = new HashMap<>();

	public WordCounter(Path file) throws IOException   {
		countWords(file);
	}

	private void countWords(Path file) throws IOException {
		Scanner input = new Scanner(file).useDelimiter(" +|(\r\n|\r|\n)");
			while (input.hasNext()) {
				String word = input.next().toLowerCase();
				
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

	public Map<String, Integer> getWords() {

		return new HashMap<>(words);

	}

	private boolean isWord(String checkWord) {
		if (checkWord.length() == 0) {
			return false;
		}
		for (int i = 0; i < checkWord.length(); i++) {
			char ch = checkWord.charAt(i);
			if (ch < 61 || ch > 122) {
				return false;
			}
		}
		return true;

	}
}

