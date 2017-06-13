package de.hsMannheim.tpe.gruppe21.ab05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BBaumMain {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int ordnung;
		do{
			System.out.println("Ordnung des BBaum: ");
			ordnung = Integer.parseInt(bf.readLine().trim());
		}while(ordnung< 1);		
		
		BTree bt = new BTree(ordnung);		
		int inp = 0;
		String inpstr;
		boolean goOn = true;
		while (goOn) {
			printMainMenu();
			int input = Integer.parseInt(bf.readLine().trim());
			switch (input) {

			case (0):
				System.out.print("Number to insert: ");
				inp = Integer.parseInt(bf.readLine().trim());
				if (bt.insert(inp)) {
					System.out.println("insertion successfull");
				} else {
					System.out.println("Failed");
				}
				break; // insert number

			case (1):
				System.out.print("File to insert: ");
			System.out.println();
				inpstr = bf.readLine();
				if (bt.insert(inpstr)) {
					System.out.println("insertion successfull");
				} else {
					System.out.println("Failed");
				}
				break; // insert File

			case (2):
				System.out.print("Number to search for: ");
				inp = Integer.parseInt(bf.readLine().trim());
				if (bt.contains(inp)) {
					System.out.println("Tree contains " + inp);
				} else {
					System.out.println("Tree doesn't contain " + inp);
				}
				break; // Contains
			case (3):
				System.out.println("Size of BTree: " + bt.size());
				break; // Size
			case (4):
				System.out.println("Height of BTree: " + bt.height());
				break; // Height
			case (5):
				System.out.println("Biggest Number of BTree: " + bt.getMax());
				break; // Biggest Number
			case (6):
				System.out.println("Smallest Number of BTree: " + bt.getMin());
				break; // Smallest Number
			case (7):
				if (bt.isEmpty()) {
					System.out.println("Tree is empty");
				} else {
					System.out.println("Tree isn't empty");
				}
				break; // insert number

			case (8):
				System.out.print("Number to delete:");
				int toDelete = Integer.parseInt(bf.readLine().trim());
				boolean ret = bt.delete(toDelete);
				if(ret){
					System.out.println("Success: " + toDelete + " got deleted.");
				}
				else{
					System.out.println("Failed");
				}
				break; //delete

			case (9):
				iteratorMenu(bt);
				break; // iterate	
				
			case (10):
				bt.printInorder();
				break; // printInorder
			case (11):
				bt.printPostorder();
				break; // printPostorder
			case (12):
				bt.printPreorder();
				break; // printPreorder
			case (13):
				bt.printLevelorder();
				break; // printLevelorder
				
			case (50):
				goOn = false;
			System.out.println("Stopped");
				break; // stop

			}
		}
	}

	private static void iteratorMenu(BTree bt) {
		BBaumIterator bbi = new BBaumIterator(bt);		
		
		int input = 0;
		boolean endIterator = false;
		
		while(!endIterator){
			printIteratorMenu(bbi);
			try {
				input = Integer.parseInt((new BufferedReader(new InputStreamReader(System.in))).readLine().trim());
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
			
			switch(input){
				case(0):
					if(bbi.hasNext()){
						System.out.println("hasNext == true");
					}
					else{
						System.out.println("hasNext == false");
					}
					break;
				case(1):
					Comparable n = (Comparable) bbi.next();
					System.out.println("Next: " + n);
					break;
				case(2):
					bbi.remove();
					System.out.println("Removed");
					break;
				case(10):
					endIterator = true;
					break;
			}
		}
		
	}

	private static void printIteratorMenu(BBaumIterator bbi) {
		System.out.println("__________________________");
		System.out.println("|Current value: " + bbi.getValue());
		System.out.println("|0:  hasNext             |");
		System.out.println("|1:  next                |");
		System.out.println("|2:  remove              |");
		System.out.println("|10: Stop iterator       |");
	}

	public static void printMainMenu() {
		System.out.println("__________________________");
		System.out.println("|0:  insert number       |");
		System.out.println("|1:  insert File         |");
		System.out.println("|2:  contains number     |");
		System.out.println("|3:  size                |");
		System.out.println("|4:  height              |");
		System.out.println("|5:  biggest number      |");
		System.out.println("|6:  smallest number     |");
		System.out.println("|7:  is Empty            |");
		System.out.println("|8:  delete number       |");
		System.out.println("|9:  iterate             |");
		System.out.println("|10: Print Inorder      |");
		System.out.println("|11: Print Postorder    |");
		System.out.println("|12: Print Preorder     |");
		System.out.println("|13: Print Levelorder   |");
		
		
		System.out.println("|50: STOP                |");
	}
}
