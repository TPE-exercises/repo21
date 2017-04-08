
package tpe.hsm.ab01;
import static gdi.MakeItSimple.*;

public class BTree implements BBaum {
	public static final int LEAF = 0;
	public static final int NOLEAF = 1;
	
	//Attribute
	private int ordnung;
	private BBaumNode wurzel;
	
	//Konstruktoren
	BTree(int ordnung){
		this.ordnung = ordnung;
		wurzel = new BBaumNode(ordnung, LEAF);
	}
	
	BTree(int ordnung, String filename){
		this(ordnung);
		if(!insert(filename))
			throw new GDIException("Datei konnte nicht eingelesen werden");
	}
	
	
	//Methoden
	public BBaumNode getWurzel(){
		return wurzel;
	}
	
	public boolean insert(Integer o) {
		//TODO contains wieder rein kloppen 
		//if(contains(o)){
		//	return false;
		//}
		BBaumNode dummy = new BBaumNode(this.ordnung, NOLEAF);
		boolean temp = wurzel.insert(o,dummy);
		if(dummy.getValues()[0] != null){
			wurzel = dummy;
		}
		return temp;
	}
		
	
	public boolean insert(String filename) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean contains(Integer o) {
		//return wurzel.contains(o);
		return false;
	}

	
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int height() {
		return wurzel.height();
	}

	
	public Integer getMax() {
		return wurzel.getMax();
	}

	
	public Integer getMin() {
		return wurzel.getMin();
	}

	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	
	public void addAll(BTree otherTree) {
		// TODO Auto-generated method stub
		
	}

	
	public void printInorder() {
		print("Inorder: ");
		wurzel.printInorder();
		println();
	}

	
	public void printPostorder() {
		print("Postorder: ");
		wurzel.printPostorder();
		println();
	}

	
	public void printPreorder() {
		print("Preorder: ");
		wurzel.printPreorder();
		println();	
	}

	
	public void printLevelorder() {
		print("Levelorder: ");
		wurzel.printLevelorder();
		println();
	}



}


