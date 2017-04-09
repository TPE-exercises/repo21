package hsm.tpeGroup21.ab01;
import static gdi.MakeItSimple.*;
public class BBaumMain {

	public static void main(String[] args) {
		BTree test = new BTree(10);
		//test.insert("rndmNmbrs.txt");
		test.insert("rndmNmbrs.txt");
		println("Contain 2: " + test.contains(2));
		//	test.printLevelorder();
	}

}
