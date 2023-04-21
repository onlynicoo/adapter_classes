/**
* CollectionAdapter represents a group of objects, known as its elements. It allows duplicate elements and prohibits null elements. Attempting an operation with a null parameter throws NullPointerException.
*/
public class CollectionAdapter implements HCollection
{
   ListAdapter la = new ListAdapter();
   
   /**
   * Ensures that this collection contains the specified element. Returns true if this collection changed as a result of the call. The collection permits duplicates.
   * @param o element whose presence in this collection is to be ensured.
   * @return true if this collection changed as a result of the call. 
   * @throws NullPointerException if the specified element is null.
   */
   public boolean add(Object o)
   {
      return la.add(o);
   }
   
   /**
   * Adds all of the elements in the specified collection to this collection. Returns true if this collection changed as a result of the call.
   * @param c elements to be inserted into this collection.
   * @return true if this collection changed as a result of the call.
   * @throws NullPointerException if the specified collection is null.
   */
   public boolean addAll(HCollection c)
   {
      return la.addAll(c);
   }
   
   /**
   * Removes all of the elements from this collection.
   */
   public void clear()
   {
      la.clear();
   }
   
   /**
   * Returns true if this collection contains the specified element.
   * @param o element whose presence in this collection is to be tested. 
   * @return true if this collection contains the specified element.
   * @throws NullPointerException if the specified element is null.
   */
   public boolean contains(Object o)
   {
      return la.contains(o);
   }

   /**
   * Returns true if this collection contains all of the elements in the specified collection.
   * @param c collection to be checked for containment in this collection.
   * @return true if this collection contains all of the elements in the specified collection. 
   * @throws NullPointerException if the specified collection is null. 
   */
   public boolean containsAll​(HCollection c)
   {
      return la.containsAll(c);
   }

   /**
   * Compares the specified object with this collection for equality. Two collections are equals if they have the same size and contain the same elements.
   * @para o Object to be compared for equality with this collection. 
   * @return true if the specified object is equal to this collection.
   * @throws NullPointerException if the specified element is null.
   */
   public boolean equals​(Object o)
   {
      if(o==null)
        throw new NullPointerException();
      HCollection coll = null;
      try
      {
         coll = (CollectionAdapter)o;
      }
      catch(ClassCastException cce)
      {
	 return false;
      }
      if(size()==coll.size())
      {
         if(hashCode()==(coll.hashCode()))
          return containsAll(coll)&&coll.containsAll(this);
      }
      return false;
   }
	
   /**
   * Returns the hash code value for this collection.
   * @return the hash code value for this collection.
   */
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
   * Returns true if this collection contains no elements.
   * @return true if this collection contains no elements.
   */
   public boolean isEmpty​()
   {
      return la.isEmpty();
   }
	
   /**
   * Returns an iterator over the elements in this collection.
   * @return an Iterator over the elements in this collection.
   */
   public HIterator iterator​()
   {
      return la.iterator();
   }
	
   /**
   * Removes a single instance of the specified element from this collection, if it is present. Returns true if this collection contained the specified element (or equivalently, if this collection changed as a result of the call).
   * @param o element to be removed from this collection, if present. 
   * @return true if this collection changed as a result of the call. 
   * @throws NullPointerException if the specified element is null.
   */
   public boolean remove(Object o)
   {
      return la.remove(o);
   }
   
   /**
   * Removes all this collection's elements that are also contained in the specified collection. After this call returns, this collection will contain no elements in common with the specified collection. Returns true if this collection changed as a result of the call. 
   * @param c elements to be removed from this collection. 
   * @return true if this collection changed as a result of the call
   * @throws NullPointerException if the specified collection is null.
   */
   public boolean removeAll​(HCollection c)
   {
      return la.removeAll(c);
   }
	
   /**
   * Retains only the elements in this collection that are contained in the specified collection. In other words, removes from this collection all of its elements that are not contained in the specified collection.
   * @param c elements to be retained in this collection. 
   * @return true if this collection changed as a result of the call.
   * @throws NullPointerException if the specified collection is null. 
   */
   public boolean retainAll​(HCollection c)
   {
      return la.retainAll(c);
   }
	
   /**
   * Returns the number of elements in this collection. If this collection contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE. 
   * @return the number of elements in this collection.
   */
   public int size()
   {
      return la.size();
   }
   
   /**
   * Returns an array containing all of the elements in this collection. 
   * @return an array containing all of the elements in this collection.
   */
   public Object[] toArray()
   {
      return la.toArray();
   }
   
   /**
   * Returns an array containing all of the elements in this collection; the runtime type of the returned array is that of the specified array. If the collection fits in the specified array, it is returned therein. Otherwise, a new array is allocated with the runtime type of the specified array and the size of this collection. If this collection fits in the specified array with room to spare, the element in the array immediately following the end of the collection is set to null.
   * @param a the array into which the elements of this collection are to be stored, if it is big enough; otherwise, a new array of the same runtime type is allocated for this purpose. 
   * @return an array containing the elements of this collection.
   * @throws NullPointerException if the specified array is null.
   */
   public Object[] toArray​(Object[] a)
   {
      return la.toArray(a);
   }  
}
