package de.hsMannheim.tpe.gruppe21.ab05;

import static gdi.MakeItSimple.*;

public class BBaumNode {

	private int maxValues;
	private Comparable[] values;
	private BBaumNode[] pointer;
	private BBaumNode parent = null;

	
	BBaumNode(int ordnung) {
		maxValues = ordnung * 2;
		// one more than necessary, to make burst "easy"
		values = new Comparable[maxValues + 1];
		pointer = new BBaumNode[maxValues + 2];
	}

	BBaumNode(int ordnung, BBaumNode parent) {
		this(ordnung);
		this.parent = parent;
	}

	public Comparable[] getValues() {
		return values;
	}

	public BBaumNode[] getPointer() {
		return pointer;
	}

	
	/**
	 * @return amount of values in nodes
	 */
	public int getSize() {
		int sum = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i] != null) {
				sum++;
			}
		}
		for (int i = 0; i < pointer.length; i++) {
			if (pointer[i] != null) {
				sum += pointer[i].getSize();
			}
		}
		return sum;
	}

	/**
	 * @param value
	 *            to search in the pointer
	 * @return position of pointer with the "value"
	 */
	private int getPointerNumber(Comparable value) {
		for (int i = 0; i < maxValues + 1; i++) {
			if (pointer[i].values[0] == value) {
				return i;
			}
		}
		return -1;
	}

	// methods

	/**
	 * adds new pointer
	 * 
	 * @param node
	 *            to insert
	 */
	public void addPointer(BBaumNode toInsert) {
		for (int i = 0; i < maxValues + 2; i++) {
			if (pointer[i] == null) {
				pointer[i] = toInsert;
				sortPointer();
				return;
			}
		}
	}

	
	/**
	 * 
	 * @return true if one value too much in node
	 */
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
	 *            dummy, if there is no parent, it becomes new root
	 * @return null, if there was an parent before, else return node
	 */
	public BBaumNode burst(BBaumNode dummy) {
		int mid = maxValues / 2;
		if (parent != null) {
			// if there is already a parent, the full node gets split
			BBaumNode leftNode = new BBaumNode(maxValues / 2, parent);
			BBaumNode rightNode = new BBaumNode(maxValues / 2, parent);
			// add values to nodes
			for (int i = 0; i < mid; i++) {
				leftNode.insert(values[i], false, dummy);
			}
			for (int i = mid + 1; i < maxValues + 1; i++) {
				rightNode.insert(values[i], false, dummy);
			}
			// add pointer to new nodes
			for (int i = 0; i < maxValues + 2; i++) {
				if (pointer[i] == null) {
					i = maxValues + 2;
				} else if (pointer[i].values[0].compareTo(values[mid])< 0) {
					leftNode.addPointer(pointer[i]);
					pointer[i].parent = leftNode;
				} else {
					rightNode.addPointer(pointer[i]);
					pointer[i].parent = rightNode;
				}
			}
			int placeForLeft = parent.getPointerNumber(values[0]);
			if (placeForLeft < 0) {
				println("Fehler bei: " + values[0]);
			}
			parent.pointer[placeForLeft] = leftNode;
			parent.addPointer(rightNode);
			parent.insert(values[mid], true, dummy);

		} else {
			// if there is no parent, node becomes the new root
			BBaumNode leftNode = new BBaumNode(maxValues / 2, dummy);
			BBaumNode rightNode = new BBaumNode(maxValues / 2, dummy);
			// add values to new nodes
			for (int i = 0; i < mid; i++) {
				leftNode.insert(values[i], false, dummy);
			}
			for (int i = mid + 1; i < maxValues + 1; i++) {
				rightNode.insert(values[i], false, dummy);
			}
			// add pointer to new nodes
			for (int i = 0; i < maxValues + 2; i++) {
				if (pointer[i] == null) {
					i = maxValues + 2;
				} else if (pointer[i].values[0].compareTo(values[mid]) < 0) {
					leftNode.addPointer(pointer[i]);
					pointer[i].parent = leftNode;
				} else {
					rightNode.addPointer(pointer[i]);
					pointer[i].parent = rightNode;
				}
			}

			dummy.insert(values[mid], false, dummy);
			dummy.pointer[0] = leftNode;
			dummy.pointer[1] = rightNode;
			return dummy;
		}
		return null;
	}

	/**
	 * @param to search Integer o
	 * @return true, if node or nodes under it contain o
	 */

	public boolean contains(Comparable o) {
		for (int i = 0; i < values.length; i++) {
			if (values[i] != null && o.compareTo(values[i]) == 0) {
				return true;
			} else if (values[i] == null || o.compareTo(values[i]) < 0|| i == values.length - 1) {
				if (pointer[i] != null) {
					return pointer[i].contains(o);
				}
			}
		}
		return false;
	}

	/**
	 * sort pointer of a node with insertionsort
	 */
	private void sortPointer() {
		for (int i = maxValues; i > 0; i--) {
			if (pointer[i] != null && pointer[i - 1].values[0].compareTo(pointer[i].values[0]) > 0 ){
				BBaumNode temp = pointer[i - 1];
				pointer[i - 1] = pointer[i];
				pointer[i] = temp;
			}
		}
	}

	/**
	 * 
	 * @param values2
	 *            gets inserted
	 * @param burst
	 *            if true: forced to insert in this node
	 * @param node
	 *            dummy node, if there is no parent, it becomes the new root
	 * @return true if it was succesfull, false if it wasnt succesfull
	 */
	public boolean insert(Comparable values2, boolean burst, BBaumNode node) {
		if (pointer[0] == null || burst) {
			for (int i = 0; i < maxValues + 1; i++) {
				if (values[i] == null) {
					values[i] = values2;
					insertionSort();
					if (isFull()) {
						burst(node);
						return true;
					}
					return true;
				}
			}
		} else {
			for (int i = 0; i < maxValues + 1; i++) {
				if (values[i] == null || values[i].compareTo(values2) > 0) {
					return pointer[i].insert(values2, false, node);
				}
			}
		}
		return false;
	}

	/**
	 * sorts values by insertion sort
	 */
	public void insertionSort() {
		int lastInsertion = maxValues;
		for (int i = 0; i < maxValues + 1; i++) {
			if (values[i] == null) {
				lastInsertion = i - 1;
				i = maxValues + 1;
			}
		}
		for (int i = lastInsertion; i > 0; i--) {
			if (values[i].compareTo(values[i - 1]) < 0) {
				Comparable temp = values[i];
				values[i] = values[i - 1];
				values[i - 1] = temp;
			} else
				return;
		}

	}
	
