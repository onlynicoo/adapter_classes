import java.util.Hashtable;
import java.util.NoSuchElementException;
import java.util.Enumeration;
/**
* MapAdapter is an object that maps keys to values. It cannot contain duplicate keys; each key can map to at most one value. It provides three collection views, which allow a map's contents to be viewed as a set of keys, collection of values, or set of key-value mappings. The order of a map is defined as the order in which the iterators on the map's collection views return their elements. It prohibits null keys and values. Attempting operation with a null parameter throws NullPointerException.
*/
public class MapAdapter
implements HMap
{
   //object adapter
   private Hashtable ht = new Hashtable();
   
   private ListAdapter list = new ListAdapter(); //lista per contenere le chiavi
   
   /**
   * Removes all of the mappings from this map.
   */
   @Override
   public void clear()
   {
      if(!isEmpty())
      {
        ht.clear();
        list.clear();
      }
   }
   
   /**
   * Returns true if this map contains a mapping for the specified key.
   * @param key key whose presence in this map is to be tested. 
   * @return true if this map contains a mapping for the specified key. 
   * @throws NullPointerException if the specified key is null.
   */
   @Override
   public boolean containsKey(Object key) 
   {
      if(key==null)
       throw new NullPointerException();
      return ht.containsKey(key);
   }
	
   /**
   * Returns true if this map maps one or more keys to the specified value.
   * @param value value whose presence in this map is to be tested. 
   * @return true if this map maps one or more keys to the specified value. 
   * @throws NullPointerException if the value is null.
   */
   @Override
   public boolean containsValue(Object value)
   { 
      if(value==null)
       throw new NullPointerException();
      return ht.contains(value);
   }
	
   /**
   * Returns a HSet view of the mappings contained in this map. Each element in the returned set is a HEntry. The set is backed by the map, so changes to the map are reflected in the set, and vice-versa. If the map is modified while an iteration over the set is in progress, the results of the iteration are undefined. The set supports element removal, which removes the corresponding mapping from the  map. It does not support the add or addAll operations.
   * @return a set view of the mappings contained in this map.
   */
   @Override
   public HSet entrySet()
   {
      return new EntrySet();
   }
   
   private class EntrySet extends SetAdapter
   {
      public boolean add(Object o)
      {
         throw new UnsupportedOperationException();
      }
      public boolean addAll(HCollection c)
      {
         throw new UnsupportedOperationException();
      }
      public int size()
      {
         return MapAdapter.this.size(); 
      }
      public void clear()
      {
         MapAdapter.this.clear();
      }
      public HIterator iterator() 
      {
         return new EntryIterator();
      }
      public boolean isEmpty()
      {
         return MapAdapter.this.isEmpty();
      }
      public boolean contains(Object o) 
      {
         if(o==null)
          throw new NullPointerException();
         HEntry entry = null;
	 try
	 {
	    entry = (HEntry)o;
	 }
	 catch(ClassCastException cce)
	 {
	    return false;
	 }
	 Object key = entry.getKey();
	 if(MapAdapter.this.containsKey(key))
	   if(entry.getValue().equals(MapAdapter.this.get(key)))
	     return true;
	 return false;
      }
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
      public boolean remove(Object o)
      {
         if(o==null)
          throw new NullPointerException();
         HEntry entry = null;
	 try
	 {
	    entry = (HEntry)o;
	 }
	 catch(ClassCastException cce)
	 {
	    return false;
	 }
	 if(contains(entry))
	 {
	    Object key = entry.getKey();
            MapAdapter.this.remove(key);
            return true;
         }
         return false;
      }
      public boolean removeAll(HCollection c)
      {
         if(c==null)
          throw new NullPointerException();
         HIterator iter = c.iterator();
         boolean modified = false;
         while(iter.hasNext())
         {
            boolean remove = this.remove(iter.next());
            modified = modified || remove;
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
      public Object[] toArray()
      {
         Object[] array = new Object[size()];
         HIterator iter = iterator();
         for(int i = 0; i < array.length; i++)
         {  
            if(iter.hasNext())
             array[i] = iter.next();
         }
         return array;       
      }
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
      class EntryIterator
      implements HIterator
      {
         int cursor = 0;
         boolean next = false;
         Object lastReturned = null;
         public boolean hasNext​()
         {   
            return cursor < list.size(); 
         }
         public Object next​()
         {
	    if(!hasNext())
	     throw new NoSuchElementException();
	    Object key = list.get(cursor);
	    Object value = MapAdapter.this.get(key);
	    HEntry entry = new Entry(key,value);
	    next = true;
	    lastReturned = entry;
	    cursor++;
	    return entry;
	 }
	 public void remove​()
         {
            if(!next)
	     throw new IllegalStateException();
	    list.remove(lastReturned);
	    EntrySet.this.remove(lastReturned);
	    next = false;
	    cursor--;
         }
      }//end class EntryIterator 
   }//end class EntrySet
   
   
   /**
   * Compares the specified object with this map for equality. Return true if the given object is also a map and the two maps represent the same mappings.
   * @param o object to be compared for equality with this map. 
   * @return true if the specified object is equal to this map.
   * @throws NullPointerException if o is null.
   */
   @Override
   public boolean equals(Object o)
   {
      if(o==null)
       throw new NullPointerException();
      HMap map = null;
      try
      {
         map = (HMap)o;
      }
      catch(ClassCastException cce)
      { 
	 return false;
      }
      if(entrySet().equals(map.entrySet()))
       return true;
      return false;
   }
   
   /**
   * Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
   * @param key key whose associated value is to be returned. 
   * @return the value to which this map maps the specified key, or null if the map contains no mapping for this key. 
   * @throws NullPointerException if the key is null.
   */
   @Override
   public Object get(Object key)
   {
      if(key==null)
       throw new NullPointerException();
      return ht.get(key);
   }
	
   /**
   * Returns the hash code value for this map. The hash code of a map is defined to be the sum of the hashCodes of each entry in the map's entrySet view.
   * @return the hash code value for this map.
   */
   @Override
   public int hashCode()
   {
      HSet set = entrySet();
      HIterator iter = set.iterator();
      int hcode = 0;
      while(iter.hasNext())
      {
         HEntry entry = null;
         try
         {
            entry = (HEntry)iter.next();
         }
         catch(ClassCastException cce)
         {
            cce.printStackTrace(); 
         }
         hcode = hcode + entry.hashCode();
      }
      return hcode;
   }

   /**
   * Returns true if this map contains no key-value mappings.
   * @return true if this map contains no key-value mappings.
   */
   @Override
   public boolean isEmpty()
   {
      return ht.isEmpty();
   }
   
   /**
   * Returns a Set view of the keys contained in this map. The set is backed by the map, so changes to the map are reflected in the set, and vice-versa. If the map is modified while an iteration over the set in progress, the results of the iteration are undefined. The set supports element removal, which removes the corresponding mapping from the  map. It does not support the add or addAll operations.  
   * @return a set view of the keys contained in this map.
   */
   @Override
   public HSet keySet()
   {
      return new KeySet();
   }
   
   private class KeySet extends SetAdapter
   {
      public boolean add(Object o)
      {
         throw new UnsupportedOperationException();
      }
      public boolean addAll(HCollection c)
      {
         throw new UnsupportedOperationException();
      }
      public int size()
      {
         return MapAdapter.this.size(); 
      }
      public void clear()
      {
         MapAdapter.this.clear();
      }
      public HIterator iterator() 
      {
        return new KeyIterator();
      }
      public boolean isEmpty()
      {
         return MapAdapter.this.isEmpty();
      }
      public boolean contains(Object o) 
      {
         return MapAdapter.this.containsKey(o);
      }
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
      public boolean remove(Object o)
      {
         Object elem = MapAdapter.this.remove(o);
         if(elem == null)
          return false;
         return true;
      }
      public boolean removeAll(HCollection c)
      {
         if(c==null)
          throw new NullPointerException();
         HIterator iter = c.iterator();
         boolean modified = false;
         while(iter.hasNext())
         {
            boolean remove = this.remove(iter.next());
            modified = modified || remove;
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
      public Object[] toArray()
      {
         Object[] array = new Object[size()];
         HIterator iter = iterator();
         for(int i = 0; i < array.length; i++)
         {  
            if(iter.hasNext())
             array[i] = iter.next();
         }
         return array;       
      }
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
      class KeyIterator
      implements HIterator
      {
         private HIterator iter = MapAdapter.this.entrySet().iterator();
         public boolean hasNext​()
         {
            return iter.hasNext();
         }
         public Object next​()
         {
            Object elem = null;
	    try
	    {
	       elem = ((HEntry)(iter.next())).getKey();
	    }
	    catch(ClassCastException cce)
	    {
	       cce.printStackTrace();
	    }
	    return elem;
	 }
	 public void remove​()
         {
            iter.remove();
         }
      }//end class KeyIterator
   }//end class KeySet
     
   /**
   * Associates the specified value with the specified key in this map. If the map previously contained a mapping for this key, the old value is replaced by the specified value. Returns previous value associated with specified key, or null if there was no mapping for key.
   * @param key key with which the specified value is to be associated.
   * @param value value to be associated with the specified key. 
   * @return previous value associated with specified key, or null if there was no mapping for key.
   * @throws NullPointerException if the specified key or value is null.
   */
   @Override
   public Object put(Object key, Object value)
   {
      if(key == null||value == null)
        throw new NullPointerException();
      Object oldval = ht.put(key, value);
      list.add(key);
      return oldval;
   }
	
   /**
   * Copies all of the mappings from the specified map to this map. The behavior of this operation is unspecified if the specified map is modified while the operation is in progress. 
   * @param t Mappings to be stored in this map.
   * @throws NullPointerException if the specified map is null.
   */
   @Override
   public void putAll(HMap t)
   {
      if(t==null)
       throw new NullPointerException();
      HIterator iter = t.keySet().iterator();
      while(iter.hasNext())
      {
         Object key = iter.next();
         Object value = t.get(key);
         put(key, value);
      }    
   }
	
   /**
   * Removes the mapping for a key from this map if it is present. Returns the value to which the map previously associated the key, or null if the map contained no mapping for this key.
   * @param key key whose mapping is to be removed from the map. 
   * @return previous value associated with specified key, or null if there was no mapping for key. 
   * @throws NullPointerException if the specified key is null.
   */
   @Override
   public Object remove(Object key)
   {
      if(key==null)
        throw new NullPointerException();
      Object oldval = ht.remove(key);
      list.remove(key);
      return oldval;
   }
   
   /**
   * Returns the number of key-value mappings in this map. If the map contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
   * @return the number of key-value mappings in this map.
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
   * Returns a Collection view of the values contained in this map. The collection is  backed by the map, so changes to the map are reflected in the collection, and vice-versa. If the map is modified while an iteration over the collection is in progress, the results of the iteration are undefined. The collection supports element removal, which removes the corresponding mapping from the map. It does not support the add or addAll operations.  
   * @return a collection view of the values contained in this map.
   */
   @Override
   public HCollection values()
   {
      return new Values();
   }
   
   private class Values extends CollectionAdapter
   {
      public boolean add(Object o)
      {
         throw new UnsupportedOperationException();
      }
      public boolean addAll(HCollection c)
      {
         throw new UnsupportedOperationException();
      }
      public int size()
      {
         return MapAdapter.this.size(); 
      }
      public void clear()
      {
         MapAdapter.this.clear();
      }
      public HIterator iterator() 
      {
        return new ValueIterator();
      }
      public boolean isEmpty()
      {
         return MapAdapter.this.isEmpty();
      }
      public boolean contains(Object o) 
      {
         return MapAdapter.this.containsValue(o);
      }
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
      public boolean equals​(Object o)
      {
         if(o==null)
          throw new NullPointerException();
         HCollection c = null;
	 try
	 {
	    c = (CollectionAdapter)o;
	 }
	 catch(ClassCastException cce)
	 {
	    return false;
	 }
	 if(size()==c.size())
	 {
	    return super.equals(c);
	 }
         return false;
      }
      public boolean remove(Object o)
      {
         if(o==null)
          throw new NullPointerException();
         HSet keySet = keySet();
         HIterator iter = keySet.iterator();
         while(iter.hasNext())
         {
            Object key = iter.next();
            if((MapAdapter.this.get(key)).equals(o))
            {
               iter.remove();
               return true;
            }
         }
         return false;
      }
      public boolean removeAll(HCollection c)
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
      public Object[] toArray()
      {
         Object[] array = new Object[size()];
         HIterator iter = iterator();
         for(int i = 0; i < array.length; i++)
         {  
            if(iter.hasNext())
             array[i] = iter.next();
         }
         return array;       
      }
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
      class ValueIterator
      implements HIterator
      {
         private HIterator iter = MapAdapter.this.entrySet().iterator();
         public boolean hasNext​()
         {
            return iter.hasNext();
         }
         public Object next​()
         {
	    Object elem = null;
	    try
	    {
	       elem = ((HEntry)(iter.next())).getValue();
	    }
	    catch(ClassCastException cce)
	    {
	       cce.printStackTrace();
	    }
	    return elem;
	 }
	 public void remove​()
         {
            iter.remove();
         }
      }//end class ValueIterator
   }//end class Values
   
   static class Entry
   implements HEntry
   {
      Object key;
      Object value;
      
      public Entry(Object k, Object v)
      {
         if(k==null)
          throw new NullPointerException();
         setValue(v);
         key = k;
      }
      
      /**
      * Returns the key corresponding to this entry.
      * @return the key corresponding to this entry.
      */
      @Override
      public Object getKey()
      {
         return key;
      }
      
      /**
      * Returns the value corresponding to this entry.
      * @return the value corresponding to this entry.
      */
      @Override
      public Object getValue()
      {
         return value;
      }
      
      /**
      * Replaces the value corresponding to this entry with the specified value. Returns the old value corresponding to the entry.
      * @param value new value to be stored in this entry. 
      * @return old value corresponding to the entry.    
      * @throws NullPointerException if the backing map does not permit null values, and the specified value is null.
      */
      @Override
      public Object setValue(Object value)
      {
         if(value==null)
           throw new NullPointerException();
         Object val = getValue();
         this.value = value;
         return val;         
      }
    
      /**
      * Compares the specified object with this entry for equality. Returns true if the given object is also a map entry and the two entries represent the same mapping.
      * @param o object to be compared for equality with this map entry. 
      * @return true if the specified object is equal to this map entry.
      */
      @Override
      public boolean equals(Object o)
      {
         HEntry entry = null;
         try
         {
            entry = (HEntry)o;
         }
         catch(ClassCastException cce)
         {
	    return false;
         }
         if(entry.getKey().equals(key))
           if(entry.getValue().equals(value))
             return true;
         return false;
      }

      /**
      * Returns the hash code value for this map entry.
      * @return the hash code value for this map entry.
      */
      @Override
      public int hashCode()
      {
         return getKey().hashCode() ^ getValue().hashCode();
      }
   }
}
