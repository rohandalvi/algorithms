package test;

import algorithms.SkylineProblem;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SkylineProblemTest {

  static SkylineProblem object;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    object = new SkylineProblem();
  }

  @Test
  public void testGetSkyline() {
    int[][] skylinePoints = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
    List<int[]> results = object.getSkyline(skylinePoints);
    List<int[]> expected = new ArrayList<>();
    expected.add(new int[] {2, 10});
    expected.add(new int[] {3, 15});
    expected.add(new int[] {7, 12});
    expected.add(new int[] {12, 0});
    expected.add(new int[] {15, 10});
    expected.add(new int[] {20, 8});
    expected.add(new int[] {24, 0});

    Assert.assertEquals(7, results.size());
    for (int i = 0; i < results.size(); i++) {
      int[] temp = results.get(i);
      Assert.assertArrayEquals(expected.get(i), temp);
    }
  }

  private void display(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

}
