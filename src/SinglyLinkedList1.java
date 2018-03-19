
/*
 * still working on it...
 * need to change some stuff
 */
public class SinglyLinkedList1 {

	private int counter = 0;
	private Node head;  // head of list
	private Node end; // end of list
	
	/* Linked list Node*/
	private class Node
	{
		int data;
		Node next;
		Node(int d) {
			data = d; 
			next = null;
		}
	}

	/* Given a key, deletes the first occurrence of key in linked list */
	void deleteNode_key(int key)
	{
		// Store head node
		Node temp = head, prev = null;

		// If head node itself holds the key to be deleted
		if (temp != null && temp.data == key)
		{
			head = temp.next; // Changed head
			return;
		}

		// Search for the key to be deleted, keep track of the
		// previous node as we need to change temp.next
		while (temp != null && temp.data != key)
		{
			prev = temp;
			temp = temp.next;
		}    

		// If key was not present in linked list
		if (temp == null) return;

		// Unlink the node from linked list
		prev.next = temp.next;
	}

	/* Given a reference (pointer to pointer) to the head of a list
    and a position, deletes the node at the given position */
	void deleteNode_pos(int position)
	{
		// If linked list is empty
		if (head == null)
			return;

		// Store head node
		Node temp = head;

		// If head needs to be removed
		if (position == 0)
		{
			head = temp.next;   // Change head
			return;
		}

		// Find previous node of the node to be deleted
		for (int i=0; temp!=null && i<position-1; i++)
			temp = temp.next;

		// If position is more than number of ndoes
		if (temp == null || temp.next == null)
			return;

		// Node temp->next is the node to be deleted
		// Store pointer to the next of node to be deleted
		Node next = temp.next.next;

		temp.next = next;  // Unlink the deleted node from list
	}

	/* Inserts a new Node at front of the list. */
	public void push(int new_data)
	{
		/* 1 & 2: Allocate the Node &
	                  Put in the data*/
		Node new_node = new Node(new_data);

		/* 3. Make next of new Node as head */
		new_node.next = head;

		/* 4. Move the head to point to new Node */
		head = new_node;
		
		// if end is null, than list was empty, so end and head will
		// point to the only node.
		if(end == null) {
			end = new_node;
		}
		
		counter++;
	}

	/* Inserts a new node after the given prev_node. */
	public void insertAfter(Node prev_node, int new_data)
	{
		/* 1. Check if the given Node is null */
		if (prev_node == null)
		{
			System.out.println("The given previous node cannot be null");
			return;
		}
		// if we want to insert after the last node
		// we simply use append function.
		if(prev_node == end) {
			this.append(new_data);
			return;
		}
		
		/* 2 & 3: Allocate the Node &
	                  Put in the data*/
		Node new_node = new Node(new_data);

		/* 4. Make next of new Node as next of prev_node */
		new_node.next = prev_node.next;

		/* 5. make next of prev_node as new_node */
		prev_node.next = new_node;
		counter++;
	}

	/* Appends a new node at the end. */
	public void append(int new_data)
	{
		
		/* If the Linked List is empty, then
		 *  use push function
		 */
		if (head == null)
		{
			this.push(new_data);
			return;
		}
		
		/* 1. Allocate the Node & Put in the data
           Set next as null */
		Node new_node = new Node(new_data);
		
		end.next = new_node;
		
		end = new_node;

		counter++;
		return;
	}

	/* This function prints contents of linked list starting from
	        the given node */
	public void printList()
	{
		Node tnode = head;
		while (tnode != null)
		{
			System.out.print(tnode.data+" ");
			tnode = tnode.next;
		}
	}

	/* Driver program to test above functions. Ideally this function
	       should be in a separate user class.  It is kept here to keep
	       code compact */
	public static void main(String[] args)
	{
		/* Start with the empty list */
		SinglyLinkedList1 llist = new SinglyLinkedList1();

		// Insert 6.  So linked list becomes 6->NUllist
		llist.append(6);

		// Insert 7 at the beginning. So linked list becomes
		// 7->6->NUllist
		llist.push(7);

		// Insert 1 at the beginning. So linked list becomes
		// 1->7->6->NUllist
		llist.push(1);

		// Insert 4 at the end. So linked list becomes
		// 1->7->6->4->NUllist
		llist.append(4);

		// Insert 8, after 7. So linked list becomes
		// 1->7->8->6->4->NUllist
		llist.insertAfter(llist.head.next, 8);

		System.out.println("\nCreated Linked list is: ");
		llist.printList();
		
	}

}
