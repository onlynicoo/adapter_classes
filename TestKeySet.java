import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
public class TestKeySet
{
   MapAdapter map = new MapAdapter();
   HSet keys = null;
   
   @Before
   public void setUp()
   {
      map.put(1, "tre");
      map.put(2, "tre");
      map.put(3, "tre");
      map.put(4, "sette");
      map.put(5, "sei");
      map.put(6, "tre");
      keys = map.keySet();
   }
   
  @Test(expected = UnsupportedOperationException.class)
   public void testAdd()
   {
      keys.add(1);        
   } 
   
   @Test(expected = UnsupportedOperationException.class)
   public void testAddAll()
   {
      keys.addAll(new CollectionAdapter());        
   } 
   
   @Test
   public void testSize()
   {
      assertEquals(6, keys.size());        
   } 
   
   @Test
   public void testClear()
   {
      keys.clear();
      assertEquals(0, keys.size()); 
      assertEquals(0, map.size()); 
   }
   
  @Test
   public void testIsEmpty()
   {
      keys.clear();
      assertEquals(true, keys.isEmpty()); 
      assertEquals(true, map.isEmpty()); 
   } 
   
   @Test
   public void testContains()
   {
      Object key = 1;
      assertEquals(true, keys.contains(key));
      Object key1 = 7;
      assertEquals(false, keys.contains(key1));
   } 
   
   @Test(expected = NullPointerException.class)
   public void testContains1()
   {
      keys.contains(null);     
   }
     
   @Test
   public void testContainsAll()
   {
      HCollection c = new CollectionAdapter();
      boolean containsAll = keys.containsAll(c);
      assertEquals(true, containsAll);           
   } 
   
   @Test
   public void testContainsAll1()
   {
      HCollection c = new CollectionAdapter();
      c.add(1);
      c.add(2);
      boolean containsAll = keys.containsAll(c);
      assertEquals(true, containsAll);       
   } 
   
   @Test
   public void testContainsAll2()
   {
      HCollection c = new CollectionAdapter();
      c.add(1);
      c.add(2);
      c.add(7);
      boolean containsAll = keys.containsAll(c);
      assertEquals(false, containsAll);           
   } 
   
  @Test(expected = NullPointerException.class)
   public void testContainsAll3()
   {
       keys.containsAll(null);     
   }
   
   @Test
   public void testEquals()
   {
      HSet o = new SetAdapter();
      o.add(1);
      o.add(2);
      o.add(3);
      o.add(4);
      o.add(5);
      o.add(6);
      boolean equals = keys.equals(o);
      assertEquals(true, equals);  
   } 
   
   @Test
   public void testEquals1()
   {
      HSet o = new SetAdapter();
      o.add(1);
      boolean equals = keys.equals(o);
      assertEquals(false, equals); 
   } 
   
   @Test
   public void testEquals2()
   {
      HCollection coll = new CollectionAdapter();
      boolean equals = keys.equals(coll);
      assertEquals(false, equals);
   } 
   
   @Test(expected = NullPointerException.class)
   public void testEquals3()
   {
       keys.equals(null);     
   }
   
    
   @Test
   public void testRemove()
   {
      boolean remove = keys.remove(1);
      assertEquals(true, remove);
      assertEquals(false, keys.contains(1));
      assertEquals(false, map.containsKey(1));
      assertEquals(5, map.size()); 
   } 
   
   @Test
   public void testRemove1()
   {
      boolean remove = keys.remove(7);
      assertEquals(false, remove); 
      assertEquals(6, map.size()); 
   } 
   
   @Test(expected = NullPointerException.class)
   public void testRemove2()
   {
       keys.remove(null);     
   }
   
   @Test
   public void testRemoveAll()
   {
      HCollection c = new CollectionAdapter();
      c.add(5);
      c.add(6);
      boolean removeAll = keys.removeAll(c);
      assertEquals(true, removeAll);
      assertEquals(false, keys.contains(5));
      assertEquals(false, map.containsKey(5));
      assertEquals(false, keys.contains(6));
      assertEquals(false, map.containsKey(6));
      assertEquals(4, map.size());       
   } 
   
   @Test
   public void testRemoveAll1()
   {
      HCollection c = new CollectionAdapter();
      boolean removeAll = keys.removeAll(c);
      assertEquals(false, removeAll);
      assertEquals(6, map.size()); 
   }
   
   @Test
   public void testRemoveAll2()
   {
      HCollection c = new CollectionAdapter();
      c.add(7);
      c.add(0);
      boolean removeAll = keys.removeAll(c);
      assertEquals(false, removeAll);
      assertEquals(6, map.size());     
   } 
   
   @Test(expected = NullPointerException.class)
   public void testRemoveAll3()
   {
       HCollection c = null;
       keys.removeAll(c);     
   } 
   
