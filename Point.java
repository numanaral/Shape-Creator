/*
Assignment : Assignment #3
Name : Ahmet Numan Aral
TA Session : T03
Version : 1.0
*/
import java.util.concurrent.atomic.AtomicInteger;
// Utility that enables atomic Integer
// It is used in as atomically incremented counters, and cannot be used as a replacement for an Integer
// Which -in our case- is our unique ID for each point

public class Point {	
	private double xCor;
	private double yCor;
	private static int activeIns=0;
	// our private values which can only be used by this class
    private int pointIDs;

	static AtomicInteger nextId = new AtomicInteger();
	//This will guarantee that two object will not share the same number (ID)
	
	public Point(double corX, double corY){
	// First constructor which allows you to specify the x and y coordinates
		activeIns++;
		// Increments active instances each time a point is created
		pointIDs = nextId.incrementAndGet();
		// Gives a unique ID to each created object
		setXY(corX, corY);
		// calls for the set methods to set the given x and y coordinates
		 
				
	}
	public Point(){
	// Second constructor which initializes the coordinates to 0.0
		this(0.0, 0.0);
		// calls for this constructor again with the given values this time
		// so that it can initialize the points to 0.0
		
	}
	
	public void setXY(double corX, double corY){
		this.setX(corX);
		this.setY(corY);
		// calls for set functions with the given points
		
	}
	public void setX(double corX){
		xCor = corX;
		// sets the x coordinate by the given point
				
	}
	
	public void setY(double corY){
		yCor = corY;
		// sets the y coordinate by the given point
		
	}
	
	public double getX(){
		return xCor;
		// method that returns the x coordinate
	}
	
	public double getY(){
		return yCor;
		// method that returns the y coordinate
	}

	public void move(double deltX, double deltY){
		xCor+=deltX;
		yCor+=deltY;
		// method that shifts x and y coordinates by the given amount
		
	}
	
	public double distance(Point pointN){
		return Math.sqrt(Math.pow((pointN.getX() - 0.0), 2) + Math.pow((pointN.getY() - 0.0), 2));
		// method that calculates the distance between the given point and
		// point 4 which has default coordinates of (0.0, 0.0)
		
	}
	
	public static double distance(Point pointK, Point pointJ){
		return pointJ.distance(pointK);
		// class method that calculates the distance between two given coordinates
	}
	
	public int pointID(){
		return pointIDs;
		// method that returns the unique point ID which was assigned whenever a point was created
		
	}
	
	public static int activeInstances(){
		return activeIns;
		// method that returns the value of the active instances
	}
	
	protected void finalize() throws Throwable{
		super.finalize();
		activeIns--;
		// when the references were deleted, they were no longer being used and garbage collected
		// each time that happened, active instances were decremented by 1
		}

	
	public static void fullGC() {
	// method that forces garbage collection
	    Runtime rt = Runtime.getRuntime();
	    long isFree = rt.freeMemory();
	    long wasFree;
	    do {
	        wasFree = isFree;
	        rt.runFinalization();
	        rt.gc();
	        isFree = rt.freeMemory();
	    } while (isFree > wasFree);
	    
	}
}