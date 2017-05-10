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
  public void testDequeue() {
    for (int i = 0; i < 50; i++) {
      object.dequeue();
    }
    Assert.assertEquals(50, object.dequeue());
  }

  @Test
  public void testGetSize() {
    Assert.assertEquals(200, object.getSize());
  }

  @Test
  public void testIsEmpty() {
    Assert.assertEquals(false, object.isEmpty());
  }

}
