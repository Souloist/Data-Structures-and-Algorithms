public class SinglyLinkedList{
	private IntNode front;
	private int size;

	/* Constructor for emptry sList */
	public SinglyLinkedList(){
		front = null;
		size = 0;
	}

	/* Constructor for sList of size 1 */
	public SinglyLinkedList(int x){
		front = new IntNode(x, null);
		size = 1;
	}

	/* Inserts new node to front of sList */
	public void insertFront(int x){
		IntNode old = front;
		front = new IntNode(x, old);
		/* Or just
		front = new IntNode(x, front);
		*/
		size++;
	}

	/* Insets new node to back of sList */
	public void insertBack(int x){
		
		/* Prevent nullpointerexception if list is empty */
		if (front == null){
			insertFront(x);
			return;
		}

		IntNode temp = front;
		while (temp.next != null){
			temp = temp.next;
		}

		temp.next = new IntNode(x, null);
		size++;
	}

	/* When working with recursive data structures,
	 * we should create a private helper method 
	 * to deal with them */

/*	private static int intNodeSize(IntNode n){
		if (n.next == null){
			return 1;
		}

		return 1 + intNodeSize(n.next);
	}*/

/*	public int size(){
		return intNodeSize(front);
	}*/

	/* However we can also create a size instance variable
	 * that gets incremented every time a Node is created */

	/* Returns size of sList */
	public int size(){
		return size;
	}

	/* Returns first value of sList */
	public int getFront(){
		return front.item;
	}

	/*Returns last value of sList */
	public int getBack(){

		IntNode temp = front;
		while (temp.next != null){
			temp = temp.next;
		}

		return temp.item;
	}

	public static void main(String[] args){
		SinglyLinkedList s1 = new SinglyLinkedList();
		s1.insertBack(3);	
		s1.insertFront(5);
		s1.insertFront(3);


		// 3 -> 5 -> 3

		System.out.println("Last value in sList: " + s1.getBack());
		System.out.println("Size of sList is: " + s1.size());
	}
}

class IntNode{

	public int item;
	public IntNode next;

	public IntNode(int i, IntNode n){
		item = i;
		next = n;
	}
}