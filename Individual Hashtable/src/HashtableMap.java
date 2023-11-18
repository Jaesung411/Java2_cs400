// --== CS400 Project One File Header ==--
// Name: Jaesung Lim
// CSL Username: jaesung
// Email: jlim83@wisc.edu
// Lecture #: <001 @11:00am>
// Notes to Grader: <any optional extra notes to your grader>
import java.util.NoSuchElementException;
import java.util.LinkedList;
 
/**
 * this class HashtableMap implements hashtable using the provide MapADT interface
 * 
 * @author Jaesung Lim
 *
 * @param <KeyType> The generic generic type of key 
 * @param <ValueType> The generic generic type of value
 */
public class HashtableMap<KeyType,ValueType> implements MapADT<KeyType, ValueType> {
	
	protected LinkedList<HashNode>[] hashtable; // hashtable
	private int size; //the number of current key-value pairs in the hashtable
	private int capacity; //the number of the maximum key-value pairs in the hashtable
	private double loadStandard = 0.75; //the standard of load factor doubling its capacity and rehashing 
	
	/*
	 * Helper class to make a group with a key-value pair
	 */
	public class HashNode{
		
		private KeyType key;
		private ValueType value;
		
		/**
		 * the constructor make a key-value pair
		 * 
		 * @param key a key of the key-value pair
		 * @param value a value of the key-value pair
		 */
		public HashNode(KeyType key , ValueType value) {
			this.key = key;
			this.value = value;
		}
		
		/**
		 * this method helps the test
		 * @return Key the key of the HashNode
		 */
		public KeyType getKey() {
			return key;
		}
		
	}
	
	/**
	 * the constructor make a hashtable with the given capacity
	 * 
	 * @param capacity the number of the maximum key-value pairs in the hashtable
	 */
	@SuppressWarnings("unchecked")
	public HashtableMap(int capacity) {
		
		hashtable = new LinkedList[capacity];
		size = 0;
		this.capacity = capacity;
		
	}
	
	/**
	 * the constructor make a hashtable which can store 20 key-value pairs
	 */
	@SuppressWarnings("unchecked")
	public HashtableMap() {
		hashtable = new LinkedList[20];
		size = 0;
		capacity = 20;
	}
	
	/**
	 * the method put the given key-value pair in the hashtable
	 * 
	 * @param key a key of the key-value pair
	 * @param value a value of the key-value pair
	 * @return true if successfully storing a new key-value pair.
	 * 		   false if the key that is null or is equal to a key that is already stored
	 */
	@Override
	public boolean put(KeyType key, ValueType value) {
		
		int index = Math.abs(key.hashCode())%capacity;
		
		if(containsKey(key)||key==null) {
			return false;
		}else {
			if(hashtable[index]==null) {
				hashtable[index] = new LinkedList<>(); 
			}
			hashtable[index].add(new HashNode(key,value));
			size++;
			
			double loadFactor = (double) size / capacity;
			
			if(loadFactor >= loadStandard) {
				rehashing();
			}
			
			return true;
		}
		
		
	}
	
	/**
	 * helper method make the hashtable double its capacity and rehashing
	 */
	@SuppressWarnings("unchecked")
	private void rehashing() {
		
		int newCapacity = capacity * 2;
		LinkedList<HashNode>[] newHashtable = new LinkedList[newCapacity];
		for(int i = 0; i < capacity; i++) {
			if(hashtable[i]!=null) {
				for(int j = 0; j < hashtable[i].size(); j++) {
					HashNode addedNode = hashtable[i].get(j);
					int newIndex = Math.abs(addedNode.key.hashCode())%newCapacity;
					if(newHashtable[newIndex]==null) {
						newHashtable[newIndex] = new LinkedList<>();
					}
					newHashtable[newIndex].add(addedNode);
				}
			}
		}
		
		this.capacity = newCapacity;
		this.hashtable = newHashtable;
		
	}
	
	/**
	 * this method return value corresponding to the given key
	 * 
	 * @param key the given key
	 * @return the value corresponding to the given key
	 * @throws NoSuchElementException when there is not the given key in the hashtable
	 */
	@Override
	public ValueType get(KeyType key) throws NoSuchElementException {
		
		int index = Math.abs(key.hashCode())%capacity;
		
		if(!containsKey(key)) {
			throw new NoSuchElementException();
		}
		for(int i = 0; i < hashtable[index].size(); i++) {
			if(hashtable[index].get(i).key.equals(key)) {
				return (ValueType) hashtable[index].get(i).value;
			}
		}
		return null;
	}
	
	/**
	 * this method return the number of current key-value pairs in the hashtable
	 * 
	 * @return the number of current key-value pairs in the hashtable
	 */
	@Override
	public int size() {
		return this.size;
	}
	
	/**
	 * this method check if the given key is included in the hashtable
	 * 
	 * @return true if the given key is included in the hashtable, otherwise false
	 */
	@Override
	public boolean containsKey(Object key) {
		
		int index = Math.abs(key.hashCode())%capacity;
		
		if(hashtable[index]==null) {
			return false;
		}
		for(int i = 0; i < hashtable[index].size(); i++) {
			if(hashtable[index].get(i).key.equals(key)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * this method remove the key-value pair corresponding to the given key and return the removing value
	 * 
	 * @param key the given key
	 * @return the removing value
	 */
	@Override
	public ValueType remove(KeyType key) {
		
		int index = Math.abs(key.hashCode())%capacity;
		
		if(!containsKey(key)) {
			return null;
		}else {
			for(int i = 0; i < hashtable[index].size(); i++) {
				if(hashtable[index].get(i).key.equals(key)) {
					size--;
					return (ValueType) hashtable[index].remove(i).value;
				}
			}
		}
		
		return null;
	}
	
	/**
	 * this method remove all the key-value pairs in the hashtable
	 */
	@Override
	public void clear() {
		
		for(int i = 0; i < hashtable.length; i++) {
			hashtable[i] = null;
		}
		
		size = 0;
		capacity = hashtable.length;
		
	}
	
}


