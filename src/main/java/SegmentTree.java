package algorithms;

import java.util.ArrayList;
import java.util.List;

public class SegmentTree {
  List<Integer> list;

  public SegmentTree(int[] nums) {
    // TODO Auto-generated constructor stub
    list = new ArrayList<>();
    int n = nums.length;
    buildTree(nums, 0, n - 1, 0);
  }

  private void buildTree(int[] nums, int start, int end, int pos) {
    if (start == end) {
      if (list.size() < pos + 1) {
        while (list.size() < pos + 1)
          list.add(Integer.MAX_VALUE);
      }
      list.set(pos, nums[start]);
      return;
    }

    int mid = (start + end) / 2;
    buildTree(nums, start, mid, 2 * pos + 1);
    buildTree(nums, mid + 1, end, 2 * pos + 2);
    list.set(pos, Math.min(list.get(2 * pos + 1), list.get(2 * pos + 2)));
  }

  public int rangeMinQuery(int qLow, int qHigh, int low, int high, int pos) {
    if (qLow <= low && qHigh >= high) {
      return list.get(pos);
    }
    if (qLow > high || qHigh < low)
      return Integer.MAX_VALUE;

    int mid = (low + high) / 2;
    int a = rangeMinQuery(qLow, qHigh, low, mid, 2 * pos + 1);
    int b = rangeMinQuery(qLow, qHigh, mid + 1, high, 2 * pos + 2);
    return Math.min(a, b);
  }

  public static void main(String[] args) {
    int[] nums = new int[] {-1, 2, 4, 0};
    SegmentTree st = new SegmentTree(nums);
    System.out.println(st.rangeMinQuery(1, 3, 0, st.list.size() - 1, 0));
  }
}
