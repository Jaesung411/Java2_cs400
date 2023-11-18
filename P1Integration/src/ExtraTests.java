// --== CS400 Project One File Header ==--
// Name: Jaesung Lim
// CSL Username: jaesung
// Email: jlim83@wisc.edu
// Lecture #: <001 @11:00am>
// Notes to Grader: <any optional extra notes to your grader>
public class ExtraTests {
	public static TextUITester tester;
	/**
	 * this method test the year search because displaying comment "Invalid Command!"
	 * @return true if it works correctly
	 */
	public static boolean test1() {
		Show show1 = new Show("American Dad!", 2005, 76, "Hulu");
		Show show2 = new Show("Final Fantasy XIV: Dad of Light", 2017, 51, "Neflix");
		Show show3 = new Show("Dad Stop Embarrassing Me!", 2021, 48, "Neflix");
		Show show4 = new Show("Date My Dad", 2017, 42, "Prime Video");
		Show show5 = new Show("Dinner with Dad", 2017, 36, "Hulu");
		ShowSeacherBackend back = new ShowSeacherBackend();
		ShowSearcherFrontend front = new ShowSearcherFrontend(back);
		
		back.addShow(show1);
		back.addShow(show2);
		back.addShow(show3);
		back.addShow(show4);
		back.addShow(show5);
		
		TextUITester tester = new TextUITester("2\n2020\nq\n");

		front.runCommandLoop();

		String output = tester.checkOutput();
		
		if(!output.contains("Invalid Command!"))
			return true;
		else
			return false;
	}
	
	/**
	 * this method test if it ignores upper case of alpabet
	 * @return true if it works correctly
	 */
	public static boolean test2() {
		Show show1 = new Show("American Dad!", 2005, 76, "Hulu");
		Show show2 = new Show("Final Fantasy XIV: Dad of Light", 2017, 51, "Neflix");
		Show show3 = new Show("Dad Stop Embarrassing Me!", 2021, 48, "Neflix");
		Show show4 = new Show("Date My Dad", 2017, 42, "Prime Video");
		Show show5 = new Show("Dinner with Dad", 2017, 36, "Hulu");
		ShowSeacherBackend back = new ShowSeacherBackend();
		ShowSearcherFrontend front = new ShowSearcherFrontend(back);
		
		back.addShow(show1);
		back.addShow(show2);
		back.addShow(show3);
		back.addShow(show4);
		back.addShow(show5);
		
		TextUITester tester = new TextUITester("1\ndad\nq\n");

		front.runCommandLoop();

		String output = tester.checkOutput();
		
		if(output.contains("American Dad!"))
			return true;
		else
			return false;
	}
	
	/**
	 * this method test if the providers are two
	 * @return true if it works correctly
	 */
	public static boolean test3() {
		
		Show show1 = new Show("American Dad!", 2005, 76, "HuluPrime Video");
		Show show2 = new Show("Final Fantasy XIV: Dad of Light", 2017, 51, "Neflix");
		Show show3 = new Show("Dad Stop Embarrassing Me!", 2021, 48, "Neflix");
		Show show4 = new Show("Date My Dad", 2017, 42, "Prime Video");
		Show show5 = new Show("Dinner with Dad", 2017, 36, "Hulu");
		
		ShowSeacherBackend back = new ShowSeacherBackend();
		ShowSearcherFrontend front = new ShowSearcherFrontend(back);
		
		back.addShow(show1);
		back.addShow(show2);
		back.addShow(show3);
		back.addShow(show4);
		back.addShow(show5);
		
		TextUITester tester = new TextUITester("1\ndad\nq\n");

		front.runCommandLoop();

		String output = tester.checkOutput();
		
		if(output.contains("Hulu Prime Video"))
			return true;
		else
			return false;
	}
	
	/**
	 * this method test if the command is upper case
	 * @return true if it works correctly
	 */
	public static boolean test4() {
		

		Show show1 = new Show("American Dad!", 2005, 76, "HuluPrime Video");
		Show show2 = new Show("Final Fantasy XIV: Dad of Light", 2017, 51, "Neflix");
		Show show3 = new Show("Dad Stop Embarrassing Me!", 2021, 48, "Neflix");
		Show show4 = new Show("Date My Dad", 2017, 42, "Prime Video");
		Show show5 = new Show("Dinner with Dad", 2017, 36, "Hulu");
		
		ShowSeacherBackend back = new ShowSeacherBackend();
		ShowSearcherFrontend front = new ShowSearcherFrontend(back);
		
		back.addShow(show1);
		back.addShow(show2);
		back.addShow(show3);
		back.addShow(show4);
		back.addShow(show5);
		
		TextUITester tester = new TextUITester("T\ndad\nQ\n");

		front.runCommandLoop();

		String output = tester.checkOutput();
		
		if(output.contains("Hulu Prime Video"))
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
		if (test1() != true) {
			System.out.println("Failed test1");
			return false;
		}
		if (test2() != true) {
			System.out.println("Failed test2");
			return false;
		}
		if (test3() != true) {
			System.out.println("Failed test3");
			return false;
		}
		if (test4() != true) {
			System.out.println("Failed test4");
			return false;
		}

		return true;
	}
	
	/**
	 * this method call the result of the runAllTests() method
	 */
	public static void main(String[] args) {
		
		System.out.print(runAllTests());

	}
}
