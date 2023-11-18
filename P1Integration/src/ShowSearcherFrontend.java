// --== CS400 Project One File Header ==--
// Name: Jaesung Lim
// CSL Username: jaesung
// Email: jlim83@wisc.edu
// Lecture #: <001 @11:00am>
// Notes to Grader: <any optional extra notes to your grader>
import java.util.List;
import java.util.Scanner;

/**
 * the class Frontend implements IShowSearcherFrontend
 * 
 * @author Jaesung Lim
 *
 */
public class ShowSearcherFrontend implements IShowSearcherFrontend{

	IShowSearcherBackend back; // the back end for using the method in the back end class
	Scanner sc; // scan the word
	String word; //the command the user put in
	
	// constructor args (IShowSearcherBackend) reads input from System.in
	public ShowSearcherFrontend (IShowSearcherBackend back) {
		this.back = back;
	}
    // constructor args (String, IShowSearcherBackend) reads input from String
	public ShowSearcherFrontend (String word, IShowSearcherBackend back) {
		this.back = back;
		this.word = word;
	}

	/**
     * This method drives the entire read, eval, print loop (repl) for the
     * Song Search App.  This loop will continue to run until the user
     * explicitly enters the quit command.
     */
	@Override
	public void runCommandLoop() {
		String a;
		sc = new Scanner(System.in);

		System.out.println("Welcome to the Show Seracher App!");
		System.out.println("==================================");
		
		//This loop will continue to run until the user explicitly enters the quit command.
		do{
			displayCommandMenu();
			System.out.print("Choose a command from the menu above: ");
			a = sc.nextLine();
			handleCommand(a);
		}while(!(a.equals("q") || a.equals("Q") || a.equals("4")));

	}

	/**
	 * this help method execute other method corresponding to the commend
	 * @param command the command uses implements
	 */
	 public void handleCommand(String command) { 
		 switch (command) {
		 	case "1":
		 	case "T":
		 	case "t":
		 		titleSearch();
		    	break;
		 	case "2":
		 	case "Y":
		 	case "y":
		        yearSearch();
		        break;
		 	case "3":
		 	case "F":
		 	case "f":
		 		providerFilter();
			    break;
		 	case "4":
		 	case "Q":
		 	case "q":
		    	break;
		    default:
		    	System.out.println("Invalid Command!");
		    	break;
		 	}
		
	}
	 
	// to help make it easier to test the functionality of this program,
    // the following helper methods will help support runCommandLoop():
	 
	/**
	 * this help method displays the commands' menu
	 */
	@Override
	public void displayCommandMenu() {
		// prints command options to System.out
	    System.out.println("Commands Menu:");
	    System.out.println("\t 1) Serach by [T]itle Word");
	    System.out.println("\t 2) Search by [Y]ear First Produced");
	    System.out.println("\t 3) [F]ilter by Streaming Provider");
	    System.out.println("\t 4) [Q]uit");
		
	}
	 
	/**
	 * this helper method display the list of shows including with their information
	 * 
	 * @param shows the displayed list
	 */
	@Override
	public void displayShows(List<IShow> shows) {
		
		//displays the list of shows
		for( int k = 0; k < shows.size(); k++) {
			
			System.out.println(k+1 + ". " + shows.get(k).getTitle());
			System.out.print("\t" + shows.get(k).getRating() + "/100 " + "(" +shows.get(k).getYear() + ") " + "on: ");
			System.out.println(displayProviders(shows.get(k)));
			
		}
		
	}
	
	/**
	 * this helper method display the provider(s) of the given show
	 * @param show the given show
	 * @return the provider(s) of the given show
	 */
	private String displayProviders (IShow show) {
		
		String ret = "";
		String[] providers = {"Netflix","Hulu","Prime Video","Disney+"};
		
		for( String w :providers) {
			if(show.isAvailableOn(w)) {
				ret += w +" ";
			}
		}
		return ret;
				
	}
	
	/**
	 * the method check the input word and display the list of the show 
	 * containing the word 
	 */
	@Override
	public void titleSearch() {
		System.out.print("Choose a word that you would like to search for: ");
		String r = sc.nextLine();
		System.out.println("Found " + this.back.searchByTitleWord(r).size()+"/"
				+this.back.getNumberOfShows()+"matches");
		displayShows(this.back.searchByTitleWord(r));
		
	}

	/**
	 * the method check the input year and display the list of the show
	 * starting in the year 
	 */
	@Override
	public void yearSearch() {
		System.out.print("Choose a year that you would like to search for: ");
		int year = sc.nextInt();
		sc.nextLine();
		System.out.println("Found " + this.back.searchByYear(year).size()+"/"
				+this.back.getNumberOfShows()+"matches");
		displayShows(this.back.searchByYear(year));
	}

	/**
	 * this method make the filters of provider and can remove the filter
	 */
	public void providerFilter() {
		
		String[] providers = {"Netflix","Hulu","Prime Video","Disney+"};
		
		System.out.println("Providers that show are being searched for:");
		
		for(String a : providers) {
			this.back.setProviderFilter(a, false);
		}
		
		helperPrintFilter(providers);
		
		String filter;
		
		do{
			
			System.out.print("Choose the provider that you'd like to toggle the filter for: ");
			filter = sc.nextLine();
			handleFilter(filter);
			if(!(filter.equals("q") || filter.equals("Q") || filter.equals("5"))) {
				helperPrintFilter(providers);	
			}
		}while(!(filter.equals("q") || filter.equals("Q") || filter.equals("5")));
		
	}
	
	/**
	 * this helper method displays the given list of filters
	 * @param providers the given list of filters
	 */
	private void helperPrintFilter(String[] providers) {
		
		String[] providersName = {"[N]etflix","[H]ulu","[P]rime Video","[D]isney+"};
		String x;
		
		for(int i = 0; i < providersName.length; i++) {
			if(!this.back.getProviderFilter(providers[i])) {
				x = "x";
			}else {
				x = "_";
			}
			System.out.println("\t"+ (i+1) +") _" + x + "_ " + providersName[i]);
		}
		System.out.println("\t5) [Q]uit toggling provider filters");
		
	}
	
	/**
	 * this help methods toggle the given filter
	 * @param filter the toggling filter
	 */
	 private void handleFilter(String filter) {
		 switch (filter) {
		 	case "1":
		 	case "N":
		 	case "n":
		 		this.back.toggleProviderFilter("Netflix");
		    	break;
		 	case "2":
		 	case "H":
		 	case "h":
		 		this.back.toggleProviderFilter("Hulu");
		        break;
		 	case "3":
		 	case "P":
		 	case "p":
		 		this.back.toggleProviderFilter("Prime Video");
			    break;
		 	case "4":
		 	case "D":
		 	case "d":
		 		this.back.toggleProviderFilter("Disney+");
			    break;
		 	case "5":
		 	case "Q":
		 	case "q":
		    	break;
		    default:
		    	System.out.println("Invalid Command!");
		    	break;
		 	}

	 }


}
