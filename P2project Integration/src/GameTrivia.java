import java.util.List;
import java.util.Random;

public class GameTrivia implements IGameTrivia
{
    private int score;

    private RedBlackTreeSets games;


    private IGame game1, game2; //randomly generated Game variables updated by calling regionRandomGame() or comparisonRandomGame()

    private Random rand; // random number generator for use in game

    public GameTrivia(List<IGame> gamesList)
    {
	this.score = 0;
	rand = new Random();


	game1 = null;
	game2 = null;

	games = new RedBlackTreeSets();

	for(IGame game : gamesList)
	    games.insert(game);
    }


    /**
    * Compares the number of sales in all the regions of the randomly generated game.
    * Checks if the input guess matches the most successful region.
    * Call regionRandomGame first!
    * @param guess region (N/A/J) which user thinks the game sold the most in
    * @return true if region matches guess
    */
    @Override
    public boolean guessMostPopularRegion(String guess)
    {
	double highestSale = Math.max(Math.max(game1.getNASales(), game1.getEUSales()), game1.getJPSales());
	if(highestSale == game1.getNASales() && guess.toLowerCase().equals("n"))
	    return true;
	if(highestSale == game1.getEUSales() && guess.toLowerCase().equals("e"))
	    return true;
	if(highestSale == game1.getJPSales() && guess.toLowerCase().equals("j"))
	    return true;

	return false;
    }

    /**
     * Checks if user guess matches the higher selling game from the two randomly generated games
     * from comparisonRandomGame.
     * Call comparisonRandomGame first!
     * @param guess user's guess as to which the higher selling game is. 1 corresponds to index 0, 2 index 1
     * @return
     */
    @Override
    public boolean isHigherRated(int guess)
    {
	if(guess == 1 && game1.getRank() > game2.getRank())
	    return true;
	if(guess == 2 && game2.getRank() > game1.getRank())
	    return true;

	return false;
    }

    /*
      Utility methods for TESTING only
     */

    protected void setGame1(IGame game1)
    {
	this.game1 = game1;
    }

    protected void setGame2(IGame game2)
    {
	this.game2 = game2;
    }

    protected IGame getGameByRating(int rating)
    {
	return games.get(rating);
    }

    /**
     * Gets the current score
     * @return score
     */
    @Override
    public int getScore()
    {
	return score;
    }

    /**
     * Increases the score by numAdd
     * @param numAdd number to increase score by
     */
    @Override
    public void addScore(int numAdd)
    {
	score += numAdd;
    }

    /**
     * Resets the score to 0
     */
    @Override
    public void resetScore()
    {
	score = 0;
    }

    /**
     * Adds game to RBT of games
     * @param g game to add
     */
    @Override
    public void addGame(IGame g)
    {
	games.insert(g);
    }

    /**
     * Adds all the games in the provided list to the RBT
     * @param g list of games to add
     */
    @Override
    public void addGames(List<IGame> games)
    {
	for(IGame g : games)
	    addGame(g);
    }



    /**
     * Takes a random game from the data for use in guessMostPopularRegion
     * @return random game
     */
    public IGame regionRandomGame()
    {
	int num = rand.nextInt(games.size());
	game1 =  games.getRandom();
	return game1;
    }



    /**
     * Takes two random games from the data for use in isHigherRated.
     * Array is of size 2, index 0 is game 1 and index 2 is game 2.
     * Logic in place to make sure the two games are not the same
     * @return array with 2 different random games
     */
    public IGame[] comparisonRandomGame()
    {

	game1 = games.getRandom();

	do
	{
	    game2 = games.getRandom();

	} while (game1.equals(game2));  //guarantee unique games

	return new IGame[]{game1, game2};
    }

}