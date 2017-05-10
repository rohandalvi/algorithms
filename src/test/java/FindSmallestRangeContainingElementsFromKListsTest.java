package test;

import geeks4geeks.FindSmallestRangeContainingElementsFromKLists;
import org.junit.BeforeClass;
import org.junit.Test;

public class FindSmallestRangeContainingElementsFromKListsTest {

  static FindSmallestRangeContainingElementsFromKLists object;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    object = new FindSmallestRangeContainingElementsFromKLists();
  }

  @Test
  public void testFindSmallestRange() {
    int[][] input = {{4, 7, 9, 12, 15}, {0, 8, 10, 14, 20}, {6, 12, 16, 30, 50}};
    int[][] input2 = {{4, 7, 30}, {1, 2, 50}, {20, 40, 90}};

    int[] res = object.findSmallestRange(input2, input2.length);
    System.out.println(res[0] + ", " + res[1]);
  }

}
