package hsm.tpeGroup21.ab01;
import static gdi.MakeItSimple.*;
public class BBaumMain {

	public static void main(String[] args) {
		BTree test = new BTree(2);
		
		
		test.insert(1);
		test.printInorder();
		test.insert(2);
		test.printInorder();
		test.insert(4);
		test.printInorder();
		test.insert(3);
		test.printInorder();
		test.insert(13);
		test.printInorder();
		test.insert(8);
		test.printInorder();
		test.insert(7);
		test.printInorder();
		test.insert(16);
		test.printInorder();
		test.insert(13);
		test.printInorder();
		test.insert(-2);
		
		test.printInorder();
	//	test.printPostorder();
	//	test.printPreorder();
	//	test.printLevelorder();
	}

}
