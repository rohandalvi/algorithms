/**
 * 
 */
package algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author rohan.dalvi {@link https://leetcode.com/problems/word-search-ii/#/description}
 *
 * 
 */
public class WordSearch {
  Set<String> set = new HashSet<>();

  public List<String> findWords(char[][] board, String[] words) {
    if (Objects.isNull(board) || Objects.isNull(words))
      return new ArrayList<>(set);
    Trie trie = new Trie();
    for (String word : words) {
      trie.insert(word);
    }

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        dfs(i, j, board, "", trie);
      }
    }
    return new ArrayList<>(set);
  }

  private void dfs(int i, int j, char[][] board, String str, Trie trie) {
    if (i < 0 || i >= board.length || j < 0 || j >= board[i].length)
      return;
    if (board[i][j] == '#')
      return;

    char c = board[i][j];
    str += board[i][j];
    if (!trie.startsWith(str))
      return;

    if (trie.search(str))
      set.add(str);

    board[i][j] = '#';
    dfs(i + 1, j, board, str, trie);
    dfs(i, j + 1, board, str, trie);
    dfs(i - 1, j, board, str, trie);
    dfs(i, j - 1, board, str, trie);
    board[i][j] = c;
  }

  public static void main(String[] args) {
    WordSearch ws = new WordSearch();
    String[] words = {"oath", "pea", "eat", "rain"};
    char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};

    List<String> list = ws.findWords(board, words);
    System.out.println(list);
  }
}
