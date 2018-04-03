import java.util.ArrayList;

public abstract class Shape {
							//extends from Object automatically

	private double xCor, yCor; 
	protected double area, circ;
	
	
	private ArrayList<Double> origin = new ArrayList<>();
	// Array list that is created for keeping the x and y coordinates
	// within a list which can be returned when the getOrigin() method is called
		
	public Shape(double corX, double corY){
	// First constructor which sets the x and y coordinates by calling the following method
		setOrigin(corX, corY);
		// Calling for the method which will set the coordinates
	}
	
	public Shape (){
	// Second constructor which initializes the coordinates to 0.0
		this(0.0, 0.0);
		// Calls the first constructor with values of (0.0, 0.0)
	}
	
	public void setOrigin(double corX, double corY){
	// Method which sets the x and y coordinates by the given values
		xCor = corX; 
		yCor = corY;
		
		origin.add(xCor);
		origin.add(yCor);
		// x and y coordinates are added to the ArrayList named origin
	}
	
	public ArrayList<Double> getOrigin(){
	// method which returns the values from the ArrayList
		return origin;
	}
		
	public void move(double deltX, double deltY){
	// method which moves the object origins by the given amounts
		xCor+=deltX;
		yCor+=deltY;		
	}
	
	public double distance(Shape s){
	// method which returns the distance between the passed in parameter and a point
		return Math.sqrt(Math.pow((origin.get(0) - this.xCor), 2) + Math.pow((origin.get(1) - this.yCor), 2));
		// formula to calculate the distance between two points
	}
	
	public double area(){
	// method which returns the area
		return area;
	}
	
	public double circumference(){
	// method which returns the circumference
		return circ;
	}
	
	public String toString(){
	// method which converts objects into printable references
		return String.format("(%s,%s)", xCor, yCor);
			
	}
}

