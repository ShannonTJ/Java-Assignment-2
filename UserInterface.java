/* Author: Shannon TJ 10101385 Tutorial 1
   Version: Mar 4, 2015

   Features: Instantiates and calls methods of class Biosphere. Displays starting menu. First prompt error checks for integers outside of 1 - 8. After the biosphere has been displayed, this file 
   gets input from the user at the end of each turn. Second prompt error checks for integer and non-integer values. This file can toggle debugging mode on and off and it can exit the program for 
   specific input. 

   Limitations: First prompt does not error check for non-integer values. The program repeats forever until the user manually exits the game. There is no prompt to turn debugging mode on or off. 
   Debugging mode can only be turned on after one round of the simulation has already run.

 */

import java.util.Scanner;

public class UserInterface
{
    private Scanner in;
    private int userSelect;
    private boolean playGame = true;

    public UserInterface ()
    {
	in = new Scanner(System.in);

	//Instantiates a new biosphere
	Biosphere biosphere1 = new Biosphere();
	
	//Sends the biosphere pattern type to the Biosphere class
	biosphere1.getPatternType(showMenu());

	//Repeats the program until the user manually quits
	do
	    {
		biosphere1.runTurn();
		repeatProgram();
	    }
	while(playGame == true);
    }

    /*showMenu: Displays the starting menu with all possible biosphere patterns. Allows the user to make a selection. Error checks for integer values only.
      Parameters: N/A
      Returns: An integer corresponding to a biosphere pattern type
     */
    public int showMenu ()
    {
	//Displays the starting menu
	System.out.println("Choose a starting biosphere: ");
	System.out.println();

	System.out.printf("%21s","1: All empty");
	System.out.println();
	System.out.printf("%23s","2: One critter");
	System.out.println();
	System.out.printf("%24s","3: Single birth");
	System.out.println();
	System.out.printf("%36s","4: Simple pattern in middle");
	System.out.println();
	System.out.printf("%33s","5: Pattern near the edge");
	System.out.println();
	System.out.printf("%27s","6: Fertile critter");
	System.out.println();
	System.out.printf("%50s","7: Complex Pattern 1: No fertile critters");
	System.out.println();
	System.out.printf("%46s","8: Complex Pattern 2: Fertile critter");

	System.out.println();
	System.out.println();

	//Gets user input
	System.out.print("Enter your selection: ");
	userSelect = in.nextInt ();
	in.nextLine();
	System.out.println();

	//Displays an error message when the user makes an invalid selection
	while (userSelect < 1 || userSelect > 8)
	    {
		System.out.print("Error. Enter a number between 1 and 8: ");
		userSelect = in.nextInt();
		in.nextLine();
	    }
	return(userSelect);
    }

    /*repeatProgram: Allows the user to run another round of the simulation, toggle debugging mode, or quit the game via specific input.
      Parameters: N/A
      Returns: N/A
     */
    public void repeatProgram()
    {
	System.out.println();
	System.out.print("Hit enter to run another generation: ");
	String input = in.nextLine();

	//Repeats the program when the user presses "enter"
	if (input.equals(""))
		{
		}

	//Performs other tasks based on specific user input
	else
	    {
		char c = input.charAt(0);
	  
		switch(c)
		    {
			//Toggles debugging mode
		    case 'd':
		    case 'D':
			//Turns debugging mode on
	        	if (Mode.debug == false)
			    {
				Mode.debug = true;
				System.out.println();
				System.out.println("<<Debugging is on!>>");
			    }
			//Turns debugging mode off
			else
			    {
				Mode.debug = false;
				System.out.println();
				System.out.println("<<Debugging is off!>>");
			    }
			break;

			//Turns the game off
		    case 'q':
		    case 'Q':
			playGame = false;
			break;

			//Error checks for unexpected input
		    default: 
			System.out.println("Error: Hit enter to continue or 'q' to quit.");
			System.out.println();
			repeatProgram();

		    }
	    }
	System.out.println();	
    }
	
}	
    
