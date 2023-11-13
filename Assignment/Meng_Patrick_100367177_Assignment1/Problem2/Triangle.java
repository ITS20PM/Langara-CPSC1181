public class Triangle {

	public static void main(String[] args) {
		
		Point v1 = new Point(0, 0);
		Point v2 = new Point(3, 0);
		Point v3 = new Point(0, 4);
		
		//compute the length of each side of the traiangle
		double a = new LineSegment(v1.getX(), v1.getY(), v1, v2).length(v1, v2);
		double b = new LineSegment(v1.getX(), v1.getY(), v1, v3).length(v1, v3);
		double c = new LineSegment(v2.getX(), v3.getY(), v2, v3).length(v2, v3);
		
		//compute the s (half perimeter) of the triangle
		double s = 0.5*(a+b+c);
		
		//compute the area of the triangle using heron formula
		double area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
		System.out.println(area);
		
	}

}