/**
 * @return values of node as a String
 */
	public String toString() {
		String ret = "(";
		for (int i = 0; i < maxValues; i++) {
			if (values[i] != null) {
				ret = ret + values[i] + " ";
			}
		}
		ret = ret + ")";
		return ret;
	}

	/**
	 * 
	 * @return max Value 
	 */
	public Comparable getMax() {
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

	/**
	 * 
	 * @return min Value
	 */
	public Comparable getMin() {
		if (pointer[0] != null) {
			return pointer[0].getMin();

		} else {
			if (values[0] != null) {
				return values[0];
			}
		}

		return null;
	}


	/**
	 * @return level of node
	 */
	public int height() {
		if (pointer[0] == null) {
			return 1;
		} else {
			return 1 + pointer[0].height();
		}
	}

	public void printLevelorder() {
		for (int i = 0; i < height(); i++) {
			printLevel(i);
			println();
		}
	}

	public void printLevel(int lvl) {
		if (lvl == 0) {
			print(toString());
		} else {
			for (int i = 0; i < pointer.length; i++) {
				if (pointer[i] != null) {
					pointer[i].printLevel(lvl - 1);
				}
			}
		}
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
		print("(");
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
		print(")");
	}

	public void printPreorder() {
		print("(");
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
		print(")");
	}

	
	public boolean delete(Comparable o) {
		for (int i = 0; i < values.length; i++) {
			if (values[i] != null && o.compareTo(values[i]) == 0) {
				values[i] = null;
				return true;
			} else if (values[i] == null || o.compareTo(values[i]) < 0|| i == values.length - 1) {
				if (pointer[i] != null) {
					return pointer[i].delete(o);
				}
			}
		}		
		return false;
	}
}
