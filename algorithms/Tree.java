package algorithms;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

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
}
