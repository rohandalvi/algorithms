package algorithms;

import java.util.Stack;

public class LL {
  ListNode<Integer> head;

  public ListNode<Integer> reorderList(ListNode<Integer> head) {
    if (head == null || head.next == null)
      return head;
    Stack<ListNode<Integer>> stack = new Stack<>();
    ListNode<Integer> curr = head;
    while (curr != null) {
      stack.push(curr);
      curr = curr.next;
    }
    System.out.println("stack size " + stack.size());
    curr = head;

    ListNode<Integer> res = helper(curr, stack, 0);
    if (!stack.isEmpty()) {
      ListNode<Integer> t = stack.pop();
      t.next = null;
    }
    return res;
  }

  ListNode<Integer> helper(ListNode<Integer> curr, Stack<ListNode<Integer>> stack, int count) {
    if (curr == null || count > stack.size())
      return curr;
    ListNode<Integer> first = curr;
    ListNode<Integer> second = stack.pop();
    ListNode<Integer> temp = first.next;
    first.next = second;
    second.next = helper(temp, stack, count + 1);
    return first;

  }

  public ListNode<Integer> insert(int[] a) {
    if (a == null || a.length == 0)
      return null;

    if (head == null)
      head = new ListNode<Integer>(a[0]);
    ListNode<Integer> curr = head;
    for (int i = 1; i < a.length; i++) {
      curr.next = new ListNode<Integer>(a[i]);
      curr = curr.next;
    }
    return head;
  }
}
