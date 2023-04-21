public interface HCollection
{   
   /**
   * Ensures that this collection contains the specified element. Returns true if this collection changed as a result of the call. The collection permits duplicates.
   * @param o element whose presence in this collection is to be ensured.
   * @return true if this collection changed as a result of the call. 
   * @throws NullPointerException if the specified element is null.
   */
   boolean add(Object o);
   
   /**
   * Adds all of the elements in the specified collection to this collection. Returns true if this collection changed as a result of the call.
   * @param c elements to be inserted into this collection.
   * @return true if this collection changed as a result of the call.
   * @throws NullPointerException if the specified collection is null.
   */
   boolean addAll(HCollection c);
   
   /**
   * Removes all of the elements from this collection.
   */
   void clear();
   
   /**
   * Returns true if this collection contains the specified element.
   * @param o element whose presence in this collection is to be tested. 
   * @return true if this collection contains the specified element.
   * @throws NullPointerException if the specified element is null.
   */
   boolean contains(Object o);

   /**
   * Returns true if this collection contains all of the elements in the specified collection.
   * @param c collection to be checked for containment in this collection.
   * @return true if this collection contains all of the elements in the specified collection. 
   * @throws NullPointerException if the specified collection is null. 
   */
   boolean containsAll​(HCollection c);

   /**
   * Compares the specified object with this collection for equality. Two collections are equals if they have the same size and contain the same elements.
   * @para o Object to be compared for equality with this collection. 
   * @return true if the specified object is equal to this collection.
   * @throws NullPointerException if the specified element is null.
   */
   boolean equals​(Object o);
	
   /**
   * Returns the hash code value for this collection.
   * @return the hash code value for this collection.
   */
   int hashCode​();
	
   /**
   * Returns true if this collection contains no elements.
   * @return true if this collection contains no elements.
   */
   boolean isEmpty​();
	
   /**
   * Returns an iterator over the elements in this collection.
   * @return an Iterator over the elements in this collection.
   */
   HIterator iterator​();
	
    /**
   * Removes a single instance of the specified element from this collection, if it is present. Returns true if this collection contained the specified element (or equivalently, if this collection changed as a result of the call).
   * @param o element to be removed from this collection, if present. 
   * @return true if this collection changed as a result of the call. 
   * @throws NullPointerException if the specified element is null.
   */
   boolean remove(Object o);
   
   /**
   * Removes all this collection's elements that are also contained in the specified collection. After this call returns, this collection will contain no elements in common with the specified collection. Returns true if this collection changed as a result of the call. 
   * @param c elements to be removed from this collection. 
   * @return true if this collection changed as a result of the call
   * @throws NullPointerException if the specified collection is null.
   */
   boolean removeAll​(HCollection c);
	
   /**
   * Retains only the elements in this collection that are contained in the specified collection. In other words, removes from this collection all of its elements that are not contained in the specified collection.
   * @param c elements to be retained in this collection. 
   * @return true if this collection changed as a result of the call.
   * @throws NullPointerException if the specified collection is null. 
   */
   boolean retainAll​(HCollection c);
	
   /**
   * Returns the number of elements in this collection. If this collection contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE. 
   * @return the number of elements in this collection.
   */
   int size();
		
   /**
   * Returns an array containing all of the elements in this collection. 
   * @return an array containing all of the elements in this collection.
   */
   Object[] toArray();
   
   /**
   * Returns an array containing all of the elements in this collection; the runtime type of the returned array is that of the specified array. If the collection fits in the specified array, it is returned therein. Otherwise, a new array is allocated with the runtime type of the specified array and the size of this collection. If this collection fits in the specified array with room to spare, the element in the array immediately following the end of the collection is set to null.
   * @param a the array into which the elements of this collection are to be stored, if it is big enough; otherwise, a new array of the same runtime type is allocated for this purpose. 
   * @return an array containing the elements of this collection.
   * @throws NullPointerException if the specified array is null.
   */
   Object[] toArray​(Object[] a);  
}
