import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
public class TestEntrySet
{
   MapAdapter map = new MapAdapter();
   HSet entries = null;
   
   @Before
   public void setUp()
   {
      map.put(1, "tre");
      map.put(2, "tre");
      map.put(3, "tre");
      map.put(4, "sette");
      map.put(5, "sei");
      map.put(6, "tre");
      entries = map.entrySet();
   }
   
   @Test(expected = UnsupportedOperationException.class)
   public void testAdd()
   {
      entries.add(1);        
   } 
   
   @Test(expected = UnsupportedOperationException.class)
   public void testAddAll()
   {
      entries.addAll(new CollectionAdapter());        
   } 
   
   @Test
   public void testSize()
   {
      assertEquals(6, entries.size());        
   } 
   
   @Test
   public void testClear()
   {
      entries.clear();
      assertEquals(0, entries.size()); 
      assertEquals(0, map.size()); 
   }
   
   @Test
   public void testIsEmpty()
   {
      entries.clear();
      assertEquals(true, entries.isEmpty()); 
      assertEquals(true, map.isEmpty()); 
   } 
   
   @Test
   public void testContains()
   {
      HMap.HEntry entry = new MapAdapter.Entry(1, "tre");
      assertEquals(true, entries.contains(entry));
      HMap.HEntry entry1 = new MapAdapter.Entry(2, "due");
      assertEquals(false, entries.contains(entry1));
   } 
     
   @Test(expected = NullPointerException.class)
   public void testContains1()
   {
      entries.contains(null);     
   } 
   
   @Test
   public void testContainsAll()
   {
      HCollection c = new CollectionAdapter();
      boolean containsAll = entries.containsAll(c);
      assertEquals(true, containsAll);           
   } 
   
   @Test
   public void testContainsAll1()
   {
      HCollection c = new CollectionAdapter();
      HMap.HEntry entry = new MapAdapter.Entry(1, "tre");
      c.add(entry);
      boolean containsAll = entries.containsAll(c);
      assertEquals(true, containsAll);       
   } 
   
   @Test
   public void testContainsAll2()
   {
      HCollection c = new CollectionAdapter();
      boolean containsAll = entries.containsAll(c);
      assertEquals(true, containsAll);
      HMap.HEntry entry = new MapAdapter.Entry(1, "tre");
      HMap.HEntry entry1 = new MapAdapter.Entry(2, "due");
      c.add(entry);
      containsAll = entries.containsAll(c);
      assertEquals(true, containsAll);
      c.add(entry1);
      containsAll = entries.containsAll(c);
      assertEquals(false, containsAll);           
   } 
   
   @Test(expected = NullPointerException.class)
   public void testContainsAll3()
   {
       entries.containsAll(null);     
   }
   
   @Test
   public void testEquals()
   {
      HSet o = new SetAdapter();
      o.add(new MapAdapter.Entry(1, "tre"));
      o.add(new MapAdapter.Entry(2, "tre"));
      o.add(new MapAdapter.Entry(3, "tre"));
      o.add(new MapAdapter.Entry(4, "sette"));
      o.add(new MapAdapter.Entry(5, "sei"));
      o.add(new MapAdapter.Entry(6, "tre"));
      boolean equals = entries.equals(o);
      assertEquals(true, equals);          
   } 
   
   @Test
   public void testEquals1()
   {
      HSet o = new SetAdapter();
      o.add(new MapAdapter.Entry(1, "tre"));
      o.add(new MapAdapter.Entry(2, "tre"));
      o.add(new MapAdapter.Entry(3, "tre"));
      o.add(new MapAdapter.Entry(4, "sette"));
      o.add(new MapAdapter.Entry(5, "sei"));
      boolean equals = entries.equals(o);
      assertEquals(false, equals);         
   } 
   
   @Test
   public void testEquals2()
   {
      HCollection coll = new CollectionAdapter();
      boolean equals = entries.equals(coll);
      assertEquals(false, equals);      
   } 
   @Test(expected = NullPointerException.class)
   public void testEquals3()
   {
       entries.equals(null);     
   }
   
   @Test
   public void testRemove()
   {
      HMap.HEntry entry = new MapAdapter.Entry(1, "tre");
      boolean remove = entries.remove(entry);
      assertEquals(true, remove);
      assertEquals(false, map.containsKey(1));
      assertEquals(5, map.size()); 
   } 
   
   @Test
   public void testRemove1()
   {
      HMap.HEntry entry1 = new MapAdapter.Entry(2, "due");
      boolean remove = entries.remove(entry1);
      assertEquals(false, remove); 
      assertEquals(true, map.containsKey(2));
      assertEquals("tre", map.get(2)); 
      assertEquals(6, map.size()); 
   } 
   
   @Test(expected = NullPointerException.class)
   public void testRemove2()
   {
       entries.remove(null);     
   } 
   
   @Test
   public void testRemoveAll()
   {
      HCollection c = new CollectionAdapter();
      HMap.HEntry entry = new MapAdapter.Entry(1, "tre");
      HMap.HEntry entry1 = new MapAdapter.Entry(2, "tre");
      c.add(entry);
      c.add(entry1);
      boolean removeAll = entries.removeAll(c);
      assertEquals(true, removeAll);
      assertEquals(false, entries.contains(entry));
      assertEquals(false, map.containsKey(1)); 
      assertEquals(false, entries.contains(entry1));
      assertEquals(false, map.containsKey(2)); 
      assertEquals(4, map.size());      
   } 
   
