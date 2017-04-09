package hsm.tpeGroup21.ab01;
import static gdi.MakeItSimple.*;
public class BBaumMain {

	public static void main(String[] args) {
		BTree test = new BTree(10);
		
		//test.insert("rndmNmbrs.txt");
		test.insert("rndmNmbrs.txt");
		test.printInorder();
		test.printPostorder();
		test.printPreorder();
		println("Sum: "+ test.size());
		//	test.printLevelorder();
	}

}
