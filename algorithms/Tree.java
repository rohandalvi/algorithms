package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Tree {
  private class TreeNode {
    TreeNode left;
    TreeNode right;
    int data;

    TreeNode(int d) {
      data = d;
      left = null;
      right = null;
    }
  }

  TreeNode root;
  static int max = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    maxDepth(root);
    return max;
  }

  public int maxBst(TreeNode root) {
    ResultNode resultNode = maxBstHelper(root);
    return resultNode.maxBST;
  }

  private ResultNode maxBstHelper(TreeNode root) {
    if (root == null)
      return new ResultNode();

    ResultNode left = maxBstHelper(root.left);
    ResultNode right = maxBstHelper(root.right);

    ResultNode result = new ResultNode();
    if (!left.isBST || !right.isBST || !inRange(left.maxValue, root.data, right.minValue)) {
      result.isBST = false;
      result.maxBST = Math.max(left.maxBST, right.maxBST);
      return result;
    }

    result.maxBST = 1 + left.maxBST + right.maxBST;
    result.minValue = root.left != null ? left.minValue : root.data;
    result.maxValue = root.right != null ? right.maxValue : root.data;

    return result;
  }

  private boolean inRange(int min, int val, int max) {
    return val > min && val < max;
  }

  private int maxDepth(TreeNode root) {
    if (root == null)
      return 0;
    int left = maxDepth(root.left);
    int right = maxDepth(root.right);

    max = Math.max(max, left + right);
    return 1 + Math.max(left, right);
  }

  private void deserialize(String data) {
    Deque<String> dq = new LinkedList<>();
    dq.addAll(Arrays.asList(data.split(",")));

  }

  public int bottomLeftTreeValue(TreeNode root) {
    if (root == null)
      return Integer.MIN_VALUE;

    List<Integer> list = new ArrayList<>();
    bottomLeftTreeValueHelper(root, list, 0);
    return list.get(list.size() - 1);
  }

  private void bottomLeftTreeValueHelper(TreeNode root, List<Integer> list, int level) {
    if (root == null)
      return;
    if (level == list.size()) {
      list.add(root.data);
    }

    bottomLeftTreeValueHelper(root.left, list, level + 1);
    bottomLeftTreeValueHelper(root.right, list, level + 1);
  }
}
