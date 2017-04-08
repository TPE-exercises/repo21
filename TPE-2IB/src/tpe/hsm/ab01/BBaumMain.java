package tpe.hsm.ab01;
import static gdi.MakeItSimple.*;
public class BBaumMain {

	public static void main(String[] args) {
		BTree test = new BTree(2);
		test.insert(1);
		test.insert(5);
		test.insert(-1);
		test.insert(34);
		test.insert(2);
		test.insert(3);
		test.insert(-54);
		test.insert(24);
		
println(test.contains(24));
println(test.contains(-54));
println(test.contains(3));
println(test.contains(2));
println(test.contains(34)); 
println(test.contains(-1));
println(test.contains(5));
println(test.contains(1));


		println(test.getWurzel().toString());
		println(test.getMax());
		println(test.getMin());
	}

}
