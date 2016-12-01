/* Author: Shannon TJ 10101385 Tutorial 1
   Version: Mar 5, 2015

   Features: Stores information about the biosphere. Initializes each pattern type. Sets starting values for each critter array. Scans the biosphere. Determines the births and deaths of each critter.
   Displays the biosphere. Updates biosphere values for the next simulation round.

   Limitations: The biosphere has a fixed size. Biosphere patterns are preset and cannot be changed. The Biosphere class cannot turn debugging messages on or off. 

 */

public class Biosphere
{

    public static final int ROWS = 10;
    public static final int COLUMNS = 10;
    public static final int MIN_ROW = 0;
    public static final int MAX_ROW = 9;
    public static final int MIN_COLUMN = 0;
    public static final int MAX_COLUMN = 9;
    public static final String HORIZONTAL_LINE = "  - - - - - - - - - -";
    public static final String HORIZONTAL_COUNT = "  0 1 2 3 4 5 6 7 8 9 ";

    private Critter [][] previous = new Critter [10][10];
    private Critter [][] current = new Critter [10][10];

    private int generation = 0;

    private int r;
    private int c;

    private int neighbourBirthCount = 0;
    private int neighbourDeathCount = 0;

    /*getPatternType: Determines what pattern should be initialized
      Parameters: An integer corresponding to a pattern type 
      Returns: N/A
     */
    public void getPatternType (int patternType)
    {
	switch (patternType)
	    {
	    case 1:
		initializePattern1 ();
		break;
	    case 2:
		initializePattern2 ();
		break;
	    case 3:
		initializePattern3 ();
		break;
	    case 4:
		initializePattern4 ();
		break;
	    case 5:
		initializePattern5 ();
		break;
	    case 6:
		initializePattern6 ();
		break;
	    case 7:
		initializePattern7 ();
		break;
	    case 8:
		initializePattern8 ();
		break;
	    }
    }

    /*initializePattern1: All Empty Biosphere. Initializes an empty biosphere
      Parameters: N/A
      Returns: N/A
     */
    private void initializePattern1 ()
    {
	for (r = 0; r < ROWS; r++)
	    {
		for (c = 0; c < COLUMNS; c++)
		    {
			previous [r][c] = new Critter(Critter.EMPTY);
			current [r][c] = new Critter(Critter.EMPTY);
		    }
	    }
    }

    /*initializePattern2: One Critter Biosphere. Initializes a biosphere with one regular critter. The placement of the critter is fixed.
      Parameters: N/A
      Returns: N/A
     */
    private void initializePattern2 ()
    {
	for (r = 0; r < ROWS; r++)
	    {
		for (c = 0; c < COLUMNS; c++)
		    {
			previous [r][c] = new Critter(Critter.EMPTY);
			current [r][c] = new Critter(Critter.EMPTY);
		    }
	    }
	previous[MIN_ROW][MIN_COLUMN] = new Critter(Critter.REGULAR);
    }

    /*initializePattern3: Single Birth Biosphere. Initializes a biosphere with three regular critters, placed so that a single birth will occur. The critters' placement is fixed.
      Parameters: N/A
      Returns: N/A
     */
    private void initializePattern3 ()
    {
        for (r = 0; r < ROWS; r++)
	    {
		for (c = 0; c < COLUMNS; c++)
		    {
			previous[r][c] = new Critter(Critter.EMPTY);
			current[r][c] = new Critter (Critter.EMPTY);
		    }
	    }
        previous[1][3] = new Critter('*');
        previous[2][3] = new Critter('*');
        previous[2][4] = new Critter('*');  
    }

    /*initializePattern4: Simple Pattern in Middle Biosphere. Initializes a biosphere with five regular critters near the middle. The critters' placement is fixed.
      Parameters: N/A
      Returns: N/A
     */
    private void initializePattern4 ()
    {
	{
	    for (r = 0; r < ROWS; r++)
		{
		    for (c = 0; c < COLUMNS; c++)
			{
			    previous[r][c] = new Critter(Critter.EMPTY);
			    current[r][c] = new Critter(Critter.EMPTY);
			}
		}
	    previous[1][1] = new Critter(Critter.REGULAR);
	    previous[2][2] = new Critter(Critter.REGULAR);
	    previous[2][3] = new Critter(Critter.REGULAR);
	    previous[3][1] = new Critter(Critter.REGULAR);
	    previous[3][3] = new Critter(Critter.REGULAR);
	}
    }

