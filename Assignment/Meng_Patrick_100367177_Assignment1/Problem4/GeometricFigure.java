public abstract class GeometricFigure {
	private double height;
	private double width;
	private String figureType;
	
	GeometricFigure(double height, double width, String figureType){
		this.height = height;
		this.width = width;
		this.figureType = figureType;
	}
	
	public double getHeight() {
		return height;
	}

	public double getWidth() {
		return width;
	}

	public String getFigureType() {
		return figureType;
	}

	public abstract double area();
}
