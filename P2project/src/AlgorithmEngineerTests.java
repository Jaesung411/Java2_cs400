import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlgorithmEngineerTests extends RedBlackTree<Integer> {

protected RedBlackTreeSets<Integer> rbTree = null;
    
    @BeforeEach
    public void createRBTree() {
    	rbTree = new RedBlackTreeSets<Integer>();
    	
    }
    
    //test if get method works in case root 
    @Test
    public void test1() {
    	
    	rbTree.insert(3);
    	rbTree.insert(2);
    	rbTree.insert(1);
    	rbTree.root.setRank(2);
    	
    	assertEquals(2,rbTree.root.data);
    	assertEquals(rbTree.root,rbTree.get(2));
    	
    }
    
    //test if get method works in case right child 
    @Test
    public void test2() {
    	
    	rbTree.insert(3);
    	rbTree.insert(2);
    	rbTree.insert(1);
    	
    	rbTree.root.setRank(2);
    	rbTree.root.rightChild.setRank(3);
    	rbTree.root.leftChild.setRank(1);
    	
    	assertEquals(3, rbTree.root.rightChild.data);
    	assertEquals(rbTree.root.rightChild,rbTree.get(3));
    }
    
    //test if get method works in case left child 
    @Test
    public void test3() {
    	
    	rbTree.insert(3);
    	rbTree.insert(2);
    	rbTree.insert(1);

    	rbTree.root.setRank(2);
    	rbTree.root.rightChild.setRank(3);
    	rbTree.root.leftChild.setRank(1);
    	
    	assertEquals(1, rbTree.root.leftChild.data);
    	assertEquals(rbTree.root.leftChild,rbTree.get(1));
    	
    }
    
    //test if get method works in case left child working while loop
    @Test
    public void test4() {
    	
    	rbTree.insert(4);
    	rbTree.insert(3);
    	rbTree.insert(2);
    	rbTree.insert(1);
    	
    	rbTree.root.setRank(3);
    	rbTree.root.rightChild.setRank(2);
    	rbTree.root.leftChild.setRank(4);
    	rbTree.root.leftChild.leftChild.setRank(1);
    	
    	assertEquals(1, rbTree.root.leftChild.leftChild.data);
    	assertEquals(rbTree.root.leftChild.leftChild,rbTree.get(1));
    }
    
    //test if get method works in case right child working while loop
    @Test
    public void test5() {
    	
    	rbTree.insert(4);
    	rbTree.insert(3);
    	rbTree.insert(2);
    	rbTree.insert(1);
    	rbTree.insert(5);
    	
    	rbTree.root.setRank(3);
    	rbTree.root.rightChild.setRank(2);
    	rbTree.root.leftChild.setRank(4);
    	rbTree.root.leftChild.leftChild.setRank(1);
    	rbTree.root.rightChild.rightChild.setRank(5);
    	
    	assertEquals(5, rbTree.root.rightChild.rightChild.data);
    	assertEquals(rbTree.root.rightChild.rightChild,rbTree.get(5));
    	
    }

}
