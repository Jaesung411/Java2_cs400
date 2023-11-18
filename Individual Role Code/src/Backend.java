// --== CS400 Project One File Header ==--
// Name: Jaesung Lim
// CSL Username: jaesung
// Email: jlim83@wisc.edu
// Lecture #: <001 @11:00am>
// Notes to Grader: <any optional extra notes to your grader>
import java.util.ArrayList;
import java.util.List;

public class Backend implements IShowSearcherBackend{
	
	List<IShow> shows = new ArrayList<IShow>();
	String provider;
	ArrayList<providerFilter> filters = new ArrayList<providerFilter>();

	public class providerFilter{
		String provider;
		Boolean filter;
		public providerFilter(String provider, boolean filter) {
			this.provider = provider;
			this.filter = filter;
		}
	}
	@Override
	public void addShow(IShow show) {
		
		shows.add(show);
		
	}

	@Override
	public int getNumberOfShows() {
		
		return shows.size();
	}

	@Override
	public void setProviderFilter(String provider, boolean filter) {
		
		providerFilter providerF = new providerFilter(provider,filter);
		this.filters.add(providerF);
		
	}

	@Override
	public boolean getProviderFilter(String provider) {
		for(int i = 0; i < filters.size(); i++) {
			if(filters.get(i).provider.equals(provider)) {
				return filters.get(i).filter;
			}
		}
		return false;
	}

	@Override
	public void toggleProviderFilter(String provider) {
		
//		for(int i = 0; i < filters.size(); i++) {
//			if(filters.get(i).provider.equals(provider)) {
//				filters.get(i).filter = true;;
//			}
//		}
//		
//		for(int i = 0; i < shows.size(); i++) {
//			if(shows.get(i).isAvailableOn(provider)) {
//				shows.remove(i);
//			}
//		}
		List<List<IShow>> removedShows = new ArrayList<List<IShow>>();
		
		for(int i = 0; i < filters.size(); i++) {
			removedShows.add(i,new ArrayList<IShow>());
			if(filters.get(i).provider.equals(provider)) {
				if(filters.get(i).filter==false) {
					
					filters.get(i).filter = true;
					for(int j = 0; j < shows.size(); j++) {
						removedShows.get(i).add(shows.remove(j));
					}
					
				}else {
					
					filters.get(i).filter = false;
					for(int j = 0; j < removedShows.get(i).size(); j++) {
						shows.add(removedShows.get(i).remove(j));
					}
				}
			}
		}
		
	}

	@Override
	public List<IShow> searchByTitleWord(String word) {
		List<IShow> shows = new ArrayList<IShow>();
		for(IShow i: this.shows) {
			if(i.getTitle().toLowerCase().contains(word.toLowerCase())) {
				shows.add(i);
			}
		}
		//make the order in the list by the rotten tomatoes rating
		for(int i = 0; i < shows.size(); i++) {
			for(int j = i+1; j < shows.size(); j++) {
				if(shows.get(i).compareTo(shows.get(j))<0){
					IShow temp = shows.get(i);
					shows.set(i, shows.get(j));
					shows.set(j, temp);										}
					}
			}
		
		return shows;
	}

	@Override
	public List<IShow> searchByYear(int year) {
		List<IShow> shows = new ArrayList<IShow>();
		for(IShow i: this.shows) {
			if(i.getYear()==year) {
				shows.add(i);
			}
		}
		//make the order in the list by the rotten tomatoes rating
		for(int i = 0; i < shows.size(); i++) {
			for(int j = i+1; j < shows.size(); j++) {
				if(shows.get(i).compareTo(shows.get(j))<0){
					IShow temp = shows.get(i);
					shows.set(i, shows.get(j));
					shows.set(j, temp);										}
					}
				}
		
		return shows;
	}

}

