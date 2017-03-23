package algorithms;

import java.util.HashMap;
import java.util.Map;

public class LPS {
  public static void main(String[] args) {
    String a = "LPASPAL";
    int start = 0;
    int end = a.length() - 1;
    Map<String, Integer> map = new HashMap<>();
    System.out.println(lps("LPASPAL", start, end, map));
  }

  public static int lps(String a, int start, int end, Map<String, Integer> map) {
    if (start >= end)
      return 0;
    if (a.charAt(start) == a.charAt(end)) {
      return 2 + lps(a, start + 1, end - 1, map);
    } else {
      return Math.max(lps(a, start + 1, end, map), lps(a, start, end - 1, map));
    }
  }
}
