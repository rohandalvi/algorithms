package algorithms;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;

public class LFUCache {
  private class Node {
    int count;
    LinkedHashSet<Integer> keys = null;
    Node next = null, prev = null;

    Node(int count) {
      this.count = count;
      keys = new LinkedHashSet<>();
    }
  }

  private Node head;
  int capacity;

  Map<Integer, Integer> valueMap = null;
  Map<Integer, Node> nodeMap = null;

  public LFUCache(int cap) {
    capacity = cap;
    valueMap = new HashMap<>();
    nodeMap = new HashMap<>();
  }

  public int get(int key) {
    if (valueMap.containsKey(key)) {
      int val = valueMap.get(key);
      increaseCount(key);
      return val;
    }
    return -1;
  }

  private void increaseCount(int key) {
    Node node = nodeMap.get(key);
    node.keys.remove(key);

    if (Objects.isNull(node.next)) {
      node.next = new Node(node.count + 1);
      node.next.keys.add(key);
    } else if (node.next.count != node.count + 1) {
      Node n = new Node(node.count + 1);
      n.next = node.next;
      n.next.prev = n;
      n.prev = node;
      node.next = n;
    }
    node.next.keys.add(key);
    nodeMap.put(key, node.next);

    if (node.keys.size() == 0)
      remove(node);

  }

  public void set(int key, int value) {
    if (capacity == 0)
      return;
    if (valueMap.containsKey(key)) {
      valueMap.put(key, value);
    } else {
      if (valueMap.size() < capacity) {
        valueMap.put(key, value);
      } else {
        removeOld();
        valueMap.put(key, value);
      }
      addToHead(key);
    }
    increaseCount(key);
  }

  private void addToHead(int key) {
    if (head == null) {
      head = new Node(0);
    } else {
      if (head.count > 0) {
        Node node = new Node(0);
        node.next = head;
        node.next.prev = node;
        head = node;
      }
      head.keys.add(key);
    }
    nodeMap.put(key, head);
  }

  private void removeOld() {
    if (head == null)
      return;
    int oldKey = 0;
    for (int key : head.keys) {
      oldKey = key;
      break;
    }
    head.keys.remove(oldKey);
    if (head.keys.size() == 0)
      remove(head);
    valueMap.remove(oldKey);
    nodeMap.remove(oldKey);
  }

  private void remove(Node n) {
    if (n.prev == null) {
      head = n.next;
    } else {
      n.prev.next = n.next;
    }
    if (n.next != null) {
      n.next.prev = n.prev;
    }
  }
}
