package test;

import algorithms.LL;
import algorithms.ListNode;
import org.junit.BeforeClass;
import org.junit.Test;

public class LLTest {

  static LL ll;
  ListNode<Integer> head;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    ll = new LL();
  }

  @Test
  public void test() {
    helper();
    head = ll.reorderList(head);
    display();

  }

  public void helper() {
    head = ll.insert(new int[] {1, 2, 3, 4, 5});
  }

  public void display() {
    ListNode<Integer> curr = head;
    while (curr != null) {
      System.out.print(curr.val + "->");
      curr = curr.next;
    }
  }

}
