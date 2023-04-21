import org.junit.runner.RunWith;
import org.junit.runners.Suite; 
 
//Suite Test 
@RunWith(Suite.class) 
@Suite.SuiteClasses({TestSetAdapter.class, TestMapAdapter.class, TestListAdapter.class, TestSubList.class, TestEntrySet.class, TestKeySet.class, TestValues.class, TestCollectionAdapter.class, TestListIterator.class, TestSubListIterator.class})
public class TestSuite { } 
