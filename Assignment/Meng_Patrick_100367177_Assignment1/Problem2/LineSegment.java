public class LineSegment extends Point{
	
	Point v1;
	Point v2;

	LineSegment(double x, double y, Point v1, Point v2) {
		super(x, y);
		this.v1 = v1;
		this.v2 = v2;
	}
	
	public double length(Point v1, Point v2) {
		
		double lengthX = this.v2.getX() - this.v1.getX();
		double lengthY = this.v2.getY() - this.v1.getY();
		return Math.sqrt(Math.pow(lengthX, 2) + Math.pow(lengthY, 2));
	}

}
