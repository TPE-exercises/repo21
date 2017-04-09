package hsm.tpeGroup21.ab01;
import static gdi.MakeItSimple.*;
public class BBaumMain {

	public static void main(String[] args) {
		BTree test = new BTree(2);
		test.insert("rndmNmbrs.txt");
		println("Height: "+ test.height());
		test.printLevelorder();
	}

}
