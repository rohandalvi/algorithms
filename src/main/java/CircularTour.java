package geeks4geeks;

/**
 * Problem statement: Suppose there is a circle. There are n petrol pumps on that circle. You will be given two sets of
 * data.
 * 
 * 1. The amount of petrol that every petrol pump has. 2. Distance from that petrol pump to the next petrol pump.
 * 
 * Your task is to complete the function tour which returns an integer denoting the first point from where a truck will
 * be able to complete the circle (The truck will stop at each petrol pump and it has infinite capacity).
 * 
 *  * Note : Assume for 1 litre petrol, the truck can go 1 unit of distance.
 * 
 * @author rohan.dalvi
 *
 */
public class CircularTour {
  class Pair {
    int petrol, distance;

    Pair(int p, int d) {
      petrol = p;
      distance = d;
    }
  }

  public int tour(int[] petrol, int[] distance) {
    if (petrol == null || distance == null || petrol.length != distance.length)
      return -1;
    int n = petrol.length;
    Pair[] pairs = new Pair[n];
    for (int i = 0; i < n; i++) {
      pairs[i] = new Pair(petrol[i], distance[i]);
    }

    for (int i = 0; i < n; i++) {
      Pair p = pairs[i];
      if (p.petrol >= p.distance) {
        boolean complete = completesCircle((i + 1) % n, n, i, p.petrol - p.distance, pairs);
        if (complete)
          return i;
      }
    }
    return -1;
  }

  private boolean completesCircle(int index, int length, int end, int remainingPetrol, Pair[] pairs) {
    if (index == end)
      return true;
    int totalPetrol = remainingPetrol + pairs[index].petrol;
    if (totalPetrol < pairs[index].distance)
      return false;

    boolean result = completesCircle((index + 1) % length, length, end, totalPetrol - pairs[index].distance, pairs);
    return result;
  }
}
