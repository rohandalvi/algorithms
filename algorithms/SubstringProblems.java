package algorithms;

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

  public static void main(String[] args) {
    String s = "ADOBECODEBANC";
    System.out.println(lengthOfLongestSubstring(s));
  }
}
