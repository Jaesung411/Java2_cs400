// --== CS400 Project One File Header ==--
// Name: Jaesung Lim
// CSL Username: jaesung
// Email: jlim83@wisc.edu
// Lecture #: <001 @11:00am>
// Notes to Grader: <any optional extra notes to your grader>
public class ROLETests {
	public static TextUITester tester;
	/**
	 * this method test the starting part
	 * @return true if it contains the specific part
	 */
	public static boolean testStarting() {
		Show show1 = new Show("American Dad!", 2005, 76, "Hulu");
		Show show2 = new Show("Final Fantasy XIV: Dad of Light", 2017, 51, "Neflix");
		Show show3 = new Show("Dad Stop Embarrassing Me!", 2021, 48, "Neflix");
		Show show4 = new Show("Date My Dad", 2017, 42, "Prime Video");
		Show show5 = new Show("Dinner with Dad", 2017, 36, "Hulu");
		Backend back = new Backend();
		Frontend front = new Frontend(back);
		
		back.addShow(show1);
		back.addShow(show2);
		back.addShow(show3);
		back.addShow(show4);
		back.addShow(show5);
		
		tester = new TextUITester("");

		front.displayCommandMenu();

		String output = tester.checkOutput();
		
		if(output.startsWith("Commands Menu:") && 
				output.contains("[F]ilter by Streaming Provider"))
			return true;
		else
			return false;
			  
	}
	
	/**
	 * this method test the title searching part
	 * @return true if it contains the specific part
	 */
	public static boolean testTitleSearch() {

		Show show1 = new Show("American Dad!", 2005, 76, "Hulu");
		Show show2 = new Show("Final Fantasy XIV: Dad of Light", 2017, 51, "Neflix");
		Show show3 = new Show("Dad Stop Embarrassing Me!", 2021, 48, "Neflix");
		Show show4 = new Show("Date My Dad", 2017, 42, "Prime Video");
		Show show5 = new Show("Dinner with Dad", 2017, 36, "Hulu");
		Backend back = new Backend();
		Frontend front = new Frontend("1\ndad\nq\n",back);
		
		back.addShow(show1);
		back.addShow(show2);
		back.addShow(show3);
		back.addShow(show4);
		back.addShow(show5);
		
		TextUITester tester = new TextUITester("1\ndad\nq\n");

		front.runCommandLoop();

		String output = tester.checkOutput();
		
		if((output.contains("1. American Dad!")) && 
				output.contains("42/100 (2017) on: Prime Video"))
			return true;
		else
			return false;
	}
	
	/**
	 * this method test the year searching part
	 * @return true if it contains the specific part
	 */
	public static boolean testYearSearch() {
		Show show1 = new Show("American Dad!", 2005, 76, "Hulu");
		Show show2 = new Show("Final Fantasy XIV: Dad of Light", 2017, 51, "Neflix");
		Show show3 = new Show("Dad Stop Embarrassing Me!", 2021, 48, "Neflix");
		Show show4 = new Show("Date My Dad", 2017, 42, "Prime Video");
		Show show5 = new Show("Dinner with Dad", 2017, 36, "Hulu");
		Backend back = new Backend();
		Frontend front = new Frontend(back);
		
		back.addShow(show1);
		back.addShow(show2);
		back.addShow(show3);
		back.addShow(show4);
		back.addShow(show5);
		
		TextUITester tester = new TextUITester("2\n2017\nq\n");

		front.runCommandLoop();

		String output = tester.checkOutput();
		
		if((output.contains("Final Fantasy XIV: Dad of Light")) && 
				output.contains("36/100 (2017) on: Hulu"))
			return true;
		else
			return false;
	}
	
	/**
	 * this method test the filter part
	 * @return true if it contains the specific part
	 */
	public static boolean testFilter() {
		Show show1 = new Show("American Dad!", 2005, 76, "Hulu");
		Show show2 = new Show("Final Fantasy XIV: Dad of Light", 2017, 51, "Neflix");
		Show show3 = new Show("Dad Stop Embarrassing Me!", 2021, 48, "Neflix");
		Show show4 = new Show("Date My Dad", 2017, 42, "Prime Video");
		Show show5 = new Show("Dinner with Dad", 2017, 36, "Hulu");
		Backend back = new Backend();
		Frontend front = new Frontend(back);
		
		back.addShow(show1);
		back.addShow(show2);
		back.addShow(show3);
		back.addShow(show4);
		back.addShow(show5);
		
		TextUITester tester = new TextUITester("3\n3\nq\nq\n");

		front.runCommandLoop();
		
		String output = tester.checkOutput();
		
		if((output.contains("1) _x_ [N]eflix")) && 
				output.contains("3) ___ [P]rime Video"))
			return true;
		else
			return false;
	}
	
	/**
	 * this method test the starting part
	 * @return true if it contains the specific part
	 */
	public static boolean testFilterSearch() {
		Show show1 = new Show("American Dad!", 2005, 76, "Hulu");
		Show show2 = new Show("Final Fantasy XIV: Dad of Light", 2017, 51, "Neflix");
		Show show3 = new Show("Dad Stop Embarrassing Me!", 2021, 48, "Neflix");
		Show show4 = new Show("Date My Dad", 2017, 42, "Prime Video");
		Show show5 = new Show("Dinner with Dad", 2017, 36, "Hulu");
		Backend back = new Backend();
		Frontend front = new Frontend(back);
		
		back.addShow(show1);
		back.addShow(show2);
		back.addShow(show3);
		back.addShow(show4);
		back.addShow(show5);
		
		TextUITester tester = new TextUITester("3\n2\nq\n1\ndad\nq\n");

		front.runCommandLoop();

		String output = tester.checkOutput();
		
		if((output.contains("51/100 (2017) on: Neflix")) && 
				output.contains("3. Date My Dad"))
			return true;
		else
			return false;
	}

	/**
	 * test all of the tester methods
	 * 
	 * @return true if it works correctly
	 */
	public static boolean runAllTests() {
		// check whether all the tests
		if (testStarting() != true) {
			System.out.println("Failed starting part");
			return false;
		}
		if (testTitleSearch() != true) {
			System.out.println("Failed title search");
			return false;
		}
		if (testYearSearch() != true) {
			System.out.println("Failed year search");
			return false;
		}
		if (testFilter() != true) {
			System.out.println("Failed filter");
			return false;
		}
		if (testFilterSearch() != true) {
			System.out.println("Failed title search after filtering");
			return false;
		}

		return true;
	}
	
	/**
	 * this method call the result of the runAllTests() method
	 */
	public static void main(String[] args) {
//		Show show1 = new Show("American Dad!", 2005, 76, "Hulu");
//		Show show2 = new Show("Final Fantasy XIV: Dad of Light", 2017, 51, "Neflix");
//		Show show3 = new Show("Dad Stop Embarrassing Me!", 2021, 48, "Neflix");
//		Show show4 = new Show("Date My Dad", 2017, 42, "Prime Video");
//		Show show5 = new Show("Dinner with Dad", 2017, 36, "Hulu");
//		Backend back = new Backend();
//		Frontend front = new Frontend(back);
//		
//		back.addShow(show1);
//		back.addShow(show2);
//		back.addShow(show3);
//		back.addShow(show4);
//		back.addShow(show5);
//		
//		front.runCommandLoop();
		
		System.out.print(runAllTests());

	}
}
