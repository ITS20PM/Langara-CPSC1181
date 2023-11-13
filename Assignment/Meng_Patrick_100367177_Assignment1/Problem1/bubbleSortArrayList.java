import java.util.*;

public class bubbleSortArrayList {

	public static void main(String[] args) {
		
		ArrayList <Integer> items = new ArrayList<>();
		
		Scanner inp = new Scanner(System.in);
		
		//ask the user for how many elements to be added
		System.out.println("Enter the number of elements to be added");
		int HowManyElements = inp.nextInt();
		
		//complete the for loop for adding the elements to the arraylist
		for(int i = 1; i <= HowManyElements; i++) {
			System.out.println("Enter each number into the arraylist");
			items.add(inp.nextInt());
		}
		
		//print out the original arraylist after user input
		System.out.println(items);
		
		Sort list = new Sort();
		list.bubbleSort(items);
		
		inp.close();
	}
	
}
