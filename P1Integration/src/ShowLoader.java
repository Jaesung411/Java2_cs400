import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

/**
 * Instances of classes that implement this interface can be used to load a
 * list of shows from a specified csv source file.
 * The following csv columns are used to load these show attributes:
 *   - Title: the complete title for a show
 *   - Year: the year that the show was first produced
 *   - Rotten Tomatoes: the review score (out of 100) for this show
 *   - Netflix: 1 = available on this service, other wise 0
 *   - Hulu: 1 = available on this service, other wise 0
 *   - Prime Video: 1 = available on this service, other wise 0
 *   - Disney+: 1 = available on this service, other wise 0
 */

public class ShowLoader implements IShowLoader
{
    //the number of columns of data in the CSV file
    private static final int NUM_COLS = 12;

    //constants for which column various fields are in, zero-indexed
    private static final int TITLE_COL = 2;
    private static final int YEAR_COL = 3;
    private static final int RATING_COL = 6;

    private static final int NETFLIX_COL = 7;
    private static final int HULU_COL = 8;
    private static final int PRIMEVIDEO_COL = 9;
    private static final int DISNEYPLUS_COL = 10;


    /**
     * This method loads the list of songs described within a CSV file.
     * @param filepath is relative to executable's working directory
     * @return a list of show objects that were read from specified file
     */
    public List<IShow> loadShows(String filepath) throws FileNotFoundException
    {
	//scanner for csv file
	Scanner scanner = new Scanner(new File(filepath), "UTF-8");

	//skip the header of the csv file
	scanner.nextLine();

	//result ArrayList
	List<IShow> res = new ArrayList<>();
	while(scanner.hasNextLine())
	{
	    String line = scanner.nextLine();

	    Show showToAdd = buildShow(parseCSVRow(line));
	    //	    System.out.println("Adding " + showToAdd);
	    res.add(showToAdd);






	}

	return res;
    }



    /**
     * Helper method to parse a row of a CSV file into a String array, with proper handling for commas and double quotes
     */
    protected String[] parseCSVRow(String row)
    {
        String[] cols = new String[NUM_COLS];


	int curCol = 0; //the current column being evaluated in the row


	String col = ""; //a dummy string, used to build up the parsed contents of the current column since StringBuilders are annoying :)

	boolean inQuotes = false; //whether we are in a pair of quotes or not
	boolean finishedWithCol = false; //a flag set to indicate whether we have finished a column

	for(int rowPos = 0; rowPos < row.length(); rowPos++) //loop through until we reach the end of the row
	{
	     char c = row.charAt(rowPos);



	     //	     System.out.println("pushin "+c);
	     //edge case -- if it's the last character in the row, then the FSM below wont quite work
	     // since im lazy I'll just explicitly handle that case here by adding the contents of the col buffer to the last element in the cols array
	     if(rowPos == row.length()-1)
	     {
		 //	 System.out.println("finished with last col. [c="+c+", col="+col+"]");
		 col += c;
		 cols[curCol] = col;


		 break;
	     }
	     //handle special characters (comma and quotes)

	     switch(c)
	     {
	     case ',':
		 ///if we are not currently in a quote block, then this comma is a "real" comma that indicates that this column is over. Set the flag indicating this column is done
		 if(!inQuotes)
		 {
		     //  System.out.println("not in quotes");
		     finishedWithCol = true;
		 }
		 //otherwise, its an escaped comma that should be added to the column string like any other character
		 else
		 {
		      col += c;
		 }
		 break;
	     case '"':
		 //encountering quotes is tricky. first, we have to see if we are already in quotes. if so, we have to lookahead to handle the special case of an escaped quote inside of an escaped quote

		 //lookahead at all times except when the next character doesnt exist (1
		  if(inQuotes && rowPos <= row.length()-1)
		  {
		      char maybeQuote = row.charAt(rowPos+1);


		      //if we see a quote ahead, add it
		      if(maybeQuote == '"')
		  	 col += c;


		 }
		  //toggle the inQuotes field (if we were in quotes, now we're not, etc.)

		 inQuotes = !inQuotes;


		 break;
	     default:
		 //default case is to just add the current character to the list we're building for the current column
	         col += c;
		 break;
	     }

	     //if the flag indicating the column is done is set, then add the col string to the array at the next position, and reset all flags
	     if(finishedWithCol)
	     {

		  cols[curCol++] = col;
		  col = "";
		  finishedWithCol = false;
		  inQuotes = false;

	     }

        }




	return cols;

    }

    /**
     * Helper method that builds a Show object from the provided CSV data in array form
     */
    protected Show buildShow(String[] data)
    {
	String title = data[TITLE_COL];
	int year = 0;
	int rating = 0;
	String providers = "";

	try
	{
	    year = Integer.parseInt(data[YEAR_COL]);
	    rating = Integer.parseInt(data[RATING_COL].split("/")[0]); // split along the / and only take the first part (eg. if the rating is 56/100 we only want the 56)
	}
	catch(NumberFormatException e)
	{
	    e.printStackTrace();
	}

       if(convertDigitToBoolean(data[NETFLIX_COL]))
	   providers += "Netflix, ";
       if(convertDigitToBoolean(data[HULU_COL]))
	   providers += "Hulu, ";
       if(convertDigitToBoolean(data[PRIMEVIDEO_COL]))
	   providers += "Prime Video, ";
       if(convertDigitToBoolean(data[DISNEYPLUS_COL]))
	   providers += "Disney+, ";




       return new Show(title, year, rating, providers.substring(0, providers.length() - 2)); //remove the trailing space and comma

    }
    /**
     * Helper method to convert a "0" or "1" String into a true/false boolean value
     */
    protected boolean convertDigitToBoolean(String digit) throws IllegalArgumentException
    {
	if(digit.equals("1"))
	    return true;
	else if (digit.equals("0"))
	    return false;

	throw new IllegalArgumentException("Illegal argument passed to convertDigitToBoolean: "+digit);
    }
}