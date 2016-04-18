import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by souloist on 4/17/16.
 */
 
public class LinkedList_noObject {

    public static void main(String[] args){

        Node front = null;
        System.out.println(front);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a movie name: ");
        String movie = sc.nextLine();

        front = addToFront(front, movie);
        System.out.println("added " + front);

        System.out.print("Enter a movie name: ");
        movie = sc.nextLine();

        front = addToFront(front, movie);
        System.out.println("added " + front);

        try {
            front = deleteFront(front);
            System.out.println("List: " + front);

            front = deleteFront(front);
            System.out.println("List: " + front);

            front = deleteFront(front);
            System.out.println("List: " + front);
        } catch (NoSuchElementException e){
            System.out.println("Tried to delete in an empty linked list");
        }
    }

    public static Node addToFront(Node front, Object movie){
        Node temp = new Node(movie, null);
        temp.next = front;
        return temp;
    }

    public static Node deleteFront(Node front){

        // check if front is null to throw exception
        if (front == null){
            throw new NoSuchElementException();
        }
        return front.next;
    }
}

class Node<T> {

    public T data;

    // pointer to the next node of object intNode
    public Node<T> next;

    // constructor accepts int and pointer to next node
    public Node(T data, Node<T> next){
        this.data = data;
        this.next = next;
    }

    // return data in node as a string
    public String toString(){
        return data.toString();
    }
}
