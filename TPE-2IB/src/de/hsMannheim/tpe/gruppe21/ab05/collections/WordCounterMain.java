package de.hsMannheim.tpe.gruppe21.ab05.collections;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class WordCounterMain {

	public static void main(String[] args) throws IOException {
		Path file = FileSystems.getDefault().getPath("Bibel.txt");
		Map<String, Integer> wordCounts = new WordCounter(file).getWords();
		
		
		/*for (Map.Entry<String,Integer> entry : wordCounts.entrySet()) {
			  String key = entry.getKey();
			  Integer value = entry.getValue();
			  System.out.println(key + ": " + value);
			}
			*/
		

	    List<Map.Entry<String, Integer>> list = new LinkedList<>( wordCounts.entrySet() );
	    Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
	    {
	        @Override
	        public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
	        {
	            return ( o1.getValue() ).compareTo( o2.getValue() );
	        }
	    } );

	    Map<String, Integer> result = new LinkedHashMap<>();
	    for (Map.Entry<String, Integer> entry : list)
	    {
	        result.put( entry.getKey(), entry.getValue() );
	    }
	    Map<String, Integer> wordCountsSorted = result;
	
	    
	for (Map.Entry<String,Integer> entry : wordCountsSorted.entrySet()) {
		  String key = entry.getKey();
		  Integer value = entry.getValue();
		  System.out.println(key + ": " + value);
		}
	

	
	}

}
