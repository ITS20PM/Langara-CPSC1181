package lab3;

public abstract class GeometricShape implements Comparable<GeometricShape> {
	
	private String color;
	private boolean shapeFilled;
	
	GeometricShape(){
		this.color = "white";
		this.shapeFilled = true;
	}

	public GeometricShape(String color, boolean shapeFilled) {
		this.color = color;
		this.shapeFilled = shapeFilled;
	}

	//setter and getter methods
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isShapeFilled() {
		return shapeFilled;
	}

	public void setShapeFilled(boolean shapeFilled) {
		this.shapeFilled = shapeFilled;
	}

	//two abstract methods
	public abstract double area();
	public abstract double perimeter();

	public static double max(GeometricShape shape1, GeometricShape shape2) {
		double maxArea = shape1.area();
		if(maxArea < shape2.area())
			maxArea = shape2.area();
		return maxArea; 
	}
	
	public static double sumArea(GeometricShape[] shapes) {
		double sum = 0;
		for(GeometricShape item: shapes) {
			sum += item.area();
		}
		return sum;
	}
	
}