//import java.util.List;
//import java.util.ArrayList;
//
///*
// * Class ShowSearcherBackend implements IShowSearcherBackend
// * this is main class for backend developer:
// * 1. save shows in database
// * 2. implements filter
// * 3. search methods with sorting
// *
// */
//public class Backend implements IShowSearcherBackend{
//
//    //args (int numShows, boolean[] setFilter)
//    private int numShows;
//    private boolean[] setFilter;
//
//    //List<IShow> shows where shows are saved (database)
//    private List<IShow> shows = new ArrayList<IShow>();
//
//    //Constructor
//    public Backend() {
//	this.shows = new ArrayList<IShow>();
//	this.setFilter = new boolean[4];
//	this.numShows = 0;
//    }
//
//    //addShow for adding show
//    public void addShow(IShow show) {
//    	this.shows.add(show);
//    	this.setFilter[0] = true;
//    	this.setFilter[1] = true;
//    	this.setFilter[2] = true;
//    	this.setFilter[3] = true;
//    	this.numShows++;
//    }
//
//    // retrieve number of shows in database
//    public int getNumberOfShows() {
//    	return this.numShows;
//    }
//
//    // set the desired provider filters before calling either search method
//    public void setProviderFilter(String provider, boolean filter) {
//
//    	if(provider == "Netflix") {
//    		if(filter) {
//    			this.setFilter[0] = true;
//    		}
//    		else {
//    			this.setFilter[0] = false;
//    		}
//    	}
//    	else if(provider == "Hulu") {
//    		if(filter) {
//    			this.setFilter[1] = true;
//    		}
//    		else {
//    			this.setFilter[1] = false;
//    		}
//    	}
//    	else if(provider == "Prime video") {
//    		if(filter) {
//    			this.setFilter[2] = true;
//    		}
//    		else {
//    			this.setFilter[2] = false;
//    		}
//    	}
//    	else if(provider == "Disney+") {
//    		if(filter) {
//    			this.setFilter[3] = true;
//    		}
//    		else {
//    			this.setFilter[3] = false;
//    		}
//    	}
//    	//temporary exceptions for future
//    	else {
//    		System.out.println("No such provider");
//    	}
//    }
//
//    //retrieve status of filter
//    public boolean getProviderFilter(String provider) {
//
//    	if(provider == "Netflix") {
//    		return this.setFilter[0];
//    	}
//    	else if(provider == "Hulu") {
//    		return this.setFilter[1];
//    	}
//    	else if(provider == "Prime video") {
//    		return this.setFilter[2];
//    	}
//    	else if(provider == "Disney+") {
//    		return this.setFilter[3];
//    	}
//    	return false;
//    }
//
//    //change status of filter
//    public void toggleProviderFilter(String provider) {
//
//    	if(provider == "Netflix") {
//    		if (this.setFilter[0]) {
//    			this.setFilter[0] = false;
//    		}
//    		else {
//    			this.setFilter[0] = true;
//    		}
//    	}
//    	else if(provider == "Hulu") {
//    		if (this.setFilter[1]) {
//    			this.setFilter[1] = false;
//    		}
//    		else {
//    			this.setFilter[1] = true;
//    		}
//    	}
//    	else if(provider == "Prime video") {
//    		if (this.setFilter[2]) {
//    			this.setFilter[2] = false;
//    		}
//    		else {
//    			this.setFilter[2] = true;
//    		}
//    	}
//    	else if(provider == "Disney+") {
//    		if (this.setFilter[3]) {
//    			this.setFilter[3] = false;
//    		}
//    		else {
//    			this.setFilter[3] = true;
//    		}
//    	}
//    }
//
//    //deepCopy methods for maintaining original database
//    public static List<IShow> deepCopy(final List<IShow> shows)
//    {
//        List<IShow> copy = new ArrayList<IShow>();
//        for(IShow val : shows){
//            copy.add(val);
//        }
//        return copy;
//    }
//
//    //search by title method returns searchedlist
//    public List<IShow> searchByTitleWord(String word) {
//
//    	List<IShow> searchedShow =  deepCopy(this.shows);
//
//    	for (int i = 0; i < searchedShow.size(); i++) {
//    	    if(!searchedShow.get(i).getTitle().contains(word)) {
//    	       searchedShow.remove(i--);
//    	    }
//    	}
//
//    	//condition for Netflix
//    	if(!this.setFilter[0]) {
//    	    for(int i=0; i<searchedShow.size(); i++) {
//    		if(searchedShow.get(i).isAvailableOn("Netflix")) {
//    	           searchedShow.remove(i--);
//    	        }
//    	    }
//    	}
//    	//condition for Hulu
//    	if(!this.setFilter[1]) {
//    	    for(int i=0; i<searchedShow.size(); i++) {
//    		if(searchedShow.get(i).isAvailableOn("Hulu")) {
//    	           searchedShow.remove(i--);
//    	        }
//    	    }
//    	}
//    	//condition for Prime video
//    	if(!this.setFilter[2]) {
//    	    for(int i=0; i<searchedShow.size(); i++) {
//    		if(searchedShow.get(i).isAvailableOn("Prime video")) {
//    	           searchedShow.remove(i--);
//    	        }
//    	    }
//    	}
//    	//condition for Disney+
//    	if(!this.setFilter[3]) {
//    	    for(int i=0; i<searchedShow.size(); i++) {
//    		if(searchedShow.get(i).isAvailableOn("Disney+")) {
//    	           searchedShow.remove(i--);
//    	        }
//    	    }
//    	}
//
//    	//Sorting (higher rate to left)
//        if(searchedShow.size() > 1) {
//	    IShow temp;
//	        for(int i=0; i<searchedShow.size()-1; i++){
//	    	    for(int j=0; j<searchedShow.size()-i-1; j++){
//	    	        if(searchedShow.get(j).compareTo(searchedShow.get(j+1)) == -1){
//	    	            temp = searchedShow.get(j);
//	    	            searchedShow.set(j, searchedShow.get(j+1));
//	    	            searchedShow.set(j+1,temp);
//	    	        }
//	    	    }
//	    	}
//        }
//
//        return searchedShow;
//    }
//
//    //search by year returns searchedlist
//    public List<IShow> searchByYear(int year) {
//
//    	List<IShow> searchedShow =  deepCopy(this.shows);
//
//    	for (int i = 0; i < searchedShow.size(); i++) {
//    	    if(!(searchedShow.get(i).getYear() == year)) {
//    	       searchedShow.remove(i--);
//    	    }
//    	}
//    	//condition for Netflix
//    	if(!this.setFilter[0]) {
//    	    for(int i=0; i<searchedShow.size(); i++) {
//    		if(searchedShow.get(i).isAvailableOn("Netflix")) {
//    	           searchedShow.remove(i--);
//    	        }
//    	    }
//    	}
//    	//condition for Hulu
//    	if(!this.setFilter[1]) {
//            for(int i=0; i<searchedShow.size(); i++) {
//    		if(searchedShow.get(i).isAvailableOn("Hulu")) {
//                   searchedShow.remove(i--);
//    	        }
//    	    }
//    	}
//    	//condition for Prime video
//    	if(!this.setFilter[2]) {
//    	    for(int i=0; i<searchedShow.size(); i++) {
//    		if(searchedShow.get(i).isAvailableOn("Prime video")) {
//    	           searchedShow.remove(i--);
//    	        }
//    	    }
//    	}
//    	//condition for Disney+
//    	if(!this.setFilter[3]) {
//    	    for(int i=0; i<searchedShow.size(); i++) {
//    		if(searchedShow.get(i).isAvailableOn("Disney+")) {
//                   searchedShow.remove(i--);
//    	        }
//    	    }
//    	}
//
//    	//Sorting (higher rate to left)
//        if(searchedShow.size() > 1) {
//	    IShow temp;
//	    for(int i=0; i<searchedShow.size()-1; i++){
//
//	        for(int j=0; j<searchedShow.size()-i-1; j++){
//
//	   	    if(searchedShow.get(j).compareTo(searchedShow.get(j+1)) == -1){
//	    	        temp = searchedShow.get(j);
//	                searchedShow.set(j, searchedShow.get(j+1));
//	  	        searchedShow.set(j+1,temp);
//	    	    }
//	    	}
//	    }
//        }
//
//        return searchedShow;
//    }
//
//    //testing purpose: return shows
//    public List<IShow> getShows() {
//	return this.shows;
//    }
//
//}
