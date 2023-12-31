// --== CS400 File Header Information ==--
// Name: Jaesung Lim
// Email: jlim83@wisc.edu
// Team: <your team name: AN>
// TA: Yelun
// Lecturer: Gary
// Notes to Grader: <optional extra notes>
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests the implementation of CS400Graph for the individual component of
 * Project Three: the implementation of Dijsktra's Shortest Path algorithm.
 */
public class GraphTest {

    private CS400Graph<String> graph;
    
    /**
     * Instantiate graph from last week's shortest path activity.
     */
    @BeforeEach
    public void createGraph() {
        graph = new CS400Graph<>();
        // insert vertices A-F
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");
        graph.insertVertex("F");
        // insert edges from Week 11. Shortest Path Activity
        graph.insertEdge("A","B",6);
        graph.insertEdge("A","C",2);
        graph.insertEdge("A","D",5);
        graph.insertEdge("B","E",1);
        graph.insertEdge("B","C",2);
        graph.insertEdge("C","B",3);
        graph.insertEdge("C","F",1);
        graph.insertEdge("D","E",3);
        graph.insertEdge("E","A",4);
        graph.insertEdge("F","A",1);
        graph.insertEdge("F","D",1);
    }

    /**
     * Checks the distance/total weight cost from the vertex A to F.
     */
    @Test
    public void testPathCostAtoF() {
        assertTrue(graph.getPathCost("A", "F") == 3);
    }

    /**
     * Checks the distance/total weight cost from the vertex A to D.
     */
    @Test
    public void testPathCostAtoD() {
        assertTrue(graph.getPathCost("A", "D") == 4);
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * A to D.
     */
    @Test
    public void testPathAtoD() {
        assertTrue(graph.shortestPath("A", "D").toString().equals(
            "[A, C, F, D]"
        ));
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * A to F.
     */
    @Test
    public void testPathAtoF() {
        assertTrue(graph.shortestPath("A", "F").toString().equals(
            "[A, C, F]"
        ));
    }
    
    /**
     * Checks the distance/total weight cost from the vertex B to F.
     */
    @Test
    public void testPathCostBtoF() {
        assertTrue(graph.getPathCost("B", "F") == 3);
    }
    
    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * A to D.
     */
    @Test
    public void testPathBtoF() {
        assertTrue(graph.shortestPath("B", "F").toString().equals(
            "[B, C, F]"
        ));
    }
    
    /**
     * Add a extra test method to confirm that the distance I computed
     *  for this node in last week's activity is correct
     */
    @Test
    public void testPathCostCtoE() {
        assertTrue(graph.getPathCost("C", "E") == 4);
    }
    
    /**
     * Add an extra test method to confirm the sequence of nodes along the path from your
     *  source node to this same end node (the end node that is furthest from your source node) is correct.
     */
    @Test
    public void testPathCtoE() {
        assertTrue(graph.shortestPath("C", "E").toString().equals(
            "[C, B, E]"
        ));
    }
    
    /**
     * Add another test method to confirm the predecessor I reported for question
     * about a final node's predecessor from last week's activity.
     */
    @Test
    public void testPredecessorCtoE() {
        assertTrue(graph.shortestPath("C", "E").get(graph.shortestPath("C", "E").size()-2) == "B");
    }
    
    /**
     * Add another test method to confirm the path cost I reported for the question about
     *  path cost from last week's activity.
     */
    @Test
    public void testPathCostBtoD() {
        assertTrue(graph.getPathCost("B", "D") == 4);
    }
    
    /**
     * Add another test method to confirm the predecessor I reported for question
     * about a final node's predecessor from last week's activity.
     */
    @Test
    public void testPredecessorBtoD() {
        assertTrue(graph.shortestPath("B", "D").get(graph.shortestPath("B", "D").size()-2) == "F");
    }
    
    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * B to D.
     */
    @Test
    public void testPathBtoD() {
        assertTrue(graph.shortestPath("B", "D").toString().equals(
            "[B, C, F, D]"
        ));
    }
}