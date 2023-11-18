// --== CS400 Project One File Header ==--
// Name: Kusum Gautam
// CSL Username: kusum
// Email: kgautam3@wisc.edu
// Lecture #: 001 @11:00am
// Notes to Grader: <any optional extra notes to your grader>

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * This class is an implementation of a hash table.
 * A hash table is used to get, add, and remove an
 * element in constant time.
 */
public class HashtableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType> {
  // hash table represented a an array of linked lists
  protected ListNode<KeyType, ValueType>[] table;

  public int capacity;
  public int size;

  /**
   * Create a hash table with given capacity
   *
   * @param capacity
   */
  public HashtableMap(int capacity) {
    this.capacity = capacity;
    this.size = 0;
    table = new ListNode[capacity];

  }

  /**
   * Create a hash table with default capacity of 20
   */
  public HashtableMap() {
    this.capacity = 20;
    this.size = 0;
    table = new ListNode[capacity];
  }

  /**
   * Puts a new key value pair into the Hash Table.
   * If null or already existing key is present, returns false.
   *
   * @param key   key
   * @param value value
   * @return true if key value pair is successfully added
   */
  @Override
  public boolean put(KeyType key, ValueType value) {
    if (key == null) {
      return false;
    }

    int bucket = getHashCode(key); // bucket is index of array (location of key)
    ListNode list = table[bucket]; // for traversing the linked list at appropriate location

    while (list != null) {
      // search nodes in list to see if it already exists
      if (list.key.equals(key)) {
        return false;
      }
      list = list.next;
    }

    if (list != null) {
      list.value = value;
    } else {
      // insert new key value pair at front of list
      ListNode newNode = new ListNode();
      newNode.key = key;
      newNode.value = value;
      newNode.next = table[bucket];
      table[bucket] = newNode;
      size++;
      // because list is null, key isn't already in list
      // add new node (that contains key and value) at head of list
      if (size >= (0.75 * capacity)) {
        // rehash whenever the load factor >= 75%
        rehash();
        bucket = getHashCode(key); // since hash code depends on table size, recompute it with new capacity
      }
    }
    return true;
  }

  /**
   * Gets the Value corresponding to the key
   *
   * @param key key
   * @return value of the specified key
   * @throws NoSuchElementException if key is not in Hashtable
   */
  @Override
  public ValueType get(KeyType key) throws NoSuchElementException {
    int bucket = getHashCode(key); // index of array (location) of the key

    ListNode list = table[bucket]; // to traverse list

    while (list != null) {
      // check if key is in the node that the list points to
      if (list.key.equals(key)) {
        return (ValueType) list.value;
      }
      list = list.next; // move to next node is current node doesn't have key
    }

    // at this point, have looked through every node in list
    // throw exception
    throw new NoSuchElementException("Key is not in the hashtable!");
  }

  /**
   * @return size of the Hash Table
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Checks if the key is present in the Hashtable
   *
   * @param key key
   * @return true if key exists in Hashtable
   */
  @Override
  public boolean containsKey(KeyType key) {
    int bucket = getHashCode(key); // index of array (location) of the key

    ListNode list = table[bucket]; // to traverse the list

    while (list != null) {
      if (list.key.equals(key)) {
        return true;
      }
      list = list.next;  // moves to check next node
    }

    // at this point, key does not exist in hash table
    return false;
  }

  /**
   * Removes the key value pair
   * If key not found, return null
   *
   * @param key
   * @return reference to value associated with key being removed
   */
  @Override
  public ValueType remove(KeyType key) {
    int bucket = getHashCode(key); // index of array (location) of the key

    if (table[bucket] == null) {   // means key not found in that location
      return null;
    }

    // remove first node on the list
    if (table[bucket].key.equals(key)) {
      // if key is the head node of list, table[bucket] has to change to get rid of first node
      ValueType temp = (ValueType) table[bucket].value;  // store value of ValueType to be removed to return later
      table[bucket] = table[bucket].next;
      size--;
      return temp;
    }

    // remove node from somewhere in middle / end of list
    ListNode previous = table[bucket];
    ListNode current = previous.next; // to traverse the list

    while (current != null && !current.key.equals(key)) {
      current = current.next;
      previous = current;
    }

    if (current != null) {
      previous.next = current.next;
      size--;
    }

    return null;
  }

  /**
   * Clears the Hash table
   */
  @Override
  public void clear() {
    // traverse through capacity number of table
    // if table at index i (bucket i) is not null, set it to null

    for (int i = 0; i < capacity; i++) {
      if (table[i] != null) {
        table[i] = null;
      }
    }
    size = 0;
  }


  // Helper Functions

  /**
   * gets hash code corresponding to a key
   *
   * @param key
   * @return hash code of a key
   */
  protected int getHashCode(KeyType key) {
    return (Math.abs(key.hashCode())) % capacity;
  }

  /**
   * implements hash function to find the index number
   * corresponding to a key
   *
   * @param key
   * @return index number
   */
  protected int getBucketIndex(KeyType key) {
    int hashCode = getHashCode(key);
    int index = hashCode % capacity;
    // key.hashCode() could be negative
    index = index < 0 ? index * -1 : index;  // if index < 0, set index to index * -1, else leave it alone
    return index;
  }

  protected void rehash() {
    ListNode[] newTable = new ListNode[capacity * 2]; // double capacity

    for (int i = 0; i < capacity; i++) {
      ListNode list = table[i];
      while (list != null) {
        ListNode next = list.next;
        int hash = (Math.abs(list.key.hashCode())) % capacity;
        list.next = newTable[hash];
        list = next;
      }
    }
    table = newTable; // replace table with new table
  }

}