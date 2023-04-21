import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
public class TestSetAdapter
{
   SetAdapter set = new SetAdapter();
   
   @Test
   public void testAdd()
   {
      boolean add = set.add("abc");
      String str = "abc";
      assertEquals(true, add);
      assertEquals(1, set.size());
      assertEquals(true, set.contains(str));
   } 
    
   @Test
   public void testAdd1()
   {
      set.add(1);
      boolean add = set.add(1);        
      assertEquals(false, add);
      assertEquals(1, set.size());
      assertEquals(true, set.contains(1));
   } 
   
   @Test(expected = NullPointerException.class)
   public void testAdd2()
   {
      set.add(null);
   } 
     
   @Test
   public void testAddAll()
   {
      HCollection c = new CollectionAdapter();
      c.add(1);
      c.add(2);
      c.add(3);
      boolean addAll = set.addAll(c);
      assertEquals(true, addAll);
      assertEquals(3, set.size());
      assertEquals(true, set.contains(1));
      assertEquals(true, set.contains(2));
      assertEquals(true, set.contains(3));
   } 
   
   @Test
   public void testAddAll1()
   {
      HCollection c = new CollectionAdapter();
      boolean addAll = set.addAll(c);
      assertEquals(false, addAll);
      assertEquals(0, set.size());       
   }
   
   @Test
   public void testAddAll2()
   {
      HCollection c = new CollectionAdapter();
      set.add(1);
      set.add(2);
      set.add(3);
      c.add(1);
      c.add(2);
      c.add(3);
      boolean addAll = set.addAll(c);
      assertEquals(false, addAll);
      assertEquals(3, set.size());      
   }  
    
   @Test(expected = NullPointerException.class)
   public void testAddAll3()
   {
      set.addAll(null);
   } 
   
   @Test(expected = NullPointerException.class)
   public void testContains()
   {
      set.contains(null);     
   } 
   
  @Test
   public void testContainsAll()
   {
      HCollection c = new CollectionAdapter();
      set.add(1);
      set.add(2);
      set.add(3);
      boolean containsAll = set.containsAll(c);
      assertEquals(true, containsAll);          
   } 
   
   @Test
   public void testContainsAll1()
   {
      HCollection c = new CollectionAdapter();
      set.add(1);
      set.add(2);
      set.add(3);
      c.add(1);
      c.add(2);     
      boolean containsAll = set.containsAll(c);
      assertEquals(true, containsAll);         
   } 
   
   @Test
   public void testContainsAll2()
   {
      HCollection c = new CollectionAdapter();
      set.add(1);
      set.add(2);
      set.add(3);     
      c.add(1);
      c.add(2);     
      c.add(4);
      boolean containsAll = set.containsAll(c);
      assertEquals(false, containsAll);           
   } 
   
   @Test(expected = NullPointerException.class)
   public void testContainsAll3()
   {
      set.containsAll(null);     
   }
   
   @Test
   public void testEquals()
   {
      set.add(1);
      set.add(2);
      set.add(3);
      SetAdapter s = new SetAdapter(); 
      s.add(1);
      s.add(2);
      s.add(3);   
      boolean equals = set.equals(s);
      assertEquals(true, equals);         
   } 
   
   @Test
   public void testEquals1()
   {
      set.add(1);
      set.add(2);
      set.add(3);
      SetAdapter s = new SetAdapter(); 
      s.add(1);
      s.add(2);
      s.add(4);   
      boolean equals = set.equals(s);
      assertEquals(false, equals);               
   } 
   
   @Test
   public void testEquals2()
   {
      HCollection c = new CollectionAdapter();
      boolean equals = set.equals(c);
      assertEquals(false, equals);
   }
   
   @Test(expected = NullPointerException.class)
   public void testEquals3()
   {
      set.equals(null);     
   }
   
   @Test
   public void testHashCode()
   {
      assertEquals(set.hashCode(), 0);   
   }  
   
   @Test
   public void testHashCode1()
   {
      set.add(1);
      set.add(2);
      set.add(3);
      SetAdapter s = new SetAdapter(); 
      s.add(1);
      s.add(2);
      s.add(3);
      assertEquals(set.hashCode(), s.hashCode());      
   } 
   
   @Test
   public void testHashCode2()
   {
      set.add(1);
      set.add(2);
      set.add(3);
      SetAdapter s = new SetAdapter(); 
      s.add(1);
      s.add(2);
      s.add(3);      
      s.add(4); 
      assertNotEquals(set.hashCode(), s.hashCode());      
   }  
   
   @Test
   public void testIterator()
   {
      set.add(1);
      set.add(2);
      set.add(3);
      HIterator iter = set.iterator();
      assertEquals(true, iter.hasNext());
      Object n1 = iter.next();
      assertEquals(true, iter.hasNext());
      Object n2 = iter.next();
      assertEquals(true, iter.hasNext());
      Object n3 = iter.next();
      assertEquals(false, iter.hasNext());
      assertEquals(true, set.contains(n1));
      assertEquals(true, set.contains(n2));
      assertEquals(true, set.contains(n3));
   }
   
   @Test
   public void testIterator1()
   {
      set.add(1);
      set.add(2);
      set.add(3);
      HIterator iter = set.iterator();      
      Object n1 = iter.next();
      iter.remove();
      Object n2 = iter.next();
      iter.remove();
      Object n3 = iter.next();
      iter.remove();
      assertEquals(false, iter.hasNext());
      assertEquals(false, set.contains(n1));
      assertEquals(false, set.contains(n2));
      assertEquals(false, set.contains(n3));     
   }
   