    /*initializePattern5: Pattern Near Edges Biosphere. Initializes a biosphere with six regular critters placed near the edges. The critters' placement is fixed. 
      Parameters: N/A
      Returns: N/A
     */
    private void initializePattern5 ()
    {
        for (r = 0; r < ROWS; r++)
	    {
		for (c = 0; c < COLUMNS; c++)
		    {
			previous[r][c] = new Critter(Critter.EMPTY);
			current[r][c] = new Critter(Critter.EMPTY);
		    }
	    }
        previous[MIN_ROW][MIN_COLUMN] = new Critter(Critter.REGULAR);
        previous[MIN_ROW][MAX_COLUMN] = new Critter(Critter.REGULAR);
        previous[MAX_ROW][MIN_COLUMN] = new Critter(Critter.REGULAR);
        previous[MAX_ROW][MAX_COLUMN] = new Critter(Critter.REGULAR);
        previous[0][2] = new Critter(Critter.REGULAR);
        previous[2][1] = new Critter(Critter.REGULAR);
    }

    /*initializePattern6: Fertile Critter Biosphere. Initializes a biosphere with two fertile critters and one regular critter. The critters' placement is fixed. 
      Parameters: N/A
      Returns: N/A
     */
    private void initializePattern6 ()
    {
        for (r = 0; r < ROWS; r++)
	    {
		for (c = 0; c < COLUMNS; c++)
		    {
			previous[r][c] = new Critter(Critter.EMPTY);
			current[r][c] = new Critter(Critter.EMPTY);
		    }
	    }
	previous[2][MIN_COLUMN] = new Critter(Critter.FERTILE);
	previous[1][1] = new Critter(Critter.REGULAR);
	previous[4][1] = new Critter(Critter.FERTILE);
    }

    /*initializePattern7: Complex Pattern 1 Biosphere. Initializes a biosphere with five regular critters. The critters' placement is fixed. 
      Parameters: N/A
      Returns: N/A
     */
    private void initializePattern7 ()
    {
        for (r = 0; r < ROWS; r++)
	    {
		for (c = 0; c < COLUMNS; c++)
		    {
			previous[r][c] = new Critter(Critter.EMPTY);
			current[r][c] = new Critter(Critter.EMPTY);
		    }
	    }
        previous[1][4] = new Critter ('*');
        previous[2][5] = new Critter ('*');
        previous[3][3] = new Critter ('*');
        previous[3][4] = new Critter ('*');
        previous[3][5] = new Critter ('*');
    }

    /*initializePattern8: Complex Pattern 2 Biosphere. Initializes a biosphere with two regular critters and two fertile critters. The critters' placement is fixed. 
      Parameters: N/A
      Returns: N/A
     */
    private void initializePattern8 ()
    {
        for (r = 0; r < ROWS; r++)
	    {
		for (c = 0; c < COLUMNS; c++)
		    {
			previous[r][c] = new Critter(Critter.EMPTY);
			current[r][c] = new Critter(Critter.EMPTY);
		    }
	    }
        previous[2][2] = new Critter (Critter.FERTILE);
        previous[2][3] = new Critter (Critter.REGULAR);
        previous[2][4] = new Critter (Critter.FERTILE);
        previous[4][1] = new Critter (Critter.REGULAR);
    }

    /*scanBiosphere: For each square in the biosphere, scans the surrounding eight squares and determines if those squares contain a regular critter, a fertile critter, or are empty. 
      Calls other methods that determine critter death and birth.
      Parameters: A 2D array of Critter references. 
      Returns: N/A
     */
    private void scanBiosphere (Critter [][] scanCritter)
    {
	for (r = 0; r < ROWS; r++)
	    {
		for (c = 0; c < COLUMNS; c++)
		    {
			//For every square in the biosphere, the surrounding squares are scanned

			//Scans top left square 
			if (r > 0 && c > 0) 
			    {
				scanTopLeft(scanCritter, r, c);
			    }

			//Scans above square
			if (r > 0) 
			    {
				scanAbove(scanCritter, r, c);
			    }

			//Scans top right square
			if (r > 0 && c < 9) 
			    {
				scanTopRight(scanCritter, r, c);
			    }

			//Scans left square
			if (c > 0) 
			    {
				scanLeft(scanCritter, r, c);
			    }

			//Scans right square
			if (c < 9) 
			    {
				scanRight(scanCritter, r, c);
			    }

			//Scans bottom left square
			if (r < 9 && c > 0) 
			    {
				scanBottomLeft(scanCritter, r, c);
			    }

			//Scans bottom square
			if (r < 9) 
			    {
				scanBottom(scanCritter, r, c);
			    }

			//Scans bottom right square
			if (r < 9 && c < 9) 
			    {
				scanBottomRight(scanCritter, r, c);
			    }	
				    
			//Determines deaths for squares with a critter
			if (scanCritter[r][c].getAppearance() == '*' || scanCritter[r][c].getAppearance() == '!')
			    {
				critterDeath(r, c, neighbourDeathCount);
			    }

			//Determines births for empty squares
			if (scanCritter[r][c].getAppearance() == ' ')
			    {
				critterBirth(r, c, neighbourBirthCount);	
			    }

			neighbourBirthCount = 0; 
			neighbourDeathCount = 0;			    				  			 	
		    }
	    }
    }

