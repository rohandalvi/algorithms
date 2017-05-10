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

  public List<Integer> getCommonNodes(TreeNode root1, TreeNode root2) {
    if (root1 == null || root2 == null)
      return null;
    List<Integer> list = new ArrayList<>();
    traverseAndFind(root1, root2, list);
    return list;
  }

  public List<Integer> getCommonNodesEfficient(TreeNode root1, TreeNode root2) {
    if (root1 == null || root2 == null)
      return null;
    List<Integer> first = new ArrayList<>();
    List<Integer> second = new ArrayList<>();

    inorder(root1, first);
    inorder(root2, second);

    return intersectLists(first, second);
  }

  private List<Integer> intersectLists(List<Integer> first, List<Integer> second) {
    if (first == null || first.size() == 0)
      return first;
    if (second == null || second.size() == 0)
      return second;
    List<Integer> list = new ArrayList<>();
    int i = 0;
    int j = 0;
    while (i < first.size() && j < second.size()) {
      if (first.get(i) == second.get(j)) {
        list.add(first.get(i));
        i++;
        j++;
      } else if (first.get(i) < second.get(j)) {
        i++;
      } else {
        j++;
      }
    }
    return list;
  }

  private void inorder(TreeNode root, List<Integer> list) {
    if (root == null)
      return;

    inorder(root.left, list);
    list.add(root.data);
    inorder(root.right, list);
  }

  private void traverseAndFind(TreeNode root1, TreeNode root2, List<Integer> list) {
    if (root1 == null)
      return;

    find(root1, root2, list);

    traverseAndFind(root1.left, root2, list);
    traverseAndFind(root1.right, root2, list);
  }

  private void find(TreeNode root1, TreeNode root2, List<Integer> list) {
    if (root2 == null)
      return;
    if (root2.data == root1.data) {
      list.add(root1.data);
      return;
    }
    if (root1.data < root2.data)
      find(root1, root2.left, list);
    else
      find(root1, root2.right, list);
  }
}
