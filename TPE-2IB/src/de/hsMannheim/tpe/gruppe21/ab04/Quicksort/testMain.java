package de.hsMannheim.tpe.gruppe21.ab04.Quicksort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class testMain {

	public static void main(String[] args) throws IOException {
		while(true){
			System.out.println("Your Array: ");
			System.out.println(printArray(mainArray));
			System.out.println("Press 1:  enter comparable in array");
			System.out.println("Press 2:  sort with sequentiell quicksort");
			System.out.println("Press 3:  sort with parallel quicksort");
			System.out.println("Press 4:  clear Array");
			System.out.println("Press 10: stop");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String inputMenu = br.readLine();
			int time = 0;
			
			switch(inputMenu){
			case "1": 
				mainArray = extendArray(mainArray);
				System.out.println("to insert:");
				int inputNumber = Integer.parseInt(br.readLine());
				mainArray[mainArray.length-1] = inputNumber;
				break;
			case "2":
				QuicksortSequentiell qs = new QuicksortSequentiell();
				time = (int)System.currentTimeMillis();
				qs.sort(mainArray);
				time = (int)System.currentTimeMillis() - time;
				printNumbers(qs.getNumbers(), time);
				break;
			case "3":
				QuicksortParallel qp = new QuicksortParallel();
				time = (int)System.currentTimeMillis();
				qp.sort(mainArray);
				time = (int)System.currentTimeMillis() - time;
				printNumbers(qs.getNumbers(), time);
				break;
			case "4":
				Integer[] newMain = {};
				mainArray = newMain;
				break;
			case "10":
				System.exit(0);
				break;
			default:
				System.out.println("Falsche Eingabe, bitte versuchen sie es erneut.");		
			}
		}
	}
	
	private static Integer[] mainArray = {};
	
	public static String printArray(Comparable[] array){
		String toPrint = "";
		for(int i = 0; i < array.length; i++){
			toPrint += array[i].toString() + ", ";
		}
		return toPrint;
	}
	
	public static boolean isSorted(Comparable[] array){
		for(int i = 0; i < array.length-1; i++){
			if(array[i].compareTo(array[i+1]) > 0){
				return false;
			}
		}
		return true;
	}

	public static void printNumbers(int[] numbers, int time){
		System.out.println("Zeit: " + time + "ms");
		System.out.println("Rekursions Schritte: " + numbers[0]);
		System.out.println("Vertauschungen: " + numbers[1]);
		System.out.println("Vergleiche: " + numbers[2]);
		System.out.println("Threads: " + numbers[3]);
	}
	
	private static Integer[] extendArray(Integer[] array){
		Integer[] newArray = new Integer[array.length+1];
		for(int i = 0; i < array.length; i++){
			newArray[i] = array[i];
		}
		return newArray;
	}
}
