public class Triangles extends GeometricFigure implements SidedObject{

	Triangles(double height, double width, String figureType) {
		super(height, width, figureType);
	}

	@Override
	public double area() {
		return 0.5*getHeight()*getWidth();
	}

	@Override
	public int displaySides() {
		return 3;
	}

}
