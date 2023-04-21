public interface HIterator
{  
  /**
  * Returns true if the iteration has more elements.
  * @return true if the iterator has more elements.
  */
  boolean hasNext();
          
  /**
  * Returns the next element in the iteration.
  * @return the next element in the iteration
  * @throws NoSuchElementException if iteration has no more elements.
  */
  Object next();
  
  /**
  * Removes from the underlying collection the last element returned by this iterator.
  * @throws IllegalStateException if the next method has not yet been called, or the remove method has already been called after the last call to the next method.
  */
  void remove();
}
