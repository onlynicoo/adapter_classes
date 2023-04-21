import java.util.Hashtable;
import java.util.Enumeration;
import java.util.NoSuchElementException;
/**
* SetAdapter is a collection that contains no duplicate elements. It prohibits null elements. Attempting an operation with a null parameter throws NullPointerException.
*/
public class SetAdapter 
implements HSet
{
   //object adapter
   private Hashtable ht = new Hashtable();
       
   /**
   * Adds the specified element to this set if it is not already present. If this set already contains the specified element, the call leaves this set unchanged and returns false. 
   * @param o element to be added to this set. 
   * @return true if this set did not already contain the specified element. 
   * @throws NullPointerException if the specified element is null
   */
   @Override
   public boolean add(Object o)
   {
      if(o==null)
        throw new NullPointerException();
      if(!contains(o))
      {
         ht.put(o,o);
         return true;
      }
      return false;
   }
   
   /**
   * Adds all of the elements in the specified collection to this set if they're not already present. Returns true if this set changed as a result of the call.
   * @param c collection whose elements are to be added to this set.
   * @return true if this set changed as a result of the call. 
   * @throws NullPointerException if the specified collection is null
   */
   @Override
   public boolean addAll(HCollection c)
   {
      if(c==null)
        throw new NullPointerException();
      HIterator iter = c.iterator();
      boolean modified = false;
      while(iter.hasNext())
      {
         boolean add = add(iter.next());
         modified = modified || add;
      }
      return modified;
   }
   
   /**
   * Removes all of the elements from this set.
   */
   @Override
   public void clear()
   {
      if(!isEmpty())
       ht.clear();
   }
   
   /**
   * Returns true if this set contains the specified element.
   * @param o element whose presence in this set is to be tested. 
   * @return true if this set contains the specified element. 
   * @throws NullPointerException if the specified element is null
   */
   @Override
   public boolean contains(Object o)
   {
      if(o==null)
       throw new NullPointerException();
      return ht.containsKey(o);
   }

   /**
   * Returns true if this set contains all of the elements of the specified collection.
   * @param c collection to be checked for containment in this set.
   * @return true if this set contains all of the elements of the specified collection. 
   * @throws NullPointerException if the specified collection is null
   */
   @Override
   public boolean containsAll​(HCollection c)
   {
      if(c==null)
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
   * Compares the specified object with this set for equality. Returns true if the specified object is also a set, the two sets have the same size, and every member of the specified set is contained in this set.
   * @param o Object to be compared for equality with this set. 
   * @return true if the specified Object is equal to this set.
   * @throws NullPointerException if the specified element is null
   */
   @Override
   public boolean equals​(Object o)
   {
      if(o==null)
       throw new NullPointerException();
      HSet set = null;
      try
      {
         set = (HSet)o;
      }
      catch(ClassCastException cce)
      {
         return false;
      }
      if(size()==set.size())
      {
         return containsAll(set);
      }
      return false;
   }
	
   /**
   * Returns the hash code value for this set. The hash code of a set is defined to be the sum of the hash codes of the elements in the set.
   * @return the hash code value for this set.
   */
   @Override
   public int hashCode​()
   {
      HIterator iter = iterator();
      int hcode = 0;
      while(iter.hasNext())
      {
         hcode = hcode + (iter.next()).hashCode();
      }
      return hcode;
   }
   
	
   /**
   * Returns true if this set contains no elements.
   * @return true if this set contains no elements.
   */
   @Override
   public boolean isEmpty​()
   {
      return ht.isEmpty();
   }
	
   /**
   * Returns an iterator over the elements in this set. The elements are returned in no particular order.
   * @return an iterator over the elements in this set.
   */
   @Override
   public HIterator iterator​()
   {
      return new SetIterator(toArray());
   }
   
   /**
   * Removes the specified element from this set if it is present. Returns true if the set contained the specified element.
   * @param o object to be removed from this set, if present. 
   * @return true if the set contained the specified element. 
   * @throws NullPointerException if the specified element is null
   */
   @Override
   public boolean remove(Object o)
   {
       if(o==null)
	throw new NullPointerException();
       if(ht.remove(o)==null)
	return false;
       return true;
   }
   
   /**
   * Removes from this set all of its elements that are contained in the specified collection. Returns true if this set changed as a result of the call.
   * @param c collection that defines which elements will be removed from this set. 
   * @return true if this set changed as a result of the call. 
   * @throws NullPointerException if the specified collection is null
   */
   @Override
   public boolean removeAll​(HCollection c)
   {
      if(c==null)
        throw new NullPointerException();
      HIterator iter = c.iterator();
      boolean modified = false;
      while(iter.hasNext())
      {
         boolean remove = remove(iter.next());
         modified = modified || remove;
      }
      return modified;
   }
	
   /**
   * Retains only the elements in this set that are contained in the specified collection. Returns true if this set changed as a result of the call.
   * @param c collection that defines which elements this set will retain. 
   * @return true if this collection changed as a result of the call.
   * @throws NullPointerException if the specified collection is null
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
   * Returns the number of elements in this set (its cardinality). If this set contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE. 
   * @return the number of elements in this set (its cardinality).
   */
   @Override
   public int size()
   {
      int size = ht.size();
      if(size > Integer.MAX_VALUE)
        return Integer.MAX_VALUE;
      return size;
   }
		
   /**
   * Returns an array containing all of the elements in this set.
   * @return an array containing all of the elements in this set.
   */
   @Override
   public Object[] toArray()
   {
      Object[] array = new Object[size()];
      Enumeration keys = ht.keys();
      for(int i = 0; i < array.length; i++)
      {  
         if(keys.hasMoreElements())
          array[i] = keys.nextElement();
      }
      return array;       
   }
   
   /**
   * Returns an array containing all of the elements in this set; the runtime type of the returned array is that of the specified array. If the set fits in the specified array, it is returned therein. Otherwise, a new array is allocated with the runtime type of the specified array and the size of this set. If this collection fits in the specified array with room to spare, the element in the array immediately following the end of the set is set to null. 
   * @param a the array into which the elements of this set are to be stored, if it is big enough; otherwise, a new array of the same runtime type is allocated for this purpose. 
   * @return an array containing the elements of this set. 
   * @throws ArrayStoreException if the runtime type of a is not a supertype of the runtime type of every element in this set. 
   * @throws NullPointerException if the specified array is null.
   */
   @Override
   public Object[] toArray​(Object[] a) 
   {
      if(a==null)
       throw new NullPointerException();
      int size = size();
      if(a.length < size)
        a = new Object[size];
      else if(a.length > size)
        a[size] = null;
      HIterator iter = iterator();
      for (int i = 0; i < size; i++)
      {
         try
         {
            a[i] = iter.next();
         }
         catch(ArrayStoreException ase)
         {
            throw new ArrayStoreException();
         }
      }
      return a;
   }
   
   private class SetIterator
   implements HIterator
   {
      int cursor = 0;
      Object[] values;
      boolean next = false;
      public SetIterator(Object[] a)
      {
	  cursor = 0;
	  values = a;
      }
      /**
      * Returns true if the iteration has more elements.
      * @return true if the iterator has more elements.
      */
      @Override
      public boolean hasNext​()
      {
         return cursor < values.length;
      }
      
      /**
      * Returns the next element in the iteration.
      * @return the next element in the iteration
      * @throws NoSuchElementException if iteration has no more elements.
      */
      @Override
      public Object next​()
      {
	 if(cursor >= values.length)
	   throw new NoSuchElementException();
	 Object val = values[cursor];
	 cursor++;
	 next = true;
	 return val;
      }
      
      /**
      * Removes from the underlying set the last element returned by this iterator.
      * @throws IllegalStateException if the next method has not yet been called, or the remove method has already been called after the last call to the next method.
      */
      @Override
      public void remove​()
      {
	 if(!next)
	   throw new IllegalStateException();
	 Object val = values[cursor-1];
	 SetAdapter.this.remove(val);
	 next = false;
      }
   }
}
