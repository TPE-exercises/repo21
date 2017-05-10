package de.hsMannheim.tpe.gruppe21.ab03;

import static gdi.MakeItSimple.*;

import de.hsMannheim.tpe.gruppe21.ab03.myutil.*;

public class TestMainExc {

	private static ADT queueArr = new QueueArray(5);
	private static ADT queueList = new QueueLinkedList(5);

	private static ADT stackArr = new StackArray(5);
	private static ADT stackList = new StackLinkedList(5);

	public static void main(String[] args) throws OverflowException, UnderflowException {
		ADT workingADT = chooseADT();
		boolean goOn = true;
		while (goOn) {
			printMainMenu();
			int input = readInt();
			readLine();
			switch (input) {

			case (0):
				enterADT(workingADT);
				break;
				
			case (1):
				println("Removed object: " + workingADT.leave());
				break;

			case (2):
				println("Front object: " + workingADT.front());
				break;

			case (3):
				if(workingADT.isEmpty()){
					println("ADT is empty");
				} else {
					println("ADT is not empty");
				}
				break;

			case (4):
				println("Size of ADT: " + workingADT.size());
				break;

			case (10):
			workingADT = chooseADT();
			break;

			case (50):
				goOn = false;
				println("Stopped");
				break;
			}
		}

	}
	
	/**
	 * Lets u decide if you want to enter a Integer or a String
	 * 
	 * @param actual workingADT
	 * @throws OverflowException if ADT gets to full for its size
	 */
	private static void enterADT(ADT workingADT) throws OverflowException{
		println("|     Choose Object   |");
		println("|0:   Integer         |");
		println("|1:   String          |");
	
		int input = readInt();
		readLine();
		switch (input) {

		case (0):
			println("Enter Integer");
			Integer integer = readInt();
			readLine();
			workingADT.enter(integer);
			println(integer + " added");
			break;
		case (1):
			println("Enter String");
			String string = readLine();
			workingADT.enter(string);
			println(string + " added");
			
			break;
			
	}
	}

	/**
	 * Method to choose a ADT to work with
	 * @return ADT to work with
	 */
	private static ADT chooseADT() {
		printADTMenu();
		int input = readInt();
		readLine();
		switch (input) {

		case (0):
			return queueArr;

		case (1):
			return queueList;

		case (2):
			return stackArr;

		case (3):
			return stackList;

		default:
			println("You get a QueueArray");
			return queueArr;

		}

	}

	/**
	 * Prints the choose menu for the ADTs
	 */
	private static void printADTMenu() {
		println("|     Choose ADT      |");
		println("|0:   QueueArray      |");
		println("|1:   QueueLinkedList |");
		println("|2:   StackArray      |");
		println("|3:   StackLinkedList |");
	}

	
	/**
	 * Prints the main menu for actions
	 */
	private static void printMainMenu() {
		println("|     Choose action   |");
		println("|0:   enter           |");
		println("|1:   leave           |");
		println("|2:   front           |");
		println("|3:   isEmpty         |");
		println("|4:   size            |");
		println("|10:  change ADT      |");
		println("|50:  STOP            |");
	}

}

