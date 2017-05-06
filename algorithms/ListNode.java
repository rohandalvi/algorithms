package algorithms;

public class ListNode<E> {
  public E val;
  public ListNode<E> next;

  ListNode(E val) {
    this.val = val;
    next = null;
  }
}
