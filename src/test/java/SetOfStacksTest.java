package test;

import ctci.stacks.SetOfStacks;
import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SetOfStacksTest {

  static SetOfStacks stacks;
  static final int CAPACITY = 10;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    stacks = new SetOfStacks(CAPACITY);
  }

  @Test
  public void test() {
    final int ITERATIONS = 1000;
    for (int i = 0; i < ITERATIONS; i++) {
      stacks.push(i);
    }

    for (int i = 999; i >= 0; i--) {
      Assert.assertEquals(stacks.pop(), i);
    }
  }

}
