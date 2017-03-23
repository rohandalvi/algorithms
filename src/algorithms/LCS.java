package algorithms;

public class LCS {
  public static void main(String[] args) {
    String a = "ACBEA";
    String b = "ADCA";

    System.out.println(lcs(a, b, a.length() - 1, b.length() - 1));
    System.out.println(lcsDP(a, b));
  }

  public static int lcs(String a, String b, int m, int n) {
    if (m == 0 || n == 0) {
      return 0;
    }

    if (a.charAt(m) == b.charAt(n))
      return 1 + lcs(a, b, m - 1, n - 1);
    else
      return Math.max(lcs(a, b, m - 1, n), lcs(a, b, m, n - 1));
  }

  public static int lcsDP(String a, String b) {
    int aLength = a.length();
    int bLength = b.length();
    int[][] memo = new int[aLength][bLength];

    for (int i = 0; i < aLength; i++) {
      for (int j = 0; j < bLength; j++) {
        if (a.charAt(i) == b.charAt(j)) {
          int val = (i == 0 || j == 0) ? 0 : memo[i - 1][j - 1];
          memo[i][j] = val + 1;
        } else {
          int val1 = i == 0 ? 0 : memo[i - 1][j];
          int val2 = j == 0 ? 0 : memo[i][j - 1];
          memo[i][j] = Math.max(val2, val1);
        }
      }
    }
    return memo[aLength - 1][bLength - 1];
  }
}
