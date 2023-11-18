/**
 * Instances of classes that implement this interface can be used to drive a
 * console-based text user interface for the Game Trivia App.
 */
public interface IGameTriviaFrontend {

  // constructor args (IGameTriviaBackend) reads input from System.in
  // constructor args (String, IGameTriviaBackend) reads input from String

  /**
   * This method drives the entire read, eval, print loop (repl) for the
   * Game Trivia App.  This loop will continue to run until the user
   * explicitly enters the quit command.
   */
  void runCommandLoop();

  // to help make it easier to test the functionality of this program,
  // the following helper methods will help support runCommandLoop():

  public void displayCommandMenu(); // prints command options to System.out

  public void playByRegion(); // prompts user to Region mini game

  public void playByComparison(); // prompts user to Comparison mini game

}