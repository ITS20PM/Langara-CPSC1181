package lab2;

public class JuiceTester {

	public static void main(String[] args) {
		
		Juice juice1 = new Juice("Apple Juice", "SMALL", "apple");
		Juice juice2 = new Juice("mangoMilk", "SMALL", "mango" , "milk", "coconut");
		Juice myJuice = new Juice("Coco Crush", "LARGE", "Banana", "Pineapple","Coconut");
		Juice yourJuice = new Juice("Orangesicle", "MEDIUM", "Orange", "Vanilla");
		Juice otherJuice = new Juice("Pineapple Freeze", "SMALL", "Pineapple", "Banana","Strawberry", "Orange");
		Juice pureOrange = new Juice("The Orangenator", "LARGE", "Orange", "Orange");
		System.out.println(juice1.display());
		System.out.println(juice2.display());
		System.out.println(myJuice.display());
		System.out.println(yourJuice.display());
		System.out.println(otherJuice.display());
		System.out.println(pureOrange.display());
		Juice combine = Juice.merge(juice1, juice2);
		System.out.println(combine.display());
		Juice combinedJuice = Juice.merge(myJuice, otherJuice);
		System.out.println(combinedJuice.display());
		Juice otherCombination= Juice.merge(yourJuice, otherJuice);
		System.out.println(otherCombination.display());
		
		
		
		
	
	}

}