   @Test(expected = java.util.NoSuchElementException.class)
   public void testIterator2()
   {
      set.add(1);
      set.add(2);
      HIterator iter = set.iterator();
      iter.next();
      iter.next();
      iter.next();
   }
   
   @Test(expected = IllegalStateException.class)
   public void testIterator3()
   {
      set.add(1);
      set.add(2);
      HIterator iter = set.iterator();
      iter.remove();
   }
   @Test(expected = IllegalStateException.class)
   public void testIterator4()
   {
      set.add(1);
      set.add(2);
      HIterator iter = set.iterator();
      iter.next();
      iter.remove();
      iter.remove();
   }
   
   @Test
   public void testRemove()
   {
      set.add("abc");
      set.add("def");
      set.add("ghi");
      String s = "def";
      boolean remove = set.remove(s);
      assertEquals(true, remove);
      assertEquals(2, set.size());
      assertEquals(false, set.contains(s));
   } 
    
   @Test
   public void testRemove1()
   {
      set.add("abc");
      set.add("def");
      set.add("ghi");
      String s = "dfg";
      boolean remove = set.remove(s);
      assertEquals(false, remove);
      assertEquals(3, set.size());
   } 
   
   @Test(expected = NullPointerException.class)
   public void testRemove2()
   {
      set.remove(null);
   } 
   
   @Test
   public void testRemoveAll()
   {
      set.add(1);
      set.add(2);
      set.add(3);
      HCollection c = new CollectionAdapter();
      c.add(1);
      c.add(2);
      boolean removeAll = set.removeAll(c);
      assertEquals(true, removeAll);
      assertEquals(1, set.size());
      assertEquals(true, set.contains(3));
      assertEquals(false, set.contains(2));
      assertEquals(false, set.contains(1));
   } 
   
   @Test
   public void testRemoveAll1()
   {
      HCollection c = new CollectionAdapter();
      set.add(1);
      set.add(2);
      set.add(3);
      boolean removeAll = set.removeAll(c);
      assertEquals(false, removeAll);
      assertEquals(3, set.size());      
   }  
   
   @Test
   public void testRemoveAll2()
   {
      HCollection c = new CollectionAdapter();
      set.add(1);
      set.add(2);
      set.add(3);      
      c.add(4);
      c.add(5);
      c.add(6);      
      boolean removeAll = set.removeAll(c);
      assertEquals(false, removeAll);
      assertEquals(3, set.size());       
   }  
    
   @Test(expected = NullPointerException.class)
   public void testRemoveAll3()
   {
      set.removeAll(null);
   } 
   
   @Test
   public void testRetainAll()
   {
      set.add(1);
      set.add(2);
      set.add(3);
      HCollection c = new CollectionAdapter();
      boolean retainAll = set.retainAll(c);
      assertEquals(true, retainAll);
      assertEquals(0, set.size());
      assertEquals(true, set.isEmpty());
   } 
   
   @Test
   public void testRetainAll1()
   {
      set.add(1);
      set.add(2);
      set.add(3);
      HCollection c = new CollectionAdapter();
      c.add(1);
      c.add(2);
      c.add(4);
      boolean retainAll = set.retainAll(c);
      assertEquals(true, retainAll);
      assertEquals(2, set.size());
      assertEquals(true, set.contains(1));
      assertEquals(true, set.contains(2));
      assertEquals(false, set.contains(3));
   } 
   
   @Test
   public void testRetainAll2()
   {
      HCollection c = new CollectionAdapter();
      set.add(1);
      set.add(2);
      set.add(3);
      c.add(1);
      c.add(2);
      c.add(3);
      boolean retainAll = set.retainAll(c);
      assertEquals(false, retainAll);
      assertEquals(3, set.size()); 
   }  
    
   @Test(expected = NullPointerException.class)
   public void testRetainAll3()
   {
      set.retainAll(null);
   }
   
   @Test
   public void testToArray()
   {
      set.add(1);
      set.add(2);
      set.add(3);
      Object[] array = set.toArray();
      assertEquals(array.length, set.size()); 
      for(int i = 0; i < array.length; i++)
      {
         assertEquals(true, set.contains(array[i]));
      } 
   } 
   
   @Test
   public void testToArrayObject()
   {
      set.add(1);
      set.add(2);
      set.add(3);
      Integer[] a = new Integer[]{1,2,3,4};
      Object[] array = set.toArray(a);
      assertEquals(array.length, 4); 
      assertEquals(null, array[set.size()]);
      for(int i = 0; i < set.size(); i++)
      {
         assertEquals(true, set.contains(array[i]));
      } 
   }
   
   @Test
   public void testToArrayObject1()
   {
      set.add(1);
      set.add(2);
      set.add(3);
      Integer[] a = new Integer[]{1,2};
      Object[] array = set.toArray(a);
      assertEquals(array.length, 3); 
      for(int i = 0; i < set.size(); i++)
      {
         assertEquals(true, set.remove(array[i]));
      } 
   }
      
   @Test
   public void testToArrayObject2()
   {
      set.add(1);
      set.add(2);
      set.add(3);
      String[] a = new String[]{"abc","def"};
      Object[] array = set.toArray(a);
      assertEquals(array.length, 3); 
      for(int i = 0; i < set.size(); i++)
      {
         assertEquals(true, set.remove(array[i]));
      } 
   }
   
   @Test(expected = ArrayStoreException.class)
   public void testToArrayObject3()
   {
      set.add(1);
      set.add(2);
      set.add(3);
      String[] a = new String[]{"abc","def","ghi","lmn"};
      Object[] array = set.toArray(a);
   }  
   
   @Test(expected = NullPointerException.class)
   public void testToArrayObject4()
   {
      set.add(1);
      Object[] array = set.toArray(null);
   }  
}
