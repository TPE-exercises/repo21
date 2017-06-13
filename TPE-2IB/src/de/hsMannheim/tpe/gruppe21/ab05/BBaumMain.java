package de.hsMannheim.tpe.gruppe21.ab05;

public class BBaumMain {

	public static void main(String[] args) {
		BTree test = new BTree(2);
		test.insert(5);
		test.insert(26);
		test.insert(23);
		test.insert(4);
		test.insert(2);
		test.insert(13);
		
		test.printInorder();
		
		test.delete(5);
		
		test.printInorder();
	}

}
