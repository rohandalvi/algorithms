package algorithms;

public class BinarySearchProblems {
  /**
   * Returns the index of the peak element
   * 
   * @param nums
   * @return
   */
  int findPeakElement(int[] nums) {
    if (nums == null || nums.length == 0)
      return -1;
    return helperFindPeakElement(nums, 0, nums.length - 1);
  }

  private int helperFindPeakElement(int[] nums, int start, int end) {
    if (start == end)
      return start;
    if (start + 1 == end)
      return nums[start] > nums[end] ? start : end;

    int mid = start + (end - start) / 2;
    if (nums[mid - 1] > nums[mid])
      return helperFindPeakElement(nums, start, mid - 1);
    else
      return helperFindPeakElement(nums, mid + 1, end);
  }
}
