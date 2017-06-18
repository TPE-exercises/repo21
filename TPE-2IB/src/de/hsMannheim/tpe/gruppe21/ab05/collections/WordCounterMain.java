package de.hsMannheim.tpe.gruppe21.ab05.collections;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class WordCounterMain {

	public static void main(String[] args) throws IOException {
		Path file = FileSystems.getDefault().getPath("src/de/hsMannheim/tpe/gruppe21/ab05/collections/Bibel.txt");
		long start = System.currentTimeMillis();
		Map<String, Integer> wordCounts = new WordCounter(file).getWords();
		List<WordAndQuantity> sortedWordCounts = loadMapIntoList(wordCounts);

		
		//Sorts the list by the word quantity
		Collections.sort(sortedWordCounts, Collections.reverseOrder());
		
		List<WordAndQuantity> cuttedList = cutList(sortedWordCounts, 100);


		sortAlphabetical(cuttedList);
		
		long elapsedTime = System.currentTimeMillis() - start;

		printList(cuttedList);

		System.out.println("Time: " + elapsedTime + "ms");

	}

	
	
	/**
	 * Creates a sub list from the original list with the entered size
	 * 
	 * @param list, list to get subList from 
	 * @param newMaxSize, new max size of the List
	 * @return subList with entered MaxSize
	 */
	public static List<WordAndQuantity> cutList(List<WordAndQuantity> list, int newMaxSize){
		if (list.size() > newMaxSize) {
			return list = list.subList(0, newMaxSize);
		}
		return list;
	}
	
	
	/**
	 * Prints out the list elements
	 * 
	 * @param list to print
	 */
	public static void printList(List<WordAndQuantity> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + 1 + ". " + list.get(i).getWord() + ": " + list.get(i).getQuantity());
		}
	}

	
	/**
	 * Loads the words and the quantity of them from a map into a list
	 * 
	 * @param map with words and the quantity of them
	 * @return List with WordAndQuantity objects
	 */
	public static List<WordAndQuantity> loadMapIntoList(Map<String, Integer> map) {
		List<WordAndQuantity> list = new LinkedList<>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			list.add(new WordAndQuantity(entry.getKey(), entry.getValue()));
		}
		return list;

	}

	
	/**
	 * Sorts the List alphabetical
	 * @param list to sort
	 */
	public static void sortAlphabetical(List<WordAndQuantity> list) {
		Collections.sort(list, new Comparator<WordAndQuantity>() {

			@Override
			public int compare(final WordAndQuantity object1, final WordAndQuantity object2) {
				return object1.getWord().compareTo(object2.getWord());
			}
		});

	}
}