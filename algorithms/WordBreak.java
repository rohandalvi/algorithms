package algorithms;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {

  public boolean wordBreak(String s, Set<String> dict) {
    boolean[] breakable = new boolean[s.length() + 1];
    breakable[0] = true;

    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {
        String sub = s.substring(j, i);
        if (breakable[j] && dict.contains(sub)) {
          breakable[i] = true;
          break;
        }
      }
    }
    return breakable[s.length()];
  }

  public static void main(String[] args) {
    WordBreak wb = new WordBreak();
    Set<String> dict = new HashSet<>();
    dict.add("leet");
    dict.add("code");
    System.out.println(wb.wordBreak("leetcode", dict));
  }
}
