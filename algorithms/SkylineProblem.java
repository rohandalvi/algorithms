package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class SkylineProblem {
  class BuildingPoint implements Comparable<BuildingPoint> {
    boolean isStart;
    int x;
    int height;

    BuildingPoint(boolean isStart, int x, int height) {
      this.isStart = isStart;
      this.x = x;
      this.height = height;
    }

    @Override
    public int compareTo(BuildingPoint o) {
      // TODO Auto-generated method stub
      if (this.x != o.x) {
        // if x is not same, then lower x comes first.
        return this.x - o.x;
      } else {
        /*
         * if x is same, then tiebreaker rules. If both are start of buildings then one with higher height comes first.
         * If both are end of buildings then one with lower height comes first. If one is start & other is end of
         * building then one with start of building comes before end of building.
         */
        return (isStart ? -height : height) - (o.isStart ? -o.height : o.height);
      }
    }
  }

  public List<int[]> getSkyline(int[][] buildings) {
    BuildingPoint[] buildingPoints = new BuildingPoint[buildings.length * 2];
    int index = 0;

    // Populated all buildings as BuildingPoints.
    for (int[] building : buildings) {
      boolean isStart = true;
      int x = building[0];
      int height = building[2];

      buildingPoints[index] = new BuildingPoint(isStart, x, height);
      isStart = false;
      x = building[1];
      buildingPoints[index + 1] = new BuildingPoint(isStart, x, height);
    }

    Arrays.sort(buildingPoints);
    // used tree map here as it supports add, remove and findMax in O(log n) time.
    // not used priority queue here as it doesn't support remove operation in O(log n) time.

    // In tree map key is height and value is count of height ( how many times it occurs)
    TreeMap<Integer, Integer> map = new TreeMap<>();
    List<int[]> result = new ArrayList<>();

    // used to simplify the program.
    map.put(0, 1);

    int prevHeight = 0;
    for (BuildingPoint buildingPoint : buildingPoints) {
      if (buildingPoint.isStart) {
        map.put(buildingPoint.height, map.getOrDefault(buildingPoint.height, 0) + 1);

      } else {

        map.compute(buildingPoint.height, (key, value) -> {

          // if original value was 1 then basically we are removing this key
          if (value == 1) {
            return null;
          }

          // otherwise simply decrementing the key.
          return value - 1;
        });

      }

      int currHeight = map.lastKey();
      if (prevHeight != currHeight) {
        // if there was a change in prev height then we should add this point to our result
        // as this is going to show up on our skyline
        prevHeight = currHeight;
        result.add(new int[] {buildingPoint.x, buildingPoint.height});
      }
    }
    return result;

  }
}