   @Test
   public void testRemoveAll1()
   {
      HCollection c = new CollectionAdapter();
      boolean removeAll = entries.removeAll(c);
      assertEquals(false, removeAll);
      assertEquals(6, map.size());      
   } 
   
   @Test
   public void testRemoveAll2()
   {
      HCollection c = new CollectionAdapter(); 
      HMap.HEntry entry = new MapAdapter.Entry(7, "cinque");
      HMap.HEntry entry1 = new MapAdapter.Entry(2, "due");
      c.add(entry);
      c.add(entry1);
      boolean removeAll = entries.removeAll(c);
      assertEquals(false, removeAll);
      assertEquals(6, map.size());     
   } 
   
   @Test(expected = NullPointerException.class)
   public void testRemoveAll3()
   {
       HCollection c = null;
       entries.removeAll(c);     
   } 
   
   @Test
   public void testRetainAll()
   {
      HCollection c = new CollectionAdapter();
      boolean retainAll = entries.retainAll(c);
      assertEquals(true, retainAll);
      assertEquals(0, map.size());
      assertEquals(true, map.isEmpty());
   } 
   
   @Test
   public void testRetainAll1()
   {
      HCollection c = new CollectionAdapter();
      HMap.HEntry entry = new MapAdapter.Entry(1, "tre");
      HMap.HEntry entry1 = new MapAdapter.Entry(4, "sette");
      c.add(entry);
      c.add(entry1);
      boolean retainAll = entries.retainAll(c);
      assertEquals(true, retainAll);
      assertEquals(2, map.size());
      assertEquals(true, map.containsKey(1));
      assertEquals(true, map.containsKey(4));
      assertEquals(false, map.containsKey(2));
      assertEquals(false, map.containsKey(3));
      assertEquals(false, map.containsKey(5));
      assertEquals(false, map.containsKey(6));
   } 
   
   @Test
   public void testRetainAll2()
   {
      HSet c = new SetAdapter();
      c.add(new MapAdapter.Entry(1, "tre"));
      c.add(new MapAdapter.Entry(2, "tre"));
      c.add(new MapAdapter.Entry(3, "tre"));
      c.add(new MapAdapter.Entry(4, "sette"));
      c.add(new MapAdapter.Entry(5, "sei"));
      c.add(new MapAdapter.Entry(6, "tre"));
      boolean retainAll = entries.retainAll(c);
      assertEquals(false, retainAll);
      assertEquals(6, map.size()); 
   }  
    
   @Test(expected = NullPointerException.class)
   public void testRetainAll3()
   {
       HCollection c = null;
       entries.retainAll(c);     
   }
   
   @Test
   public void testIterator()
   {
      HIterator iter = entries.iterator();
      assertEquals(true, iter.hasNext());
      HMap.HEntry n1 = (HMap.HEntry)iter.next();
      assertEquals(true, iter.hasNext());
      HMap.HEntry n2 = (HMap.HEntry)iter.next();
      assertEquals(true, iter.hasNext());
      HMap.HEntry n3 = (HMap.HEntry)iter.next();
      assertEquals(true, iter.hasNext());
      HMap.HEntry n4 = (HMap.HEntry)iter.next();
      assertEquals(true, iter.hasNext());
      HMap.HEntry n5 = (HMap.HEntry)iter.next();
      assertEquals(true, iter.hasNext());
      HMap.HEntry n6 = (HMap.HEntry)iter.next();
      assertEquals(false, iter.hasNext());
      assertEquals(true, map.containsKey(n1.getKey()));
      assertEquals(true, map.containsKey(n2.getKey()));
      assertEquals(true, map.containsKey(n3.getKey()));
      assertEquals(true, map.containsKey(n4.getKey()));   
      assertEquals(true, map.containsKey(n5.getKey()));
      assertEquals(true, map.containsKey(n6.getKey())); 
   }
   
   @Test
   public void testIterator1()
   {
      HIterator iter = entries.iterator();
      HMap.HEntry n1 = (HMap.HEntry)iter.next();
      iter.remove();
      HMap.HEntry n2 = (HMap.HEntry)iter.next();
      iter.remove();
      HMap.HEntry n3 = (HMap.HEntry)iter.next();
      iter.remove();
      HMap.HEntry n4 = (HMap.HEntry)iter.next();
      iter.remove();
      HMap.HEntry n5 = (HMap.HEntry)iter.next();
      iter.remove();
      HMap.HEntry n6 = (HMap.HEntry)iter.next();
      iter.remove();
      assertEquals(false, map.containsKey(n1.getKey()));
      assertEquals(false, map.containsKey(n2.getKey()));
      assertEquals(false, map.containsKey(n3.getKey()));
      assertEquals(false, map.containsKey(n4.getKey()));   
      assertEquals(false, map.containsKey(n5.getKey()));
      assertEquals(false, map.containsKey(n6.getKey())); 
      assertEquals(0, map.size());
   }
   
   @Test(expected = java.util.NoSuchElementException.class)
   public void testIterator2()
   {
      HIterator iter = entries.iterator();
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
      HIterator iter = entries.iterator();
      iter.remove();
   }
   
  @Test(expected = IllegalStateException.class)
   public void testIterator4()
   {
      HIterator iter = entries.iterator();
      iter.next();
      iter.remove();
      iter.remove();
   } 
   
   @Test
   public void testToArray()
   {
      Object[] array = entries.toArray();
      assertEquals(array.length, entries.size()); 
      for(int i = 0; i < array.length; i++)
      {
         assertEquals(true, entries.remove(array[i]));
      }
      assertEquals(true, map.isEmpty()); 
   } 
}
