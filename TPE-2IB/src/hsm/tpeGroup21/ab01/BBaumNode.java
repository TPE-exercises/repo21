package hsm.tpeGroup21.ab01;

import static gdi.MakeItSimple.*;

public class BBaumNode {

	public static final int LEAF = 0;
	public static final int NOLEAF = 1;

	// Attr
	private int maxValues;
	private int isLeaf;
	private Integer[] values;
	private BBaumNode[] pointer;
	private BBaumNode parent;

	// Konstr
	BBaumNode(int ordnung, int isLeaf) {
		maxValues = ordnung * 2;
		this.isLeaf = isLeaf;
		values = new Integer[maxValues + 1];
		pointer = new BBaumNode[maxValues + 1];
	}

	BBaumNode(int ordnung, int isLeaf, BBaumNode parent) {
		this(ordnung, isLeaf);
		this.parent = parent;
	}

	// getter, setter
	public Integer[] getValues() {
		return values;
	}

	// methods

	/**
	 * adds new pointer
	 * 
	 * @param node
	 *            to insert
	 */
	public void addPointer(BBaumNode toInsert) {
		for (int i = 0; i < maxValues + 1; i++) {
			if (pointer[i] == null) {
				pointer[i] = toInsert;
				sortPointer();
				return;
			}
		}
	}

	private boolean isFull() {
		if (values[maxValues] != null)
			return true;
		else
			return false;
	}

	/**
	 * split the node, mid get inserted in parent, parent gets new pointer
	 * 
	 * @param node
	 *            to split
	 * @return null, if there was an parent before, else the new parent/wurzel
	 */
	public BBaumNode burst(BBaumNode node) {
		int mid = maxValues / 2;
		BBaumNode leftNode = new BBaumNode(maxValues / 2, this.isLeaf);
		BBaumNode rightNode = new BBaumNode(maxValues / 2, this.isLeaf);
		for (int i = 0; i < mid; i++) {
			leftNode.insert(values[i], node);
		}
		for (int i = mid + 1; i < maxValues+1; i++) {
			rightNode.insert(values[i], node);
		}
		if (parent != null) {
			parent.insert(values[mid], node);
			parent.addPointer(leftNode);
			parent.addPointer(rightNode);
		} else {
			node.insert(values[mid], node);
			node.pointer[0] = leftNode;
			node.pointer[1] = rightNode;
			return node;
		}
		return null;
	}

	/**
	 * @param to
	 *            search Integer o
	 * @return true, if node or nodes under it contain o
	 */

	public boolean contains(Integer o) {
		// search all values and pointer
		for (int i = 0; i < pointer.length; i++) {
			if (values[i] == null) { // end of values, one pointer left
				if (pointer[i] == null) {
					return false;
				} else
					return pointer[i].contains(o);
			} else if (values[i] == o) {
				return true;
			} else if (values[i] > o) {
				if(pointer[i]==null){
					return false;
				}else
					return pointer[i].contains(o);
			}
		}
		return false;
	}

	/**
	 * sort pointer of a node with insertionsort
	 */
	private void sortPointer() {
		for (int i = maxValues + 1; i > 0; i--) {
			if (pointer[i] == null) {
				return;
			} else if (pointer[i - 1].values[0] > pointer[i].values[0]) {
				BBaumNode temp = pointer[i - 1];
				pointer[i - 1] = pointer[i];
				pointer[i] = temp;
			}
		}
	}

	public boolean insert(int value, BBaumNode node) {		
		for (int i = 0; i < maxValues + 1; i++) {
			//if its not
			if (values[i]!=null && values[i]>value && pointer[i]!=null){
				return pointer[i].insert(value,node);
			}
			if (values[i] == null) {
				values[i] = value;
				insertionSort();
				if (isFull()) {
					burst(node);
					return true;
				}
				return true;
			}
		}
		return false;
	}

	public void insertionSort() {
		int lastInsertion = maxValues - 1;
		for (int i = 0; i < maxValues; i++) {
			if (values[i] == null) {
				lastInsertion = i - 1;
				i = maxValues;
			}
		}
		for (int i = lastInsertion; i > 0; i--) {
			if (values[i] < values[i - 1]) {
				int temp = values[i];
				values[i] = values[i - 1];
				values[i - 1] = temp;
			} else
				return;
		}

	}

	public String toString() {
		String ret = "(";
		for (int i = 0; i < maxValues; i++) {
			if (values[i] != null) {
				ret = ret + values[i] + ";";
			}
		}
		ret = ret + ")";
		return ret;
	}

	// gibt zz falsche sachen aus D:
	public Integer getMax() {
		if (pointer[0] != null) {
			for (int i = pointer.length - 1; i >= 0; i--) {
				if (pointer[i] != null) {
					return pointer[i].getMax();
				}
			}
		} else {
			for (int i = values.length - 1; i >= 0; i--) {
				if (values[i] != null) {
					return values[i];
				}
			}
		}
		return null;
	}

	public Integer getMin() {
		if (pointer[0] != null) {
			return pointer[0].getMin();

		} else {
			if (values[0] != null) {
				return values[0];
			}
		}

		return null;
	}

	
	public int height(){
		if(pointer[0] ==  null){
			return 1;
		}
		BBaumNode node = pointer[0];
		int height = 1;
		while(node != null){
			height++;
			node = node.pointer[0];
		}
		return height;
		
	}

	public void printLevelorder() {
		// TODO dann mach ich mal die height funktion
	}

	public void printInorder() {
		print("(");
		for (int i = 0; i < pointer.length; i++) {
			if (pointer[i] != null) {
				pointer[i].printInorder();
			}
			if (i < values.length && values[i] != null) {
				print(values[i] + " ");
			}
		}
		print(")");
	}

	public void printPostorder() {
		for (int i = 0; i < pointer.length; i++) {
			if (pointer[i] != null) {
				pointer[i].printPostorder();
			}
		}
		for (int i = 0; i < values.length; i++) {
			if (values[i] != null) {
				print(values[i] + " ");
			}
		}
	}

	public void printPreorder() {
		for (int i = 0; i < values.length; i++) {
			if (values[i] != null) {
				print(values[i] + " ");
			}
		}
		for (int i = 0; i < pointer.length; i++) {
			if (pointer[i] != null) {
				pointer[i].printPreorder();
			}
		}
	}

}
