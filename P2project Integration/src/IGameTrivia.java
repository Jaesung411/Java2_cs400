import java.util.List;
/**
   Game trivia backend interface
   @author Zach Yosick, George Mavroghenis
 */
public interface IGameTrivia
{
    //constructor -- single argument taking a list of IGame objects (from DW code)



    //--TRIVIA LOGIC METHODS--

    /**
    * Compares the number of sales in all the regions of the randomly generated game.
    * Checks if the input guess matches the most successful region.
    * Call regionRandomGame first!
    * @param guess region (N/A/J) which user thinks the game sold the most in
    * @return true if region matches guess
    */
    public boolean guessMostPopularRegion(String guess);

    /**
     * Checks if user guess matches the higher selling game from the two randomly generated games
     * from comparisonRandomGame.
     * Call comparisonRandomGame first!
     * @param guess user's guess as to which the higher selling game is. 1 corresponds to index 0, 2 index 1
     * @return
     */
    public boolean isHigherRated(int guess);

    //--SCORE MANIPULATION METHODS--

    /**
     * Gets the current score
     * @return score
     */
    public int getScore();

    /**
     * Increases the score by numAdd
     * @param numAdd number to increase score by
     */
    public void addScore(int numAdd);


    /**
     * Brings score back to 0
     */
    public void resetScore();

    //--GAME METHODS--

     /**
     * Adds game to RBT of games
     * @param g game to add
     */
    public void addGame(IGame g);
    /**
     * Adds all the games in the provided list to the RBT
     * @param g list of games to add
     */
    public void addGames(List<IGame> g);

     /**
     * Takes a random game from the data for use in guessMostPopularRegion
     * @return random game
     */
    public IGame regionRandomGame();


    /**
     * Takes two random games from the data for use in isHigherRated.
     * Array is of size 2, index 0 is game 1 and index 2 is game 2.
     * Logic in place to make sure the two games are not the same
     * @return array with 2 different random games
     */
    public IGame[] comparisonRandomGame();

}