package design;

public class MyQueue {
  int[] arr;
  int start, end;

  int capacity;
  int size;
  private static final int DEFAULT_CAPACITY = 100;

  public MyQueue() {
    // TODO Auto-generated constructor stub
    capacity = DEFAULT_CAPACITY;
    arr = new int[capacity];
    size = 0;
    start = end = 0;
  }

  public MyQueue(int c) {
    capacity = c;
    arr = new int[capacity];
    size = 0;
    start = end = 0;
  }

  // O(1) .. amortized O(n)
  public void enqueue(int x) {
    if (size < capacity) {
      size++;
    } else {
      resize();
      size++;
    }
    arr[end] = x;
    end = (end + 1) % capacity;

  }

  private void resize() {
    int[] temp = arr;
    int newCapacity = capacity * 2;
    arr = new int[newCapacity];
    start = end = 0;
    size = 0;
    capacity = newCapacity;
    for (int i = 0; i < temp.length; i++) {
      enqueue(temp[i]);
    }
  }

  public int dequeue() {
    if (size == 0)
      return -1;
    size--;
    int value = arr[start];
    start = (start + 1) % capacity;

    return value;
  }

  public int getSize() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }
}
