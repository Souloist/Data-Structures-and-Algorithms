/* Naive implementation of an Arraylist
 * Created by Richard Shen
 */


public class ArrayList<T> {

    private T[] array;
    private int size;

    /* Resize factor for when to create a new array */
    private static int R_FACTOR = 2;

    /* Creates a new ArrayList */
    public ArrayList(){
        size = 0;
        array = (T[]) new Object[100];
    }

    /* Creates a new array of length size + 1 and copy over the 
     * previous array values to the new array */
    private void resize(int capacity){
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(array, 0, a, 0, size);
        array = a;
    }

    /* Adds value to the next index. If the addition excedes
     * the length of the current array (n), create another array of size
     * n + 1, copy over the values and append the new value to the end */
    public void insertBack(T x){
        if (size == array.length){
            resize(size * R_FACTOR);
        }
        array[size] = x;
        size+=1;
    }

    /* Deletes the value at the end of the array and return it */
    public T deleteBack(){
        T returnValue = array[size - 1];

        array[size - 1] = null;
        size -= 1;
        return returnValue;
    }

    /* Return the value given the index */
    public T get(int x){
        return array[x];
    }

    /* Return the size of the array */
    public int size(){
        return size;
    }

    public static void main(String[] args){
        ArrayList s = new ArrayList();

        for (int i = 0; i < 100000; i++){
            s.insertBack(i);
        }

        System.out.println(s.get(s.size() - 1));
        System.out.println(s.deleteBack());
        System.out.println(s.size());
        System.out.println("Done!");
    }
}