    /*scanTopLeft: Scans the top left square next to a critter to see if it has a neighbour. Increases birth and death count based on what kind of neighbour it is.
      Parameters: A 2D array of Critter references, row number, column number 
      Returns: N/A
     */
    private void scanTopLeft(Critter [][] scanCritter, int row, int column)
    {			    
	if (scanCritter[row-1][column-1].getAppearance() == '*')
	    {
		neighbourBirthCount++;
		neighbourDeathCount++;			       
	    }
	else if (scanCritter[row-1][column-1].getAppearance() == '!')
	    {
		neighbourBirthCount = neighbourBirthCount + 2;
		neighbourDeathCount++;
	    }				    
    }

    /*scanAbove: Scans the square above a critter to see if it has a neighbour. Increases birth and death count based on what kind of neighbour it is.
      Parameters: A 2D array of Critter references, row number, column number 
      Returns: N/A
     */
    private void scanAbove(Critter [][] scanCritter, int row, int column)
    {
	if (scanCritter[row-1][column].getAppearance() == '*')
	    {
		neighbourBirthCount++;
		neighbourDeathCount++;
	    }
	else if (scanCritter[row-1][column].getAppearance() == '!')
	    {
		neighbourBirthCount = neighbourBirthCount + 2;
		neighbourDeathCount++;
	    }
    }

    /*scanTopRight: Scans the top right square next to a critter to see if it has a neighbour. Increases birth and death count based on what kind of neighbour it is.
      Parameters: A 2D array of Critter references, row number, column number 
      Returns: N/A
     */
    private void scanTopRight(Critter [][] scanCritter, int row, int column)
    {
	if (scanCritter[row-1][column+1].getAppearance() == '*')
	    {
		neighbourBirthCount++;
		neighbourDeathCount++;
	    }
	else if (scanCritter[row-1][column+1].getAppearance() == '!')
	    {
		neighbourBirthCount = neighbourBirthCount + 2;
		neighbourDeathCount++;
	    }
    }

    /*scanLeft: Scans the square on the left side of a critter to see if it has a neighbour. Increases birth and death count based on what kind of neighbour it is.
      Parameters: A 2D array of Critter references, row number, column number 
      Returns: N/A
     */
    private void scanLeft(Critter [][] scanCritter, int row, int column)
    {
				    
	if (scanCritter[row][column-1].getAppearance() == '*')
	    {
		neighbourBirthCount++;
		neighbourDeathCount++;
	    }
	else if (scanCritter[row][column-1].getAppearance() == '!')
	    {
		neighbourBirthCount = neighbourBirthCount + 2;
		neighbourDeathCount++;
	    }
    }

    /*scanRight: Scans the square on the right side of a critter to see if it has a neighbour. Increases birth and death count based on what kind of neighbour it is.
      Parameters: A 2D array of Critter references, row number, column number 
      Returns: N/A
     */
    private void scanRight(Critter [][] scanCritter, int row, int column)
    {
	if (scanCritter[row][column+1].getAppearance() == '*')
	    {
		neighbourBirthCount++;
		neighbourDeathCount++;
	    }
	else if (scanCritter[row][column+1].getAppearance() == '!')
	    {
		neighbourBirthCount = neighbourBirthCount + 2;
		neighbourDeathCount++;
	    }
    }

    /*scanBottomLeft: Scans the bottom left square next to a critter to see if it has a neighbour. Increases birth and death count based on what kind of neighbour it is.
      Parameters: A 2D array of Critter references, row number, column number 
      Returns: N/A
     */
    private void scanBottomLeft(Critter [][] scanCritter, int row, int column)
    {
	if (scanCritter[row+1][column-1].getAppearance() == '*')
	    {
		neighbourBirthCount++;
		neighbourDeathCount++;
	    }
	else if (scanCritter[row+1][column-1].getAppearance() == '!')
	    {
		neighbourBirthCount = neighbourBirthCount + 2;
		neighbourDeathCount++;
	    }
    }

    /*scanBottom: Scans the square below a critter to see if it has a neighbour. Increases birth and death count based on what kind of neighbour it is.
      Parameters: A 2D array of Critter references, row number, column number 
      Returns: N/A
     */
    private void scanBottom(Critter [][] scanCritter, int row, int column)
    {
	if (scanCritter[row+1][column].getAppearance() == '*')
	    {
		neighbourBirthCount++;
		neighbourDeathCount++;
	    }
	else if (scanCritter[row+1][column].getAppearance() == '!')
	    {
		neighbourBirthCount = neighbourBirthCount + 2;
		neighbourDeathCount++;
	    }
    }

