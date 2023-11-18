// --== CS400 Project One File Header ==--
// Name: Jaesung Lim
// CSL Username: jaesung
// Email: jlim83@wisc.edu
// Lecture #: <001 @11:00am>
// Notes to Grader: <any optional extra notes to your grader>
import java.util.Arrays;
import java.util.NoSuchElementException;
/**
 * This class tests if the Hashtable work correctly
 * 
 * @author Jaesung Lim
 *
 */
public class HashtableMapTests {
	
	/**
	 * this method tests if put and get method works correctly
	 * 
	 * @return true if put method works correctly
	 */
	public static boolean getTest() { 
			try {
				String expectedValue= "8";
				Integer givenKey = 8;
				int capacity = 20;
				int expectedIndex = Math.abs(givenKey.hashCode())%capacity;
		
				HashtableMap<Integer, String> test1 = new HashtableMap<Integer,String>();
				test1.put(6, "6");
				test1.put(8, "8");
				test1.put(9, "9");
				
				//check if the node is correct position in the put method
				if(!test1.hashtable[expectedIndex].peek().getKey().equals(givenKey)) {
					return false;
				}
				
				//check if the size of the hashtable is increasing in the put method
				if(test1.size()!=3) {
					return false;
				}
				
				//check if the get method works correctly
				if(test1.get(8) != expectedValue) {
					return false;
				}
				
				//check if exception works correctly when the key does not contain in the hashtable
				if(test1.get(7) != expectedValue) {
					return false;
				}
			}catch(NoSuchElementException nse) {
				return true;
			}catch(Exception ex) {
				System.out.println(ex);
				return false;
			}
			return true;
	}
	
	/**
	 * this method tests if collision is dealing correctly
	 * 
	 * @return true if collision is dealing correctly
	 */
	public static boolean collisionTest() { 
		try {
			String expectedValue= "8";
			String expectedValue2= "9";
			HashtableMap<Integer, String> test1 = new HashtableMap<Integer,String>();
			test1.put(9, "6");
			test1.put(19, "8");
			test1.put(29, "9");
			
			//check if the node is stored during collision
			if(test1.get(19) != expectedValue) {
				return false;
			}
			if(test1.get(29) != expectedValue2) {
				return false;
			}
		}catch(Exception ex) {
			System.out.println(ex);
			return false;
		}
		return true;
	}
	
	/**
	 * this method tests if remove method works correctly
	 * 
	 * @return true if remove method works correctly
	 */
	public static boolean removeTest() {
		try {
			
			String expectValue = "9";
			Integer removedKey = 9;
			
			HashtableMap<Integer, String> test1 = new HashtableMap<Integer,String>();
			test1.put(6, "6");
			test1.put(8, "8");
			test1.put(9, "9");
			
			//check if the remove method return the expect value
			if(!test1.remove(9).equals(expectValue)){
				return false;
			}
			
			//check if the size of hashtable decreases after remove method
			if(test1.size() != 2) {
				return false;
			}
			
			//check if the removed hashtable does not contain the removed node
			if(test1.containsKey(removedKey)) {
				return false;
			}
			
		}catch(Exception ex) {
			System.out.println(ex);
			return false;
		}
		return true;
	}
	
	/**
	 * this method tests if rehash works correctly
	 * 
	 * @return true if put method works correctly
	 */
	public static boolean rehashTest() { 
		try {
			
			HashtableMap<Integer, String> test1 = new HashtableMap<Integer,String>(10);
			Integer expectedKey = 11;
			int capacity = 20;
			int index = Math.abs(expectedKey.hashCode())%capacity;
			
			test1.put(1, "1");
			test1.put(2, "2");
			test1.put(3, "3");
			test1.put(11, "11");
			test1.put(5, "5");
			test1.put(6, "6");
			test1.put(7, "7");
			test1.put(9, "7");
			test1.put(21, "11");
			
			//check if the size of hashtable is double
			if(test1.hashtable.length != 20) {
				return false;
			}
			
			//check if rehashing
			if(!test1.hashtable[index].peek().getKey().equals(expectedKey)) {
				return false;
			}
			
		}catch(Exception ex) {
			System.out.println(ex);
			return false;
		}
		return true;
	}
	
	/**
	 * this method tests if contains and clear method works correctly
	 * 
	 * @return true if clear method works correctly
	 */
	public static boolean clearTest() { 
		try {
			
			HashtableMap<Integer, String> test1 = new HashtableMap<Integer,String>(10);
			
			test1.put(1, "1");
			test1.put(2, "2");
			test1.put(3, "3");
			test1.put(4, "4");
			test1.put(5, "5");
			test1.put(6, "6");
			test1.put(7, "7");
			test1.put(8, "8");
			System.out.println(Arrays.toString(test1.hashtable));
			//check if contains method works correctly
			if(test1.containsKey(1) != true) {
				return false;
			}
			if(test1.containsKey(11) != false) {
				return false;
			}
			
			test1.clear();
			
			//check if the hash table is empty and size is zero
			for(int i = 0; i < test1.hashtable.length; i++) {
				if(test1.hashtable[i]!=null) {
					return false;
				}
			}
			if(test1.size() != 0) {
				return false;
			}
			
		}catch(Exception ex) {
			return false;
		}
		return true;
	}
	
	/**
	 * test all of the tester methods
	 * 
	 * @return true if it works correctly
	 */
	public static boolean runAllTests() {
		// check whether all the tests
		if (getTest() != true) {
			System.out.println("Failed put and get method");
			return false;
		}
		if (collisionTest() != true) {
			System.out.println("Failed collision");
			return false;
		}
		if (removeTest() != true) {
			System.out.println("Failed remove method");
			return false;
		}
		if (rehashTest() != true) {
			System.out.println("Failed rehash");
			return false;
		}
		if (clearTest() != true) {
			System.out.println("Failed clear");
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
