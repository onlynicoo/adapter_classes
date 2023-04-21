import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
public class TestListIterator
{
   ListAdapter list = new ListAdapter();
   HListIterator iter = null;
   
   @Before
   public void setUp()
   {
      list.add(3);
      list.add(1);
      list.add(2);
      iter = list.listIterator();
   }
   
   @Test
   public void testNext()
   {
      assertEquals(true, iter.hasNext());
      assertEquals(0, iter.nextIndex());
      Object n1 = iter.next();
      assertEquals(3, n1);      
      assertEquals(true, iter.hasNext());
      assertEquals(1, iter.nextIndex());
      Object n2 = iter.next();
      assertEquals(1, n2);
      assertEquals(true, iter.hasNext());
      assertEquals(2, iter.nextIndex());
      Object n3 = iter.next();
      assertEquals(2, n3);
      assertEquals(false, iter.hasNext());
      assertEquals(3, iter.nextIndex());
   }
   
   @Test
   public void testPrevious()
   {
      iter.next();
      iter.next();
      iter.next();
      assertEquals(true, iter.hasPrevious());
      assertEquals(2, iter.previousIndex());
      Object n3 = iter.previous();
      assertEquals(2, n3);
      assertEquals(true, iter.hasPrevious());
      assertEquals(1, iter.previousIndex());
      Object n2 = iter.previous();
      assertEquals(1, n2);
      assertEquals(true, iter.hasPrevious());
      assertEquals(0, iter.previousIndex());
      Object n1 = iter.previous();
      assertEquals(3, n1);
      assertEquals(false, iter.hasPrevious());
      assertEquals(-1, iter.previousIndex());
   }
   
   @Test(expected = java.util.NoSuchElementException.class)
   public void testExceptionNext()
   {
      iter.next();
      iter.next();
      iter.next();
      iter.next();
   }
   
  @Test(expected = java.util.NoSuchElementException.class)
   public void testExceptionPrevious()
   {
      iter.next();
      iter.previous();
      iter.previous();
   }
   
    
  @Test
   public void testRemove()
   {
      Object n1 = iter.next();
      iter.remove();
      Object n2 = iter.next();
      iter.remove();
      Object n3 = iter.next();
      iter.remove();
      assertEquals(false, list.contains(n1));
      assertEquals(false, list.contains(n2));
      assertEquals(false, list.contains(n3));
   }
   
   @Test
   public void testRemove1()
   {
      iter.next();
      iter.next();
      iter.next();
      Object n3 = iter.previous();
      iter.remove();
      assertEquals(2,n3);
      assertEquals(false, list.contains(n3));
      Object n2 = iter.previous();      
      iter.remove();
      assertEquals(1,n2);
      assertEquals(false, list.contains(n2));
      Object n1 = iter.previous();      
      iter.remove();
      assertEquals(3,n1);
      assertEquals(false, list.contains(n1));
   }
   
   @Test(expected = IllegalStateException.class)
   public void testExceptionRemove()
   {
      iter.remove();
   }
   
  @Test(expected = IllegalStateException.class)
   public void testExceptionRemove1()
   {
      iter.next();
      iter.remove();
      iter.remove();
   }
   
  @Test(expected = IllegalStateException.class)
   public void testExceptionRemove2()
   {
      iter.next();
      iter.add(3);
      iter.remove();
   }
   
   @Test
   public void testAdd()
   {
      iter.next();
      iter.add(3);
      Object n2 = iter.next();
      assertEquals(1,n2);
      assertEquals(true, list.contains(3));
      iter.add(4);
      Object n4 = iter.previous();
      assertEquals(4,n4);
      assertEquals(true, list.contains(4));
   }
   
   @Test(expected = NullPointerException.class)
   public void testExceptionAdd()
   {
      iter.add(null);
   }
   
      
   @Test
   public void testSet()
   {
      Object n1 = iter.next();
      iter.set(0);
      Object n0 = iter.previous();
      assertEquals(0, n0);
      assertEquals(false, list.contains(n1));
      assertEquals(true, list.contains(0));
   }
   
   @Test
   public void testSet1()
   {
      iter.next();
      Object n1 = iter.previous();
      iter.set(0);
      Object n0 = iter.next();
      assertEquals(0, n0);
      assertEquals(false, list.contains(n1));
      assertEquals(true, list.contains(0));
   }
   
   @Test(expected = IllegalStateException.class)
   public void testExceptionSet()
   {
      iter.set(3);
   }
   
   @Test(expected = IllegalStateException.class)
   public void testExceptionSet1()
   {
      iter.next();
      iter.remove();
      iter.set(0);
   }
   
   @Test(expected = IllegalStateException.class)
   public void testExceptionSet2()
   {
      iter.next();
      iter.add(3);
      iter.set(0);
   }
   
