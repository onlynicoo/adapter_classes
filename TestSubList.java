import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
public class TestSubList
{
   ListAdapter list = new ListAdapter();
   HList sub = null;
   
   @Before
   public void setUp()
   {
      list.add(3);
      list.add(1);
      list.add(2);
      list.add(4);
      list.add(5);
      list.add(7);
      list.add(4);
      list.add(9);   
      sub = list.subList(2,6);
   }
   
   @Test
   public void testAddIndex()
   {
      sub.add(3, 12);
      sub.add(4, 11);
      sub.add(1, 10);
      assertEquals(7, sub.size());
      assertEquals(11, list.size());
      assertEquals(0, list.indexOf(3));
      assertEquals(1, list.indexOf(1));
      assertEquals(2, list.indexOf(2));
      assertEquals(3, list.indexOf(10));
      assertEquals(4, list.indexOf(4));
      assertEquals(5, list.indexOf(5));
      assertEquals(6, list.indexOf(12));
      assertEquals(7, list.indexOf(11));
      assertEquals(8, list.indexOf(7));
      assertEquals(9, list.lastIndexOf(4));
      assertEquals(10, list.indexOf(9));
      assertEquals(0, sub.indexOf(2));
      assertEquals(1, sub.indexOf(10));
      assertEquals(2, sub.indexOf(4));
      assertEquals(3, sub.indexOf(5));
      assertEquals(4, sub.indexOf(12));
      assertEquals(5, sub.indexOf(11));
      assertEquals(6, sub.indexOf(7));
   } 
   
   @Test(expected = NullPointerException.class)
   public void testAddIndex1()
   {
      sub.add(0, null);
   } 
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void testAddIndex2()
   {
      sub.add(5, 10);
   } 
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void testAddIndex3()
   {
      sub.add(-1, 13);
   } 
    
   @Test
   public void testAdd()
   {
      boolean add = sub.add(13);        
      assertEquals(true, add);
      assertEquals(5, sub.size());
      assertEquals(9, list.size());
      assertEquals(6, list.indexOf(13));
      assertEquals(4, sub.indexOf(13));
   } 
      
   @Test(expected = NullPointerException.class)
   public void testAdd1()
   {
      sub.add(null);
   } 
     
   @Test
   public void testAddAll()
   {
      HCollection c = new CollectionAdapter();
      c.add(11);
      c.add(12);
      boolean addAll = sub.addAll(c);
      assertEquals(true, addAll);
      assertEquals(6, sub.size());
      assertEquals(10, list.size());
      assertEquals(0, list.indexOf(3));
      assertEquals(1, list.indexOf(1));
      assertEquals(2, list.indexOf(2));
      assertEquals(3, list.indexOf(4));
      assertEquals(4, list.indexOf(5));
      assertEquals(5, list.indexOf(7));
      assertEquals(6, list.indexOf(11));
      assertEquals(7, list.indexOf(12));
      assertEquals(8, list.lastIndexOf(4));
      assertEquals(9, list.indexOf(9));
      assertEquals(0, sub.indexOf(2));
      assertEquals(1, sub.indexOf(4));
      assertEquals(2, sub.indexOf(5));
      assertEquals(3, sub.indexOf(7));
      assertEquals(4, sub.indexOf(11));
      assertEquals(5, sub.indexOf(12));
   } 
   
   @Test
   public void testAddAll1()
   {
      HCollection c = new CollectionAdapter();
      boolean addAll = sub.addAll(c);
      assertEquals(false, addAll);
      assertEquals(4, sub.size());
      assertEquals(8, list.size()); 
   }  
    
   @Test(expected = NullPointerException.class)
   public void testAddAll2()
   {
      sub.addAll(null);
   } 
   
   @Test
   public void testAddAllIndex()
   {
      HCollection c = new CollectionAdapter();
      c.add(10);
      c.add(12);
      boolean addAll = sub.addAll(1,c);
      assertEquals(true, addAll);
      assertEquals(6, sub.size());
      assertEquals(10, list.size());
      assertEquals(0, list.indexOf(3));
      assertEquals(1, list.indexOf(1));
      assertEquals(2, list.indexOf(2));
      assertEquals(3, list.indexOf(10));
      assertEquals(4, list.indexOf(12));
      assertEquals(5, list.indexOf(4));
      assertEquals(6, list.indexOf(5));
      assertEquals(7, list.indexOf(7));
      assertEquals(8, list.lastIndexOf(4));
      assertEquals(9, list.indexOf(9));
      assertEquals(0, sub.indexOf(2));
      assertEquals(1, sub.indexOf(10));
      assertEquals(2, sub.indexOf(12));
      assertEquals(3, sub.indexOf(4));
      assertEquals(4, sub.indexOf(5));
      assertEquals(5, sub.indexOf(7));
   } 
   
