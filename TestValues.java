
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
public class TestValues
{
   MapAdapter map = new MapAdapter();
   HCollection values = null;
   
   @Before
   public void setUp()
   {
      map.put(1, "tre");
      map.put(2, "tre");
      map.put(3, "tre");
      map.put(4, "sette");
      map.put(5, "sei");
      map.put(6, "tre");
      values = map.values();
   }
   
   @Test(expected = UnsupportedOperationException.class)
   public void testAdd()
   {
      values.add(1);        
   } 
   
   @Test(expected = UnsupportedOperationException.class)
   public void testAddAll()
   {
      values.addAll(new CollectionAdapter());        
   } 
   
   @Test
   public void testSize()
   {
      assertEquals(6, values.size());        
   } 
   
   @Test
   public void testClear()
   {
      values.clear();
      assertEquals(0, values.size()); 
      assertEquals(0, map.size()); 
   }
   
   @Test
   public void testIsEmpty()
   {
      values.clear();
      assertEquals(true, values.isEmpty()); 
      assertEquals(true, map.isEmpty()); 
   } 
   
   @Test
   public void testContains()
   {
      Object value = "tre";
      Object value1 = "sette";
      Object value2 = "sei";
      assertEquals(true, values.contains(value));
      assertEquals(true, values.contains(value1));
      assertEquals(true, values.contains(value2));
      Object value3 = "uno";
      assertEquals(false, values.contains(value3));
   } 
     
   @Test(expected = NullPointerException.class)
   public void testContains1()
   {
      values.contains(null);     
   }
     
   @Test
   public void testContainsAll()
   {
      HCollection c = new CollectionAdapter();
      boolean containsAll = values.containsAll(c);
      assertEquals(true, containsAll);         
   } 
   
   @Test
   public void testContainsAll1()
   {
      HCollection c = new CollectionAdapter();
      c.add("tre");
      c.add("sette");
      c.add("sei");
      boolean containsAll = values.containsAll(c);
      assertEquals(true, containsAll);           
   } 
   
   @Test
   public void testContainsAll2()
   {
      HCollection c = new CollectionAdapter();
      c.add("tre");
      c.add("sette");
      c.add("sei");
      c.add("uno");
      boolean containsAll = values.containsAll(c);
      assertEquals(false, containsAll);           
   } 
   
  @Test(expected = NullPointerException.class)
   public void testContainsAll3()
   {
       values.containsAll(null);     
   }
   
   @Test
   public void testEquals()
   {
      HCollection o = new CollectionAdapter();
      o.add("tre");
      o.add("tre");
      o.add("tre");
      o.add("tre");
      o.add("sette");
      o.add("sei");
      boolean equals = values.equals(o);
      assertEquals(true, equals);  
   }
   
   @Test
   public void testEquals1()
   {
      HCollection o = new CollectionAdapter();
      o.add("tre");
      o.add("sei");
      o.add("sette");
      boolean equals = values.equals(o);
      assertEquals(false, equals); 
   }
   
   @Test(expected = NullPointerException.class)
   public void testEquals2()
   {
       values.equals(null);     
   }
   
    
   @Test
   public void testRemove()
   {
      boolean remove = values.remove("sette");
      assertEquals(true, remove);
      assertEquals(false, values.contains("sette"));
      assertEquals(false, map.containsValue("sette"));
      assertEquals(5, map.size()); 
      remove = values.remove("tre");
      assertEquals(true, remove); 
      assertEquals(true, values.contains("tre"));
      assertEquals(true, map.containsValue("tre"));
      assertEquals(4, map.size());
      remove = values.remove("uno");
      assertEquals(false, remove); 
      assertEquals(4,map.size());    
   } 
   
   @Test
   public void testRemove1()
   {
      boolean remove = values.remove("tre");
      assertEquals(true, remove); 
      assertEquals(true, values.contains("tre"));
      assertEquals(true, map.containsValue("tre"));
      assertEquals(5, map.size());   
   } 
   
   @Test
   public void testRemove2()
   {
      boolean remove = values.remove("uno");
      assertEquals(false, remove); 
      assertEquals(6,map.size());    
   } 
   
   @Test(expected = NullPointerException.class)
   public void testRemove3()
   {
       values.remove(null);     
   }
   
