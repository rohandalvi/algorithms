package test;

import algorithms.MinimumNumberOfArrowsToBurstBalloons;
import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class MinimumNumberOfArrowsToBurstBalloonsTest {

  static MinimumNumberOfArrowsToBurstBalloons object;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    object = new MinimumNumberOfArrowsToBurstBalloons();
  }

  @SuppressWarnings("deprecation")
  @Test
  public void test() {
    int[][] testArray = {{10, 6}, {2, 8}, {1, 6}, {7, 12}};
    Assert.assertEquals(2, object.minArrowsRequired(testArray));
  }

}
