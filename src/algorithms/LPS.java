package algorithms;

public class LPS {
  public static void main(String[] args) {
    String a = "LPASPAL";
    int start = 0;
    int end = a.length() - 1;
    System.out.println("LPS Naive " + lpsNaive(a, start, end));
    System.out.println("LPS DP " + lpsDP(a));
  }

  public static int lpsNaive(String a, int start, int end) {
    if (start >= end)
      return 0;
    if (a.charAt(start) == a.charAt(end)) {
      return 2 + lpsNaive(a, start + 1, end - 1);
    } else {
      return Math.max(lpsNaive(a, start + 1, end), lpsNaive(a, start, end - 1));
    }
  }

  public static int lpsDP(String a) {
    int n = a.length();
    int[][] memo = new int[n][n];

    for (int i = 0; i < n; i++) {
      memo[i][i] = 1;
    }

    for (int currLen = 2; currLen <= n; currLen++) {
      for (int i = 0; i < n - currLen + 1; i++) {
        int j = i + currLen - 1;
        if (a.charAt(i) == a.charAt(j)) {
          memo[i][j] = 2 + memo[i + 1][j - 1];
        } else {
          memo[i][j] = Math.max(memo[i + 1][j], memo[i][j - 1]);
        }
      }
    }
    return memo[0][n - 1];
  }
}
