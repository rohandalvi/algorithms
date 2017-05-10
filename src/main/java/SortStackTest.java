package algorithms;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;
import java.util.Stack;

public class SortStackTest {

  static Stack<Integer> stack;
  static Random random;
  static SortStack ss;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    stack = new Stack<>();
    random = new Random();
    ss = new SortStack();
  }

  @Test
  public void test() {

    for (int i = 0; i < 100; i++) {
      stack.push(random.nextInt());
    }
    ss.sort(stack);
    while (stack.size() > 1) {
      int top = stack.pop();
      assertEquals(true, top >= stack.peek());
    }

  }

}
