package test;

import geeks4geeks.AllPossibleStrings;
import org.junit.BeforeClass;
import org.junit.Test;

public class AllPossibleStringsTest {

  static AllPossibleStrings object;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    object = new AllPossibleStrings();
  }

  @Test
  public void test() {
    String str = "abc";
    object.printSpace(str);
    
  }

}
