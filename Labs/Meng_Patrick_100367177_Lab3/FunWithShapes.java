package lab3;

import java.util.*;

public class FunWithShapes {

	public static void main(String[] args) {
		
		GeometricShape[] shapes = new GeometricShape[5];
		shapes[0] = new Circle("blue", true, 4.5); 
		shapes[1] = new Circle("white", true, 3.6);
		shapes[2] = new Octagon("yellow", true, 6);
		shapes[3] = new Octagon("teal", true, 5.2);
		shapes[4] = new Circle("", false, 4);
		
		//test cases for larger area
		System.out.println("The larger area " + shapes[0].area()+ " and "+shapes[1].area()+ ": " + GeometricShape.max(shapes[0], shapes[1]));
		//System.out.println("The larger area " + shapes[0].area()+ " and "+shapes[2].area()+ ": " + GeometricShape.max(shapes[0], shapes[2]));
		//System.out.println("The larger area " + shapes[1].area()+ " and "+shapes[4].area()+ ": " + GeometricShape.max(shapes[1], shapes[4]));
		//System.out.println("The larger area " + shapes[2].area()+ " and "+shapes[3].area()+ ": " + GeometricShape.max(shapes[2], shapes[3]));
		
		//test cases for computing total area
		System.out.println("The total area of all the shapes: " + GeometricShape.sumArea(shapes));
		
		System.out.println(Arrays.toString(shapes));
		//sort the area in ascending order
		Arrays.sort(shapes);
		System.out.println(Arrays.toString(shapes));
	}

}
