package algorithms;

public class ResultNode {
  boolean isBST;
  int maxBST;
  int minValue;
  int maxValue;

  ResultNode() {
    isBST = true;
    maxBST = 0;
    minValue = Integer.MAX_VALUE;
    maxValue = Integer.MIN_VALUE;
  }

  ResultNode(boolean isBST, int maxBST, int minValue, int maxValue) {
    this.isBST = isBST;
    this.maxBST = maxBST;
    this.minValue = minValue;
    this.maxValue = maxValue;
  }
}
