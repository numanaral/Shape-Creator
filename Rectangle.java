
public class Rectangle extends Shape{
	private double length, width;
		
	public Rectangle(double leng, double wid, double corX, double corY){
	// First constructor which calls for the method to set the dimensions
		super(corX, corY);
		// to get the information from the upper/superclass
		setSizeLW(leng, wid);
		// calls for the method which will set dimensions
	}
	
	public Rectangle(){
	// Second constructor which initializes the dimensions and origin to 0.0
		this(0.0, 0.0, 0.0, 0.0);
		// Calls the first constructor with 0.0s
	}
	
	public void setSizeLW(double leng, double wid){
	// method which calls for two other methods to set the length and width
		this.setSizeL(leng);
		this.setSizeW(wid);
		// calling the methods to set the dimensions with the passed in parameters
	}
	
	public void setSizeL(double leng){
	// method which sets the length
		length = leng;
	}
	
	public void setSizeW(double wid){
	// method which sets the width
		width = wid;
	}
	
	public double getSizeL(){
	// method which returns the length of the object
		return length;
	}
	
	public double getSizeW(){
	// method which returns the length of the object
		return width;
	}

	public double area(){
	// method which calculates the area of the object
		return width * length;
	}
	
	public double circumference(){
	// method which calculates the circumference of the object
		return (2*width) + (2*length);
	}
	
	public String toString(){
	// // method which converts objects into printable references
		return String.format("Properties of the rectangle with the origin (%s):\n"
							+"Area: %.2f\n"
							+"Circumference: %.2f\n"
							+"Length: %.2f\n"
							+"Width: %.2f\n"
							,super.toString(), area(), circumference(), length, width);
	}
	
	
}
