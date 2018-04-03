
public class Circle extends Shape{
private double radius;
	
	public Circle(double rad, double corX, double corY){
	// First constructor which sets the origin and the radius
		super(corX, corY);
		// to get the information from the upper/superclass
		setRad(rad);
		// calls for the method which will set the radius
	}
	
	public Circle(){
	// second constructor which initializes the origin and the radius to 0.0s
		this(0.0, 0.0, 0.0);
	}
	
	public void setRad(double rad){
	// method which sets the radius of the object
		radius = rad;
	}
	
	public double getRad(){
	// method which returns the radius of the object
		return radius;
	}

	public double area(){
	// method which calculates the are of the object
		return radius * radius * Math.PI;
	}
	
	public double circumference(){
	// method which calculates the circumference of the object
		return Math.PI * 2*radius;
	}
	
	public String toString(){
	// method which converts objects into printable references
		return String.format("Properties of the rectangle with the origin (%s):\n"
				+"Area: %.2f\n"
				+"Circumference: %.2f\n"
				+"Radius: %.2f\n"
				,super.toString(), area(), circumference(), radius);
	}
}
