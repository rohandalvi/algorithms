package algorithms;

import java.util.Stack;

public class SortStack {
  public void sort(Stack<Integer> stack) {
    if (stack == null || stack.size() < 2)
      return;
    int top = stack.pop();
    sort(stack);
    Stack<Integer> temp = new Stack<>();
    while (!stack.isEmpty() && top < stack.peek()) {
      temp.push(stack.pop());
    }
    stack.push(top);
    while (!temp.isEmpty()) {
      stack.push(temp.pop());
    }
  }

  public static void main(String[] args) {
    Stack<Integer> s = new Stack<>();
    s.push(10);
    s.push(5);
    s.push(20);
    s.push(15);
    s.push(0);
    s.push(15);

    SortStack ss = new SortStack();
    ss.sort(s);

    while (!s.isEmpty()) {
      System.out.println(s.pop());
    }
  }
}
