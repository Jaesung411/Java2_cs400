/**
 * This class is implemented by a RedBlackTree that stores a list of games
 * These lists of games are sorted according to the compareTo() defined within the gameType
 */
public interface IRedBlackTreeSortedSets<T extends Comparable<T>> extends SortedCollectionInterface<T> {

	//method that return game according to the given rank
	public Object get(int rank);

}