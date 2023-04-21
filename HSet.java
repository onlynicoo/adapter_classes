public interface HSet extends HCollection
{   
   /**
   * Adds the specified element to this set if it is not already present. If this set already contains the specified element, the call leaves this set unchanged and returns false. 
   * @param o element to be added to this set. 
   * @return true if this set did not already contain the specified element. 
   * @throws NullPointerException if the specified element is null
   */
   boolean add(Object o);
   
   /**
   * Adds all of the elements in the specified collection to this set if they're not already present. Returns true if this set changed as a result of the call.
   * @param c collection whose elements are to be added to this set.
   * @return true if this set changed as a result of the call. 
   * @throws NullPointerException if the specified collection is null
   */
   boolean addAll(HCollection c);
   
   /**
   * Removes all of the elements from this set.
   */
   void clear();
   
   /**
   * Returns true if this set contains the specified element.
   * @param o element whose presence in this set is to be tested. 
   * @return true if this set contains the specified element. 
   * @throws NullPointerException if the specified element is null
   */
   boolean contains(Object o);

   /**
   * Returns true if this set contains all of the elements of the specified collection.
   * @param c collection to be checked for containment in this set.
   * @return true if this set contains all of the elements of the specified collection. 
   * @throws NullPointerException if the specified collection is null
   */
   boolean containsAll​(HCollection c);

   /**
   * Compares the specified object with this set for equality. Returns true if the specified object is also a set, the two sets have the same size, and every member of the specified set is contained in this set.
   * @param o Object to be compared for equality with this set. 
   * @return true if the specified Object is equal to this set.
   * @throws NullPointerException if the specified element is null
   */
   boolean equals​(Object o);
	
   /**
   * Returns the hash code value for this set. The hash code of a set is defined to be the sum of the hash codes of the elements in the set.
   * @return the hash code value for this set.
   */
   int hashCode​();
	
   /**
   * Returns true if this set contains no elements.
   * @return true if this set contains no elements.
   */
   boolean isEmpty​();
	
   /**
   * Returns an iterator over the elements in this set. The elements are returned in no particular order.
   * @return an iterator over the elements in this set.
   */
   HIterator iterator​();
	
   /**
   * Removes the specified element from this set if it is present. Returns true if the set contained the specified element.
   * @param o object to be removed from this set, if present. 
   * @return true if the set contained the specified element. 
   * @throws NullPointerException if the specified element is null
   */
   boolean remove(Object o);
   
   /**
   * Removes from this set all of its elements that are contained in the specified collection. Returns true if this set changed as a result of the call.
   * @param c collection that defines which elements will be removed from this set. 
   * @return true if this set changed as a result of the call. 
   * @throws NullPointerException if the specified collection is null
   */
   boolean removeAll​(HCollection c);
	
   /**
   * Retains only the elements in this set that are contained in the specified collection. Returns true if this set changed as a result of the call.
   * @param c collection that defines which elements this set will retain. 
   * @return true if this collection changed as a result of the call.
   * @throws NullPointerException if the specified collection is null
   */
   boolean retainAll​(HCollection c);
	
   /**
   * Returns the number of elements in this set (its cardinality). If this set contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE. 
   * @return the number of elements in this set (its cardinality).
   */
   int size();
		
   /**
   * Returns an array containing all of the elements in this set.
   * @return an array containing all of the elements in this set.
   */
   Object[] toArray();
   
   /**
   * Returns an array containing all of the elements in this set; the runtime type of the returned array is that of the specified array. If the set fits in the specified array, it is returned therein. Otherwise, a new array is allocated with the runtime type of the specified array and the size of this set. If this collection fits in the specified array with room to spare, the element in the array immediately following the end of the set is set to null. 
   * @param a the array into which the elements of this set are to be stored, if it is big enough; otherwise, a new array of the same runtime type is allocated for this purpose. 
   * @return an array containing the elements of this set. 
   * @throws ArrayStoreException if the runtime type of a is not a supertype of the runtime type of every element in this set. 
   * @throws NullPointerException if the specified array is null.
   */
   Object[] toArray​(Object[] a);   
}
