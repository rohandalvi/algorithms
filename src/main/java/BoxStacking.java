package geeks4geeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoxStacking {

  /**
   * Given boxes of different dimensions, stack them on top of each other to get maximum height such that box on top has
   * strictly less length and width than box under it.
   * 
   * Remember the property of rectangle that we always consider length>=width.
   * 
   * @author rohan.dalvi
   *
   */
  class Box implements Comparable<Box> {
    int height;
    int width;
    int length;

    Box(int length, int width, int height) {
      this.height = height;
      this.width = width;
      this.length = length;
    }

    @Override
    public int compareTo(Box o) {
      // TODO Auto-generated method stub
      return (o.length * o.width) - (length * width);
    }

  }

  public int maxHeight(int[] height, int[] width, int[] length, int n) {

    List<Box> list = new ArrayList<>();

    // get all permutations of rectangular (length >=width) boxes
    for (int i = 0; i < n; i++) {
      permute(new int[] {length[i], width[i], height[i]}, list, 0);
    }

    // sort them in the descending order of the area.. so larger area boxes come before smaller
    Collections.sort(list);
    int maxHeight = 0;
    if (n == 1) { // if there is only one box
      for (int i = 0; i < list.size(); i++) {
        maxHeight = Math.max(maxHeight, list.get(i).height);
      }
      return maxHeight;
    }

    int max[] = new int[list.size()];

    // initially populate all existing heights of the boxes in max. That is the max you can get for each box if it were
    // only one
    for (int i = 0; i < max.length; i++) {
      max[i] = list.get(i).height;
    }

    // Similar logic as longest increasing subsequence
    for (int i = 1; i < list.size(); i++) {
      for (int j = 0; j < i; j++) {
        // can 'i' go on top of 'j'.. why like this? because remember we sorted the boxes in decreasing order of area
        // so we always need to check if the next box can go on top of the current box coz current box has greater area
        // than next box as per our sorting order
        if (canGoOnTop(i, j, list)) { // can 'i' go on top of 'j'
          // The max height we can go upto is max height already in j + max height in i (dp)
          max[i] = Math.max(max[i], list.get(i).height + max[j]);
        } else {
          break;
        }
      }
    }

    for (int i = 0; i < max.length; i++) {

      maxHeight = Math.max(maxHeight, max[i]);
    }

    return maxHeight;
  }

  private boolean canGoOnTop(int i, int j, List<Box> list) {
    // can 'i' go on top of 'j' ?

    return list.get(j).length > list.get(i).length && list.get(j).width > list.get(i).width;
  }

  private void permute(int[] arr, List<Box> list, int index) {
    if (index == arr.length) {
      if (arr[0] >= arr[1]) {
        list.add(new Box(arr[0], arr[1], arr[2]));
      }
      return;
    }
    for (int i = index; i < arr.length; i++) {
      swap(i, index, arr);
      permute(arr, list, index + 1);
      swap(i, index, arr);
    }
  }

  private void swap(int i, int j, int arr[]) {
    if (i != j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }
  }

}
