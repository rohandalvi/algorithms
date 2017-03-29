package algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Trie {
  class TrieNode {
    char c;
    private boolean endOfWord;
    private Map<Character, TrieNode> map;

    TrieNode(char c) {
      this.c = c;
      endOfWord = false;
      map = new HashMap<>();
    }

    public boolean contains(char c) {
      return map.containsKey(c);
    }

    public Set<Character> suggestNext() {
      return map.keySet();
    }

    public TrieNode insert(char c) {
      if (!map.containsKey(c)) {
        TrieNode temp = new TrieNode(c);
        map.put(c, temp);
      }
      return map.get(c);
    }

    public TrieNode get(char c) {
      return map.get(c);
    }

    public void setEndOfWord() {
      endOfWord = true;
    }

    public boolean isEndOfWord() {
      return endOfWord;
    }
  }

  TrieNode root;

  Trie() {
    root = new TrieNode('#');
  }

  public void insert(String str) {
    if (Objects.isNull(str))
      return;
    TrieNode temp = root;
    for (int i = 0; i < str.length(); i++) {
      temp = temp.insert(str.charAt(i));
    }
    temp.setEndOfWord();
  }

  public boolean search(String str) {
    if (Objects.isNull(str))
      return false;
    TrieNode temp = root;
    for (int i = 0; i < str.length(); i++) {
      temp = temp.get(str.charAt(i));
      if (temp == null)
        return false;
    }
    return temp.isEndOfWord();
  }

  public boolean startsWith(String str) {
    if (Objects.isNull(str))
      return false;
    TrieNode temp = root;

    for (int i = 0; i < str.length(); i++) {
      temp = temp.get(str.charAt(i));
      if (temp == null)
        return false;
    }
    return true;
  }

  public Set<Character> suggestNext() {
    return suggestNext();
  }

  public TrieNode getTrieNodeForSubstring(String str) {
    TrieNode temp = root;
    for (int i = 0; i < str.length(); i++) {
      temp = temp.get(str.charAt(i));
      if (temp == null)
        return null;
    }
    return temp;
  }

  public TrieNode getRoot() {
    return root;
  }
}
