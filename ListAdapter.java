import java.util.Vector;
import java.util.NoSuchElementException;
/**
* ListAdapter is an ordered collection. The user of this interface has precise control over where in the list each element is inserted. The user can access elements by their integer index (position in the list), and search for elements in the list. It allows duplicate elements.
It provides four methods for positional (indexed) access to list elements. It is zero based. ListAdapter provides a special iterator, called a HListIterator, that allows element insertion and replacement, and bidirectional access in addition to the normal operations that the HIterator interface provides. A method is provided to obtain a list iterator that starts at a specified position in the list. ListAdapter provides two methods to search for a specified object. ListAdapter provides two methods to efficiently insert and remove multiple elements at an arbitrary point in the list. It prohibits null elements. Attempting an operation with a null parameter throws NullPointerException. 
*/
public class ListAdapter 
implements HList
{
   private Vector vc = new Vector();
   
   /**
   * Inserts the specified element at the specified position in this list. Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
   * @param index index at which the specified element is to be inserted.
   * @param element element to be inserted. 
   * @throws NullPointerException if the specified element is null.
   * @throws IndexOutOfBoundsException if the index is out of range.
   */
   @Override
   public void add(int index, Object element)
   {
      if(element == null)
       throw new NullPointerException();
      if(index < 0 || index > size())
       throw new IndexOutOfBoundsException();
      vc.insertElementAt(element, index);      
   }
   
   /**
   * Appends the specified element to the end of this list.
   * @param o element to be appended to this list.
   * @return true 
   * @throws NullPointerException if the specified element is null.
   */
   @Override
   public boolean add(Object o)
   {
      if(o == null)
       throw new NullPointerException();
      vc.addElement(o);
      return true;
   }
   
   /**
   * Appends all of the elements in the specified collection to the end of this list, in the order that they are returned by the specified collection's iterator. Returns true if this list changed as a result of the call.
   * @param c collection whose elements are to be added to this list. 
   * @retrun true if this list changed as a result of the call.  
   * @throws NullPointerException if the specified collection is null.
   */
   @Override
   public boolean addAll(HCollection c)
   {
      if(c == null)
       throw new NullPointerException();
      HIterator iter = c.iterator();
      while(iter.hasNext())
      {
         add(iter.next());
      }
      if(c.size() > 0)
       return true;
      return false;
   }
   
   /**
   * Inserts all of the elements in the specified collection into this list at the specified position. Shifts the element currently at that position (if any) and any subsequent elements to the right (increases their indices). The new elements will appear in this list in the order that they are returned by the specified collection's iterator. Returns true if this list changed as a result of the call. 
   * @param index index at which to insert first element from the specified collection.
   * @param c elements to be inserted into this list. 
   * @return true if this list changed as a result of the call. 
   * @throws NullPointerException if the specified collection is null.
   * @throws IndexOutOfBoundsException if the index is out of range.
   */
   @Override
   public boolean addAll(int index, HCollection c)
   {
      if(c == null)
       throw new NullPointerException();
      if(index < 0 || index > size())
       throw new IndexOutOfBoundsException();
      HIterator iter = c.iterator();
      while(iter.hasNext())
      {
         add(index,iter.next());
         index++;
      }
      if(c.size() > 0)
       return true;
      return false;
   }
   
   /**
   * Removes all of the elements from this list.
   */
   @Override
   public void clear()
   {
      if(!isEmpty())
       vc.removeAllElements();
   }
   
   /**
   * Returns true if this list contains the specified element.
   * @param o element whose presence in this list is to be tested.
   * @return true if this list contains the specified element. 
   * @throws NullPointerException if the specified element is null.
   */
   @Override
   public boolean contains(Object o)
   {
      if(o == null)
       throw new NullPointerException();
      return vc.contains(o);
   }

   /**
   * Returns true if this list contains all of the elements of the specified collection.
   * @param c collection to be checked for containment in this list. 
   * @return true if this list contains all of the elements of the specified collection. 
   * @throws NullPointerException if the specified collection is null.
   */
   @Override
   public boolean containsAll​(HCollection c)
   {
      if(c == null)
       throw new NullPointerException();
      HIterator iter = c.iterator();
      while(iter.hasNext())
      {
         if(!contains(iter.next()))
          return false;
      }
      return true;
   }

   /**
   * Compares the specified object with this list for equality. Returns true if and only if the specified object is also a list, both lists have the same size, and all corresponding pairs of elements in the two lists are equal. 
   * @param o the object to be compared for equality with this list. 
   * @return true if the specified object is equal to this list.
   * @throws NullPointerException if the specified collection is null.
   */
   @Override
   public boolean equals​(Object o)
   {
       if(o==null)
	 throw new NullPointerException();
       HList list = null;
       try
       {
          list = (HList)o;
       }
       catch(ClassCastException cce)
       {
	  return false;
       }
       if(size()==list.size())
       {
          for(int i = 0; i < size(); i++)
          {
             if(!get(i).equals(list.get(i)))
               return false;
          }
          return true;
       }
       return false;
   }
   
   /**
   * Returns the element at the specified position in this list.
   * @param index index of element to return.
   * @return the element at the specified position in this list. 
   * @throws IndexOutOfBoundsException if the index is out of range.
   */
   @Override
   public Object get(int index)
   {
      if(index < 0 || index >= size())
       throw new IndexOutOfBoundsException();
      return vc.elementAt(index);
   }
	
   /**
   * Returns the hash code value for this list.
   * @return the hash code value for this list.
   */
   @Override
   public int hashCode​()
   {
      int hashCode = 1;
      HIterator iter = iterator();
      while(iter.hasNext()) 
      {
         Object obj = iter.next();
         hashCode = 31*hashCode + (obj==null ? 0 : obj.hashCode());
      }
      return hashCode;
   }
   
   /**
   * Returns the index in this list of the first occurrence of the specified element, or -1 if this list does not contain this element.
   * @param o element to search for.
   * @return the index in this list of the first occurrence of the specified element, or -1 if this list does not contain this element. 
   * @throws NullPointerException if the specified collection is null.
   */
   @Override
   public int indexOf(Object o)
   {
      if(o==null)
	throw new NullPointerException();
      return vc.indexOf(o);
   }
	
   /**
   * Returns true if this list contains no elements.
   * @return true if this list contains no elements.
   */
   @Override
   public boolean isEmpty​()
   {
      return vc.isEmpty();
   }
	
   /**
   * Returns an iterator over the elements in this list in proper sequence.
   * @return an iterator over the elements in this list in proper sequence.
   */
   @Override
   public HIterator iterator​()
   {
      return listIterator();
   }
   
   /**
   * Returns the index in this list of the last occurrence of the specified element, or -1 if this list does not contain this element.
   * @param o element to search for. 
   * @return the index in this list of the last occurrence of the specified element, or -1 if this list does not contain this element. 
   * @throws NullPointerException if the specified element is null.
   */  
   @Override
   public int lastIndexOf(Object o)
   {
      if(o==null)
        throw new NullPointerException();
      int i = indexOf(o);
      while(i != -1 && i < size()-1)
      {
         int tmp = vc.indexOf(o, i+1);
         if(tmp != -1)
          i = tmp;
         else
          return i;
      }
      return i;
   }
   
   /**
   * Returns a list iterator of the elements in this list in proper sequence.
   * @return a list iterator of the elements in this list (in proper sequence).
   */
   @Override
   public HListIterator listIterator​()
   {
      return listIterator(0);
   }
   
   /**
   * Returns an iterator of the elements in this list in proper sequence, starting at the specified position in this list.
   * @param index index of first element to be returned from the list iterator (by a call to the next method). 
   * @return a list iterator of the elements in this list (in proper sequence), starting at the specified position in this list. 
   * @throws IndexOutOfBoundsException if the index is out of range.
   */
   @Override
   public HListIterator listIterator​(int index)
   {
      if(index < 0 || index > size())
       throw new IndexOutOfBoundsException();
      return new ListIterator(index);
   }
   
   /**
   * Removes the element at the specified position in this list. Shifts any subsequent elements to the left (subtracts one from their indices). Returns the element that was removed from the list. 
   * @param index the index of the element to removed.
   * @return the element previously at the specified position. 
   * @throws IndexOutOfBoundsException if the index is out of range.
   */
   @Override
   public Object remove(int index)
   {
      if(index < 0 || index >= size())
       throw new IndexOutOfBoundsException();
      Object val = get(index);
      vc.removeElementAt(index);
      return val;
   }
	
   /**
   * Removes the first occurence in this list of the specified element. Returns true if this list contained the specified element. 
   * @param o element to be removed from this list, if present.
   * @return true if this list contained the specified element. 
   * @throws NullPointerException if the specified element is null.
   */
   @Override
   public boolean remove(Object o)
   {
      if(o==null)
       throw new NullPointerException();
      return vc.removeElement(o); 
   }
   
   /**
   * Removes from this list all the elements that are contained in the specified collection. Returns true if this list changed as a result of the call. 
   * @param c collection that defines which elements will be removed from this list. 
   * @return true if this list changed as a result of the call. 
   * @throws NullPointerException if the specified collection is null.
   */
   @Override
   public boolean removeAll​(HCollection c)
   {
      if(c==null)
       throw new NullPointerException();
      HIterator iter = iterator();
      boolean modified = false;      
      while(iter.hasNext())
      {
         Object elem = iter.next();
         if(c.contains(elem))
         {
            iter.remove();
            modified = true;           
         } 
      }
      return modified;
   }
	
   /**
   * Retains only the elements in this list that are contained in the specified collection. Returns true if this list changed as a result of the call. 
   * @param c collection that defines which elements this set will retain.
   * @return true if this list changed as a result of the call. 
   * @throws NullPointerException if the specified collection is null.
   */
   @Override
   public boolean retainAll​(HCollection c)
   {
      if(c==null)
        throw new NullPointerException();
      HIterator iter = iterator();
      boolean modified = false;
      while(iter.hasNext())
      {
         Object elem = iter.next();
         if(!c.contains(elem))
         {
            iter.remove();
            modified = true;           
         }  
      }
      return modified;
   }
   
   /**
   * Replaces the element at the specified position in this list with the specified element. Returns the element previously at the specified position.
   * @param index index of element to replace.
   * @param element element to be stored at the specified position. 
   * @return the element previously at the specified position.
   * @throws NullPointerException if the specified element is null.
   * @throws IndexOutOfBoundsException if the index is out of range. 
   */
   @Override
   public Object set(int index, Object element)
   {
      if(element == null)
       throw new NullPointerException();
      if(index < 0 || index > size())
       throw new IndexOutOfBoundsException();
      Object val = get(index);
      vc.setElementAt(element, index);
      return val;
   }
	
   /**
   * Returns the number of elements in this list. If this list contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE. 
   * @return the number of elements in this list.
   */
   @Override
   public int size()
   {
      int size = vc.size();
      if(size > Integer.MAX_VALUE)
        return Integer.MAX_VALUE;
      return size;
   }
   
   /**
   * Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive. (If fromIndex and toIndex are equal, the returned list is empty.) The returned list is backed by this list, so non-structural changes in the returned list are reflected in this list, and vice-versa. The returned list supports all of the optional list operations supported by this list.
   * @param fromIndex low endpoint (inclusive) of the subList.
   * @param toIndex high endpoint (exclusive) of the subList. 
   * @return a view of the specified range within this list. 
   * @throws IndexOutOfBoundsException for an illegal endpoint index value.
   */
   @Override
   public HList subList(int fromIndex, int toIndex)
   {
      if(fromIndex < 0 || toIndex > size() || fromIndex > toIndex)
       throw new IndexOutOfBoundsException();
      return new SubList(this, fromIndex, toIndex);
   }
		
   /**
   * Returns an array containing all of the elements in this list in proper sequence. The returned array will be "safe" in that no references to it are maintained by this collection. (In other words, this method must allocate a new array even if this collection is backed by an array). The caller is thus free to modify the returned array.
   * @return an array containing all of the elements in this list in proper sequence.
   */
   @Override
   public Object[] toArray()
   {
      Object[] array = new Object[size()];
      for(int i = 0; i < array.length; i++)
      {  
         array[i] = get(i);
      }
      return array;
   }
   
   /**
   * Returns an array containing all of the elements in this list in proper sequence; the runtime type of the returned array is that of the specified array. If the list fits in the specified array, it is returned therein. Otherwise, a new array is allocated with the runtime type of the specified array and the size of this list. If this list fits in the specified array with room to spare, the element in the array immediately following the end of the list is set to null. 
   * @param a the array into which the elements of this list are to be stored, if it is big enough; otherwise, a new array of the same runtime type is allocated for this purpose. 
   * @return an array containing the elements of this list. 
   * @throws NullPointerException if the specified array is null.
   */
   @Override
   public Object[] toArray​(Object[] a)
   {
      if(a==null)
       throw new NullPointerException();
      int size = size();
      if (a.length < size)
        a = new Object[size];
      else if (a.length > size)
        a[size] = null;
      for(int i = 0; i < size; i++)
      {  
         try
         {
            a[i] = get(i);
         }
         catch(ArrayStoreException ase)
         {
            throw new ArrayStoreException();
         }
      }
      return a;
   } 
   
   private class SubList extends ListAdapter
   {
      private HList list = null;
      private int fromIndex;
      private int toIndex;
      public SubList(HList l, int fromI, int toI)
      {
         list = l;
         fromIndex = fromI;
         toIndex = toI;
      }
      public void add(int index, Object element)
      {
         if(element == null)
          throw new NullPointerException();
         if(index < 0 || index > this.size())
          throw new IndexOutOfBoundsException();
         list.add(fromIndex + index, element);
         toIndex++;
      }
      public boolean add(Object o)
      {
         if(o == null)
          throw new NullPointerException();
         add(this.size(), o);
         return true;
      }
      public boolean addAll(HCollection c) 
      {
         return addAll(this.size(), c);
      }

      public boolean addAll(int index, HCollection c) 
      {
         if(c == null)
          throw new NullPointerException();
         if(index < 0 || index > this.size())
          throw new IndexOutOfBoundsException();
         boolean val = list.addAll(fromIndex + index, c);
         toIndex = toIndex + c.size();
         return val;
      }      
      public void clear()
      {
         while(!this.isEmpty())
           this.remove(0);
      }
      public boolean contains(Object o)
      {
         if(o == null)
           throw new NullPointerException();
         for(int i=fromIndex;i<toIndex;i++)
         {
            if(list.get(i).equals(o))
                return true;            
         }
         return false;
      }
      public boolean containsAll​(HCollection c)
      {
         if(c == null)
          throw new NullPointerException();
         HIterator iter = c.iterator();
         while(iter.hasNext())
         {
            if(!contains(iter.next()))
             return false;
         }
         return true;
      }
      public boolean equals​(Object o)
      {
         if(o==null)
	  throw new NullPointerException();
         HList l = null;
         try
         {
            l = (HList)o;
         }
         catch(ClassCastException cce)
         {
	    return false;
         }
         if(size()==l.size())
         {
            for(int i = 0; i < size(); i++)
            {
               if(!get(i).equals(l.get(i)))
                return false;
            }
            return true;
         }
         return false;
      }
      public Object get(int index) 
      {
         if(index < 0 || index >= this.size())
          throw new IndexOutOfBoundsException();
         return list.get(fromIndex+index);
      }
      public int hashCode​()
      {
         int hashCode = 1;
         HIterator iter = iterator();
         while(iter.hasNext()) 
         {
            Object obj = iter.next();
            hashCode = 31*hashCode + (obj==null ? 0 : obj.hashCode());
         }
         return hashCode;
      }
      public int indexOf(Object o)
      {
         if(o==null)
	   throw new NullPointerException();
         for(int i = 0; i < size(); i++)
         {
            if(get(i).equals(o))
              return i;
         }
         return -1;
      }
      public boolean isEmpty()
      {
         return size()<=0;
      }
      public HIterator iterator()
      {
         return listIterator();
      }
      public int lastIndexOf(Object o)
      {
         if(o==null)
           throw new NullPointerException();
         int index = -1;
         for(int i = 0; i < size(); i++)
         {
            boolean found = get(i).equals(o);
            if(found)
             index = i;            
         }
         return index;
         
      }
      public HListIterator listIterator​()
      {
         return listIterator(0);
      }
      public HListIterator listIterator​(int index)
      {
         if(index < 0 || index > size())
          throw new IndexOutOfBoundsException();
         return new SubListIterator(index);
      }
      public Object remove(int index) 
      {
         if(index < 0 || index >= this.size())
          throw new IndexOutOfBoundsException();
         Object val = list.remove(fromIndex + index);
         toIndex--;
         return val;
      }
      public boolean remove(Object o)
      {
         if(o==null)
          throw new NullPointerException();
         int i = indexOf(o);
         if(i!=-1)
         {
            remove(i);
            return true;
         }
         return false; 
      }
      public boolean removeAll​(HCollection c)
      {
         if(c==null)
          throw new NullPointerException();
         HIterator iter = iterator();
         boolean modified = false;      
         while(iter.hasNext())
         {
            Object tmp = iter.next();
            if(c.contains(tmp))
            {
               iter.remove();
               modified = true;
            }
         }
         return modified;
      }
      public boolean retainAll​(HCollection c)
      {
         if(c==null)
           throw new NullPointerException();
         HIterator iter = iterator();
         boolean modified = false;
         while(iter.hasNext())
         {
            Object elem = iter.next();
            if(!c.contains(elem))
            {
               iter.remove();
               modified = true;
            }
         }   
         return modified;
      }
      public Object set(int index, Object element) 
      {
         if(index < 0 || index >= this.size())
          throw new IndexOutOfBoundsException();
         return list.set(fromIndex + index, element);
      }
      public int size() 
      {
         return toIndex-fromIndex;
      }
      public HList subList(int fromIndex, int toIndex)
      {
         if(fromIndex < 0 || toIndex > size() || fromIndex > toIndex)
          throw new IndexOutOfBoundsException();
         return new SubList(this, fromIndex, toIndex);
      }
      public Object[] toArray()
      {
         Object[] array = new Object[size()];
         for(int i = 0; i < array.length; i++)
         {  
            array[i] = get(i);
         }
         return array;
      }
      public Object[] toArray​(Object[] a)
      {
         if(a==null)
          throw new NullPointerException();
         int size = size();
         if (a.length < size)
           a = new Object[size];
         else if (a.length > size)
           a[size] = null;
         for(int i = 0; i < size; i++)
         {  
            a[i] = get(i);
         }
         return a;
      }
      class SubListIterator 
      implements HListIterator
      {
         int cursor = 0;
         boolean next = false;
         boolean previous = false;
         int lastReturned = 0;
     
         public SubListIterator(int index)
         {
            cursor = index;
         }
         public void add(Object o)
         {
            SubList.this.add(cursor, o);
            cursor++;
            next = false;
            previous = false;
         }
         public boolean hasNext()
         {
            return cursor < size();
         }
         public boolean hasPrevious()
         {
            return cursor > 0;
         }
         public Object next()
         {
            if(cursor >= size())
	      throw new NoSuchElementException();
	    Object val = get(cursor);
	    lastReturned = cursor;
	    cursor++;
	    next = true;
	    previous = false;
	    return val;
         }
         public int nextIndex()
         {
            return cursor;
         }
         public Object previous()
         {
            if(cursor <= 0)
	      throw new NoSuchElementException();
	    cursor--;
   	    Object val = get(cursor);
   	    lastReturned = cursor;
   	    previous = true;
   	    next = false;
	    return val;
         }
         public int previousIndex()
         {
            return cursor-1;
         }
         public void remove()
         {
            if(!next && !previous)
	      throw new IllegalStateException();
	    SubList.this.remove(lastReturned);
	    if(next)
	     cursor--;
	    next = false;
	    previous = false;
         }
         public void set(Object o)
         {
            if(!next && !previous)
	      throw new IllegalStateException();
	    SubList.this.set(lastReturned, o);
	    next = false;
	    previous = false;
         }
      }//end class SubListIterator
   }//end class SubList
   
   class ListIterator 
   implements HListIterator
   {
      int cursor = 0;
      boolean previous = false;
      int lastReturned = 0;
      boolean next = false;
     
      public ListIterator(int index)
      {
         cursor = index;
      }
      
      /**
      * Inserts the specified element into the list. The element is inserted immediately before the next element that would be returned by next, if any, and after the next element that would be returned by previous, if any. (If the list contains no elements, the new element becomes the sole element on the list.) The new element is inserted before the implicit cursor: a subsequent call to next would be unaffected, and a subsequent call to previous would return the new element. (This call increases by one the value that would be returned by a call to nextIndex or previousIndex.) 
      * @param o the element to insert. 
      * @throws NullPointerException if the specified element is null
      */
      @Override
      public void add(Object o)
      {
         if(o==null)
          throw new NullPointerException();
         ListAdapter.this.add(cursor, o);
         cursor++;
         next = false;
         previous = false;
      }
  
      /**
      * Returns true if this list iterator has more elements when traversing the list in the forward direction.
      * @return true if the list iterator has more elements when traversing the list in the forward direction.
      */
      @Override
      public boolean hasNext()
      {
         return cursor < size();
      }
          
      /**
      * Returns true if this list iterator has more elements when traversing the list in the reverse direction.
      * @return true if the list iterator has more elements when traversing the list in the reverse direction.
      */
      @Override
      public boolean hasPrevious()
      {
         return cursor > 0;
      }
          
      /**
      * Returns the next element in the list.
      * @return the next element in the list. 
      */
      @Override
      public Object next()
      {
         if(cursor >= size())
	   throw new NoSuchElementException();
	 Object val = get(cursor);
	 lastReturned = cursor;
	 cursor++;
	 next = true;
	 previous = false;
	 return val;
      }
      
      /**
      * Returns the index of the element that would be returned by a subsequent call to next. Returns list size if the list iterator is at the end of the list.
      * @return the index of the element that would be returned by a subsequent call to next, or list size if list iterator is at end of list.
      */
      @Override
      public int nextIndex()
      {
         return cursor;
      }
  
      /**
      * Returns the previous element in the list.
      * @return the previous element in the list. 
      */ 
      @Override       
      public Object previous()
      {
         if(cursor <= 0)
	   throw new NoSuchElementException();
	 cursor--;
	 Object val = get(cursor);
	 lastReturned = cursor;
	 previous = true;
	 next = false;
	 return val;
      }
  
      /**
      * Returns the index of the element that would be returned by a subsequent call to previous. Returns -1 if the list iterator is at the beginning of the list.
      * @return the index of the element that would be returned by a subsequent call to previous, or -1 if list iterator is at beginning of list.
      */   
      @Override     
      public int previousIndex()
      {
         return cursor-1;
      }
   
      /**
      * Removes from the list the last element that was returned by next or previous. This call can only be made once per call to next or previous. It can be made only if add has not been called after the last call to next or previous. 
      * @throws IllegalStateException if neither next nor previous have been called, or remove or add have been called after the last call to next or previous.
      */
      @Override
      public void remove()
      {
         if(!next && !previous)
	   throw new IllegalStateException();
	 ListAdapter.this.remove(lastReturned);
	 if(next)
	  cursor--;
	 next = false;
	 previous = false;
	
      }
  
      /**
      * Replaces the last element returned by next or previous with the specified element. This call can be made only if neither ListIterator.remove nor ListIterator.add have been called after the last call to next or previous.
      * @throws IllegalStateException if neither next nor previous have been called, or remove or add have been called after the last call to next or previous. 
      * @param o the element with which to replace the last element returned by next or previous.
      * @throws NullPointerException if the specified element is null
      */
      @Override
      public void set(Object o)
      {
         if(!next && !previous)
	   throw new IllegalStateException();
         if(o==null)
           throw new NullPointerException();
	 ListAdapter.this.set(lastReturned, o);
	 next = false;
	 previous = false;
      }
   }
}
