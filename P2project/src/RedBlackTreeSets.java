
public class RedBlackTreeSets <T extends Comparable<T>> extends RedBlackTree<T> implements IRedBlackTreeSortedSets<T>{

	//method that return game according to the given rank
	@Override
	public Object get(int rank) {
		Node<T> current = root;
		Object returnNode = searchHelper(current, rank);
		return returnNode;
	}
	
	private Object searchHelper(Node<T> newNode, int rank) {
		if(newNode.getRank() == rank) {
			return newNode;
		}else if(newNode.getRank() < rank) {
			 return searchHelper(newNode.rightChild, rank);
		}else {
			return searchHelper(newNode.leftChild, rank);
		}
		
	}

//	@Override
//	public Object get(T game) {
//		Node<T> current = root;
//		if(this.contains(game)) {
//			
//			while(!current.data.equals(game)) {
//				
//				if(current.data.compareTo(game)>0) {
//					
//					current = current.leftChild;
//					
//				}else if(current.data.compareTo(game)<0) {
//					current = current.rightChild;
//				}
//				
//			}
//		}else {
//			return null;
//		}
//		return current;
//	}
	
}
