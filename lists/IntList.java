import java.util.*;

public class IntList{

	public int head;
	public IntList tail;

	public IntList (int h, IntList t){
		head = h;
		tail = t;
	}


	/* Returns the number of integers in this IntList
	 * using recursion */
	public int size(){
		/* if that tail is null, then the list only has
		 * one item */
		if (tail == null){
			return 1;
		}

		return 1 + tail.size();
	}

	/* Returns the number of integers in this IntList
	 * using iteration */
	public int iter_size(){
		IntList p = this;
		int size = 0;

		while (p != null){
			p = p.tail;
			size+=1;
		}

		return size;
	}

	/* Returns the value of that index in the array
	 * given an index */

	public int get(int index){

		IntList p = this;
		while (index > 0){
			p = p.tail;
			index-=1;
		}
		return p.head;
	}

	/* Returns the string representation of the list */
	public String toString(){

		String values = "";
		for(int i = 0; i < this.size()-1; i++){
			values += this.get(i) + ", ";
		}

		return "[" + values + this.get(this.size()-1) + "]";
	}

	public static void main(String[] args){

		IntList L = new IntList(1, null);
		L = new IntList(2, L);
		L = new IntList(3, L);

		// List looks like [3, 2, 1]

		System.out.println("L = "+ L);
		System.out.println("First index is " + L.get(0));
		System.out.println("Last index is " + L.get(2));
		System.out.println("Size of list is " + L.size());
		/*System.out.println(L.iter_size());*/
	}
}
