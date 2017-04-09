package hsm.tpeGroup21.ab01;
import static gdi.MakeItSimple.*;
public class BBaumMain {

	public static void main(String[] args) {
		BTree test = new BTree(10);
		BTree test2 = new BTree(10);
		//test.insert("rndmNmbrs.txt");
		test.insert("rndmNmbrs.txt");
		test2.addAll(test);
		test.printInorder();
		test2.printInorder();
		test.printPostorder();
		test.printPreorder();
		//	test.printLevelorder();
	}

}