    /*scanBottomRight: Scans the bottom right square next to a critter to see if it has a neighbour. Increases birth and death count based on what kind of neighbour it is.
      Parameters: A 2D array of Critter references, row number, column number 
      Returns: N/A
     */
    private void scanBottomRight(Critter [][] scanCritter, int row, int column)
    {
	if (scanCritter[row+1][column+1].getAppearance() == '*')
	    {
		neighbourBirthCount++;
		neighbourDeathCount++;
	    }
	else if (scanCritter[row+1][column+1].getAppearance() == '!')
	    {
		neighbourBirthCount = neighbourBirthCount + 2;
		neighbourDeathCount++;
	    }
    }

    /*critterDeath: Determines whether a critter death will occur. Accounts for death by loneliness and overcrowding. Prints debugging messages if debugging is on.
      Parameters:  row of scanned critter, column of scanned critter, neighbour death count
      Returns: N/A
     */
    private void critterDeath (int deathRow, int deathColumn, int neighbours)
    {
	//Determines whether a critter dies of loneliness or overcrowding
	if (neighbours <= 1 || neighbours >= 4)
	    {
		current[deathRow][deathColumn].setAppearance(' ');	    

		//Prints a debug message for deceased critters
		if (Mode.debug == true)
		    {
			System.out.println("<<Lonely/Overcrowding Death at Row: "+deathRow+" and Column: "+deathColumn+">>");
			System.out.println("<<Number of Neighbours: "+neighbours+">>");
			System.out.println();
		    }
	    }
	    
	//Determines if no deaths occur
	else if (neighbours == 2 || neighbours == 3)
	    {
		current[deathRow][deathColumn].setAppearance('*');

		//Prints a debug message for critters that survive
		if (Mode.debug == true)
		    {
			System.out.println("<<Enough neighbours. No death at Row: "+deathRow+" and Column: "+deathColumn+">>");
			System.out.println("<<Number of Neighbours: "+neighbours+">>");
			System.out.println();
		    }
	    }
    }

    /*critterBirth: Determines whether a critter birth will occur in an empty square. Prints debugging messages if debugging is on.
      Parameters: row of empty square, column of empty square, neighbour birth count
      Returns: N/A
     */
    private void critterBirth (int birthRow, int birthColumn, int neighbours)
    {
	if (neighbours == 3)
	    {
		//Regular critter is born into an empty square
		current[birthRow][birthColumn].setAppearance('*');

		//Prints a debug message for location of critters who gave birth and location of newborn critters
		if (Mode.debug == true)
		    {
			System.out.println("<<New Critter born at Row: "+birthRow+" and Column: "+birthColumn+">>");
			System.out.println("<<Number of Neighbours: "+neighbours+">>");
			System.out.println();
		    }     
	    }
    }

   /* display: Displays the biosphere.
      Parameters: N/A
      Returns: N/A
     */
    private void display ()
    {
        System.out.println("\t\tGeneration: " + generation);
        System.out.println("  PREVIOUS GENERATION" + "\t   CURRENT GENERATION");
        System.out.println(HORIZONTAL_COUNT + " \t " + HORIZONTAL_COUNT);
        for (r = 0; r < ROWS; r++)
        {
	    System.out.println(HORIZONTAL_LINE + " \t " + HORIZONTAL_LINE);
	    System.out.print(r + "|");
	    for (c = 0; c < COLUMNS; c++)
		{
		    previous[r][c].display();
		    System.out.print('|');
		}

	    System.out.print("\t" + r);
	    System.out.print(" |");
	    for (c = 0; c < COLUMNS; c++)
		{
		    current[r][c].display();
		    System.out.print('|');
		}
	    System.out.println();
	}
	System.out.println(HORIZONTAL_LINE + " \t " + HORIZONTAL_LINE);
	generation++;
    }
    

   /* newCurrent: Creates a new 2D array of critter references to use as the current array.
      Parameters: N/A
      Returns: N/A
     */
    private void newCurrent ()
    {
        for (r = 0; r < ROWS; r++)
	    {
		for (c = 0; c < COLUMNS; c++)
		    {
			previous[r][c] = current[r][c];
		    }
	    }
        for (r = 0; r < ROWS; r++)
	    {
		for (c = 0; c < COLUMNS; c++)
		    {
			current[r][c] = new Critter(Critter.EMPTY);
		    }
	    }
    }

   /* runTurn: Calls all of the methods needed to generate another round of the simulation
      Parameters: N/A
      Returns: N/A
     */
    public void runTurn ()
    {
	scanBiosphere(previous);
	display();
	newCurrent();
    }
}
