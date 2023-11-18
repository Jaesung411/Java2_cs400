import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlgorithmEngineerTests extends RedBlackTree<IGame> {

protected RedBlackTreeSets rbTree = null;
    
    @BeforeEach
    public void createRBTree() {
    	rbTree = new RedBlackTreeSets();
    	
    }
    
    //test if get method works in case root 
    @Test
    public void testRootGetMethod() {
    	
    	Game game1 = new Game(1,"first","Wii",1,1,1);
    	Game game2 = new Game(2,"second","NES",2,2,2);
    	Game game3 = new Game(3,"third","Wii",3,3,3);
    	rbTree.insert(game1);
    	rbTree.insert(game2);
    	rbTree.insert(game3);
    	
    	assertEquals(game2,rbTree.root.data);
    	assertEquals(game2,rbTree.get(2));
    	
    }
    
    //test if get method works in case right child 
    @Test
    public void testRightChildGetmethod() {
    	
    	Game game1 = new Game(1,"first","Wii",1,1,1);
    	Game game2 = new Game(2,"second","NES",2,2,2);
    	Game game3 = new Game(3,"third","Wii",3,3,3);
    	
    	rbTree.insert(game3);
    	rbTree.insert(game2);
    	rbTree.insert(game1);
    	
    	assertEquals(game3, rbTree.root.rightChild.data);
    	assertEquals(game3,rbTree.get(3));
    }
    
    //test if get method works in case left child 
    @Test
    public void testLeftChildGetmethod() {
    	
    	Game game1 = new Game(1,"first","Wii",1,1,1);
    	Game game2 = new Game(2,"second","NES",2,2,2);
    	Game game3 = new Game(3,"third","Wii",3,3,3);
    	
    	rbTree.insert(game3);
    	rbTree.insert(game2);
    	rbTree.insert(game1);
    	
    	assertEquals(game1, rbTree.root.leftChild.data);
    	assertEquals(game1,rbTree.get(1));
    	
    }
    
    //test if get method works in case left child working while loop
    @Test
    public void testLoopLeftChildGet() {
    	
    	Game game1 = new Game(1,"first","Wii",1,1,1);
    	Game game2 = new Game(2,"second","NES",2,2,2);
    	Game game3 = new Game(3,"third","Wii",3,3,3);
    	Game game4 = new Game(4,"fourth","DS",4,4,4);
    	
    	rbTree.insert(game4);
    	rbTree.insert(game3);
    	rbTree.insert(game2);
    	rbTree.insert(game1);
    	
    	assertEquals(game1, rbTree.root.leftChild.leftChild.data);
    	assertEquals(game1,rbTree.get(1));
    }
    
    //test if get method works in case right child working while loop
    @Test
    public void testLoopRightChildGet() {
    	
    	Game game1 = new Game(1,"first","Wii",1,1,1);
    	Game game2 = new Game(2,"second","NES",2,2,2);
    	Game game3 = new Game(3,"third","Wii",3,3,3);
    	Game game4 = new Game(4,"fourth","DS",4,4,4);
      	Game game5 = new Game(5,"fifth","DS",5,5,5);
    	
    	rbTree.insert(game4);
    	rbTree.insert(game3);
    	rbTree.insert(game2);
    	rbTree.insert(game1);
    	rbTree.insert(game5);
    	
    	assertEquals(game5, rbTree.root.rightChild.rightChild.data);
    	assertEquals(game5,rbTree.get(5));
    	
    }

}
