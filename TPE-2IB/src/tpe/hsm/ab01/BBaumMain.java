package tpe.hsm.ab01;
import static gdi.MakeItSimple.*;
public class BBaumMain {

	public static void main(String[] args) {
		BTree test = new BTree(2);
		test.insert(1);
		test.insert(5);
		test.insert(-1);
		test.insert(34);



		println(test.getWurzel().toString());
		println(test.getMax());
		println(test.getMin());
	}

}
