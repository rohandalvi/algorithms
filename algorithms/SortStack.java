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
}