   @Test
   public void testAddAllIndex1()
   {
      HCollection c = new CollectionAdapter();
      boolean addAll = sub.addAll(2, c);
      assertEquals(false, addAll);
      assertEquals(4, sub.size()); 
      assertEquals(8, list.size());      
   }  
    
   @Test(expected = NullPointerException.class)
   public void testAddAllIndex2()
   {
      sub.addAll(0, null);
   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void testAddAllIndex3()
   {
      sub.addAll(-1, new CollectionAdapter());
   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void testAddAllIndex4()
   {
      sub.addAll(5, new CollectionAdapter());
   }
   
   @Test
   public void testClear()
   {
      sub.clear(); 
      assertEquals(true, sub.isEmpty());
      assertEquals(4, list.size());         
   } 
   
   @Test(expected = NullPointerException.class)
   public void testContains()
   {
      sub.contains(null);     
   } 
   
  @Test
   public void testContains1()
   {
      assertEquals(true, sub.contains(2)); 
      assertEquals(true, sub.contains(4)); 
      assertEquals(true, sub.contains(5)); 
      assertEquals(true, sub.contains(7));
      assertEquals(false, sub.contains(9));     
   } 
   
   @Test
   public void testContainsAll()
   {
      HCollection c = new CollectionAdapter();
      boolean containsAll = sub.containsAll(c);
      assertEquals(true, containsAll);          
   } 
   
   @Test
   public void testContainsAll1()
   {
      HCollection c = new CollectionAdapter();
      c.add(7);
      c.add(2);     
      boolean containsAll = sub.containsAll(c);
      assertEquals(true, containsAll);          
   } 
   
   @Test
   public void testContainsAll2()
   {
      HCollection c = new CollectionAdapter();
      c.add(7);
      c.add(2);     
      c.add(1);
      boolean containsAll = sub.containsAll(c);
      assertEquals(false, containsAll);           
   } 
   
   @Test(expected = NullPointerException.class)
   public void testContainsAll3()
   {
      sub.containsAll(null);     
   }
   
   @Test
   public void testEquals()
   {
      ListAdapter list1 = new ListAdapter(); 
      list1.add(2);
      list1.add(4);
      list1.add(5);
      list1.add(7);
      boolean equals = sub.equals(list1);
      assertEquals(true, equals);         
   } 
   
   @Test
   public void testEquals1()
   {
      ListAdapter list1 = new ListAdapter(); 
      list1.add(2);
      list1.add(4);         
      list1.add(7);
      list1.add(5);
      boolean equals = sub.equals(list1);
      assertEquals(false, equals);                
   } 
   
   @Test
   public void testEquals2()
   {
      HSet s = new SetAdapter();
      boolean equals = sub.equals(s);
      assertEquals(false, equals);
   }
   
   @Test(expected = NullPointerException.class)
   public void testEquals3()
   {
      sub.equals(null);     
   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void testGet()
   {
      sub.get(-1);
   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void testGet1()
   {
      sub.get(4);
   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void testGet2()
   {
      sub.get(5);
   }
      
   @Test
   public void testHashCode()
   {
      sub.clear();
      assertEquals(sub.hashCode(), 1);   
   }  
   
   @Test
   public void testHashCode1()
   {
      ListAdapter list1 = new ListAdapter(); 
      list1.add(2);
      list1.add(4);
      list1.add(5);
      list1.add(7);
      assertEquals(sub.hashCode(), list1.hashCode());     
   }
   
   @Test
   public void testHashCode2()
   {
      ListAdapter list1 = new ListAdapter(); 
      list1.add(5);
      list1.add(4);
      list1.add(2);
      list1.add(7);
      assertNotEquals(sub.hashCode(), list1.hashCode());      
   }
   
   @Test(expected = NullPointerException.class)
   public void testIndexOf()
   {
      sub.indexOf(null);
   }
   
   @Test
   public void testIndexOf1()
   {
      sub.add(5);
      assertEquals(0, sub.indexOf(2));
      assertEquals(1, sub.indexOf(4));
      assertEquals(2, sub.indexOf(5));
      assertEquals(3, sub.indexOf(7));
   }
   
   @Test
   public void testIterator()
   {
      HIterator iter = sub.iterator();
      assertEquals(true, iter.hasNext());
      Object n1 = iter.next();
      assertEquals(2, n1);
      assertEquals(true, iter.hasNext());
      Object n2 = iter.next();
      assertEquals(4, n2);
      assertEquals(true, iter.hasNext());
      Object n3 = iter.next();
      assertEquals(5, n3);
      assertEquals(true, iter.hasNext());
      Object n4 = iter.next();
      assertEquals(7, n4);
      assertEquals(false, iter.hasNext()); 
   }
   
   @Test
   public void testIterator1()
   {
      HIterator iter = sub.iterator();
      Object n1 = iter.next();
      iter.remove();
      assertEquals(false, sub.contains(n1));
      Object n2 = iter.next();
      iter.remove();
      assertEquals(false, sub.contains(n2));
      Object n3 = iter.next();
      iter.remove();
      assertEquals(false, sub.contains(n3));
      Object n4 = iter.next();
      iter.remove();
      assertEquals(false, sub.contains(n4));  
      assertEquals(4, list.size());  
   }
   
   @Test(expected = java.util.NoSuchElementException.class)
   public void testIterator2()
   {
      HIterator iter = sub.iterator();
      iter.next();
      iter.next();
      iter.next();
      iter.next();
      iter.next();
   }
   
   @Test(expected = IllegalStateException.class)
   public void testIterator3()
   {
      HIterator iter = sub.iterator();
      iter.remove();
   }
   
   @Test(expected = IllegalStateException.class)
   public void testIterator4()
   {
      HIterator iter = sub.iterator();
      iter.next();
      iter.remove();
      iter.remove();
   }
   
   @Test(expected = NullPointerException.class)
   public void testlastIndexOf()
   {
      sub.lastIndexOf(null);
   }
   
   @Test
   public void testlastIndexOf1()
   {
      sub.add(2);
      sub.add(4);
      sub.add(5);
      sub.add(7);
      int index1 = sub.lastIndexOf(2);
      int index2 = sub.lastIndexOf(4);
      int index3 = sub.lastIndexOf(5);
      int index4 = sub.lastIndexOf(7);
      assertEquals(4, index1); 
      assertEquals(5, index2); 
      assertEquals(6, index3);    
      assertEquals(7, index4);       
   }
   
   @Test
   public void testlastIndexOf2()
   {
      int index = sub.lastIndexOf(3);
      assertEquals(-1, index); 
   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void testListIteratorIndex()
   {
      HListIterator iter = sub.listIterator(-1);
   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void testListIteratorIndex1()
   {
      HListIterator iter = sub.listIterator(5);
   }
   
   @Test
   public void testRemoveIndex()
   {
      Object remove = sub.remove(2);
      assertEquals(5, remove);
      assertEquals(3, sub.size());
      assertEquals(7, list.size());
      assertEquals(false, sub.contains(5));
      assertEquals(false, list.contains(5));
   } 
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void testRemoveIndex1()
   {
      Object remove = sub.remove(-1);
   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void testRemoveIndex2()
   {
      Object remove = sub.remove(4);
   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void testRemoveIndex3()
   {
      Object remove = sub.remove(5);
   }
   
   @Test
   public void testRemove()
   {
      sub.add(2);
      boolean remove = sub.remove((Object)2);
      assertEquals(true, remove);
      assertEquals(4, sub.size());
      assertEquals(3, sub.indexOf(2));
   }
    
   @Test(expected = NullPointerException.class)
   public void testRemove1()
   {
      sub.remove(null);
   } 
   
   @Test
   public void testRemoveAll()
   {
      HCollection c = new CollectionAdapter();
      c.add(5);
      c.add(2);
      boolean removeAll = sub.removeAll(c);
      assertEquals(true, removeAll);
      assertEquals(2, sub.size());
      assertEquals(6, list.size());
      assertEquals(false, sub.contains(5));
      assertEquals(false, sub.contains(2));
      assertEquals(false, list.contains(5));
      assertEquals(false, list.contains(2));
   } 
   
   @Test
   public void testRemoveAll1()
   {
      HCollection c = new CollectionAdapter();
      boolean removeAll = sub.removeAll(c);
      assertEquals(false, removeAll);
      assertEquals(4, sub.size());
      assertEquals(8, list.size());   
   }  
   
   @Test
   public void testRemoveAll2()
   {
      HCollection c = new CollectionAdapter();
      c.add(9);
      c.add(1);
      c.add(6);      
      boolean removeAll = sub.removeAll(c);
      assertEquals(false, removeAll);
      assertEquals(4, sub.size());
      assertEquals(8, list.size());       
   }  
    
   @Test(expected = NullPointerException.class)
   public void testRemoveAll3()
   {
      sub.removeAll(null);
   } 
   
   @Test
   public void testRetainAll()
   {
      HCollection c = new CollectionAdapter();
      boolean retainAll = sub.retainAll(c);
      assertEquals(true, sub.isEmpty());
      assertEquals(0, sub.size());
      assertEquals(true, retainAll);
   } 
   
   @Test
   public void testRetainAll1()
   {
      HCollection c = new CollectionAdapter();
      c.add(2);
      c.add(4);
      boolean retainAll = sub.retainAll(c);
      assertEquals(true, retainAll);
      assertEquals(2, sub.size());
      assertEquals(6, list.size());
      assertEquals(false, sub.contains(5));
      assertEquals(false, sub.contains(7));
      assertEquals(true, sub.contains(2));
      assertEquals(true, sub.contains(4));
      assertEquals(false, list.contains(5));
      assertEquals(false, list.contains(7));
   } 
   
   @Test
   public void testRetainAll2()
   {
      HCollection c = new CollectionAdapter();
      c.add(2);
      c.add(4);
      c.add(5);
      c.add(7);
      boolean retainAll = sub.retainAll(c);
      assertEquals(false, retainAll);
      assertEquals(4, sub.size()); 
      assertEquals(8, list.size()); 
   }  
    
   @Test(expected = NullPointerException.class)
   public void testRetainAll3()
   {
      sub.retainAll(null);
   }
   
   @Test
   public void testSet()
   {
      Object set = sub.set(1, 6);
      assertEquals(4, set);
      assertEquals(4, sub.size());
      assertEquals(8, list.size()); 
      assertEquals(false, sub.contains(set));
      assertEquals(true, sub.contains(6));
      assertEquals(true, list.contains(6));
   } 
    
   @Test(expected = NullPointerException.class)
   public void testSet1()
   {
      sub.set(0, null);
   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void testSet2()
   {
      sub.set(-1, 1);
   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void testSet3()
   {
      sub.set(4, 3);
   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void testSet4()
   {
      sub.set(5, 5);
   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void testSubList()
   {
      sub.subList(-1,1);
   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void testSubList1()
   {
      sub.subList(1,5);
   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void testSubList2()
   {
      sub.subList(1,0);
   }
   
   @Test
   public void testSubList3()
   {
      HList s = sub.subList(1,3);
      assertEquals(2, s.size());
      s.add(6);
      assertEquals(3, s.size());
      assertEquals(5, sub.size());
      assertEquals(9, list.size());
      assertEquals(true, s.contains(6));
      assertEquals(true, sub.contains(6));
      assertEquals(true, list.contains(6));
      s.remove((Object)5);
      assertEquals(2, s.size());
      assertEquals(4, sub.size());
      assertEquals(8, list.size());
      assertEquals(false, s.contains(5));
      assertEquals(false, sub.contains(5));
      assertEquals(false, list.contains(5));
      s.remove(1);
      assertEquals(1, s.size());
      assertEquals(3, sub.size());
      assertEquals(7, list.size());
      assertEquals(false, s.contains(6));
      assertEquals(false, sub.contains(6));
      assertEquals(false, list.contains(6));     
   }
     
   @Test
   public void testToArray()
   {
      Object[] array = sub.toArray();
      assertEquals(array.length, sub.size()); 
      assertEquals(2, array[0]);
      assertEquals(4, array[1]);
      assertEquals(5, array[2]); 
      assertEquals(7, array[3]);      
   } 
   
   @Test
   public void testToArrayObject()
   {
      Integer[] a = new Integer[]{1,2,3,4,5};
      Object[] array = sub.toArray(a);
      assertEquals(array.length, 5); 
      assertEquals(null, array[sub.size()]);
      assertEquals(2, array[0]);
      assertEquals(4, array[1]);
      assertEquals(5, array[2]); 
      assertEquals(7, array[3]); 
   }
   
   @Test
   public void testToArrayObject1()
   {
      Integer[] a = new Integer[]{1,2};
      Object[] array = sub.toArray(a);
      assertEquals(array.length, sub.size()); 
      assertEquals(2, array[0]);
      assertEquals(4, array[1]);
      assertEquals(5, array[2]); 
      assertEquals(7, array[3]); 
   }
      
   @Test
   public void testToArrayObject2()
   {
      String[] a = new String[]{"abc","def"};
      Object[] array = sub.toArray(a);
      assertEquals(array.length, sub.size()); 
      assertEquals(2, array[0]);
      assertEquals(4, array[1]);
      assertEquals(5, array[2]); 
      assertEquals(7, array[3]); 
   }
   
   @Test(expected = ArrayStoreException.class)
   public void testToArrayObject3()
   {
      String[] a = new String[]{"abc","def","ghi","lmn"};
      Object[] array = sub.toArray(a);
   }
   
   @Test(expected = NullPointerException.class)
   public void testToArrayObject4()
   {
      Object[] array = sub.toArray(null);
   } 
}
