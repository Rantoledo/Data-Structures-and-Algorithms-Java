
public class Singlylinkedlist {

	private static int counter;
	private Node head;

	// Default constructor
	public Singlylinkedlist() {}
	
	
	
	// appends the specified element to the end of this list.
	public void add(Object data) {

		// Initialize Node only incase of 1st element
		if (head == null) {
			head = new Node(data);
		}
		
		Node crunchifyTemp = new Node(data);
		Node linkedLstCurr = head;

		// Let's check for NPE before iterate over linkedLstCurr
		if (linkedLstCurr != null) {
			// starting at the head node, crawl to the end of the list and then add element after last node
			while (linkedLstCurr.getNext() != null) {
				linkedLstCurr = linkedLstCurr.getNext();
			}
			// the last node's "next" reference set to our new node
			linkedLstCurr.setNext(crunchifyTemp);
		}
		// increment the number of elements variable
		incrementCounter();
	}

	private static int getCounter() { return counter;}
	private static void incrementCounter() {counter++;}
	private void decrementCounter() {counter--;}

	// inserts the specified element at the specified position in this list
	public void add(Object data, int index) {
		Node crunchifyTemp = new Node(data);
		Node linkedLstCurr = head;

		// Let's check for NPE before iterate over linkedLstCurr
		if (linkedLstCurr != null) {
			// crawl to the requested index or the last element in the list, whichever comes first
			for (int i = 0; i < index && linkedLstCurr.getNext() != null; i++) {
				linkedLstCurr = linkedLstCurr.getNext();
			}
		}

		// set the new node's next-node reference to this node's next-node reference
		crunchifyTemp.setNext(linkedLstCurr.getNext());

		// now set this node's next-node reference to the new node
		linkedLstCurr.setNext(crunchifyTemp);

		// increment the number of elements variable
		incrementCounter();
	}

	public Object get(int index)
	// returns the element at the specified position in this list.
	{
		// index must be 1 or higher
		if (index < 0)
			return null;
		Node linkedLstCurr = null;
		if (head != null) {
			linkedLstCurr = head.getNext();
			for (int i = 0; i < index; i++) {
				if (linkedLstCurr.getNext() == null)
					return null;

				linkedLstCurr = linkedLstCurr.getNext();
			}
			return linkedLstCurr.getData();
		}
		return linkedLstCurr;
	}

	// removes the element at the specified position in this list.
	public boolean remove(int index) {

		// if the index is out of range, exit
		if (index < 1 || index > size())
			return false;

		Node linkedLstCurr = head;
		if (head != null) {
			for (int i = 0; i < index; i++) {
				if (linkedLstCurr.getNext() == null)
					return false;

				linkedLstCurr = linkedLstCurr.getNext();
			}
			linkedLstCurr.setNext(linkedLstCurr.getNext().getNext());

			// decrement the number of elements variable
			decrementCounter();
			return true;
		}
		return false;
	}

	// returns the number of elements in this list.
	public int size() { return getCounter();}

	public String toString() {
		String output = "";

		if (head != null) {
			Node linkedLstCurr = head.getNext();
			while (linkedLstCurr != null) {
				output += "[" + linkedLstCurr.getData().toString() + "]";
				linkedLstCurr = linkedLstCurr.getNext();
			}

		}
		return output;
	}

	private class Node {
		// reference to the next node in the chain, or null if there isn't one.
		private Node next;

		// data carried by this node. could be of any type you need.
		Object data;

		// Node constructor
		public Node(Object dataValue) {
			next = null;
			data = dataValue;
		}

		// another Node constructor if we want to specify the node to point to.
		@SuppressWarnings("unused")
		public Node(Object dataValue, Node nextValue) {
			next = nextValue;
			data = dataValue;
		}

		// these methods should be self-explanatory
		public Object getData() {
			return data;
		}

		@SuppressWarnings("unused")
		public void setData(Object dataValue) {
			data = dataValue;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node nextValue) {
			next = nextValue;
		}
	}
}
