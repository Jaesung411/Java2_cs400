
import java.util.ArrayList;
import java.util.List;

public class ShowSeacherBackend implements IShowSearcherBackend{
	
	List<IShow> shows = new ArrayList<IShow>();
	String provider;
	private int numShows = 0;
	ArrayList<providerFilter> filters = new ArrayList<providerFilter>();
	List<List<IShow>> removedShowsByFilter = new ArrayList<List<IShow>>();
	
	public class providerFilter{
		String provider;
		Boolean filter;
		public providerFilter(String provider, boolean filter) {
			this.provider = provider;
			this.filter = filter;
			removedShowsByFilter.add(new ArrayList<IShow>());
		}
	}
	
	@Override
	public void addShow(IShow show) {
		
		shows.add(show);
		this.numShows++;
		
	}

	@Override
	public int getNumberOfShows() {
		
		return numShows;
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
		
		for(int i = 0; i < filters.size(); i++) {

			if(filters.get(i).provider.equals(provider)) {
				
				if(filters.get(i).filter==false) {
					
					filters.get(i).filter = true;
					
					for(int j = 0; j < shows.size(); j++) {
						
						if(shows.get(j).isAvailableOn(provider)) {
							System.out.println("1");
							removedShowsByFilter.get(i).add(shows.remove(j--));
							System.out.println(removedShowsByFilter.get(i).size());
						}
					}
					
				}
				else if(filters.get(i).filter) {
					System.out.println(removedShowsByFilter.get(i).size());
					filters.get(i).filter = false;
					
					for(int k = 0; k < removedShowsByFilter.get(i).size(); k++) {
			
						shows.add(removedShowsByFilter.get(i).remove(k--));
						
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
//		HashTableSortedSets<String, IShow> sortedSet = new HashTableSortedSets<>();
//		for(IShow i: this.shows) {
//			if(i.getTitle().toLowerCase().contains(word.toLowerCase())) {
//				sortedSet.add(word, i);
//			}
//		}
//
//		return sortedSet;
		
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
	
//	HashTableSortedSets<String, IShow> sortedSet = new HashTableSortedSets<>();
//	for(IShow i: this.shows) {
//		if(i.getYear()==year) {
//			sortedSet.add(year, i);
//		}
//	}
//
//	return sortedSet;

}