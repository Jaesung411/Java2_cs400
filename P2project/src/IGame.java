// --== CS400 Project two File Header ==--
// Name: <Changjae Han>
// CSL Username: <changjae>
// Email: <chan82@wisc.edu>
// Lecture #: <001 @11:00am>
// Notes to Grader: <any optional extra notes to your grader>

/**
 * This class's instances represent a game object that includes related game information. These game objects can be
 * stored, sorted and compared based on the accessors below.
 */
public interface IGame extends Comparable<IGame> {

    // constructor args (int rank, String name, String platform, Double NASales, Double EUSales, Double JPSales)

    int getRank(); // return the game's sales rank
    String getName(); // return the game's name
    String getPlatform(); // return the platform the game was released on
    Double getNASales(); // return the number of sold game units in North America
    Double getEUSales(); // return the number of sold game units in Europe
    Double getJPSales(); // return the number of sold game units in Japan
}