import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class BackendDeveloperAdditionTests{
    
    //test if directed connection is working
    @Test
    public void testOwnCode1() {
    	int[] n1 = {3};
    	IPlace p1 = new Place(1,"place1",false,1,1,1, n1);
    	int[] n2 = {1};
    	IPlace p2 = new Place(2,"place2",false,2,2,2, n2);
    	int[] n3 = {2};
    	IPlace p3 = new Place(3,"place1",false,3,3,3, n3);
    	List<IPlace> places = new ArrayList<IPlace>();
    	places.add(p1);
    	places.add(p2);
    	places.add(p3);
    	placeSearcherBackend backend = new placeSearcherBackend(places);
    	
    	assertEquals(backend.path.containsEdge(p1, p3),true);
    	assertEquals(backend.path.containsEdge(p3, p1),false);
    }
    
    //test if undirected connection is working
    @Test
    public void testOwnCode2() {
    	int[] n1 = {2};
    	IPlace p1 = new Place(1,"place1",false,1,1,1, n1);
    	int[] n2 = {1};
    	IPlace p2 = new Place(2,"place2",false,2,2,2, n2);
    	List<IPlace> places = new ArrayList<IPlace>();
    	places.add(p1);
    	places.add(p2);
    	placeSearcherBackend backend = new placeSearcherBackend(places);
    	
    	assertEquals(backend.path.containsEdge(p1, p2),true);
    	assertEquals(backend.path.containsEdge(p2, p1),true);
    }
    
    //test if it the method connectBothWays is working correctly
    @Test
    public void testReviewedCode1() {
    	
    	int[] n1 = {2,3};
    	IPlace p1 = new Place(1,"place1",true,1,1,1, n1);
    	int[] n2 = {1,3,4};
    	IPlace p2 = new Place(2,"place2",false,2,2,2, n2);
    	DijkstraGraph<IPlace> graph =new DijkstraGraph<>();
    	graph.insertVertex(p1);
    	graph.insertVertex(p2);
    	graph.connectBothWays(p1, p2, 2);
    	
    	assertEquals(p1.connectedTo()[0],2);
    	assertEquals(p2.connectedTo()[0],1);
    	assertEquals(graph.containsEdge(p1, p2),true);
    	
    }
    
    //test if it the method calculateEdgeWeight is working correctly
    @Test
    public void testReviewedCode2() {
    	
    	int[] n1 = {2,3};
    	IPlace p1 = new Place(1,"place1",true,1,1,1, n1);
    	int[] n2 = {1,3,4};
    	IPlace p2 = new Place(2,"place2",false,2,2,2, n2);
    	DijkstraGraph<IPlace> graph =new DijkstraGraph<>();
    	graph.insertVertex(p1);
    	graph.insertVertex(p2);
    	
    	//square root of (2-1)^2+(2-1)^2+(2-1)^2 = square root of 3 = 1.732
    	//So, the square root of 3 is around 2, so the result is 2
    	assertEquals(graph.calculateEdgeWeight(p1, p2),2);
    	
    }
    
    
  

}
