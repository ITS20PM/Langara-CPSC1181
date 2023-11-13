package lab3;

public class Circle extends GeometricShape{
	
	private double radius;
	
	public Circle(String color, boolean shapeFilled, double radius) {
		super(color, shapeFilled);
		this.radius = radius;
	}
	
	//setter and getter method
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", area()=" + area() + ", perimeter()=" + perimeter() + "]";
	}

	@Override
	public double area() {
		return Math.PI*Math.pow(this.radius, 2.0);
	}

	@Override
	public double perimeter() {
		return 2*Math.PI*radius;
	}
	
	@Override
	public int compareTo(GeometricShape shape) {
		
		return (int)(this.area() - shape.area());
	}

}
