import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class BackendDeveloperTests{
    
    //test if the constructor makes a graph which is connected correctly
    @Test
    public void testConnectedGraph() {
    	int[] n1 = {2,3};
    	IPlace p1 = new place(1,"place1",false,1,1,1, n1);
    	int[] n2 = {1,3};
    	IPlace p2 = new place(2,"place2",false,2,2,2, n2);
    	int[] n3 = {1,2};
    	IPlace p3 = new place(3,"place1",false,3,3,3, n3);
    	List<IPlace> places = new ArrayList<IPlace>();
    	places.add(p1);
    	places.add(p2);
    	places.add(p3);
    	placeSearcherBackend backend = new  placeSearcherBackend(places);
    	
    	assertEquals(backend.path.containsEdge(p1, p2),true);
    	assertEquals(backend.path.containsEdge(p2, p3),true);
    	assertEquals(backend.path.containsEdge(p3, p1),true);
    	
    }
    
    //test if each edge has correct weight
    @Test
    public void testWeightGraph() {
    	int[] n1 = {2,3};
    	IPlace p1 = new place(1,"place1",false,1,1,1, n1);
    	int[] n2 = {1,3};
    	IPlace p2 = new place(2,"place2",false,2,2,2, n2);
    	int[] n3 = {1,2};
    	IPlace p3 = new place(3,"place1",false,3,3,3, n3);
    	List<IPlace> places = new ArrayList<IPlace>();
    	places.add(p1);
    	places.add(p2);
    	places.add(p3);
    	placeSearcherBackend backend = new  placeSearcherBackend(places);
    	
    	assertEquals(backend.path.getWeight(p1, p2),p1.compareTo(p2));
    	assertEquals(backend.path.getWeight(p2, p3),p2.compareTo(p3));
    	assertEquals(backend.path.getWeight(p3, p1),p3.compareTo(p1));
    }
    
    //test if it returns the shortest path
    @Test
    public void testReturnPath() {
    	
    	int[] n1 = {2,3};
    	IPlace p1 = new place(1,"place1",true,1,1,1, n1);
    	int[] n2 = {1,3,4};
    	IPlace p2 = new place(2,"place2",false,2,2,2, n2);
    	int[] n3 = {1,2,4};
    	IPlace p3 = new place(3,"place3",false,3,3,3, n3);
    	int[] n4 = {2,3};
    	IPlace p4 = new place(4,"place4",true,4,4,4, n4);
    	List<IPlace> places = new ArrayList<IPlace>();
    	places.add(p1);
    	places.add(p2);
    	places.add(p3);
    	places.add(p4);
    	placeSearcherBackend backend = new  placeSearcherBackend(places);
    	
    	assertEquals(backend.shortestPath(p1, p4).get(0).getID(),1);
    	assertEquals(backend.shortestPath(p1, p4).get(1).getID(),2);
    	assertEquals(backend.shortestPath(p1, p4).get(2).getID(),3);
    	assertEquals(backend.shortestPath(p1, p4).get(3).getID(),4);
    	
    }
    
    //test if it returns the shortest path's cost
    @Test
    public void testCostPath() {
    	
    	int[] n1 = {2,3};
    	IPlace p1 = new place(1,"place1",true,1,1,1, n1);
    	int[] n2 = {1,3,4};
    	IPlace p2 = new place(2,"place2",false,2,2,2, n2);
    	int[] n3 = {1,2,4};
    	IPlace p3 = new place(3,"place3",false,3,3,3, n3);
    	int[] n4 = {2,3};
    	IPlace p4 = new place(4,"place4",true,4,4,4, n4);
    	List<IPlace> places = new ArrayList<IPlace>();
    	places.add(p1);
    	places.add(p2);
    	places.add(p3);
    	places.add(p4);
    	placeSearcherBackend backend = new  placeSearcherBackend(places);
    	
    	assertEquals(backend.getPathCost(p1, p4),3);
    	
    }
    
    //test if exception when starting or ending place is not supplying dining
    @Test
    public void testNoDiningPlace() {
    	try {
	    	int[] n1 = {2,3};
	    	IPlace p1 = new place(1,"place1",false,1,1,1, n1);
	    	int[] n2 = {1,3,4};
	    	IPlace p2 = new place(2,"place2",false,2,2,2, n2);
	    	int[] n3 = {1,2,4};
	    	IPlace p3 = new place(3,"place3",false,3,3,3, n3);
	    	int[] n4 = {2,3};
	    	IPlace p4 = new place(4,"place4",true,4,4,4, n4);
	    	List<IPlace> places = new ArrayList<IPlace>();
	    	places.add(p1);
	    	places.add(p2);
	    	places.add(p3);
	    	places.add(p4);
	    	placeSearcherBackend backend = new  placeSearcherBackend(places);
    	}catch(NoSuchElementException nse) {
    		assertEquals(nse.getMessage(),"The place does not supply dining");
    	}
    }
    
    //test if returnAllPlaces method works correctly
    @Test
    public void testReturnAllPlaces() {
    	
    	int[] n1 = {2,3};
    	IPlace p1 = new place(1,"place1",true,1,1,1, n1);
    	int[] n2 = {1,3,4};
    	IPlace p2 = new place(2,"place2",false,2,2,2, n2);
    	int[] n3 = {1,2,4};
    	IPlace p3 = new place(3,"place3",false,3,3,3, n3);
    	int[] n4 = {2,3};
    	IPlace p4 = new place(4,"place4",true,4,4,4, n4);
    	List<IPlace> places = new ArrayList<IPlace>();
    	places.add(p1);
    	places.add(p2);
    	places.add(p3);
    	places.add(p4);
    	placeSearcherBackend backend = new  placeSearcherBackend(places);
    	
    	assertEquals(backend.returnAllPlaces().get(0).getName(),"place1");
    	assertEquals(backend.returnAllPlaces().get(1).getName(),"place2");
    	assertEquals(backend.returnAllPlaces().get(2).getName(),"place3");
    	assertEquals(backend.returnAllPlaces().get(3).getName(),"place4");
    	
    }

}
