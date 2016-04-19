public class SinglyLinkedList{
	private IntNode front;
	private int size;

	public SinglyLinkedList(int x){
		front = new IntNode(x, null);
		size++;
	}

	public void insertFront(int x){
		IntNode old = front;
		front = new IntNode(x, old);
		/* Or just
		front = new IntNode(x, front);
		*/
		size++;
	}

	public void insertBack(int x){
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

	/* However we can also create a static size variable
	 * that gets incremented every time a Node is created */

	public int size(){
		return size;
	}
	public int getFront(){
		return front.item;
	}

	public int getBack(){
		IntNode temp = front;
		while (temp.next != null){
			temp = temp.next;
		}

		return temp.item;
	}

	public static void main(String[] args){
		SinglyLinkedList s1 = new SinglyLinkedList(10);
		s1.insertFront(5);
		s1.insertFront(3);
		s1.insertBack(3);

		// 3 -> 5 -> 10 -> 3

		System.out.println(s1.getBack());
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