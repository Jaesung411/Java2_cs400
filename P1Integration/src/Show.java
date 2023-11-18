
public class Show implements IShow
{
    //the title of the show
    private String title;

    //the year it was released
    private int year;

    //the rating given
    private int rating;

    //available providers
    private String providers;

    /**
     * Constructs a new Show object with the given details
     */
    public Show(String title, int year, int rating, String providers)
    {
	this.title = title;
	this.year = year;
	this.rating = rating;
	this.providers = providers;
    }

    /**
     * Returns the show's title
     */
    public String getTitle()
    {
	return title;
    }

    /**
     * Returns the show's year
     */
    public int getYear()
    {
	return year;
    }

    /**
     * Returns the show's rating
     */
    public int getRating()
    {
	return rating;
    }

    /**
     * Returns whether this show is available on the specified platform
     */
    public boolean isAvailableOn(String provider)
    {
	return providers.contains(provider);
    }

    /**
     * Returns a String representation of this Show, for debugging purposes
     */
    public String toString()
    {
	return "[title="+title+", year="+year+", rating="+rating+", providers="+providers+"]";
    }

    public boolean equals(Object o)
    {
	if(o instanceof Show)
	{
	    Show s = (Show)o;
	    return this.title.equals(s.title) && this.rating == s.rating && this.year == s.year && this.providers.equals(s.providers);
	}
	return false;
    }

    /**
     * Compares this Show with another based on rating. Returns >0 if this Show is rated higher, <0 if this Show is rated lower, and 0 if ratings are equal
     */
    public int compareTo(IShow other)
    {
	return rating - other.getRating();
    }

}