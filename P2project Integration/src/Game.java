//--== CS400 Individual Role Code for Data Wrangler File Header ==--
//Name: <Changjae Han>
//CSL Username: <changjae>
//Email: <chan82@wisc.edu>
//Lecture #: <001 @11:00am>
//Notes to Grader: I am considering making changes to IGame interface
//                 to utilize three compareTo methods.
//                 I also make note about it on DataWranglerTests.java


/**
 * @author changjae
 *
 * Game
 * This class set each game object that has rank, name, platform, sales from 3 region
 * including get() and compareTo() method.
 */
public class Game implements IGame{

    //constructor args (int rank, String name, String platform,
    //Double NASales, Double EUSales, Double JPSales)
    private int rank;
    private String name;
    private String platform;
    private double NASales;
    private double EUSales;
    private double JPSales;

    //constructor
    public Game(int rank, String name, String platform,
	double NASales, double EUSales, double JPSales) {
	this.rank = rank;
	this.name = name;
	this.platform = platform;
	this.NASales = NASales;
	this.EUSales = EUSales;
	this.JPSales = JPSales;
    }

    @Override
    public int getRank() {
   	// return the game's sales rank
	return this.rank;
    }

    @Override
    public String getName() {
    	// return the game's name
    	return this.name;
    }

    @Override
    public String getPlatform() {
    	// return the platform the game was released on
    	return this.platform;
    }

    @Override
    public Double getNASales() {
    	// return the number of sold game units in North America
    	return this.NASales;
    }

    @Override
    public Double getEUSales() {
    	// return the number of sold game units in Europe
    	return this.EUSales;
    }

    @Override
    public Double getJPSales() {
    	// return the number of sold game units in Japan
    	return this.JPSales;
    }

     /**
     * Compares this Game with @param other game based on sales.
     * returns 1 if this Game is more in demand,
     * returns 0 if this Game's sale is equal to other's sale,
     * returns -1 if this Game is less in demand
     *
     * (need to be fixed itself or auto-fixed if interface is altered)
     */
    @Override
    public int compareTo(IGame other)
    {
    	if(this.NASales - other.getNASales() > 0) return 1;
    	else if(this.NASales - other.getNASales() == 0) return 0;
    	else return -1;
    }
    public int compareToEU(IGame other)
    {
    	if(this.EUSales - other.getEUSales() > 0) return 1;
    	else if(this.EUSales - other.getEUSales() == 0) return 0;
    	else return -1;
    }
    public int compareToJP(IGame other)
    {
    	if(this.JPSales - other.getJPSales() > 0) return 1;
    	else if(this.JPSales - other.getJPSales() == 0) return 0;
    	else return -1;
    }

    //@@@@@@@@@@@@@@
    public String toString() {
    	return name;
    }
}