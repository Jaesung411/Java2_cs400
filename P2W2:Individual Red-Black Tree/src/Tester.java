
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Tester {
	 protected RedBlackTree<Integer> rbTree = null;
	    
	    @BeforeEach
	    public void createRBTree() {
	    	rbTree = new RedBlackTree<Integer>();
	    }
	    
	    //test case1: only color is changed 
	    @Test
	    public void test1() {
	    	
	    	rbTree.insert(20);
	    	rbTree.insert(10);
	    	rbTree.insert(30);
	    	rbTree.insert(40);
	    	rbTree.insert(50);
	    	rbTree.insert(60);
	    	
	    	assertEquals(1,rbTree.root.rightChild.leftChild.blackHeight);
	    	assertEquals(0,rbTree.root.rightChild.rightChild.rightChild.blackHeight);
	    	
	    }
	    
	    //test rotate case
	    @Test
	    public void test2() {
	    	
	    	rbTree.insert(20);
	    	rbTree.insert(10);
	    	rbTree.insert(30);
	    	rbTree.insert(40);
	    	rbTree.insert(50);
	    	rbTree.insert(60);
	    	rbTree.insert(70);
	    	rbTree.insert(80);
	    	
	    	assertEquals(20,rbTree.root.leftChild);
	    	assertEquals(0,rbTree.root.leftChild.blackHeight);
	    	
	    }
	    
	    //test double rotate case
	    @Test
	    public void test3() {
	    	
	    	rbTree.insert(20);
	    	rbTree.insert(10);
	    	rbTree.insert(30);
	    	rbTree.insert(40);
	    	rbTree.insert(50);
	    	rbTree.insert(60);
	    	rbTree.insert(70);
	    	rbTree.insert(80);
	    	rbTree.insert(75);
	    	
	    	assertEquals(75,rbTree.root.rightChild.rightChild.leftChild);
	    	assertEquals(0,rbTree.root.rightChild.rightChild.leftChild.blackHeight);
	    }
}
