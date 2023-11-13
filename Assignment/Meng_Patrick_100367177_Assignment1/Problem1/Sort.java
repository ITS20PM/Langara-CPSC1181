import java.util.ArrayList;

public class Sort {
	
	public void bubbleSort(ArrayList<Integer> items) {
		
		for(int j = 0; j < items.size()-1; j++) {
			
			for(int i = 0; i < items.size()-1-j ; i++) {
				if(items.get(i)>items.get(i+1)) {
					//swap two adjacent numbers
					int temp = items.get(i);
					items.set(i, items.get(i+1));
					items.set(i+1, temp);
				}
			}
		}
		//print the sorted arraylist
		System.out.println(items);
	}
}
