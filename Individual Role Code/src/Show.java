// --== CS400 Project One File Header ==--
// Name: Jaesung Lim
// CSL Username: jaesung
// Email: jlim83@wisc.edu
// Lecture #: <001 @11:00am>
// Notes to Grader: <any optional extra notes to your grader>
import java.util.ArrayList;

public class Show implements IShow{
	
	//the title of the show
	private String title;
	
	//the year it was released
	private int year;
	
	 //the rating given
	private int rating;
	
	ArrayList<String> providers = new ArrayList<String>();
	
	// constructor args (String title, int year, int rating, String providers)
    // where the providers string includes the names of every streaming source
	public Show(String title, int year, int rating, String providers) {
		this.title = title;
		this.year = year;
		this.rating = rating;
		this.providers.add(providers);
				
	}
	
	@Override
	public int compareTo(IShow o) {
		if(this.rating < o.getRating()){
			return this.rating - o.getRating();
		}else if(this.rating > o.getRating()) {
			return this.rating - o.getRating();
		}else {
			return 0;
		}
	}

	// retrieve the title of this show object
	@Override
	public String getTitle() {
		
		return this.title;
	}

    // retrieve the year that this show was first produced
	@Override
	public int getYear() {
		
		return this.year;
	}

	// retrieve the Rotten Tomatoes Rating (out of 100)
	@Override
	public int getRating() {
		
		return this.rating;
	}

	// checks show availability
	@Override
	public boolean isAvailableOn(String provider) {
		for(String s : providers) {
			if(s.equals(provider)) {
				return true;
			}
		}

		return false;
	}

}
