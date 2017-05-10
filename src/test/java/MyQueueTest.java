package test;

import design.MyQueue;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyQueueTest {

  static MyQueue object;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    object = new MyQueue();
  }

  @Test
  public void testEnqueue() {
    for (int i = 0; i < 200; i++) {
      object.enqueue(i);
    }
  }



  @Test
  public void testGetSize() {
    Assert.assertEquals(200, object.getSize());
  }

}
