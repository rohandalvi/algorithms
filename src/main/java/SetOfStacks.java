package ctci.stacks;

import java.util.Stack;

public class SetOfStacks {

  int capacity;
  Stack<Integer>[] arr;
  int buckets;
  int currBucket;

  public SetOfStacks(int capacity) {
    this.capacity = capacity;
    buckets = capacity * 10;
    arr = new Stack[buckets];
    currBucket = 0;
    for (int i = 0; i < arr.length; i++) {
      arr[i] = new Stack<Integer>();
    }
  }

  public void push(int x) {
    if (currBucket == buckets - 1 && arr[currBucket].size() == capacity) {
      resize();
    } else {
      if (arr[currBucket].size() == capacity) {
        currBucket++;
      }
    }
    arr[currBucket].push(x);

  }

  public int pop() {
    if (arr[currBucket].size() == 0) {
      if (currBucket == 0)
        return -1;
      else
        return arr[--currBucket].pop();
    } else {
      return arr[currBucket].pop();
    }
  }

  private void resize() {
    buckets *= 2;
    Stack<Integer>[] temp = arr;
    arr = new Stack[buckets];
    int i = 0;
    for (i = 0; i < temp.length; i++) {
      arr[i] = temp[i];
    }
    currBucket = i;
    for (int j = currBucket; j < arr.length; j++) {
      arr[j] = new Stack<Integer>();
    }

  }

}
