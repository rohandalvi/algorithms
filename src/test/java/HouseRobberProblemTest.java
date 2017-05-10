package test;

import algorithms.HouseRobberProblem;
import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class HouseRobberProblemTest {

  static HouseRobberProblem object;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    object = new HouseRobberProblem();
  }

  @SuppressWarnings("deprecation")
  @Test
  public void test() {
    int[] cost = {1, 4, 5, 6, 10, 2, 3, 4};
    Assert.assertEquals(20, object.robI(cost));
    Assert.assertEquals(19, object.robII(cost));
  }

}
