public interface HMap
{   
   /**
   * Removes all of the mappings from this map.
   */
   void clear();
   	
   /**
   * Returns true if this map contains a mapping for the specified key.
   * @param key key whose presence in this map is to be tested. 
   * @return true if this map contains a mapping for the specified key. 
   * @throws NullPointerException if the specified key is null.
   */
   boolean containsKey(Object key);
	
   /**
   * Returns true if this map maps one or more keys to the specified value.
   * @param value value whose presence in this map is to be tested. 
   * @return true if this map maps one or more keys to the specified value. 
   * @throws NullPointerException if the value is null.
   */
   boolean containsValue(Object value);

   /**
   * Returns a HSet view of the mappings contained in this map. Each element in the returned set is a HEntry. The set is backed by the map, so changes to the map are reflected in the set, and vice-versa. If the map is modified while an iteration over the set is in progress, the results of the iteration are undefined. The set supports element removal, which removes the corresponding mapping from the  map. It does not support the add or addAll operations.
   * @return a set view of the mappings contained in this map.
   */
   HSet entrySet();   
   
   /**
   * Compares the specified object with this map for equality. Return true if the given object is also a map and the two maps represent the same mappings.
   * @param o object to be compared for equality with this map. 
   * @return true if the specified object is equal to this map.
   * @throws NullPointerException if o is null.
   */
   boolean equals(Object o);
   	
   /**
   * Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
   * @param key key whose associated value is to be returned. 
   * @return the value to which this map maps the specified key, or null if the map contains no mapping for this key. 
   * @throws NullPointerException if the key is null.
   */
   Object get(Object key);
   	
   /**
   * Returns the hash code value for this map. The hash code of a map is defined to be the sum of the hashCodes of each entry in the map's entrySet view.
   * @return the hash code value for this map.
   */
   int hashCode();
   
   /**
   * Returns true if this map contains no key-value mappings.
   * @return true if this map contains no key-value mappings.
   */
   boolean isEmpty();
      
   /**
   * Returns a Set view of the keys contained in this map. The set is backed by the map, so changes to the map are reflected in the set, and vice-versa. If the map is modified while an iteration over the set in progress, the results of the iteration are undefined. The set supports element removal, which removes the corresponding mapping from the  map. It does not support the add or addAll operations.  
   * @return a set view of the keys contained in this map.
   */
   HSet keySet();
  	
   /**
   * Associates the specified value with the specified key in this map. If the map previously contained a mapping for this key, the old value is replaced by the specified value. Returns previous value associated with specified key, or null if there was no mapping for key.
   * @param key key with which the specified value is to be associated.
   * @param value value to be associated with the specified key. 
   * @return previous value associated with specified key, or null if there was no mapping for key.
   * @throws NullPointerException if the specified key or value is null.
   */
   Object put(Object key, Object value);
	
   /**
   * Copies all of the mappings from the specified map to this map. The behavior of this operation is unspecified if the specified map is modified while the operation is in progress. 
   * @param t Mappings to be stored in this map.
   * @throws NullPointerException if the specified map is null.
   */
   void putAll(HMap t);
   	
   /**
   * Removes the mapping for a key from this map if it is present. Returns the value to which the map previously associated the key, or null if the map contained no mapping for this key.
   * @param key key whose mapping is to be removed from the map. 
   * @return previous value associated with specified key, or null if there was no mapping for key. 
   * @throws NullPointerException if the specified key is null.
   */
   Object remove(Object key);
   
   /**
   * Returns the number of key-value mappings in this map. If the map contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
   * @return the number of key-value mappings in this map.
   */
   int size();
   
   /**
   * Returns a Collection view of the values contained in this map. The collection is  backed by the map, so changes to the map are reflected in the collection, and vice-versa. If the map is modified while an iteration over the collection is in progress, the results of the iteration are undefined. The collection supports element removal, which removes the corresponding mapping from the map. It does not support the add or addAll operations.  
   * @return a collection view of the values contained in this map.
   */
   HCollection values();
      
   static interface HEntry
   {
      /**
      * Returns the key corresponding to this entry.
      * @return the key corresponding to this entry.
      */
      Object getKey();
            
      /**
      * Returns the value corresponding to this entry.
      * @return the value corresponding to this entry.
      */
      Object getValue();
            
      /**
      * Replaces the value corresponding to this entry with the specified value. Returns the old value corresponding to the entry.
      * @param value new value to be stored in this entry. 
      * @return old value corresponding to the entry.    
      * @throws NullPointerException if the backing map does not permit null values, and the specified value is null.
      */
      Object setValue(Object value);
          
      /**
      * Compares the specified object with this entry for equality. Returns true if the given object is also a map entry and the two entries represent the same mapping.
      * @param o object to be compared for equality with this map entry. 
      * @return true if the specified object is equal to this map entry.
      */
      boolean equals(Object o);
      
      /**
      * Returns the hash code value for this map entry.
      * @return the hash code value for this map entry.
      */
      int hashCode();
   }
}
