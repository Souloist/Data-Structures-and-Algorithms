public class SinglyLinkedList<T>{

	public class Node{

		public T item;
		public Node next;

		public Node(T i, Node n){
			item = i;
			next = n;
		}
	}	

	private Node sentinel;
	private int size;

	/* Constructor for emptry sList */
	public SinglyLinkedList(){
		size = 0;
		/* The value of sentinel does not matter
		 * What matters is that the value is not null
		 * This allows us to avoid nullpointer exceptions */
		sentinel = new Node(null, null);
	}

	/* Constructor for sList of size 1 */
	public SinglyLinkedList(T x){
		size = 1;
		sentinel = new Node(null, null);
		sentinel.next = new Node(x, null);
	}

	/* Inserts new node to front of sList */
	public void insertFront(T x){

		/* Remember oldFrontNode is not the actual front node
		 * It is the node behind the sentinal node */
		Node oldFrontNode = sentinel.next;
		sentinel.next = new Node(x, oldFrontNode);
		size++;
	}

	/* Returns first value of sList */
	public T getFront(){
		return sentinel.next.item;
	}	

	/* Helper method to get the last node */

	private Node getBackNode(){
		Node p = sentinel;

		while (p.next != null){
			p = p.next;
		}

		return p;
	}
	/* Insets new node to back of sList */
	public void insertBack(T x){

		Node oldback = getBackNode();
		oldback.next = new Node(x, null);
		size++;
	}

	/*Returns last value of sList */
	public T getBack(){

		Node oldback = getBackNode();
		return oldback.item;
	}	

	/* Returns size of sList */
	public int size(){
		return size;
	}

	public static void main(String[] args){
		SinglyLinkedList<Integer> s1 = new SinglyLinkedList<Integer>();
		s1.insertBack(3);	
		s1.insertFront(5);

		SinglyLinkedList<String> s2 = new SinglyLinkedList<String>();
		s2.insertFront("HI");

		// 3 -> 5 -> 3

		System.out.println("Last value in s1: " + s1.getBack());
		System.out.println("Size of s1 is: " + s1.size());
		System.out.println("Last value in s2 is: " + s2.getBack());
	}
}