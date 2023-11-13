package lab3;

public class Octagon extends GeometricShape{
	
	private double sideLength;
	
	Octagon(String color, boolean shapeFilled, double sideLength){
		super(color, shapeFilled);
		this.sideLength = sideLength;
	}
	
	//setter and getter methods
	public double getSideLength() {
		return sideLength;
	}

	public void setSideLength(double sideLength) {
		this.sideLength = sideLength;
	}
	
	@Override
	public String toString() {
		return "Octagon [sideLength=" + sideLength + ", area()=" + area() + ", perimeter()=" + perimeter() + "]";
	}

	@Override
	public double area() {
		return 2.0*(1+Math.sqrt(2.0))*Math.pow(sideLength, 2.0);
	}

	@Override
	public double perimeter() {
		return 8*sideLength;
	}
	
	@Override
	public int compareTo(GeometricShape shape) {
		
		return (int)(this.area() - shape.area());
	}
	
}
