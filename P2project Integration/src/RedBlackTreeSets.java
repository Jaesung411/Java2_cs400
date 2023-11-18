import java.util.Random;

public class RedBlackTreeSets extends RedBlackTree<IGame>implements IRedBlackTreeSortedSets<IGame>{

	//method that return game according to the given rank
	@Override
	public IGame get(int rank) {
		Node<IGame> current = root;
		IGame returnNode = searchHelper(current, rank);
		return returnNode;
	}
	
	private IGame searchHelper(Node<IGame> newNode, int rank) {
		if(newNode.data.getRank() == rank) {
			return newNode.data;
		}else if(newNode.data.getRank() < rank) {
			 return searchHelper(newNode.rightChild, rank);
		}else {
			return searchHelper(newNode.leftChild, rank);
		}
		
	}
	
	 public IGame getRandom()
	    {
		int r = new Random().nextInt(size);
		int count = 0;
		for(IGame game : this)
		{
		    if(count++ == r)
			return game;
		}
		return null;
	    }


}