   @Test
   public void testRetainAll()
   {
      HCollection c = new CollectionAdapter();
      boolean retainAll = keys.retainAll(c);
      assertEquals(true, retainAll);
      assertEquals(0, keys.size());
      assertEquals(0, map.size());
      assertEquals(true, map.isEmpty());
   } 
   
   @Test
   public void testRetainAll1()
   {
      HCollection c = new CollectionAdapter();
      c.add(2);
      c.add(4);
      boolean retainAll = keys.retainAll(c);
      assertEquals(true, retainAll);
      assertEquals(2, map.size());
      assertEquals(true, keys.contains(2));
      assertEquals(true, keys.contains(4));
      assertEquals(false, keys.contains(1));
      assertEquals(false, keys.contains(3));
      assertEquals(false, keys.contains(5));
      assertEquals(false, keys.contains(6));
      assertEquals(true, map.containsKey(2));
      assertEquals(true, map.containsKey(4));
      assertEquals(false, map.containsKey(1));
      assertEquals(false, map.containsKey(3));
      assertEquals(false, map.containsKey(5));
      assertEquals(false, map.containsKey(6));
   } 
   
   @Test
   public void testRetainAll2()
   {
      HSet c = new SetAdapter();
      c.add(2);
      c.add(4);
      c.add(1);
      c.add(3);
      c.add(5);
      c.add(6);
      boolean retainAll = keys.retainAll(c);
      assertEquals(false, retainAll);
      assertEquals(6, keys.size());
      assertEquals(6, map.size()); 
   }  
    
   @Test(expected = NullPointerException.class)
   public void testRetainAll3()
   {
       HCollection c = null;
       keys.retainAll(c);     
   }
   
   @Test
   public void testIterator()
   {
      HIterator iter = keys.iterator();
      assertEquals(true, iter.hasNext());
      Object n1 = iter.next();
      assertEquals(true, iter.hasNext());
      Object n2 = iter.next();
      assertEquals(true, iter.hasNext());
      Object n3 = iter.next();
      assertEquals(true, iter.hasNext());
      Object n4 = iter.next();
      assertEquals(true, iter.hasNext());
      Object n5 = iter.next();
      assertEquals(true, iter.hasNext());
      Object n6 = iter.next();
      assertEquals(false, iter.hasNext());
      assertEquals(true, keys.contains(n1));
      assertEquals(true, keys.contains(n2));
      assertEquals(true, keys.contains(n3));
      assertEquals(true, keys.contains(n4));
      assertEquals(true, keys.contains(n5));
      assertEquals(true, keys.contains(n6));
      assertEquals(true, map.containsKey(n1));
      assertEquals(true, map.containsKey(n2));
      assertEquals(true, map.containsKey(n3));
      assertEquals(true, map.containsKey(n4));   
      assertEquals(true, map.containsKey(n5));
      assertEquals(true, map.containsKey(n6));
   }
   
   @Test
   public void testIterator1()
   {
      HIterator iter = keys.iterator();
      Object n1 = iter.next();
      iter.remove();
      Object n2 = iter.next();
      iter.remove();
      Object n3 = iter.next();
      iter.remove();
      Object n4 = iter.next();
      iter.remove();
      Object n5 = iter.next();
      iter.remove();
      Object n6 = iter.next();
      iter.remove();
      assertEquals(false, keys.contains(n1));
      assertEquals(false, keys.contains(n2));
      assertEquals(false, keys.contains(n3));
      assertEquals(false, keys.contains(n4));
      assertEquals(false, keys.contains(n5));
      assertEquals(false, keys.contains(n6));
      assertEquals(false, map.containsKey(n1));
      assertEquals(false, map.containsKey(n2));
      assertEquals(false, map.containsKey(n3));
      assertEquals(false, map.containsKey(n4));   
      assertEquals(false, map.containsKey(n5));
      assertEquals(false, map.containsKey(n6));
      assertEquals(0, map.size());
   }
   
   @Test(expected = java.util.NoSuchElementException.class)
   public void testIterator2()
   {
      HIterator iter = keys.iterator();
      iter.next();
      iter.next();
      iter.next();
      iter.next();
      iter.next();
      iter.next();
      iter.next();
   }
   
   @Test(expected = IllegalStateException.class)
   public void testIterator3()
   {
      HIterator iter = keys.iterator();
      iter.remove();
   }
   
   @Test(expected = IllegalStateException.class)
   public void testIterator4()
   {
      HIterator iter = keys.iterator();
      iter.next();
      iter.remove();
      iter.remove();
   } 
   
   @Test
   public void testToArray()
   {
      Object[] array = keys.toArray();
      assertEquals(array.length, keys.size()); 
      for(int i = 0; i < array.length; i++)
      {
         assertEquals(true, keys.remove(array[i]));
      } 
      assertEquals(true, map.isEmpty());
   } 
}
