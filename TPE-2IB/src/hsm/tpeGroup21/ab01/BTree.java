package hsm.tpeGroup21.ab01;

import static gdi.MakeItSimple.*;

public class BTree implements BBaum {
	
	//Attribute
	private int ordnung;
	private BBaumNode wurzel;
	
	//Konstruktoren
	BTree(int ordnung){
		this.ordnung = ordnung;
		wurzel = new BBaumNode(ordnung);
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
		//if(contains(o)){
		//	return false;
		//}
		BBaumNode dummy = new BBaumNode(this.ordnung);
		boolean temp = wurzel.insert(o,false,dummy);
		if(dummy.getValues()[0] != null){
			wurzel = dummy;
		}
		return temp;
	}
		
	public boolean insert(String filename) {
		Object file = openInputFile(filename);
		boolean temp = true;
		while (!isEndOfInputFile(file)) {
			temp = insert(readInt(file)) && temp;
		}
		closeInputFile(file);
		return temp;
	}

	
	public boolean contains(Integer o) {
		return wurzel.contains(o);
	}

	
	public int size() {
		return wurzel.getSize();
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
		if(wurzel == null || wurzel.getValues()[0]==null){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * like printInorder, but instead of printing, it adds the values to this tree
	 * @param otherTree inserts everything of other tree
	 */
	public void addAll(BTree otherTree) {
		addAll(otherTree.wurzel);
		
	}
	
	public void addAll(BBaumNode otherNode) {
		for(int i = 0; i < otherNode.getPointer().length; i++){
			if(otherNode.getPointer()[i]!=null){
				addAll(otherNode.getPointer()[i]);
			}
			if(i < otherNode.getValues().length && otherNode.getValues()[i]!=null){
				insert(otherNode.getValues()[i]);
			}
		}
		
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


