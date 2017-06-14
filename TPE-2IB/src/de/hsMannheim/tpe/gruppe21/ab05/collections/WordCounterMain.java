package de.hsMannheim.tpe.gruppe21.ab05.collections;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class WordCounterMain {

	public static void main(String[] args) throws IOException {
		Path file = FileSystems.getDefault().getPath("src/de/hsMannheim/tpe/gruppe21/ab05/collections/Bibel.txt");
		long start = System.currentTimeMillis();
		Map<String, Integer> wordCounts = new WordCounter(file).getWords();
		List<WordQuantity> sortedWordCounts = loadMapIntoList(wordCounts);

		
		
		sortAlphabetical(sortedWordCounts);
		Collections.sort(sortedWordCounts, Collections.reverseOrder());
		List<WordQuantity> cuttedList = cutList(sortedWordCounts, 100);

		long elapsedTime = System.currentTimeMillis() - start;

		printMap(cuttedList);

		System.out.println("Time: " + elapsedTime + "ms");

	}

	
	public static List<WordQuantity> cutList(List<WordQuantity> list, int elementQuantity){
		if (list.size() > elementQuantity) {
			return list = list.subList(0, elementQuantity);
		}
		return list;
	}
	
	
	public static void printMap(List<WordQuantity> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + 1 + ". " + list.get(i).getWord() + ": " + list.get(i).getQuantity());
		}
	}

	public static List<WordQuantity> loadMapIntoList(Map<String, Integer> map) {
		List<WordQuantity> list = new LinkedList<>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			list.add(new WordQuantity(entry.getKey(), entry.getValue()));
		}
		return list;

	}

	public static void sortAlphabetical(List<WordQuantity> list) {
		Collections.sort(list, new Comparator<WordQuantity>() {

			@Override
			public int compare(final WordQuantity object1, final WordQuantity object2) {
				return object1.getWord().compareTo(object2.getWord());
			}
		});

	}
}