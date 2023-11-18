import java.util.*;

public class HashTableSortedSets<KeyType, ValueType extends Comparable<ValueType>> extends HashtableMap<KeyType, List<ValueType>> implements IHashTableSortedSets<KeyType, ValueType> {

  private HashtableMap<KeyType, ArrayList<ValueType>> map;
  ArrayList<ValueType> lis;

  HashTableSortedSets() {
	  super();
//    map = new HashtableMap<KeyType, ArrayList<ValueType>>();
    lis = null;
  }

  /**
   * This add method is different from the put() method in that it appends a
   * single value to the end of the list associated with a given key.  If a
   * key does not yet have a list of values associated with it, then a new
   * one will be created when this method is called.
   *
   * @param key   used to later lookup the list containing this value
   * @param value associated with the previous key
   */

  // previous value was an int
  // now value is list
  // node: list of value
  @Override
  public void add(KeyType key, ValueType value) {

    if (!(containsKey(key))) {
      lis = new ArrayList<ValueType>();  // create new ArrayList
      lis.add(value);                    // add value to that list
      map.put(key, lis);                 // put list in map
      size++;
    }
    // look for key in HashMap (find node that contains the key)
    // add value to list in that node
    else {
      int bucket = getHashCode(key); // bucket is index of array (location of key)
      ListNode list = table[bucket]; // for traversing the linked list at appropriate location

      while (list != null) {
        if (list.key.equals(key)) {
          lis.add(value);
//          lis.sort(compareTo(ValueType));
          size++;
        }
      }

      // gets list of value
/*  @Override
  public ArrayList<ValueType> get(KeyType key) throws NoSuchElementException {

    if (!map.containsKey(key)) {
      throw new NoSuchElementException("Key is not in the hashtable!");
    }

    return map.get(key);

  }*/

    }
  }
}