package lab2;

import java.util.ArrayList;

public class Juice {
	private String name;
	private String size;
	ArrayList<String> ingredients = new ArrayList<>();
	
	public Juice(String name, String size, String ... ingredients) {
		this.name = name;
		this.size = size;
		this.ingredients = new ArrayList<>();
		for(String item: ingredients) {
			uniqueIngredient(item);
		}
	}
	
	//getter and setter methods
	public String getName() {
		return this.name;
	}
	
	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	public void uniqueIngredient(String food) {
		if(!ingredients.contains(food))
			ingredients.add(food);
	}
	
	public String display() {
		return "Juice name: " + this.name + '\n'
				+ "Juice size: " + this.size + '\n'
				+ "Contains"+this.ingredients + '\n';
	}
	
	public static Juice merge(Juice j1, Juice j2) {
		String name = j1.getName()+" "+j2.getName();
		String size = j1.getSize();
		ArrayList<String> combo = j1.ingredients;
		combo.addAll(j2.ingredients);
		String container = "";
		for(int i = 0; i<combo.size(); i++) {
			if(!container.contains(combo.get(i))) {
				container+=combo.get(i);
				if(i<combo.size()-1)
					container+=", ";
			}	
		}
		Juice combine = new Juice(name ,size, container);
		return combine;
	}
	
}
