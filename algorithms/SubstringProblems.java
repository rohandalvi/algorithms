package algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubstringProblems {

  public static int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0)
      return 0;
    int maxLength = 0;
    Set<String> set = new HashSet<>();
    Set<String> result = new HashSet<>();
    Map<Character, Integer> map = new HashMap<>();
    int begin = 0;
    int end = 0;
    while (end < s.length()) {
      char c = s.charAt(end);
      if (map.containsKey(c)) {
        begin = Math.max(begin, map.get(c) + 1);
      }
      map.put(c, end);
      end++;
      if (end - begin > maxLength) {
        maxLength = end - begin;
        if (!set.add(s.substring(begin, end))) {
          result.add(s.substring(begin, end));
        }
      }

    }
    System.out.println(set);
    System.out.println(result);
    return maxLength;
  }

  public static boolean rearrangeString(String str) {
    if (str == null || str.length() == 0)
      return false;

    char[] c = str.toCharArray();
    Arrays.sort(c);
    str = new String(c);

    int start = 0;
    int end = str.length() - 1;

    while (start < end) {
      if (str.charAt(start) == str.charAt(end))
        return false;
      start++;
      end--;
    }
    return true;
  }

  public static void main(String[] args) {
    String s = "ADOBECODEBANC";
    System.out.println(lengthOfLongestSubstring(s));

    String str = "a";
    System.out.println(rearrangeString(str));
  }
}
