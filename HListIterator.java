public interface HListIterator extends HIterator
{
  /**
  * Inserts the specified element into the list. The element is inserted immediately before the next element that would be returned by next, if any, and after the next element that would be returned by previous, if any. (If the list contains no elements, the new element becomes the sole element on the list.) The new element is inserted before the implicit cursor: a subsequent call to next would be unaffected, and a subsequent call to previous would return the new element. (This call increases by one the value that would be returned by a call to nextIndex or previousIndex.) 
  * @param o the element to insert. 
  * @throws NullPointerException if the specified element is null
  */
  void add(Object o);
  
  /**
  * Returns true if this list iterator has more elements when traversing the list in the forward direction.
  * @return true if the list iterator has more elements when traversing the list in the forward direction.
  */
  boolean hasNext();
  
  /**
  * Returns true if this list iterator has more elements when traversing the list in the reverse direction.
  * @return true if the list iterator has more elements when traversing the list in the reverse direction.
  */
  boolean hasPrevious();
          
  /**
  * Returns the next element in the list.
  * @return the next element in the list. 
  */
  Object next();
  
  /**
  * Returns the index of the element that would be returned by a subsequent call to next. Returns list size if the list iterator is at the end of the list.
  * @return the index of the element that would be returned by a subsequent call to next, or list size if list iterator is at end of list.
  */
  int nextIndex();
  
  /**
  * Returns the previous element in the list.
  * @return the previous element in the list. 
  */         
  Object previous();
  
  /**
  * Returns the index of the element that would be returned by a subsequent call to previous. Returns -1 if the list iterator is at the beginning of the list.
  * @return the index of the element that would be returned by a subsequent call to previous, or -1 if list iterator is at beginning of list.
  */        
  int previousIndex();
   
  /**
  * Removes from the list the last element that was returned by next or previous. This call can only be made once per call to next or previous. It can be made only if add has not been called after the last call to next or previous. 
  * @throws IllegalStateException if neither next nor previous have been called, or remove or add have been called after the last call to next or previous.
  */
  void remove();
  
  /**
  * Replaces the last element returned by next or previous with the specified element. This call can be made only if neither ListIterator.remove nor ListIterator.add have been called after the last call to next or previous.
  * @throws IllegalStateException if neither next nor previous have been called, or remove or add have been called after the last call to next or previous. 
  * @param o the element with which to replace the last element returned by next or previous.
  * @throws NullPointerException if the specified element is null
  */
  void set(Object o);          
}
