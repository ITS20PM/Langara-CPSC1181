public class FigureTest {

	public static void main(String[] args) {
		GeometricFigure[] shapes= {new Square(3.0, 3.0, "square"), 
								new Triangles(3.8, 6.1, "triangle"),
								new Triangles(6.6, 2.8, "triangle"),
								new Square(4.4, 4.4, "square")};
		
		/*GeometricFigure[] shapes = {new Square(5.0, 5.0, "square"), 
								new Triangles(5.6, 7.1, "triangle"),
								new Triangles(4.2, 6.8, "triangle"),
								new Square(3.1, 3.1, "square")};* * */
		
		/*GeometricFigure[] shapes = {new Square(2.9, 2.9, "square"), 
								new Triangles(9.2, 4.1, "triangle"),
								new Triangles(4.2, 7.8, "triangle"),
								new Square(5.7, 5.7, "square")};* * */
		
		for(int i = 0; i < shapes.length; i++) {
			System.out.print("[Shape: "+shapes[i].getFigureType());
			System.out.print(", Width: "+shapes[i].getWidth());
			System.out.print(", Height: "+shapes[i].getHeight());
			System.out.print(", Area: "+shapes[i].area()+"]\n");
		}
	}

}
