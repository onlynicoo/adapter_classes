public interface HList extends HCollection
{   
   /**
   * Inserts the specified element at the specified position in this list. Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
   * @param index index at which the specified element is to be inserted.
   * @param element element to be inserted. 
   * @throws NullPointerException if the specified element is null.
   * @throws IndexOutOfBoundsException if the index is out of range.
   */
   void add(int index, Object element);
   
   /**
   * Appends the specified element to the end of this list.
   * @param o element to be appended to this list.
   * @return true 
   * @throws NullPointerException if the specified element is null.
   */
   boolean add(Object o);
   
   /**
   * Appends all of the elements in the specified collection to the end of this list, in the order that they are returned by the specified collection's iterator. Returns true if this list changed as a result of the call.
   * @param c collection whose elements are to be added to this list. 
   * @retrun true if this list changed as a result of the call.  
   * @throws NullPointerException if the specified collection is null.
   */
   boolean addAll(HCollection c);
   
   /**
   * Inserts all of the elements in the specified collection into this list at the specified position. Shifts the element currently at that position (if any) and any subsequent elements to the right (increases their indices). The new elements will appear in this list in the order that they are returned by the specified collection's iterator. Returns true if this list changed as a result of the call. 
   * @param index index at which to insert first element from the specified collection.
   * @param c elements to be inserted into this list. 
   * @return true if this list changed as a result of the call. 
   * @throws NullPointerException if the specified collection is null.
   * @throws IndexOutOfBoundsException if the index is out of range.
   */
   boolean addAll(int index, HCollection c);
   
   /**
   * Removes all of the elements from this list.
   */
   void clear();
   
   /**
   * Returns true if this list contains the specified element.
   * @param o element whose presence in this list is to be tested.
   * @return true if this list contains the specified element. 
   * @throws NullPointerException if the specified element is null.
   */
   boolean contains(Object o);

   /**
   * Returns true if this list contains all of the elements of the specified collection.
   * @param c collection to be checked for containment in this list. 
   * @return true if this list contains all of the elements of the specified collection. 
   * @throws NullPointerException if the specified collection is null.
   */
   boolean containsAll​(HCollection c);

   /**
   * Compares the specified object with this list for equality. Returns true if and only if the specified object is also a list, both lists have the same size, and all corresponding pairs of elements in the two lists are equal. 
   * @param o the object to be compared for equality with this list. 
   * @return true if the specified object is equal to this list.
   * @throws NullPointerException if the specified collection is null.
   */
   boolean equals​(Object o);
   
   /**
   * Returns the element at the specified position in this list.
   * @param index index of element to return.
   * @return the element at the specified position in this list. 
   * @throws IndexOutOfBoundsException if the index is out of range.
   */
   Object get(int index);
	
   /**
   * Returns the hash code value for this list.
   * @return the hash code value for this list.
   */
   int hashCode​();
   
   /**
   * Returns the index in this list of the first occurrence of the specified element, or -1 if this list does not contain this element.
   * @param o element to search for.
   * @return the index in this list of the first occurrence of the specified element, or -1 if this list does not contain this element. 
   * @throws NullPointerException if the specified collection is null.
   */
   int indexOf(Object o);
	
   /**
   * Returns true if this list contains no elements.
   * @return true if this list contains no elements.
   */
   boolean isEmpty​();
	
   /**
   * Returns an iterator over the elements in this list in proper sequence.
   * @return an iterator over the elements in this list in proper sequence.
   */
   HIterator iterator​();
   
   /**
   * Returns the index in this list of the last occurrence of the specified element, or -1 if this list does not contain this element.
   * @param o element to search for. 
   * @return the index in this list of the last occurrence of the specified element, or -1 if this list does not contain this element. 
   * @throws NullPointerException if the specified element is null.
   */
   int lastIndexOf(Object o);
   
   /**
   * Returns a list iterator of the elements in this list in proper sequence.
   * @return a list iterator of the elements in this list (in proper sequence).
   */
   HListIterator listIterator​();
   
   /**
   * Returns an iterator of the elements in this list in proper sequence, starting at the specified position in this list.
   * @param index index of first element to be returned from the list iterator (by a call to the next method). 
   * @return a list iterator of the elements in this list (in proper sequence), starting at the specified position in this list. 
   * @throws IndexOutOfBoundsException if the index is out of range.
   */
   HListIterator listIterator​(int index);
   
   /**
   * Removes the element at the specified position in this list. Shifts any subsequent elements to the left (subtracts one from their indices). Returns the element that was removed from the list. 
   * @param index the index of the element to removed.
   * @return the element previously at the specified position. 
   * @throws IndexOutOfBoundsException if the index is out of range.
   */
   Object remove(int index);
	
   /**
   * Removes the first occurence in this list of the specified element. Returns true if this list contained the specified element. 
   * @param o element to be removed from this list, if present.
   * @return true if this list contained the specified element. 
   * @throws NullPointerException if the specified element is null.
   */
   boolean remove(Object o);
   
   /**
   * Removes from this list all the elements that are contained in the specified collection. Returns true if this list changed as a result of the call. 
   * @param c collection that defines which elements will be removed from this list. 
   * @return true if this list changed as a result of the call. 
   * @throws NullPointerException if the specified collection is null.
   */
   boolean removeAll​(HCollection c);
	
   /**
   * Retains only the elements in this list that are contained in the specified collection. Returns true if this list changed as a result of the call. 
   * @param c collection that defines which elements this set will retain.
   * @return true if this list changed as a result of the call. 
   * @throws NullPointerException if the specified collection is null.
   */
   boolean retainAll​(HCollection c);
   
   /**
   * Replaces the element at the specified position in this list with the specified element. Returns the element previously at the specified position.
   * @param index index of element to replace.
   * @param element element to be stored at the specified position. 
   * @return the element previously at the specified position.
   * @throws NullPointerException if the specified element is null.
   * @throws IndexOutOfBoundsException if the index is out of range. 
   */
   Object set(int index, Object element);
	
   /**
   * Returns the number of elements in this list. If this list contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE. 
   * @return the number of elements in this list.
   */
   int size();
   
   /**
   * Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive. (If fromIndex and toIndex are equal, the returned list is empty.) The returned list is backed by this list, so non-structural changes in the returned list are reflected in this list, and vice-versa. The returned list supports all of the optional list operations supported by this list.
   * @param fromIndex low endpoint (inclusive) of the subList.
   * @param toIndex high endpoint (exclusive) of the subList. 
   * @return a view of the specified range within this list. 
   * @throws IndexOutOfBoundsException for an illegal endpoint index value.
   */
   HList subList(int fromIndex, int toIndex);
		
   /**
   * Returns an array containing all of the elements in this list in proper sequence. The returned array will be "safe" in that no references to it are maintained by this collection. (In other words, this method must allocate a new array even if this collection is backed by an array). The caller is thus free to modify the returned array.
   * @return an array containing all of the elements in this list in proper sequence.
   */
   Object[] toArray();
   
   /**
   * Returns an array containing all of the elements in this list in proper sequence; the runtime type of the returned array is that of the specified array. If the list fits in the specified array, it is returned therein. Otherwise, a new array is allocated with the runtime type of the specified array and the size of this list. If this list fits in the specified array with room to spare, the element in the array immediately following the end of the list is set to null. 
   * @param a the array into which the elements of this list are to be stored, if it is big enough; otherwise, a new array of the same runtime type is allocated for this purpose. 
   * @return an array containing the elements of this list. 
   * @throws NullPointerException if the specified array is null.
   */
   Object[] toArray​(Object[] a);  
}
