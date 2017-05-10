package geeks4geeks;

import java.util.PriorityQueue;

public class LargestElementsInArray {
  PriorityQueue<Integer> queue;
  int limit;
  private static final int DEFAULT_LIMIT = 10;

  public LargestElementsInArray() {
    // TODO Auto-generated constructor stub
    queue = new PriorityQueue<>();
    limit = DEFAULT_LIMIT;
  }

  public LargestElementsInArray(int limit) {

    // TODO Auto-generated constructor stub
    queue = new PriorityQueue<>();
    this.limit = limit;
  }

  public PriorityQueue<Integer> getKLargestElementsInStream() {
    return queue;
  }

  public void addToStream(int x) {
    if (queue.size() == limit) {
      if (x > queue.peek()) {
        queue.poll();
        queue.offer(x);
      }
    } else {
      queue.offer(x);
    }
  }
}
