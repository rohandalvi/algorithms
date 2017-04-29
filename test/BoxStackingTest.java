package test;

import geeks4geeks.BoxStacking;
import org.junit.BeforeClass;
import org.junit.Test;

public class BoxStackingTest {

  static BoxStacking object;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    object = new BoxStacking();
  }

  @Test
  public void testMaxHeight() {
    int[] length = {1, 3};
    int[] width = {2, 2};
    int[] height = {4, 5};

    int result = object.maxHeight(height, width, length, height.length);
    System.out.println(result);
  }

}
