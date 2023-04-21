import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
public class TestCollectionAdapter
{
   CollectionAdapter c = new CollectionAdapter();
   
   @Test
   public void testEquals()
   {
      c.add(1);
      c.add(2);
      c.add(3);
      HList l = new ListAdapter(); 
      l.add(1);
      l.add(2);
      l.add(3);   
      boolean equals = c.equals(l);
      assertEquals(false, equals);         
   } 
   
   @Test
   public void testEquals1()
   {
      c.add(1);
      c.add(2);
      c.add(3);
      HCollection c1 = new CollectionAdapter(); 
      c1.add(1);
      c1.add(3);
      c1.add(2);         
      boolean equals = c.equals(c1);
      assertEquals(true, equals);                
   } 
   
   @Test
   public void testEquals2()
   {
      c.add(1);
      c.add(2);
      c.add(3);
      c.add(2);
      HCollection c1 = new CollectionAdapter(); 
      c1.add(1);
      c1.add(3);
      c1.add(2);
      c1.add(3);         
      boolean equals = c.equals(c1);
      assertEquals(false, equals); 
   }
   
   @Test(expected = NullPointerException.class)
   public void testEquals3()
   {
      c.equals(null);     
   }
   
   @Test
   public void testHashCode()
   {
      assertEquals(c.hashCode(), 0);   
   }  
   
   @Test
   public void testHashCode1()
   {
      c.add(1);
      c.add(2);
      c.add(3);
      HCollection c1 = new CollectionAdapter(); 
      c1.add(1);
      c1.add(3);
      c1.add(2);
      assertEquals(c.hashCode(), c1.hashCode());   
   }
   
   @Test
   public void testHashCode2()
   {
      c.add(1);
      c.add(2);
      c.add(3);
      HList list1 = new ListAdapter(); 
      list1.add(1);
      list1.add(2);
      list1.add(3);
      assertNotEquals(c.hashCode(), list1.hashCode());   
   }
}
