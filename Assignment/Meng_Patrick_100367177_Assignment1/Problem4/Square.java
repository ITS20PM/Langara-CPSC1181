public class Square extends GeometricFigure implements SidedObject{

	Square(double height, double width, String figureType) {
		super(height, width, figureType);
	}

	@Override
	public double area() {
		
		return getHeight()*getWidth();
	}

	@Override
	public int displaySides() {
		return 4;
	}

}
