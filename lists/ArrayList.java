/* Naive implementation of an Arraylist
 * Created by Richard Shen
 */


public class ArrayList {

	int[] array;
	int size;

	/* Creates a new ArrayList */
	public ArrayList(){
		size = 0;
		array = new int[100];
	}

	/* Creates a new array of length size + 1 and copy over the 
	 * previous array values to the new array */
	private void resize(int capacity){
		int[] a = new int[capacity];
		System.arraycopy(array, 0, a, 0, size);
		array = a;
	}

	/* Adds value to the next index. If the addition excedes
	 * the length of the current array (n), create another array of size
	 * n + 1, copy over the values and append the new value to the end */
	public void addBack(int x){
		if (size == array.length){
			resize(size + 1);
		}
		array[size] = x;
		size+=1;
	}

	/* Return the value given the index */
	public int get(int x){
		return array[x];
	}

	/* Return the size of the array */
	public int size(){
		return size;
	}

	public static void main(String[] args){
		ArrayList s = new ArrayList();

		s.addBack(3);
		s.addBack(4);

		System.out.println(s.get(1));
		System.out.println(s.size());
	}
}
