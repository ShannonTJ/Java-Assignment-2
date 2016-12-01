/* Author: Shannon TJ 10101385 Tutorial 1
   Version: Mar 4, 2015

   Features: Stores information about each critter. Can get the appearance, change the appearance, and print the appearance of a critter. The REGULAR, FERTILE, and EMPTY constants can be accessed 
   by any classes in the program.

   Limitations: A critter can only have one of three appearances.
 */

public class Critter
{

    public static final char REGULAR = '*';
    public static final char FERTILE = '!';
    public static final char EMPTY = ' ';

    private char appearance;

    public Critter(char newAppearance)
    {
	setAppearance(newAppearance);
    }

    /*setAppearance: Changes a critter's appearance 
      Parameters: The character that becomes the critter's new appearance
      Returns: N/A
     */
    public void setAppearance(char newAppearance)
    {
	appearance = newAppearance;
    }

    /*getAppearance: Gets the character representing a critter's current appearance
      Parameters: N/A
      Returns: The character representing the critter's current appearance
     */
    public char getAppearance()
    {
	return(appearance);
    }

    /*display: Prints out a critter's current appearance as a single character. Displays the character in the terminal and keeps the cursor on the same line
      Parameters: N/A
      Returns: N/A
     */
    public void display()
    {
	System.out.print(appearance);
    }
}
