// --== CS400 Project One File Header ==--
// Name: Kusum Gautam
// CSL Username: kusum
// Email: kgautam3@wisc.edu
// Lecture #: 001
// Notes to Grader: <any optional extra notes to your grader>

import java.util.Scanner;

/**
 * This class contains the frontend code for Game Trivia
 */
public class GameTriviaFrontend implements IGameTriviaFrontend {

  IGameTrivia backEnd; // to use methods in the backend class
  Scanner sc = new Scanner(System.in); // to scan the word
  // String word; // user's command
  boolean keepPlaying;

  /**
   * reads inputs from System.in
   *
   * @param backEnd to access backend methods
   */
  public GameTriviaFrontend(IGameTrivia backEnd) {
    this.backEnd = backEnd;
  }

  /**
   * reads input from String
   *
   * @param word    string to read
   * @param backEnd to access backend methods
   */
  public GameTriviaFrontend(String word, IGameTrivia backEnd) {
    this.backEnd = backEnd;
    //  this.word = word;
    sc = new Scanner(word);
  }


  /**
   * This method drives the entire read, eval, print loop (repl) for the
   * Game Trivia App.  This loop will continue to run until the user
   * explicitly enters the quit command.
   */
  @Override
  public void runCommandLoop() {
    String a = "";
    keepPlaying = true;

    System.out.println("Welcome to the Game Sales Trivia App!");
    System.out.println("=================================");
    System.out.println("This app offers two minigames about Video Game Sales:\n" +
        "\n" +
        "Region - which region sold more of the specified game?\n" +
        "Comparison - which of these two games sold more?\n" +
        "\n" +
        "=================================\n");

    // this loop will continuously run until user explicitly enters the quit command
    while (keepPlaying && (!a.equals("q") || !a.equals("Q") || !a.equals("3"))) {
      displayCommandMenu();
      a = sc.nextLine();
      handleCommand(a);
    }

    System.out.println("Thanks for playing. Your final score is " + backEnd.getScore());
  }

  // to help make it easier to test the functionality of this program,
  // the following helper methods will help support runCommandLoop():

  /**
   * displays the command menu
   */
  @Override
  public void displayCommandMenu() {
    System.out.println("Command Menu:");
    System.out.println("\t 1) Play by [R]egion");
    System.out.println("\t 2) Play by [C]omparison");
    System.out.println("\t 3) [Q]uit");
    System.out.println("Choose a command from the menu above:");
  }

//TODO make 1,2,3 choices

  /**
   * Prompts user to play the Region game
   */
  @Override
  public void playByRegion() {

    IGame game1 = backEnd.regionRandomGame();
    int round = 0;

    System.out.println("The game is: " + game1.getName() + "(" + game1.getPlatform() + ")");
    System.out.println("Which region do you think sold more " + game1.getName() + "?");
    displayRegionChoices();

    String userGuess = sc.nextLine();

    if (backEnd.guessMostPopularRegion(userGuess)) {
      System.out.println("CORRECT!");
      backEnd.addScore(1); // increment score by 1
      round++;
      System.out.println("Play [A]gain question or [Q]uit game?");  // user can choose to play again or quit
      String command = sc.nextLine();
      handleRegion(command);
    } else {
      System.out.println("WRONG!");
      round++;
      System.out.println("Play [A]gain question or [Q]uit game?");
      String command = sc.nextLine();
      handleRegion(command);
    }
  }

  /**
   * Prompts user to play the Comparison game
   */
  @Override
  public void playByComparison() {

	  //@@@@@@@@@@@@@@@@@@
	  //We get some errors this part, so fix if
    IGame game1 = backEnd.comparisonRandomGame()[0];
    IGame game2 = backEnd.comparisonRandomGame()[1];

    System.out.println(game1.getName() + " " + game1.getPlatform() + " " + " vs. " + game2.getName() + " " + game2.getPlatform());
    System.out.println("Which game do you think sold more?");
    System.out.println("\t1) " + game1.getName() + " " + game1.getPlatform());
    System.out.println("\t2) " + game2.getName() + " " + game2.getPlatform());


    while (!(sc.hasNextInt())) {
      System.out.println("Invalid input! Please enter 1 or 2");
      sc.next();

    }

    int userGuess = sc.nextInt();
    sc.nextLine();


    if (backEnd.isHigherRated(userGuess)) {
      System.out.println("CORRECT!");
      backEnd.addScore(1); // increment score by 1
      System.out.println("Play [A]gain question or [Q]uit game?");  // user can choose to play again or quit
      String command = sc.nextLine();
      handleComparison(command);
    } else {
      System.out.println("WRONG!");
      System.out.println("Play [A]gain question or [Q]uit game?");
      String command = sc.nextLine();
      handleComparison(command);
    }
  }

  /**
   * this method executes other methods corresponding to the command
   *
   * @param command
   */
  public void handleCommand(String command) {
    switch (command) {
      case "1":
      case "R":
      case "r":
        playByRegion();
        break;
      case "2":
      case "C":
      case "c":
        playByComparison();
        break;
      case "3":
      case "Q":
      case "q":
        keepPlaying = false;
        break;
      default:
        System.out.println("Invalid Command!");
        break;
    }
  }

  /**
   * this method handles commands for the Region game
   *
   * @param command user's command
   */
  public void handleRegion(String command) {
    switch (command) {
      case "A":
      case "a":
        playByRegion();
        break;
      case "Q":
      case "q":
        System.out.println("Try harder next time! Your score is " + backEnd.getScore());
        break;
      default:
        System.out.println("Invalid Command!");
        break;
    }
  }

  /**
   * this method handles commands for the Comparison game
   *
   * @param command
   */
  public void handleComparison(String command) {
    switch (command) {
      case "A":
      case "a":
        playByComparison();
        break;
      case "Q":
      case "q":
        System.out.println("Try harder next time! Your score is " + backEnd.getScore());
        break;
      default:
        System.out.println("Invalid Command!");
        break;
    }
  }

  /**
   * this method displays Region choices
   */
  public void displayRegionChoices() {
    System.out.println("\t 1) [N]orth America");
    System.out.println("\t 2) [E]urope");
    System.out.println("\t 3) [J]apan");
  }

}