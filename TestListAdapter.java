import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
public class TestListAdapter
{
   ListAdapter list = new ListAdapter();
   
   @Test
   public void testAddIndex()
   {
      list.add("abc");
      list.add("def");
      list.add("ghi");
      list.add(1, "aaa");
      String str = "aaa";
      assertEquals(4, list.size());
      assertEquals(true, list.contains(str));
      assertEquals(1, list.indexOf(str));
      assertEquals(0, list.indexOf("abc"));
      assertEquals(2, list.indexOf("def"));
      assertEquals(3, list.indexOf("ghi"));
   } 
   
   @Test(expected = NullPointerException.class)
   public void testAddIndex1()
   {
      list.add(0, null);
   } 
   
  @Test(expected = IndexOutOfBoundsException.class)
   public void testAddIndex2()
   {
      list.add("aaa");
      list.add(2, "abc");
   } 
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void testAddIndex3()
   {
      list.add("aaa");
      list.add(-1, "abc");
   } 
    
   @Test
   public void testAdd()
   {
      boolean add = list.add(1);        
      assertEquals(true, add);
      assertEquals(1, list.size());
      assertEquals(true, list.contains(1));
      assertEquals(0, list.indexOf(1));
   } 
   
   @Test
   public void testAdd1()
   {
      list.add(1);
      list.add(2);      
      boolean add = list.add(1);        
      assertEquals(true, add);
      assertEquals(3, list.size());
      assertEquals(2, list.lastIndexOf(1));
   }
   
   @Test(expected = NullPointerException.class)
   public void testAdd2()
   {
      list.add(null);
   } 
     
   @Test
   public void testAddAll()
   {
      HCollection c = new CollectionAdapter();
      c.add(2);
      c.add(1);
      c.add(3);
      list.add(4);
      boolean addAll = list.addAll(c);
      assertEquals(true, addAll);
      assertEquals(4, list.size());
      assertEquals(4, list.get(0));
      assertEquals(2, list.get(1));
      assertEquals(1, list.get(2));
      assertEquals(3, list.get(3));
   } 
   
   @Test
   public void testAddAll1()
   {
      HCollection c = new CollectionAdapter();
      list.add(1);
      list.add(2);
      list.add(3);
      boolean addAll = list.addAll(c);
      assertEquals(false, addAll);
      assertEquals(3, list.size());  
   }  
    
   @Test(expected = NullPointerException.class)
   public void testAddAll2()
   {
      list.addAll(null);
   } 
   
   @Test
   public void testAddAllIndex()
   {
      HCollection c = new CollectionAdapter();
      c.add(2);
      c.add(1);
      c.add(3);
      list.add(4);
      list.add(5);
      list.add(1);      
      boolean addAll = list.addAll(1,c);
      assertEquals(true, addAll);
      assertEquals(6, list.size());
      assertEquals(4, list.get(0));
      assertEquals(2, list.get(1));
      assertEquals(1, list.get(2));
      assertEquals(3, list.get(3));
      assertEquals(5, list.get(4));
      assertEquals(1, list.get(5));
   } 
   
   @Test
   public void testAddAllIndex1()
   {
      HCollection c = new CollectionAdapter();
      list.add(1);
      list.add(2);
      list.add(3);
      boolean addAll = list.addAll(2, c);
      assertEquals(false, addAll);
      assertEquals(3, list.size());      
   }  
    
