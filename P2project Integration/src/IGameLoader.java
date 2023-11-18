// --== CS400 Project two File Header ==--
// Name: <Changjae Han>
// CSL Username: <changjae>
// Email: <chan82@wisc.edu>
// Lecture #: <001 @11:00am>
// Notes to Grader: <any optional extra notes to your grader>

import java.util.List;
import java.io.FileNotFoundException;

/** <Interface of IGameLoader>
 *
 * This interface, IGameLoader, will be used to load a list of games
 * from a specified XML source file.
 * The following XML columns are used to load these games attributes:
 *   - Rank: the ranking of overall sales
 *   - Name: the name of the game
 *   - Platform: the platform of the games release (i.e. PC,PS4, etc.)
 *   - NA_Sales: Sales in North America (in millions)
 *   - EU_Sales: Sales in Europe (in millions)
 *   - JP_Sales: Sales in Japan (in millions)
 *
 */

public interface IGameLoader {

	/**
     * This method loads the list of games described within a XML file.
     * @param filepath is relative to executable's working directory
     * @return a list of games objects that were read from specified file
     */

	List<IGame> loadShows(String filepath) throws FileNotFoundException;
}