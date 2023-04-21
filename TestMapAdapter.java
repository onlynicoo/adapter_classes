import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
public class TestMapAdapter
{
   MapAdapter map = new MapAdapter();
   
   @Before
   public void setUp()
   {
      map.put(1, "tre");
      map.put(2, "tre");
      map.put(3, "tre");
      map.put(4, "sette");
      map.put(5, "sei");
      map.put(6, "tre");
   }
   
   @Test
   public void testClear()
   {
      map.clear();
      assertEquals(0, map.size());
   }
   
   @Test
   public void testContainsKey()
   {
      boolean contains = map.containsKey(2);
      assertEquals(true, contains);
      contains = map.containsKey(7);
      assertEquals(false, contains);
   } 
    
   @Test(expected = NullPointerException.class)
   public void testContainsKey1()
   {
      map.containsKey(null);
   }
   
   @Test
   public void testContainsValue()
   {
      boolean contains = map.containsValue("tre");
      assertEquals(true, contains);
      contains = map.containsValue("due");
      assertEquals(false, contains);
   } 
    
  @Test(expected = NullPointerException.class)
   public void testContainsValue1()
   {
      map.containsValue(null);
   } 
   
   @Test
   public void testEquals()
   {
      MapAdapter map1 = new MapAdapter(); 
      map1.put(6, "tre");
      map1.put(5, "sei");
      map1.put(4, "sette");
      map1.put(3, "tre");
      map1.put(2, "tre");
      map1.put(1, "tre");
      boolean equals = map.equals(map1);
      assertEquals(true, equals);         
   } 
   
   @Test
   public void testEquals1()
   {
      MapAdapter map1 = new MapAdapter(); 
      map1.put(6, "tre");
      map1.put(5, "sei");
      map1.put(4, "sette");
      map1.put(3, "tre");
      map1.put(2, "due");
      map1.put(1, "tre");
      boolean equals = map.equals(map1);
      assertEquals(false, equals);                   
   } 
   
   @Test
   public void testEquals2()
   {
      HCollection c = new CollectionAdapter();
      boolean equals = map.equals(c);
      assertEquals(false, equals);
   }
   
   @Test(expected = NullPointerException.class)
   public void testEquals3()
   {
      map.equals(null);     
   }
   
   @Test
   public void testGet()
   {
      Object get = map.get(3);
      assertEquals("tre", get);
      get = map.get(7);
      assertEquals(null, get);
   } 
    
   @Test(expected = NullPointerException.class)
   public void testGet1()
   {
      map.get(null);
   }
   
   @Test
   public void testHashCode()
   {
      map.clear();
      assertEquals(map.hashCode(), 0);   
   }  
   
   @Test
   public void testHashCode1()
   {
      MapAdapter map1 = new MapAdapter(); 
      map1.put(6, "tre");
      map1.put(5, "sei");
      map1.put(4, "sette");
      map1.put(3, "tre");
      map1.put(2, "tre");
      map1.put(1, "tre");
      assertEquals(map.hashCode(), map1.hashCode());
      map1.put(7, "cinque");
      assertNotEquals(map.hashCode(), map1.hashCode());      
   } 
   
   @Test
   public void testHashCode2()
   {
      MapAdapter map1 = new MapAdapter(); 
      map1.put(6, "tre");
      map1.put(5, "sei");
      map1.put(4, "sette");
      map1.put(3, "tre");
      map1.put(2, "tre");
      map1.put(1, "tre");
      map1.put(7, "cinque");
      assertNotEquals(map.hashCode(), map1.hashCode());      
   } 
   
   @Test
   public void testPut()
   {
      Object put = map.put(7, "cinque");
      assertEquals(null, put);
      assertEquals(7, map.size());
      assertEquals(true, map.containsKey(7));
      assertEquals("cinque", map.get(7));   
   } 
   
   @Test
   public void testPut1()
   {
      Object put = map.put(2, "due");
      assertEquals("tre", put);
      assertEquals(6, map.size());
      assertEquals(true, map.containsKey(2));
      assertEquals("due", map.get(2));      
   } 
   
   @Test(expected = NullPointerException.class)
   public void testPut2()
   {
      map.put(null, "zero");
   } 
   
   @Test(expected = NullPointerException.class)
   public void testPut3()
   {
      map.put(0, null);
   } 
   
   @Test
   public void testPutAll()
   {
      HMap map1 = new MapAdapter(); 
      map1.put(1, "uno");
      map1.put(7, "cinque");
      map1.put(0, "quattro");
      map.putAll(map1);      
      assertEquals(8, map.size());
      assertEquals(true, map.containsKey(7));
      assertEquals(true, map.containsKey(0));
      assertEquals("cinque", map.get(7));
      assertEquals("quattro", map.get(0));
      assertEquals("uno", map.get(1));   
   } 
   
   @Test(expected = NullPointerException.class)
   public void testPutAll1()
   {
      map.putAll(null);
   } 
   
   @Test
   public void testRemove()
   {
      Object remove = map.remove(3);
      assertEquals("tre", remove);
      assertEquals(5, map.size());
      assertEquals(false, map.containsKey(3));
      assertEquals(true, map.containsValue("tre"));
   } 
   
   @Test
   public void testRemove1()
   {
      Object remove = map.remove(7);
      assertEquals(null, remove);
      assertEquals(6, map.size());   
   } 
   
   @Test(expected = NullPointerException.class)
   public void testRemove2()
   {
      map.remove(null);
   }    
}     
