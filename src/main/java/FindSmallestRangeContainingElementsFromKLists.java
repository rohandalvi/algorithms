package geeks4geeks;

import java.util.PriorityQueue;

public class FindSmallestRangeContainingElementsFromKLists {

  class Range {
    int val;
    int max;

    Range(int val) {
      this.val = val;
    }
  }

  public int[] findSmallestRange(int[][] arr, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int size = 0;
    int max = Integer.MIN_VALUE;
    int range = Integer.MAX_VALUE;
    int[] res = new int[2];

    for (int j = 0; j < arr[0].length; j++) {

      for (int i = 0; i < k; i++) {

        if (pq.size() == k) {

          System.out.println("Going in for " + i + " and " + j + " and removing " + pq.peek());
          System.out.println("Size " + pq.size());
          int min = pq.poll();
          if ((max - min) < range) {
            range = max - min;
            res[0] = min;
            res[1] = max;
          }

        }
        pq.add(arr[i][j]);
        max = Math.max(arr[i][j], max);
      }
    }
    return res;
  }
}
