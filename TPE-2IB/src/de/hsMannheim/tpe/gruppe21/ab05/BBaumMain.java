package de.hsMannheim.tpe.gruppe21.ab05;

public class BBaumMain {

	public static void main(String[] args) {
		BTree test = new BTree(5,"rndmNmbrs.txt");
		test.printInorder();
		
		test.delete(50);
		
		test.printInorder();
		
	}

}
