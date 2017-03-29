package algorithms;

import algorithms.Trie.TrieNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordLadder {
  public int findLadderLength(String beginWord, String endWord, Set<String> words) {
    Set<String> beginSet = new HashSet<>(Arrays.asList(beginWord));
    Set<String> endSet = new HashSet<>(Arrays.asList(endWord));
    Set<String> visited = new HashSet<>();
    Trie t = new Trie();
    for (String word : words) {
      t.insert(word);
    }
    int len = 1;
    while (!beginSet.isEmpty() && !endSet.isEmpty()) {
      if (beginSet.size() > endSet.size()) {
        Set<String> set = beginSet;
        beginSet = endSet;
        endSet = set;
      }
      TrieNode root = t.getRoot();
      Set<String> temp = new HashSet<>();
      for (String word : beginSet) {
        char[] chs = word.toCharArray();
        for (int i = 0; i < chs.length; i++) {
          String sub = word.substring(0, i);
          TrieNode tN = t.getTrieNodeForSubstring(sub);
          if (tN == null)
            continue;
          for (char c : tN.suggestNext()) {
            char old = chs[i];
            chs[i] = c;
            String str = String.valueOf(chs);
            if (endSet.contains(str)) {
              return len + 1;
            }

            if (words.contains(str) && !visited.contains(str)) {
              temp.add(str);
              visited.add(str);
            }

            chs[i] = old;
          }
        }
      }
      beginSet = temp;
      len++;
    }
    return -1;
  }

  public static void main(String[] args) {
    WordLadder wl = new WordLadder();
    String beginWord = "hit";
    String endWord = "cog";
    Set<String> wordList = new HashSet<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
    System.out.println(wl.findLadderLength(beginWord, endWord, wordList));
  }
}
