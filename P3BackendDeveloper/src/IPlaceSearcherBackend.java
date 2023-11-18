// --== CS400 Project3 File Header ==--
// Name: <Jaesung Lim>
// CSL Username: <jaesung>
// Email: <jlim83@wisc.edu>
// Lecture #: <001 @11:00am>
// Notes to Grader: <any optional extra notes to your grader>

public interface IPlaceSearcherBackend {
	
	/**
	 * create a path by using AE method
	 * @param point the created point
	 */
	public IPlace createGraph(IPlace point);
	
	/**
	 * get any possible paths in the given point
	 * @param point the given point
	 * @return the possible paths in the given point
	 */
	public IPlace[] returnPath(IPlace point);
	
	/**
	 * save all paths which should be used in a list
	 * @param start the starting place
	 * @param end the ending place
	 * @return the list of the places
	 */
	public IPlace[] returnAllPlaces(IPlace start, IPlace end);
		
}
