public class SinglyLinkedList{
	private IntNode sentinel;
	private int size;

	/* Constructor for emptry sList */
	public SinglyLinkedList(){
		size = 0;
		/* The value of sentinel does not matter
		 * What matters is that the value is not null
		 * This allows us to avoid nullpointer exceptions */
		sentinel = new IntNode(232, null);
	}

	/* Constructor for sList of size 1 */
	public SinglyLinkedList(int x){
		size = 1;
		sentinel = new IntNode(232, null);
		sentinel.next = new IntNode(x, null);
	}

	/* Inserts new node to front of sList */
	public void insertFront(int x){

		/* Remember oldFrontNode is not the actual front node
		 * It is the node behind the sentinal node */
		IntNode oldFrontNode = sentinel.next;
		sentinel.next = new IntNode(x, oldFrontNode);
		size++;
	}

	/* Returns first value of sList */
	public int getFront(){
		return sentinel.next.item;
	}	

	/* Helper method to get the last node */

	private IntNode getBackNode(){
		IntNode p = sentinel;

		while (p.next != null){
			p = p.next;
		}

		return p;
	}
	/* Insets new node to back of sList */
	public void insertBack(int x){

		IntNode oldback = getBackNode();
		oldback.next = new IntNode(x, null);
		size++;
	}

	/*Returns last value of sList */
	public int getBack(){

		IntNode oldback = getBackNode();
		return oldback.item;
	}	

	/* Returns size of sList */
	public int size(){
		return size;
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