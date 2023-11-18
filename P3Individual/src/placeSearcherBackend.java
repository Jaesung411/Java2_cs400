import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class placeSearcherBackend implements IPlaceSearcherBackend{
	
	CS400Graph<IPlace> path = new CS400Graph<>(); //the path which makes for path
	List<IPlace> places = new ArrayList<IPlace>(); // all the places in the graph
	
	/**
	 * the constructor makes a graph which has all the connected places 
	 * which are supplied by DW
	 * @param places the places which are supplied by DW
	 */
	public placeSearcherBackend(List<IPlace> places){
		
		for(IPlace p : places) {
			path.insertVertex(p);
			this.places.add(p);
		}

		for(IPlace p1 : places) {
			for(int n : p1.connectedTo()) {
				for(IPlace p2 : places) {
					if(n == p2.getID()) {
						path.insertEdge(p1, p2, p1.compareTo(p2));
					}
				}
				
			}
		}
	}
	
	/**
	 * this method get the shortest path from the given starting place to the given end place
	 * @param start the given starting place
	 * @param end the given ending place
	 * @return the shortest path 
	 */
	@Override
	public CS400Graph<IPlace>.Path returnPath(IPlace start, IPlace end) {
		if(start.checkIsDining()==false||end.checkIsDining()==false) 
			throw new NoSuchElementException("The place does not supply dining");
		return path.dijkstrasShortestPath(start, end);
	}

	/**
	 * for test
	 * @param start the given starting place
	 * @param end the given ending place
	 * @return the shortest path's list of data
	 */
	public List<IPlace> shortestPath(IPlace start, IPlace end) {
        return this.returnPath(start, end).dataSequence;
    }
	
	/**
	 * for test
	 * @param start the given starting place
	 * @param end the given ending place
	 * @return the cost of the shortest path 
	 */
	public int getPathCost(IPlace start, IPlace end) {
	        return this.returnPath(start, end).distance;
    }
	/**
	 * this method return all the places
	 * @return all the places in the graph
	 */
	@Override
	public ArrayList<IPlace> returnAllPlaces() {
		ArrayList<IPlace> places = new ArrayList<IPlace>();
		for(int i = 0; i < path.vertices.size(); i++) {
			places.add(path.vertices.get(this.places.get(i)).data);
		}
		return places;
	}
}
