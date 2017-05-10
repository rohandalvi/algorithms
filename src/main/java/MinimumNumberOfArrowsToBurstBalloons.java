package algorithms;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/#/description
 * 
 * @author rohan.dalvi
 *
 */
public class MinimumNumberOfArrowsToBurstBalloons {

  public int minArrowsRequired(int[][] points) {
    if (points == null || points.length == 0)
      return 0;
    PriorityQueue<Interval> pq = new PriorityQueue<>(new Comparator<Interval>() {
      public int compare(Interval a, Interval b) {
        if (a.start == b.start)
          return a.end - b.end;
        else
          return a.start - b.start;
      }
    });
    for (int i = 0; i < points.length; i++) {
      pq.add(new Interval(points[i][0], points[i][1]));
    }
    int minArrows = 1;
    Interval temp = pq.poll();
    int end = temp.end;

    while (!pq.isEmpty()) {
      Interval curr = pq.poll();
      if (curr.start <= end) {
        // if they are merging
        end = Math.min(end, curr.end);
      } else {
        // if they aren't merging, you need another arrow here buddy
        minArrows++;
        end = curr.end;
      }
    }

    return minArrows;
  }
}
