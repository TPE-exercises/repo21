package tpe.hsm.ab01;
import static gdi.MakeItSimple.*;
public class BBaumMain {

	public static void main(String[] args) {
		BTree test = new BTree(2);
		
		
		test.insert(1);
		test.insert(2);


		
		println(test.height());
		
	//	test.printInorder();
	//	test.printPostorder();
	//	test.printPreorder();
	//	test.printLevelorder();
	}

}