   @Test(expected = NullPointerException.class)
   public void testAddAllIndex2()
   {
      list.addAll(0, null);
   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void testAddAllIndex3()
   {
      list.addAll(-1, new CollectionAdapter());
   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void testAddAllIndex4()
   {
      list.add(2);
      list.add(1);
      list.addAll(3, new CollectionAdapter());
   }
   
   @Test(expected = NullPointerException.class)
   public void testContains()
   {
      list.contains(null);     
   } 
   
   @Test
   public void testContainsAll()
   {
      HCollection c = new CollectionAdapter();
      list.add(1);
      list.add(2);
      list.add(3);
      boolean containsAll = list.containsAll(c);
      assertEquals(true, containsAll);         
   } 
   
   @Test
   public void testContainsAll1()
   {
      HCollection c = new CollectionAdapter();
      list.add(1);
      list.add(2);
      list.add(3);
      c.add(1);
      c.add(2);     
      boolean containsAll = list.containsAll(c);
      assertEquals(true, containsAll);           
   } 
   
   @Test
   public void testContainsAll2()
   {
      HCollection c = new CollectionAdapter();
      list.add(1);
      list.add(2);
      list.add(3);
      c.add(1);
      c.add(2); 
      c.add(4);
      boolean containsAll = list.containsAll(c);
      assertEquals(false, containsAll);           
   } 
   
   @Test(expected = NullPointerException.class)
   public void testContainsAll3()
   {
      list.containsAll(null);     
   }
   
   @Test
   public void testEquals()
   {
      list.add(1);
      list.add(2);
      list.add(3);
      ListAdapter list1 = new ListAdapter(); 
      list1.add(1);
      list1.add(2);
      list1.add(3);   
      boolean equals = list.equals(list1);
      assertEquals(true, equals);         
   } 
   
   @Test
   public void testEquals1()
   {
      list.add(1);
      list.add(2);
      list.add(3);
      ListAdapter list1 = new ListAdapter(); 
      list1.add(1);
      list1.add(3);         
      list1.add(2);
      boolean equals = list.equals(list1);
      assertEquals(false, equals);                
   } 
   
   @Test
   public void testEquals2()
   {
      HSet s = new SetAdapter();
      boolean equals = list.equals(s);
      assertEquals(false, equals);
   }
   
   @Test(expected = NullPointerException.class)
   public void testEquals3()
   {
      list.equals(null);     
   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void testGet()
   {
      list.get(-1);
   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void testGet1()
   {
      list.add(1);
      list.add(2);
      list.get(2);
   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void testGet2()
   {
      list.add(1);
      list.add(2);
      list.get(3);
   }
   
   @Test
   public void testHashCode()
   {
      assertEquals(list.hashCode(), 1);   
   }  
   
   @Test
   public void testHashCode1()
   {
      list.add(1);
      list.add(2);
      list.add(3);
      ListAdapter list1 = new ListAdapter(); 
      list1.add(1);
      list1.add(2);
      list1.add(3);
      assertEquals(list.hashCode(), list1.hashCode());   
   }
   
   @Test
   public void testHashCode2()
   {
      list.add(1);
      list.add(2);
      list.add(3);
      ListAdapter list1 = new ListAdapter(); 
      list1.add(1);
      list1.add(3);
      list1.add(2);
      assertNotEquals(list.hashCode(), list1.hashCode());      
   }
   
   @Test(expected = NullPointerException.class)
   public void testIndexOf()
   {
      list.indexOf(null);
   }
   
   @Test
   public void testIterator()
   {
      list.add(1);
      list.add(2);
      list.add(3);
      HIterator iter = list.iterator();
      assertEquals(true, iter.hasNext());
      Object n1 = iter.next();
      assertEquals(1, n1);
      assertEquals(true, iter.hasNext());
      Object n2 = iter.next();
      assertEquals(2, n2);
      assertEquals(true, iter.hasNext());
      Object n3 = iter.next();
      assertEquals(3, n3);
      assertEquals(false, iter.hasNext());    
   }
   
   @Test
   public void testIterator1()
   {
      list.add(1);
      list.add(2);
      list.add(3);
      HIterator iter = list.iterator();
      Object n1 = iter.next();
      iter.remove();
      assertEquals(false, list.contains(n1));
      Object n2 = iter.next();
      iter.remove();
      assertEquals(false, list.contains(n2));
      Object n3 = iter.next();
      iter.remove();
      assertEquals(false, list.contains(n3));      
   }
   
   @Test(expected = java.util.NoSuchElementException.class)
   public void testIterator2()
   {
      list.add(1);
      list.add(2);
      HIterator iter = list.iterator();
      iter.next();
      iter.next();
      iter.next();
   }
   
   @Test(expected = IllegalStateException.class)
   public void testIterator3()
   {
      list.add(1);
      list.add(2);
      HIterator iter = list.iterator();
      iter.remove();
   }
   
   @Test(expected = IllegalStateException.class)
   public void testIterator4()
   {
      list.add(1);
      list.add(2);
      HIterator iter = list.iterator();
      iter.next();
      iter.remove();
      iter.remove();
   }
   
   @Test(expected = NullPointerException.class)
   public void testlastIndexOf()
   {
      list.lastIndexOf(null);
   }
   
   @Test
   public void testlastIndexOf1()
   {
      list.add(1);
      list.add(2);
      list.add(1);
      list.add(1);
      list.add(2);
      list.add(3);
      int index1 = list.lastIndexOf(1);
      int index2 = list.lastIndexOf(2);
      int index3 = list.lastIndexOf(3);
      assertEquals(3, index1); 
      assertEquals(4, index2); 
      assertEquals(5, index3);       
   }
   
   @Test
   public void testlastIndexOf2()
   {
      list.add(1);
      list.add(2);
      int index = list.lastIndexOf(3);
      assertEquals(-1, index); 
   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void testListIteratorIndex()
   {
      list.add(1);
      HListIterator iter = list.listIterator(-1);
   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void testListIteratorIndex1()
   {
      list.add(1);
      HListIterator iter = list.listIterator(2);
   }
  
   @Test
   public void testRemoveIndex()
   {
      list.add("abc");
      list.add("def");
      list.add("ghi");
      String s = "def";
      Object remove = list.remove(1);
      assertEquals(s, remove);
      assertEquals(2, list.size());
      assertEquals(false, list.contains(s));
   } 
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void testRemoveIndex1()
   {
      list.add("abc");
      Object remove = list.remove(-1);
   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void testRemoveIndex2()
   {
      list.add("abc");
      Object remove = list.remove(1);
   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void testRemoveIndex3()
   {
      list.add("abc");
      Object remove = list.remove(2);
   }
   
   @Test
   public void testRemove()
   {
      list.add("def");
      list.add("abc");
      list.add("def");
      String s = "def";
      boolean remove = list.remove(s);
      assertEquals(true, remove);
      assertEquals(2, list.size());
      assertEquals(1, list.indexOf(s));
   }
    
  @Test(expected = NullPointerException.class)
   public void testRemove1()
   {
      list.remove(null);
   } 
   
   @Test
   public void testRemoveAll()
   {
      list.add(1);
      list.add(2);
      list.add(3);
      HCollection c = new CollectionAdapter();
      c.add(1);
      c.add(2);
      boolean removeAll = list.removeAll(c);
      assertEquals(true, removeAll);
      assertEquals(1, list.size());
      assertEquals(true, list.contains(3));
      assertEquals(false, list.contains(2));
      assertEquals(false, list.contains(1));
   } 
   
   @Test
   public void testRemoveAll1()
   {
      HCollection c = new CollectionAdapter();
      list.add(1);
      list.add(2);
      list.add(3);
      boolean removeAll = list.removeAll(c);
      assertEquals(false, removeAll);
      assertEquals(3, list.size());     
   }  
   
   @Test
   public void testRemoveAll2()
   {
      HCollection c = new CollectionAdapter();
      list.add(1);
      list.add(2);
      list.add(3);
      c.add(4);
      c.add(5);
      c.add(6);      
      boolean removeAll = list.removeAll(c);
      assertEquals(false, removeAll);
      assertEquals(3, list.size());       
   }  
    
   @Test(expected = NullPointerException.class)
   public void testRemoveAll3()
   {
      list.removeAll(null);
   } 
   
   @Test
   public void testRetainAll()
   {
      list.add(1);
      list.add(2);
      list.add(3);
      HCollection c = new CollectionAdapter();
      boolean retainAll = list.retainAll(c);
      assertEquals(true,list.isEmpty());
      assertEquals(0, list.size());
      assertEquals(true, retainAll);
   } 
   
   @Test
   public void testRetainAll1()
   {
      list.add(1);
      list.add(2);
      list.add(3);
      HCollection c = new CollectionAdapter();
      c.add(1);
      c.add(2);
      c.add(4);
      boolean retainAll = list.retainAll(c);
      assertEquals(true, retainAll);
      assertEquals(2, list.size());
      assertEquals(true, list.contains(1));
      assertEquals(true, list.contains(2));
      assertEquals(false, list.contains(3));
   } 
   
   @Test
   public void testRetainAll2()
   {
      HCollection c = new CollectionAdapter();
      list.add(1);
      list.add(2);
      list.add(3);
      c.add(1);
      c.add(2);
      c.add(3);
      boolean retainAll = list.retainAll(c);
      assertEquals(false, retainAll);
      assertEquals(3, list.size()); 
   }  
    
   @Test(expected = NullPointerException.class)
   public void testRetainAll3()
   {
      list.retainAll(null);
   }
   
   @Test
   public void testSet()
   {
      list.add("abc");
      list.add("def");
      list.add("ghi");
      String s = "def";
      Object set = list.set(1, "adg");
      assertEquals(s, set);
      assertEquals(3, list.size());
      assertEquals(false, list.contains(s));
      assertEquals(true, list.contains("adg"));
   } 
    
   @Test(expected = NullPointerException.class)
   public void testSet1()
   {
      list.set(0, null);
   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void testSet2()
   {
      list.set(-1, 1);
   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void testSet3()
   {
      list.add("abc");
      list.set(1, "def");
   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void testSet4()
   {
      list.add("abc");
      list.set(2, "def");
   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void testSubList()
   {
      list.add("abc");
      list.subList(-1,1);
   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void testSubList1()
   {
      list.add("abc");
      list.add("def");
      list.subList(1,3);
   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void testSubList2()
   {
      list.add("abc");
      list.add("def");
      list.subList(1,0);
   }
   
   @Test
   public void testToArray()
   {
      list.add(2);
      list.add(1);
      list.add(3);
      Object[] array = list.toArray();
      assertEquals(array.length, list.size()); 
      assertEquals(2, array[0]);
      assertEquals(1, array[1]);
      assertEquals(3, array[2]);      
   } 
   
   @Test
   public void testToArrayObject()
   {
      list.add(3);
      list.add(1);
      list.add(2);
      Integer[] a = new Integer[]{1,2,3,4};
      Object[] array = list.toArray(a);
      assertEquals(array.length, 4); 
      assertEquals(null, array[list.size()]);
      assertEquals(3, array[0]);
      assertEquals(1, array[1]);
      assertEquals(2, array[2]);
   }
   
   @Test
   public void testToArrayObject1()
   {
      list.add(3);
      list.add(1);
      list.add(2);
      Integer[] a = new Integer[]{1,2};
      Object[] array = list.toArray(a);
      assertEquals(array.length, 3); 
      assertEquals(3, array[0]);
      assertEquals(1, array[1]);
      assertEquals(2, array[2]);
   }
      
   @Test
   public void testToArrayObject2()
   {
      list.add(3);
      list.add(1);
      list.add(2);
      String[] a = new String[]{"abc","def"};
      Object[] array = list.toArray(a);
      assertEquals(array.length, 3); 
      assertEquals(3, array[0]);
      assertEquals(1, array[1]);
      assertEquals(2, array[2]);
   }
   
   @Test(expected = ArrayStoreException.class)
   public void testToArrayObject3()
   {
      list.add(1);
      list.add(2);
      list.add(3);
      String[] a = new String[]{"abc","def","ghi","lmn"};
      Object[] array = list.toArray(a);
   }
   
   @Test(expected = NullPointerException.class)
   public void testToArrayObject4()
   {
      list.add(1);
      Object[] array = list.toArray(null);
   }      
}
