public class ArrayList {

	int[] array;
	int size;

	public ArrayList(){
		size = 0;
		array = new int[100];
	}

	public void addBack(int x){
		array[size] = x;
		size+=1;
	}

	public int get(int x){
		return array[x];
	}

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