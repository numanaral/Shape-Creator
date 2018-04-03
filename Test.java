import java.util.Scanner;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
//utility named scanner that enables user keyboard input
//utility ArrayList keeps the -Objects in our case- within the list we create
//utility named TimeUnit that enables sleep functions to work

public final class Test{

	public static void main(String[] args) throws InterruptedException {
		ArrayList<Object> objList = new ArrayList<Object>();
		// ArrayList -Object Type- to keep the created objects within a list and use them
		Scanner inp = new Scanner(System.in);
		int counter = 0, fakeCounter = 0;
		// counter => counts how many objects are created
		// fakeCounter => edits the while loop which forces the loop to break, thus 
		// allowing the user to go back to the main menu
		
		System.out.println("Welome to Shape Creator v2!\n");
		TimeUnit.SECONDS.sleep(1);
		
		do
		// do-while loop to keep the menu up all the time unless exited
		{
			System.out.println("\nPlease choose one of the following options:\n" +
							   "-------------------------------------------\n" +
								"1) Create a shape\n" + 
								"2) Set origin for an object\n" +
								"3) Set dimensions for an object\n" +
								"4) Display the current state\n" +
								"5) Move an object\n" +
								"6) Display the distance between two objects\n" +
								"7) Destroy an object\n" +
								"8) List the current state of all objects\n" +
								"0) Exit\n"  );
								// Menu that lets user see the available options
			
			TimeUnit.SECONDS.sleep(1);
			System.out.print("--> ");
			int opt = inp.nextInt();	
			// gets the user input for the menu
			
			
			switch (opt){
			// switch method to keep menu have options
			
				case 1:
					fakeCounter=0;
					System.out.print("\n1) Create a shape\n-----------------\n");
					TimeUnit.SECONDS.sleep(1);
					// in order to be able to reach this option again, the fake counter has to be 0
					// it's changed only when the user wants to exit the following nested-switch
					while (counter + fakeCounter < 10){
					// This option wont be reachable after 10 objects are created
						
						System.out.print("Type 1 for Rectangle, 2 for Circle, 3 for Menu\n");
						System.out.print("\n--> ");
						int caseNum = inp.nextInt();
						// user input for the option to create a rectangle or circle
						TimeUnit.SECONDS.sleep(1);
						
						if (caseNum == 1 || caseNum==2){
						// If none of the options -rectangle or circle - is chosen, the program will exit this sub-menu
							switch (caseNum){
							// nested-switch for the first case which has two cases to create the objects
									case 1:
									// case 1 creates the rectangle
										counter++;
										objList.add(new Rectangle());
										System.out.print("Total Object Created " + "|" + counter + "|\n\n");
										TimeUnit.SECONDS.sleep(1);
										break;
							
									case 2:
									// case two creates the circle
										counter++;
										objList.add(new Circle());
										System.out.print("Total Object Created " + "|" + counter + "|\n\n");	
										TimeUnit.SECONDS.sleep(1);
										break;
										
										//counter => it is incremented each time an object is created
										// objList => name of our array list, which is using one of its own function "add" to add an object
										// (new Rectangle/Circle) creates our new objects and they are added into the ArrayList with ".add"
										// |counter| shows the objects created which makes it easier for user to follow
							}
						} 
						else {
							fakeCounter =+ 10;
						 }
					}					
				
					if (counter == 10) {
						TimeUnit.SECONDS.sleep(1);
						System.out.println("\nYou cannot create more than 10 objects\n");
						TimeUnit.SECONDS.sleep(1);
						System.out.println("Back to main menu\n");						
						TimeUnit.SECONDS.sleep(1);
						// this if statement is added so that the program doesn't print out this message every time it exits the sub-menu
					}				
					break;
					
				case 2:
					TimeUnit.SECONDS.sleep(1);
					System.out.println("2) Set origin for an object");
					TimeUnit.SECONDS.sleep(1);
					System.out.println("Which object number do you want to edit?");
					System.out.print("\n--> ");
					int opt2 = inp.nextInt() ;
					// lets the user choose the object from the list
					TimeUnit.SECONDS.sleep(1);
					System.out.println("\nPlease enter your x and y values");
					((Shape) objList.get(opt2-1)).setOrigin(inp.nextInt(),inp.nextInt());
					// in order to be able to use the Shape's method, we are adding cast (Shape) 
					System.out.printf("Object #%s\n%s", opt2-1,((Shape) objList.get(opt2-1)));
										
					break;
				case 3:
					TimeUnit.SECONDS.sleep(1);
					System.out.println("3) Set dimensions for an object");
					TimeUnit.SECONDS.sleep(1);
					System.out.println("Which object do you want to modify?\n");
					System.out.print("\n--> \n");
					int opt3 = inp.nextInt() ;
					// lets the user choose the object from the list
					if (objList.get(opt3-1) instanceof Rectangle){
					System.out.println("\nEnter the dimensions for the rectangle object\n");
					((Rectangle) objList.get(opt3-1)).setSizeLW(inp.nextInt(),inp.nextInt());
					TimeUnit.SECONDS.sleep(1);
					System.out.printf("\nObject #%s\n%s", opt3,((Shape) objList.get(opt3-1)));
					}else if (objList.get(opt3-1) instanceof Circle){
					System.out.println("\nEnter the radius for the circle object\n");
					((Circle) objList.get(opt3-1)).setRad(inp.nextInt());
					TimeUnit.SECONDS.sleep(1);
					System.out.printf("\nObject #%s\n%s", opt3-1,((Shape) objList.get(opt3-1)));
					}
					// this if-elif lets the program decide which class the referred object belongs to and lets user input a value/values
					// in order to be able to use the Rectangle's or Circle's method, we are adding cast (Rectangle), (Circle)
					break;
				case 4:
					TimeUnit.SECONDS.sleep(1);
					System.out.println("4) Display the current state");
					TimeUnit.SECONDS.sleep(1);
					System.out.println("Which object number do you want to see?");
					System.out.print("\n--> \n");
					int opt4 = inp.nextInt() ;
					// lets the user choose the object from the list
					System.out.println(objList.get(opt4-1));
					// prints the current state of the object that is selected from the ArrayList
					break;
				case 5:
					TimeUnit.SECONDS.sleep(1);
					System.out.println("5) Move an object");
					TimeUnit.SECONDS.sleep(1);
					System.out.println("Which object number do you want to move?");
					System.out.print("\n--> \n");
					int opt5 = inp.nextInt() ;
					// lets the user choose the object from the list
					TimeUnit.SECONDS.sleep(1);
					System.out.println("Please enter your deltaX and deltaY values\n");
					((Shape) objList.get(opt5-1)).move(inp.nextInt(),inp.nextInt());
					TimeUnit.SECONDS.sleep(1);
					System.out.printf("\nObject #%s\n%s", opt5-1,((Shape) objList.get(opt5-1)));
					// in order to be able to use the Shape's method, we are adding cast (Shape)
					// lets the user move the object with his inputs
					break;
				case 6:
					TimeUnit.SECONDS.sleep(1);
					System.out.println("6) Display the distance between two objects");
					TimeUnit.SECONDS.sleep(1);
					System.out.println("Which objects do you want to compare?\n");
					System.out.print("\n--> \n");
					int opt6 = inp.nextInt() ;
					int opt6b = inp.nextInt() ;
					// lets the user choose the objects from the list
					System.out.printf("The ditance between Object #%s and Object #%s is ", opt6-1, opt6b-1);
					System.out.print(((Shape) objList.get(opt6-1)).distance((Shape) objList.get(opt6b-1)));
					System.out.println("\n");
					
					// in order to be able to use the superclass' method, we are adding cast the Shape class
					break;
				case 7:
					TimeUnit.SECONDS.sleep(1);
					System.out.println("7) Destroy an object");
					TimeUnit.SECONDS.sleep(1);
					System.out.println("Which objects do you want to destroy?\n");
					System.out.print("\n--> \n");
					int opt7 = inp.nextInt() ;
					// lets the user choose the object from the list
					objList.remove(opt7-1);
					objList.add(opt7-1, null);
					// causes list to increase in number, obj order will get messed up
					// add an if statement referring to null object and it should be fine
					// or just remove the object completely and change the orders
					counter--;
					TimeUnit.SECONDS.sleep(1);
					System.out.printf("\nObject #%s was destroyed and replaced with null \n", opt7);
					// removes the desired object and adds a null object instead
					break;
				case 8:
					TimeUnit.SECONDS.sleep(1);
					System.out.println("8) List the current state of all objects");
					for (Object p : objList) {
					    System.out.println(p);
					    // lists the current state of all the active objects
					}
					break;
				case 0:
					System.out.println("You just exited");
					System.exit(0);
					// exits the program
				
			}
			
		} while (true);	
		// keeps the menu alive until exited
	}
}

