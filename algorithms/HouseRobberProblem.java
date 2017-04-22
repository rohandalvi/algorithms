package algorithms;

public class HouseRobberProblem {

  /**
   * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
   * stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system
   * connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
   * 
   * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount
   * of money you can rob tonight without alerting the police.
   * 
   * @param nums
   * @return
   */
  public int robI(int[] nums) {
    if (nums == null || nums.length == 0)
      return 0;
    int n = nums.length;
    int start = 0;
    int end = n - 1;

    return robInRange(nums, start, end);
  }

  /**
   * Continuation of House Robber I (above). After robbing those houses on that street, the thief has found himself a
   * new place for his thievery so that he will not get too much attention. This time, all houses at this place are
   * arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system
   * for these houses remain the same as for those in the previous street.
   * 
   * @param nums
   * @return
   */
  public int robII(int[] nums) {
    if (nums == null || nums.length == 0)
      return 0;
    int firstIncluded = robInRange(nums, 0, nums.length - 2);
    int firstExcluded = robInRange(nums, 1, nums.length - 1);

    return Math.max(firstIncluded, firstExcluded);
  }

  /**
   * Very good helper to solve House Robber I and House Robber II leetcode problems. In case of HouseRobber II the only
   * change should be to get max of first included and first excluded.
   * 
   * @param nums
   * @param start
   * @param end
   * @return
   */
  private int robInRange(int[] nums, int start, int end) {
    if (end < start || nums == null || nums.length == 0)
      return 0;
    int[] memo = new int[end - start + 1];
    memo[0] = nums[start];
    if (memo.length > 1) {
      memo[1] = Math.max(nums[start], nums[start + 1]);
    }
    int j = start + 2;
    for (int i = 2; i < memo.length; i++, j++) {
      memo[i] = Math.max(memo[i - 1], memo[i - 2] + nums[j]);
    }
    return memo[memo.length - 1];
  }
}
