package algorithms;

import java.util.HashMap;
import java.util.Map;

public class SuffixTrie {
  class TrieNode {
    char c;
    Map<Character, TrieNode> map;
    boolean endOfWord;

    public TrieNode() {
      // TODO Auto-generated constructor stub
      c = '*';
      map = new HashMap<>();
      endOfWord = false;

    }

    public TrieNode(char c) {
      // TODO Auto-generated constructor stub
      this.c = c;
      map = new HashMap<>();
      endOfWord = false;
    }

    public TrieNode insert(char c) {
      if (!map.containsKey(c)) {
        TrieNode node = new TrieNode(c);
        map.put(c, node);
      }
      return map.get(c);
    }

    public TrieNode get(char c) {
      return map.get(c);
    }

    public void setEndOfWord() {
      endOfWord = true;
    }

    public boolean getEndOfWord() {
      return endOfWord;
    }

    public boolean contains(char c) {
      return map.containsKey(c);
    }
  }

  TrieNode root;
  static int maxLevel = 0;
  static String res = "";

  public SuffixTrie() {
    // TODO Auto-generated constructor stub
    root = new TrieNode('*');

  }

  public void createSuffixTree(String str) {
    if (str == null || str.length() == 0)
      return;
    int end = str.length() - 1;
    int start = end;

    while (start >= 0) {
      TrieNode temp = root;
      String sub = str.substring(start, end + 1);
      for (int i = 0; i < sub.length(); i++) {
        temp = temp.insert(sub.charAt(i));
      }
      temp.setEndOfWord();
      start--;
    }
  }

  public boolean suffixExists(String str) {
    TrieNode temp = root;
    for (int i = 0; i < str.length(); i++) {
      temp = temp.get(str.charAt(i));
      if (temp == null)
        return false;
    }
    return true;
  }

  public String getLongestRepeatedSubstring(String str) {
    if (str == null || str.length() == 0)
      return str;
    dfs(root, 0, "");
    return res;
  }

  private void dfs(TrieNode root, int level, String temp) {
    if (root == null || root.map.size() == 0)
      return;

    for (char key : root.map.keySet()) {

      TrieNode t = root.map.get(key);

      if ((root.map.size() > 1 || (root.map.size() == 1 && root.endOfWord)) && level > maxLevel) {
        maxLevel = level;
        res = temp;
      }

      dfs(t, level + 1, temp + "" + t.c);

    }
  }

}