   @Test(expected = NullPointerException.class)
   public void testExceptionSet3()
   {
      iter.next();
      iter.set(null);
   }
   
   @Test
   public void testIndexNext()
   {
      iter = list.listIterator(1);
      assertEquals(true, iter.hasNext());
      assertEquals(1, iter.nextIndex());
      Object n1 = iter.next();
      assertEquals(1, n1);      
      assertEquals(true, iter.hasNext());
      assertEquals(2, iter.nextIndex());
      Object n2 = iter.next();
      assertEquals(2, n2);
      assertEquals(false, iter.hasNext());
      assertEquals(3, iter.nextIndex());
   }
   
   @Test
   public void testIndexPrevious()
   {
      iter = list.listIterator(3);
      assertEquals(true, iter.hasPrevious());
      assertEquals(2, iter.previousIndex());
      Object n3 = iter.previous();
      assertEquals(2, n3);
      assertEquals(true, iter.hasPrevious());
      assertEquals(1, iter.previousIndex());
      Object n2 = iter.previous();
      assertEquals(1, n2);
      assertEquals(true, iter.hasPrevious());
      assertEquals(0, iter.previousIndex());
      Object n1 = iter.previous();
      assertEquals(3, n1);
      assertEquals(false, iter.hasPrevious());
      assertEquals(-1, iter.previousIndex());
   }
   
   @Test(expected = java.util.NoSuchElementException.class)
   public void testIndexExceptionNext()
   {
      iter = list.listIterator(3);
      iter.next();
   }
   
   @Test(expected = java.util.NoSuchElementException.class)
   public void testIndexExceptionPrevious()
   {
      iter = list.listIterator(0);
      iter.previous();
   }
   
   @Test
   public void testIndexRemove()
   {
      iter = list.listIterator(1);
      Object n1 = iter.next();
      iter.remove();
      assertEquals(1,n1);
      assertEquals(false, list.contains(n1));
   }
   
   @Test
   public void testIndexRemove1()
   {
      iter = list.listIterator(2);
      Object n2 = iter.previous();
      iter.remove();
      assertEquals(1,n2);
      assertEquals(false, list.contains(n2));
      Object n1 = iter.previous();      
      iter.remove();
      assertEquals(3,n1);
      assertEquals(false, list.contains(n1));
   }
      
   @Test(expected = IllegalStateException.class)
   public void testIndexExceptionRemove()
   {
      iter = list.listIterator(1);
      iter.remove();
   }
   
   @Test(expected = IllegalStateException.class)
   public void testIndexExceptionRemove1()
   {
      iter = list.listIterator(1);
      iter.next();
      iter.remove();
      iter.remove();
   }
   
   @Test(expected = IllegalStateException.class)
   public void testIndexExceptionRemove2()
   {
      iter = list.listIterator(2);
      iter.add(3);
      iter.remove();
   }
   
   @Test
   public void testIndexAdd()
   {
      iter = list.listIterator(1);
      iter.add(3);
      Object n2 = iter.next();
      assertEquals(1,n2);
      assertEquals(true, list.contains(3));
      iter.add(4);
      Object n4 = iter.previous();
      assertEquals(4,n4);
      assertEquals(true, list.contains(4));
   }
   
   @Test(expected = NullPointerException.class)
   public void testIndexExceptionAdd()
   {
      iter = list.listIterator(1);
      iter.add(null);
   }
   
   @Test
   public void testIndexSet()
   {
      iter = list.listIterator(1);
      Object n1 = iter.next();
      assertEquals(1, n1);
      iter.set(0);
      Object n0 = iter.previous();
      assertEquals(0, n0);
      assertEquals(false, list.contains(n1));
      assertEquals(true, list.contains(0));
   }
   
   @Test
   public void testIndexSet1()
   {
      iter = list.listIterator(2);
      Object n1 = iter.previous();
      assertEquals(1, n1);
      iter.set(0);
      Object n0 = iter.next();
      assertEquals(0, n0);
      assertEquals(false, list.contains(n1));
      assertEquals(true, list.contains(0));
   }
   
  @Test(expected = IllegalStateException.class)
   public void testIndexExceptionSet()
   {
      iter = list.listIterator(2);
      iter.set(3);
   }
   
   @Test(expected = IllegalStateException.class)
   public void testIndexExceptionSet1()
   {
      iter = list.listIterator(1);
      iter.next();
      iter.remove();
      iter.set(0);
   }
   
   @Test(expected = IllegalStateException.class)
   public void testIndexExceptionSet2()
   {
      iter = list.listIterator(1);
      iter.add(3);
      iter.set(0);
   }
   
   @Test(expected = NullPointerException.class)
   public void testIndexExceptionSet3()
   {
      iter = list.listIterator(0);
      iter.next();
      iter.set(null);
   }
}