   @Test
   public void testRemoveAll()
   {
      HCollection c = new CollectionAdapter();
      c.add("tre");
      c.add("sei");
      boolean removeAll = values.removeAll(c);
      assertEquals(true, removeAll);
      assertEquals(false, values.contains("tre"));
      assertEquals(false, map.containsValue("tre"));
      assertEquals(false, values.contains("sei"));
      assertEquals(false, map.containsValue("sei"));
      assertEquals(1, map.size());       
   } 
   
   @Test
   public void testRemoveAll1()
   {
      HCollection c = new CollectionAdapter();
      boolean removeAll = values.removeAll(c);
      assertEquals(false, removeAll);
      assertEquals(6, map.size());      
   } 
   
   @Test
   public void testRemoveAll2()
   {
      HCollection c = new CollectionAdapter();
      c.add("zero");
      c.add("uno");
      boolean removeAll = values.removeAll(c);
      assertEquals(false, removeAll);
      assertEquals(6, map.size());     
   } 
   
   @Test(expected = NullPointerException.class)
   public void testRemoveAll3()
   {
       HCollection c = null;
       values.removeAll(c);     
   } 
   
   @Test
   public void testRetainAll()
   {
      HCollection c = new CollectionAdapter();
      boolean retainAll = values.retainAll(c);
      assertEquals(true, retainAll);
      assertEquals(0, values.size());
      assertEquals(0, map.size());
      assertEquals(true, map.isEmpty());
   } 
   
   @Test
   public void testRetainAll1()
   {
      HCollection c = new CollectionAdapter();
      c.add("sei");
      c.add("tre");
      boolean retainAll = values.retainAll(c);
      assertEquals(true, retainAll);
      assertEquals(5, map.size());
      assertEquals(true, values.contains("sei"));
      assertEquals(true, values.contains("tre"));
      assertEquals(false, values.contains("sette"));
      assertEquals(true, map.containsValue("sei"));
      assertEquals(true, map.containsValue("tre"));
      assertEquals(false, map.containsValue("sette"));
   } 
   
   @Test
   public void testRetainAll2()
   {
      HSet c = new SetAdapter();
      c.add("tre");
      c.add("sei");
      c.add("sette");
      boolean retainAll = values.retainAll(c);
      assertEquals(false, retainAll);
      assertEquals(6, values.size());
      assertEquals(6, map.size()); 
   }  
    
   @Test(expected = NullPointerException.class)
   public void testRetainAll3()
   {
       HCollection c = null;
       values.retainAll(c);     
   }
   
   @Test
   public void testIterator()
   {
      HIterator iter = values.iterator();
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
      assertEquals(true, values.contains(n1));
      assertEquals(true, values.contains(n2));
      assertEquals(true, values.contains(n3));
      assertEquals(true, values.contains(n4));
      assertEquals(true, values.contains(n5));
      assertEquals(true, values.contains(n6));
      assertEquals(true, map.containsValue(n1));
      assertEquals(true, map.containsValue(n2));
      assertEquals(true, map.containsValue(n3));
      assertEquals(true, map.containsValue(n4));   
      assertEquals(true, map.containsValue(n5));
      assertEquals(true, map.containsValue(n6));
   }
   
   @Test
   public void testIterator1()
   {
      HIterator iter = values.iterator();
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
      assertEquals(false, values.contains(n1));
      assertEquals(false, values.contains(n2));
      assertEquals(false, values.contains(n3));
      assertEquals(false, values.contains(n4));
      assertEquals(false, values.contains(n5));
      assertEquals(false, values.contains(n6));
      assertEquals(false, map.containsValue(n1));
      assertEquals(false, map.containsValue(n2));
      assertEquals(false, map.containsValue(n3));
      assertEquals(false, map.containsValue(n4));   
      assertEquals(false, map.containsValue(n5));
      assertEquals(false, map.containsValue(n6));
      assertEquals(0, map.size());
   }
   
   @Test(expected = java.util.NoSuchElementException.class)
   public void testIterator2()
   {
      HIterator iter = values.iterator();
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
      HIterator iter = values.iterator();
      iter.remove();
   }
   
   @Test(expected = IllegalStateException.class)
   public void testIterator4()
   {
      HIterator iter = values.iterator();
      iter.next();
      iter.remove();
      iter.remove();
   } 
   
   @Test
   public void testToArray()
   {
      Object[] array = values.toArray();
      assertEquals(array.length, values.size()); 
      for(int i = 0; i < array.length; i++)
      {
         assertEquals(true, map.containsValue(array[i]));
      } 
   } 
}
