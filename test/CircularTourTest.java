package test;

import geeks4geeks.CircularTour;
import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CircularTourTest {

  private static CircularTour object;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    object = new CircularTour();
  }

  // 4 6 6 5 7 3 4 5
  @Test
  public void testTour() {
    int[] petrol = {87, 40, 71, 79, 2, 3, 93, 57, 81, 42, 90, 20, 30};
    int[] distance = {27, 95, 96, 35, 68, 98, 18, 53, 2, 87, 66, 45, 41};

    int result = object.tour(petrol, distance);
    Assert.assertEquals(-1, result);

    petrol = new int[] {4, 6, 7, 4};
    distance = new int[] {6, 5, 3, 5};

    result = object.tour(petrol, distance);
    Assert.assertEquals(1, result);
  }

}
