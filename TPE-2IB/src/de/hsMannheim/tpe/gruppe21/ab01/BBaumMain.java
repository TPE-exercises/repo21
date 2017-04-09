package de.hsMannheim.tpe.gruppe21.ab01;

import static gdi.MakeItSimple.*;

public class BBaumMain {

	public static void main(String[] args) {
		BTree[] bt = new BTree[3];
		int[] ordnung = new int[3];
		do{
			println("Ordnung des ersten BBaum: ");
			ordnung[0] = readInt();
		}while(ordnung[0]< 1);
		
		do{
			println("Ordnung des zweiten BBaum: ");
			ordnung[1] = readInt();
		}while(ordnung[1]< 1);
		
		do{
			println("Ordnung des dritten BBaum: ");
			ordnung[2] = readInt();
		}while(ordnung[2]< 1);
		
		for (int i = 0; i < bt.length; i++) {
			bt[i] = new BTree(ordnung[i]);
		}
		int wn = 0;
		int inp = 0;
		String inpstr;
		boolean goOn = true;
		while (goOn) {
			println("-------------------------");
			println("|Working Tree: " + wn + "\t" + "|");
			printMainMenu();
			int input = readInt();
			switch (input) {

			case (0):
				print("Number to insert: ");
				inp = readInt();
				if (bt[wn].insert(inp)) {
					println("insertion successfull");
				} else {
					println("Failed");
				}
				break; // insert number

			case (1):
				print("File to insert: ");
				readLine();
				inpstr = readLine();
				if (bt[wn].insert(inpstr)) {
					println("insertion successfull");
				} else {
					println("Failed");
				}
				break; // insert File

			case (2):
				print("Number to search for: ");
				inp = readInt();
				if (bt[wn].contains(inp)) {
					println("Tree contains " + inp);
				} else {
					println("Tree doesn't contain " + inp);
				}
				break; // Contains
			case (3):
				println("Size of BTree: " + bt[wn].size());
				break; // Size
			case (4):
				println("Height of BTree: " + bt[wn].height());
				break; // Height
			case (5):
				println("Biggest Number of BTree: " + bt[wn].getMax());
				break; // Biggest Number
			case (6):
				println("Smallest Number of BTree: " + bt[wn].getMin());
				break; // Smallest Number
			case (7):
				if (bt[wn].isEmpty()) {
					println("Tree is empty");
				} else {
					println("Tree isn't empty");
				}
				break; // insert number

			case (8):
				do{
					print("Binary Tree to add: ");
					inp = readInt();
				}
				while(inp<0 || inp>=3);
				bt[wn].addAll(bt[inp]);
				println("Success");
				break; //addAll

			case (10):
				bt[wn].printInorder();
				break; // printInorder
			case (11):
				bt[wn].printPostorder();
				break; // printPostorder
			case (12):
				bt[wn].printPreorder();
				break; // printPreorder
			case (13):
				bt[wn].printLevelorder();
				break; // printLevelorder

			case (20):
				do {
					println("Change to: ");
					inp = readInt();
				} while (inp < 0 || inp >= 3);
				wn = inp;
				break; // change wn
			case (50):
				goOn = false;
				println("Stopped");
				break; // stop

			}
		}
	}

	public static void printMainMenu() {
		println("|Das ist ein tolles Menue|");
		
		println("|0:  insert number       |");
		println("|1:  insert File         |");
		println("|2:  contains number     |");
		println("|3:  size                |");
		println("|4:  height              |");
		println("|5:  biggest number      |");
		println("|6:  smallest number     |");
		println("|7:  is Empty            |");
		println("|8:  addAll              |");
		
		
		println("|10:  Print Inorder      |");
		println("|11:  Print Postorder    |");
		println("|12:  Print Preorder     |");
		println("|13:  Print Levelorder   |");
		
		
		println("|20: change wn to:       |");
		println("|50: STOP                |");
		print("???Watcha gonna do???: ");
	}

}
